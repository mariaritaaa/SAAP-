package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Segurança extends Controller{
	
	@Before
	public static void verificar() {
		
		if(session.contains("proMatricula") == false) {
			Login.login();
		}
	}

}
