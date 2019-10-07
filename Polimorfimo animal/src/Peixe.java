
public class Peixe extends Animal{
	
	private String corEscama;

	@Override
	public void locomover() {
		System.out.println("Peixe se locomovendo");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Peixe se alimentando");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Peixe emitindo Som");
		
	}

	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}
	
	public void soltarBolha() {
		
		System.out.println("Soltando bolhas!");
	}

}
