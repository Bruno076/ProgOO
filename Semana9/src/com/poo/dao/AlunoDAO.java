package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {
	
	public void insert(Aluno aluno)
	{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO aluno(Nome, Idade, ID_Turma) VALUES (?, ?, ?)";
		
		try{
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setInt(3, aluno.getIdTurma());
			
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	
	}

	public List<Aluno> readAll()
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT Matricula, Nome, Idade, ID_Turma FROM aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("Matricula"));
				aluno.setNome(rs.getString("Nome"));
				aluno.setIdade(rs.getInt("Idade"));
				aluno.setIdTurma(rs.getInt("ID_Turma"));
				
				alunos.add(aluno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela aluno");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return alunos;
	}
	
	public List<Aluno> readAlunosTurma(int idTurma)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT Matricula, Nome, Idade, ID_Turma FROM aluno WHERE ID_Turma = ?";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try{
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idTurma);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("Matricula"));
				aluno.setNome(rs.getString("Nome"));
				aluno.setIdade(rs.getInt("Idade"));
				aluno.setIdTurma(rs.getInt("ID_Turma"));
				
				alunos.add(aluno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela aluno");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return alunos;
	}
	
	public void update(Aluno aluno) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE aluno SET Nome = ?, Idade = ?, ID_Turma = ? WHERE Matricula = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setInt(3, aluno.getIdTurma());
			stmt.setInt(4, aluno.getMatricula());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Aluno aluno) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM aluno WHERE Matricula = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, aluno.getMatricula());
			stmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
