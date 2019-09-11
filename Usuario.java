import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String usuario;
	private boolean logado;
	private ArrayList<Tweets> t1;
	
	public void Login() {
		Scanner dados = new Scanner(System.in);
		System.out.print("Digite o Login: ");
		String login = dados.next();
		System.out.print("Digite a Senha: ");
		String senha = dados.next();
		if(senha.equals("poo"))
		{
			logado = true;
			System.out.println("Bem vindo, "+nome+"!");
			System.out.println("\r\n");
		}
		else
		{
			System.out.println("Senha incorreta!");
			System.out.print("Tentar novamente? (Digite s para continuar ou n para sair): ");
			String confirmacao = dados.next();
			if(confirmacao.equals("s")){
				System.out.println("\r\n");
				Login(); }
}
}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public boolean isLogado() {
		return logado;
	}

	public Usuario(){
		t1 = new ArrayList<Tweets>();
	}
	
	public void Logout()
	{
		if(logado){
			logado=false;
			System.out.println("Deslogado!"); }
		else {
			System.out.println("Você não está logado!");}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Tweets> getTweets() {
		return t1;
	}
	public void setTweets(ArrayList<Tweets> tweets) {
		this.t1 = tweets;
	}
	public void adicionarTweet(Tweets novoTweet){
		if (logado){
			t1.add(novoTweet);
		}
		else
		{
			System.out.println("Para postar é necessario estar logado");
		}	}
	public void imprimir(){
		for(int i = 0 ; i < t1.size() ; i++){
			Tweets teste;
			teste = t1.get(i);
			System.out.println("Tweet Postado:"+teste.getTexto());
}	}	}