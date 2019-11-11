package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {

	public void Create(Aluno aluno)
	{
		Connection con =  ConnectionFactory.getConnection();
		System.out.println("Conexao Bem Sucedida");
		PreparedStatement stmt = null;

		String sql = "insert into aluno values(?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());

			stmt.executeUpdate();
			System.out.println("Inserido com sucesso");

		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erro, nao inserido");
		}
		finally
		{
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
		public List<Aluno> readAll()
		{
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Conexao Bem Sucedida");
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String sql = "select * from aluno";
			List<Aluno> Alunos = new ArrayList<Aluno>();

			try
			{
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next())
				{
					Aluno aluno = new Aluno();
					aluno.setMatricula(rs.getString("matricula"));
					aluno.setNome(rs.getString("nome"));
					Alunos.add(aluno);
				}


				System.out.println("Pesquisa realizada");
			}
			catch(SQLException e)
			{
				System.out.println("Erro na leitura");
			}
			finally{
				ConnectionFactory.closeConnection(con,stmt);
			}

			return Alunos;

		}
		public void Delete(Aluno Aluno)
		{
			Connection con =  ConnectionFactory.getConnection();
			System.out.println("Conexao Bem Sucedida");
			PreparedStatement stmt = null;

			String sql = "delete from aluno where matricula = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, Aluno.getMatricula());

				stmt.executeUpdate();
				System.out.println("Aluno deletado");

			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Erro ao excluir");
			}
			finally
			{
				ConnectionFactory.closeConnection(con,stmt);
			}
		}
		public void Update (Aluno Aluno)
		{
			Connection con =  ConnectionFactory.getConnection();
			System.out.println("Conexao Bem Sucedida");
			PreparedStatement stmt = null;

			String sql = "update aluno set nome = ? where matricula = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, Aluno.getNome());
				stmt.setString(1, Aluno.getMatricula());

				stmt.executeUpdate();
				System.out.println("Informacao do Aluno atualizada");

			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Erro ao atualizar infomacao.");
			}
			finally
			{
				ConnectionFactory.closeConnection(con,stmt);
			}
		}


	}