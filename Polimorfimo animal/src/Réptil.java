
public class R�ptil extends Animal {
	
	private String corEscama;

	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}

	@Override
	public void locomover() {
		System.out.println("R�ptil se locomovendo");
		
	}

	@Override
	public void alimentar() {
		System.out.println("R�ptil se alimentando");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("R�ptil emitindo Som");
		
	}

}
