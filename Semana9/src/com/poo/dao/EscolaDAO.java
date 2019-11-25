package com.poo.dao;

import java.sql.*;
import java.util.*;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Escola;


public class EscolaDAO {

	public List<Escola> readAll() 
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID_Escola, Nome FROM escola";
		List<Escola> escolas = new ArrayList<Escola>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Escola escola = new Escola();
				escola.setIdEscola(rs.getInt("ID_Escola"));
				escola.setNome(rs.getString("Nome"));
				
				escolas.add(escola);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return escolas;
	}
	
	
	public void update(Escola escola) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = String.format("UPDATE escola SET Nome = '%s' WHERE ID_Escola = %d", escola.getNome(), escola.getIdEscola());
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public void delete(Escola escola) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = String.format("DELETE from escola WHERE ID_Escola = %d", escola.getIdEscola());
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void insert(Escola escola) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = String.format("INSERT INTO escola (Nome) VALUES ('%s')", escola.getNome());
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
