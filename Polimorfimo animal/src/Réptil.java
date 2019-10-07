
public class Réptil extends Animal {
	
	private String corEscama;

	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}

	@Override
	public void locomover() {
		System.out.println("Réptil se locomovendo");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Réptil se alimentando");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Réptil emitindo Som");
		
	}

}
