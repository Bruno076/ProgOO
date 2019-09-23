public class Time
	{
	private String nome;
	private int nVitorias;
	private int nEmpates;
	private int nDerrotas;
	private int nPontos;
	
	Time()
	{
		nVitorias = 0;
		nEmpates  = 0;
		nDerrotas = 0;
		nPontos  = 0;
	}
	
	public int getQtdPontos() 
	{
		return nPontos;
	}
	public void setQtdPontos(int qtdPontos) 
	{
		this.nPontos = qtdPontos;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public int getQtdVitorias() 
	{
		return nVitorias;
	}
	public void setQtdVitorias(int qtdVitorias) 
	{
		this.nVitorias = qtdVitorias;
	}
	public int getQtdEmpates() 
	{
		return nEmpates;
	}
	public void setQtdEmpates(int qtdEmpates) 
	{
		this.nEmpates = qtdEmpates;
	}
	public int getQtdDerrotas() 
	{
		return nDerrotas;
	}
	public void setQtdDerrotas(int qtdDerrotas) 
	{
		this.nDerrotas = qtdDerrotas;
	}
	
	public void listar()
	{
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Time : "+ nome);
		System.out.println("Vitorias: "+ nVitorias);
		System.out.println("Empates: "+ nEmpates);
		System.out.println("Derrotas: " + nDerrotas);
		System.out.println("Pontos: " + nPontos);
	}	
	}