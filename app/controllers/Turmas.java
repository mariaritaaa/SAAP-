package controllers;

import java.util.List;

import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Turma;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Segurança.class)
public class Turmas extends Controller{

	public static void form() {
		Turma turma = (Turma) Cache.get("turma");//²recupera os dados da 'turma'
		Cache.clear();
     	render(turma); //³devolve p pagina do form prenchido
}											
	public static void salvar(@Valid Turma turma, List<Long> IDdisciplinas) {
		if(validation.hasErrors()) {
			validation.keep();
			flash.error("Falha ao salvar turma!");
			
			Cache.set("turma", turma); //¹guardar dados já preenchidos
			form();
		}
		
		if (IDdisciplinas != null) {
			for(Long id: IDdisciplinas) {
				Disciplina d = Disciplina.findById(id);

				if (turma.disciplinas.contains(d) == false) {// verificar se já existe a disciplinas cadastrada na turma
					turma.disciplinas.add(d);
				}
				
			}
		}
		
		turma.save();
		flash.success("Turma cadastrada!");
		editar(turma.id); //apos a criação da turma, direciona para a edição para adicionar as disciplinas
		
	}
	
	public static void listar() {
		List<Turma> lista = Turma.findAll();
		render(lista);
	}
	public static void deletar(Long id) {
		Turma turma = Turma.findById(id);
		
		for(Disciplina dis: turma.disciplinas) {
			dis.turmas.remove(turma);
			dis.save();
		}
		for(Aluno a: turma.alunos) {
			a.turma = null;
			a.save();
		}
		
		turma.delete();		
		listar();
	}
	public static void editar(Long id) {
		Turma turma = Turma.findById(id);
		
		List<Disciplina> disciplinas = Disciplina.findAll();
		
		
		renderTemplate("Turmas/form.html", turma, disciplinas);
	}
	
	public static void detalhes(Long id) {
		Turma turma = Turma.findById(id);
		render(turma);
	}
}
