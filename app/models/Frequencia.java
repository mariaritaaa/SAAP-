package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Frequencia extends Model{
	
	@Required
	public Date data;
	
	public boolean presenca;

	@OneToOne(mappedBy="frequencia")
	public Aula aula;
	
	@ManyToMany
	@JoinTable(name="frequencias_alunos")
	public List<Aluno> presentes;
	
	public Frequencia() {
		this.presentes = new ArrayList();
	}
	
	
}
