
public class AnimalTester {

	public static void main(String[] args) {
		
		Ave A= new Ave();
		Mamifero M = new Mamifero();
		Peixe P = new Peixe();
		Réptil R = new Réptil();
		
		//Aves
		A.setPeso(3);
		A.setIdade(1);
		A.setMembros(1);
		A.setCorPena("Branco");
		A.fazerNinho();
		A.locomover();
		A.alimentar();
		A.emitirSom();
		
		
		//Mamifero
		System.out.println("----------------------------------------");
		M.setPeso(12);
		M.setIdade(5);
		M.setMembros(3);
		M.setCorPelo("Preto");
		M.locomover();
		M.alimentar();
		M.emitirSom();
		
		//Peixe
		System.out.println("----------------------------------------");
		P.setPeso(1);
		P.setIdade(1);
		P.setMembros(5);
		P.setCorEscama("Azul");
		P.soltarBolha();
		P.locomover();
		P.alimentar();
		P.emitirSom();
		
		//Réptil
		System.out.println("----------------------------------------");
		R.setPeso(7);
		R.setIdade(4);
		R.setMembros(4);
		R.setCorEscama("Verde");
		R.locomover();
		R.alimentar();
		R.emitirSom();
		

	}

}
