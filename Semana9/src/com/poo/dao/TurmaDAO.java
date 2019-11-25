package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Turma;

public class TurmaDAO {

	public List<Turma> readAll() 
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID_Turma, Ano, ID_Escola FROM Turma";
		List<Turma> turmas = new ArrayList<Turma>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("ID_Turma"));
				turma.setAno(rs.getString("Ano"));
				turma.setIdEscola(rs.getInt("ID_Escola"));
				
				turmas.add(turma);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return turmas;
	}
	
	public List<Turma> readTurmasEscola(int idEscola) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID_Turma, Ano, ID_Escola FROM Turma WHERE ID_Escola = ?";
		List<Turma> turmas = new ArrayList<Turma>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idEscola);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("ID_Turma"));
				turma.setAno(rs.getString("Ano"));
				turma.setIdEscola(rs.getInt("ID_Escola"));
				
				turmas.add(turma);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return turmas;
	}
	
	
	public void update(Turma turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="UPDATE turma SET Ano = ?, ID_Escola = ? WHERE ID_Turma = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, turma.getAno());
			stmt.setInt(2, turma.getIdEscola());
			stmt.setInt(3, turma.getIdTurma());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public void delete(Turma turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "DELETE from turma WHERE ID_Turma = %d";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, turma.getIdTurma());
			stmt.executeUpdate(sql);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void insert(Turma turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO turma (Ano, ID_Escola) VALUES (?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, turma.getAno());
			stmt.setInt(2, turma.getIdEscola());
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
