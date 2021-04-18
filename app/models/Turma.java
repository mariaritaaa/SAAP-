package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Max;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Turma extends Model {
	
	@Required
	@Max(value=4, message = "apenas um número.")
	public String ano;
	
	@Required
	public String curso;
	
	@Required
	@Unique(message="Uma turma já possui este nome.")
	public String nome;
	
	@Required
	public String turno;
	
	@OneToMany(mappedBy="turma")
	public List<Aluno> alunos;
	

	@ManyToMany
	@JoinTable(name = "turma_disciplina")
	public List<Disciplina> disciplinas;
	
	public Turma() {
		this.disciplinas = new ArrayList();
	}
	
	
	
}
