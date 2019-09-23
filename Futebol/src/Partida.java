import java.util.Date;

//Dupla: Bruno Legentil e Vitor de Souza


public class Partida implements IPartida
	{
	private Time timeLocal;
	private int scoreLocal;
	private Time timeVisitante;
	private int scoreVisitante;
	private Date dataPartida;
	
	public Time getTimeLocal() 
	{
		return timeLocal;
	}

	public void setTimeLocal(Time timeLocal) 
	{
		this.timeLocal = timeLocal;
	}
	
	public Time getTimeVisitante() 
	{
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) 
	{
		this.timeVisitante = timeVisitante;
	}

	public Date getDataPartida() 
	{
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) 
	{
		this.dataPartida = dataPartida;
	}
	
	public int Random_Placar(int min, int max)
	{
		int numrandom = (int)((Math.random()*((max-min)+1))+min);
		return numrandom;
	}
	
	@Override
	public void iniciarPartida() 
		{
		System.out.println("Hino Nacional!");
		System.out.println("Apita o Árbitro, começa a partida!");
		scoreLocal = Random_Placar(0,10);
		scoreVisitante = Random_Placar(0,10);
	
		}

	@Override
	public void mostrarResultado() 
		{
		System.out.println(timeLocal.getNome()+" "+scoreLocal+ " X "+scoreVisitante+" "+timeVisitante.getNome());
		try { Thread.sleep (4000); } catch (InterruptedException ex) {}
		}
	

	@Override
	public void finalizarPartida() 
		{
		if (scoreLocal == scoreVisitante)
		{	// TimeLocal Empatou (+1 Ponto)
			timeLocal.setQtdEmpates(timeLocal.getQtdEmpates()+1);
			timeLocal.setQtdPontos(timeLocal.getQtdPontos()+1);
			// TimeVisitante Empatou (+1 Ponto)
			timeVisitante.setQtdEmpates(timeVisitante.getQtdEmpates()+1);
			timeVisitante.setQtdPontos(timeVisitante.getQtdPontos()+1);
		}
		
		
		else if(scoreLocal > scoreVisitante)
		{
			// TimeLocal Venceu (+3 Pontos)
			timeLocal.setQtdVitorias(timeLocal.getQtdVitorias() + 1); 
			timeLocal.setQtdPontos(timeLocal.getQtdPontos() + 3);
			// TimeVisitante Perdeu (+1 Derrota)
			timeVisitante.setQtdDerrotas(timeVisitante.getQtdDerrotas() + 1);
		}
		
		
		else
		{
			// TimeVisitante Venceu (+3 Pontos)
			timeVisitante.setQtdVitorias(timeVisitante.getQtdVitorias() + 1);
			timeVisitante.setQtdPontos(timeVisitante.getQtdPontos() +3);
			// TimeLocal Perdeu (+1 Derrota)
			timeLocal.setQtdDerrotas(timeLocal.getQtdDerrotas() + 1);
		}
		}	
		}
