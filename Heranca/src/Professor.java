public class Professor extends Pessoa {
	private int salario;
	private String especialidade;
	public void receberAumento()
	{
		System.out.println("Aumento no salario: Salario antigo= R$"+salario+" Salario atual R$"+ (salario*0.10+salario));
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	

}