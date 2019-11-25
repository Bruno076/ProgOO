package com.poo.model;

public class Escola {

	private int idEscola;
	private String nome;
	
	
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return String.format("%05d - %s", idEscola, nome);
	}
}
