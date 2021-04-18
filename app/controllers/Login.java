package controllers;

import models.Professor;
import play.cache.Cache;
import play.mvc.Controller;

public class Login extends Controller {
	
	
	public static void login() {
		render();
	}
	
	public static void autenticar(String matricula, String senha) {
		Professor pro = Professor.find("matricula = ? and senha = ?", matricula, senha).first();
		if(pro != null) {
			
			session.put("proMatricula", pro.matricula);		
			session.put("proSenha", pro.senha);
			session.put("proNome", pro.nome);
			
		    
		
			flash.success("LOGIN EFETUADO!");
			renderTemplate("Application/index.html");
		
		}else {
			flash.error("Usuário ou senha incorreta!");
			login();
		}
	}

	public static void logout() {
		session.clear();
		login();
	}
}

