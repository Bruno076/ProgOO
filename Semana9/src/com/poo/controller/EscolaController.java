package com.poo.controller;

import com.poo.dao.EscolaDAO;
import com.poo.model.Escola;
import java.util.*;

public class EscolaController {

	public List<Escola> readAll()
	{
		List<Escola> escolas = new ArrayList<Escola>();
		try {
			EscolaDAO dao = new EscolaDAO();
			escolas = dao.readAll();
		}
		finally {
			
		}
		return escolas;
		
	}
	
	public void update(Escola escola) {
		try {
			EscolaDAO dao = new EscolaDAO();
			dao.update(escola);
		}
		finally {
			
		}
	}
	
	
	public void delete(Escola escola) {
		try {
			EscolaDAO dao = new EscolaDAO();
			dao.delete(escola);
		}
		finally {
			
		}
	}
	
	
	public void insert(Escola escola) {
		try {
			EscolaDAO dao = new EscolaDAO();
			dao.insert(escola);
		}
		finally {
			
		}
	}
}
