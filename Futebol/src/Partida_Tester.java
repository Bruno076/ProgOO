public class Partida_Tester 
	{

	public static void main(String[] args) 
	{
		Time b1 = new Time();
		Time v2 = new Time();
		Partida p1 = new Partida();
		
		b1.setNome("Botafogo");
		v2.setNome("Vasco");
		
		p1.setTimeLocal(b1);
		p1.setTimeVisitante(v2);
		
		p1.iniciarPartida();
		p1.mostrarResultado();
		p1.finalizarPartida();
		
		b1.listar();
		try { Thread.sleep (4000); } catch (InterruptedException ex) {}
		
		v2.listar();
	

		
	}

	}