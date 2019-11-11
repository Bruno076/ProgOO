package com.poo.jdbc;

import java.sql.Connection;

public class TestBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conexão Bem Sucedida");
	
	}

}