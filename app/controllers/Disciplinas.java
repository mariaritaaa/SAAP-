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
public class Disciplinas extends Controller{
	
	public static void formDisciplina() {
		Disciplina disciplina = (Disciplina) Cache.get("disciplina");
		Cache.clear();
		List<Professor> professores = Professor.findAll();
		render(professores, disciplina);
}
	public static void salvar(@Valid Disciplina disciplina) {
		if(validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao salvar disciplina!");
			Cache.set("disciplina", disciplina);
			formDisciplina();
			
		}
		
		
		disciplina.save();
		flash.success("Disciplina cadastrada!");
		formDisciplina();
	}
	
	public static void listar() {
		List<Disciplina> lista = Disciplina.findAll();
		render(lista);
	}
	
	public static void deletar(Long id) {
		Disciplina d = Disciplina.findById(id);
		
		
		if(d.professor != null) {
			d.professor = null;
			d.save();
		}
		for(Turma t: d.turmas) {
			t.disciplinas.clear();
			t.save();
		}
		
		d.delete();
		listar();
	}
	
	public static void editar(Long id) {
		Disciplina disciplina = Disciplina.findById(id);
		List<Professor> professores = Professor.findAll();
		
		renderTemplate("disciplinas/formDisciplina.html", disciplina, professores);
	}
	
	
	

}
