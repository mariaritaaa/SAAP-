package controllers;

import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job{

	
	public void doJob() {
		
		if(Disciplina.count() == 0) {
			
			Professor professor = new Professor();
			professor.nome = "João Helis Bernardo";
			professor.matricula = "2020";
			professor.senha = "123";
			professor.save();
			
			Professor professor2 = new Professor();
			professor2.nome = "João Freire";
			professor2.matricula = "2017107";
			professor2.senha = "123";
			professor2.save();
			
			Professor professor3 = new Professor();
			professor3.nome = "admin";
			professor3.matricula = "admin";
			professor3.senha = "123";
			professor3.save();
			
		
			Disciplina d7 = new Disciplina();
			d7.nome = "Redes";
			d7.codigo = 4100;
			d7.professor = professor;
			d7.save();
			
			Disciplina d1 = new Disciplina();
			d1.nome = "Programação para Internet";
			d1.codigo = 100;
			d1.professor = professor;
			d1.save();
			
			Disciplina d2 = new Disciplina();
			d2.codigo = 200;
			d2.nome = "Matemática";
			d2.professor = professor2;
			d2.save();
		
			
			Disciplina d3 = new Disciplina();
			d3.nome = "Física";
			d3.professor = professor3;
			d3.save();
			
			Disciplina d4 = new Disciplina();
			d4.nome = "Português";
			d4.save();
			
			Disciplina d5 = new Disciplina();
			d5.nome = "História";
			d5.save();
			
			Disciplina d6 = new Disciplina();
			d6.nome = "Sociologia";
			d6.save();

			Turma t1 = new Turma();
			t1.ano = "4º";
			t1.curso = "Informática";
			t1.nome = "4INF - 1M";
			t1.turno = "Matutino";
			t1.disciplinas.add(d1);
			t1.disciplinas.add(d2);

			t1.save();
			
			Turma t2 = new Turma();
			t2.ano = "4º";
			t2.curso = "Química";
			t2.nome = "4QM - 1V";
			t2.turno = "Vespertino";
			t2.save();
			
			Turma t3 = new Turma();
			t3.ano = "4º";
			t3.curso = "Recursos Pesqueiros";
			t3.nome = "4RP - 1V";
			t3.turno = "Vespertino";
			t3.save();
			
			
			Aluno a1 = new Aluno();
			a1.nome = "Maria Rita Araújo";
			a1.matricula = " 20171074010018";
			a1.senha = "123";
			a1.turma = t1;
			a1.save();
			
			Aluno a2 = new Aluno();
			a2.nome = "Rímele Natalia";
			a2.matricula = " 20161074010019";
			a2.senha = "123";
			a2.turma = t1;
			a2.save();
			
			Aluno a3 = new Aluno();
			a3.nome = "Ana Caroline";
			a3.matricula = " 20171074010011";
			a3.senha = "123";
			a3.turma = t2;
			a3.save();
			
			Aluno a4 = new Aluno();
			a4.nome = "Everton";
			a4.matricula = " 20171074010017";
			a4.senha = "123";
			a4.turma = t3;
			a4.save();
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * if(Aluno.count() == 0) 
		 * { Aluno aluno = new Aluno();
		 * aluno.nome="Joao";
		 * aluno.matricula="12344"; 
		 * aluno.senha="321"; 
		 * aluno.turma.id=(1); }
		 */		
		/*if(Professor.count() == 0) {
			Fixtures.loadModels("dadosProfessor.yml");
		}
		if(Aluno.count() == 0) {
		Fixtures.loadModels("dadosAlunos.yml");
		} */
		
	}
}