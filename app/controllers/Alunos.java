package controllers;

import java.util.List;

import models.Aluno;
import models.Turma;
import play.cache.Cache;
import play.data.validation.Valid;
import play.db.jpa.JPABase;
import play.mvc.Controller;
import play.mvc.With;

@With(Segurança.class)
public class Alunos extends Controller  {
	
		public static void form() {
			Aluno alun = (Aluno) Cache.get("alun"); //²recupera os dados do 'aluno'
			Cache.clear();
			List<Turma> turmas = Turma.findAll(); // buscar todos os registros da entidade turma no BD
			render(turmas, alun); //³devolve p pagina do form prenchido
		}
		
		public static void salvar(@Valid Aluno alun) {
			
			if(validation.hasErrors()) {
				validation.keep();
				
				flash.error("Falha ao salvar aluno!");
				
				Cache.set("alun", alun); //¹guardar dados já preenchidos
				form();
			}
			
			alun.save();
			flash.success("Aluno cadastrado!");
			form();
		}

		public static void listar() {
			List<Aluno> lista = Aluno.findAll();
			render(lista);
		}
		
		public static void editar(Long id) {
			Aluno alun = Aluno.findById(id);
		
			List<Turma> turmas = Turma.findAll(); 
			renderTemplate("alunos/form.html", alun, turmas);
		}
		public static void deletar(long id) {
			Aluno alun = Aluno.findById(id);
			alun.delete();
			listar();
		}
}
