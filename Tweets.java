import java.util.Scanner;

public class Tweets {
	private String texto;
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void  Tweetar(Usuario u1) {
		String teste = "s";
		while(teste.equals("s"))
		{
			if(u1.isLogado())
			{
				
				Scanner dados = new Scanner(System.in);
				System.out.print("Digite o tweet: ");
				String tweet = dados.nextLine();
				
				if(tweet.length() >= 140)
				{
					System.out.println("Você ultrapassou o limite de caracteres estabelecido!");
				}
				else
				{
					Tweets t2 = new Tweets();
					t2.setTexto(tweet);
					//this.texto = tweet;
					u1.adicionarTweet(t2);
					System.out.println("Tweet postado.");
					System.out.print("Deseja postar mais algum tweet? (s/n):");
					teste = dados.next();
					
				}
			}
			else
			{
				System.out.println("Logue primeiro para postar");
				break;
				
}
}
		System.out.println("\r\n");
}
}
