package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoController {

	public void Create(Aluno aluno)
	{
		try
		{
			AlunoDAO dao = new AlunoDAO();
			dao.Create(aluno);
		}
		finally{
			System.out.println("Fim da Insercao");
		}
	}
	public List<Aluno> ReadAll()
	{	List<Aluno> Alunos1 =  new ArrayList<Aluno>();
		try{
			AlunoDAO dao = new AlunoDAO();

			Alunos1 = dao.readAll();

		}
		finally{
			System.out.println("Pesquisa concluida");
		}
		return Alunos1;

	}

	public void Delete(Aluno aluno)
	{
		try
		{
			AlunoDAO dao = new AlunoDAO();
			dao.Delete(aluno);
		}
		finally{
			System.out.println("Insercao feita");
		}
	}

	public void Update(Aluno aluno)
	{
		try
		{
			AlunoDAO dao = new AlunoDAO();
			dao.Update(aluno);
		}
		finally{
			System.out.println("Insercao feita");
		}
	}




}