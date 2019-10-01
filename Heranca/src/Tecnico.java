public class Tecnico extends Aluno{
	private String registroProfissional;
	
	public String getRegistroProfissional() 
	{
		return registroProfissional;
	}
	public void setRegistroProfissional(String registroProfissional) 
	{
		this.registroProfissional = registroProfissional;
	}
	
	public void Praticar()
	{
		System.out.println(""+getNome() +" ira praticar!");
	}
	
		
}