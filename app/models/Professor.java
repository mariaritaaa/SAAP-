package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Professor extends Model {
	
	@Required
	public String nome;
	
	@Required(message="requerido")
	@Unique(message="Matricula já em uso")
	@MaxSize(value=14, message="14 caracteres no maximos")
	public String matricula;
	
	@Required
	public String senha;
	
	@OneToMany(mappedBy="professor")
	public List<Disciplina> disciplinas;
	
	public Professor() {
		this.disciplinas = new ArrayList();
	}
	
	
	

	
	
	
	
	

}