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
public class Professores extends Controller {
	//https://http://localhost:9000/professores/form
	public static void form() {
		Professor prof = (Professor) Cache.get("prof"); //²recupera os dados do 'aluno'
		Cache.clear();
		render(prof); //³devolve p pagina do form prenchido
}
	public static void salvar(@Valid Professor prof) {
		
		if(validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao salvar professor!");
			
			Cache.set("prof", prof); //¹guardar dados já preenchidos
			form();
		
		}
		prof.save();
		flash.success("Professor cadastrado!");
		form();
	}
	public static void listar(){
		List<Professor> lista = Professor.findAll();
		render(lista);
	}
	public static void editar(long id) {
		Professor prof = Professor.findById(id);
		
		renderTemplate("Professores/form.html", prof);
	}
	public static void deletar(long id) {
		Professor prof = Professor.findById(id);
		
		for(Disciplina d: prof.disciplinas) {
			d.professor = null;
			d.save();
		}
		
		prof.delete();
		listar();
	}
}
