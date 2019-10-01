public class Bolsista extends Aluno {
	private int bolsa;
	public int getBolsa() 
	{
		return bolsa;
	}
	public void setBolsa(int bolsa) 
	{
		this.bolsa = bolsa;
	}
	public void RenovarBolsa() {
		System.out.println("Renovamento de bolsa concluido");
	}

	@Override
	public void PagarMensalidade()
	{
		System.out.println(""+ getNome()+ " pagou a bolsa no valor de R$"+ bolsa);
	}
	
	
}