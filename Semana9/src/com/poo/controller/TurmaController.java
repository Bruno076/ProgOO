package com.poo.controller;

import com.poo.dao.TurmaDAO;
import com.poo.model.Turma;
import java.util.*;

public class TurmaController {

	public List<Turma> readAll()
	{
		List<Turma> turmas = new ArrayList<Turma>();
		try {
			TurmaDAO dao = new TurmaDAO();
			turmas = dao.readAll();
		}
		finally {
			
		}
		return turmas;
		
	}
	
	public List<Turma> readTurmasEscola(int idEscola) {
		List<Turma> turmas = new ArrayList<Turma>();
		try {
			TurmaDAO dao = new TurmaDAO();
			turmas = dao.readTurmasEscola(idEscola);
		}
		finally {
			
		}
		return turmas;
	}
	
	public void update(Turma escola) {
		try {
			TurmaDAO dao = new TurmaDAO();
			dao.update(escola);
		}
		finally {
			
		}
	}
	
	
	public void delete(Turma escola) {
		try {
			TurmaDAO dao = new TurmaDAO();
			dao.delete(escola);
		}
		finally {
			
		}
	}
	
	
	public void insert(Turma escola) {
		try {
			TurmaDAO dao = new TurmaDAO();
			dao.insert(escola);
		}
		finally {
			
		}
	}
}
