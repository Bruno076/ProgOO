
public class Mamifero extends Animal{
	private String corPelo;
		
	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}

	@Override
	public void locomover() {
		System.out.println("Mamifero se locomovendo");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Mamifero comendo");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Mamifero emitindo Som");
		
	}	
	
}
