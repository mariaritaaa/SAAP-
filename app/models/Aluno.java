package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aluno extends Model {
	
	@Required
	public String nome;
	
	@Required
	@Unique(message = "Matricula já em uso")
	@MaxSize(14)
	public String matricula;
	
	@Required
	@Min(value=4, message = "No minimo 4 caracteres")
	public String senha;
	//public Blob fotoQr;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@ManyToMany(mappedBy="presentes")
	public List<Frequencia> frequencias;
	
	public Aluno() {
		this.frequencias = new ArrayList();
	}

	
}
