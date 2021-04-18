package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Aula extends Model{
	
	@Required
	public Date data;
	
	public String conteudo;
	
	@Required
	public int quantidade;
	
	@ManyToOne
	@JoinColumn(name="disciplinaID")
	public Disciplina disciplina;
	
	@OneToOne
	@JoinColumn(name="frequenciaID")
	public Frequencia frequencia;
	
	

	

}
