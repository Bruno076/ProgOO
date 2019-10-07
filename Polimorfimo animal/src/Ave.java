
public class Ave extends Animal{

	private String corPena;
	
	@Override
	public void locomover() {
		System.out.println("Ave se locomovendo");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Ave se alimentando");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Ave emitindo Som");
		
	}

	public String getCorPena() {
		return corPena;
	}

	public void setCorPena(String corPena) {
		this.corPena = corPena;
	}	
		
	public void fazerNinho() {
		
		System.out.println("Ave fazendo Ninho");
	}
	
}
