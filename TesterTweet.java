public class TesterTweet {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("Bruno");
		usuario.setUsuario("@usuarioteste");
		
		usuario.Login();
		
		Tweets t1 = new Tweets();
		t1.Tweetar(usuario);
		usuario.imprimir();
		usuario.Logout();
		
	}

}