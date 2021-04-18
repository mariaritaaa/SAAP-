package controllers;

import java.util.List;

import models.Disciplina;
import models.Professor;
import play.cache.Cache;
import play.mvc.Controller;

public class Diarios extends Controller{

	 public static void listagem() {
		 Professor pro = (Professor) Cache.get("pro");
		 
	     render(pro);
	    }
}
