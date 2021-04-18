package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Disciplina extends Model {
	
	 @Required
	 public String nome;
	
	 @Required
	 @Unique
	 @MaxSize(3)
	 public int codigo;
	
	 @Required
	 @ManyToOne
	 @JoinColumn(name="professorID")
	 public Professor professor;
	 
	 @ManyToMany(mappedBy="disciplinas")
	 public List<Turma> turmas;
	 
	 @OneToMany(mappedBy="disciplina")
	 public List<Aula> aulas;
	 
	 public Disciplina() {
			this.aulas = new ArrayList();
		}
	 

		
	 


	
	
	
	

}
