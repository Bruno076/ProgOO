public class Tester {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Visitante v1 = new Visitante();
		Bolsista b1 = new Bolsista();
		Tecnico t1 = new Tecnico();
		Professor p1 = new Professor();
		
				// Aluno
				a1.setCurso("S.I.");
				a1.setIdade(20);
				a1.setMatricula(00501);
				a1.setNome("Bruno");
				a1.setSexo("M");
				a1.PagarMensalidade();
				
				// Visitante
				v1.setNome("Primeiro Visitante");
				v1.setIdade(27);
				v1.setSexo("M");
		
		
				// Bolsista
				b1.setBolsa(1150);
				b1.setCurso("Pedagogia");
				b1.setIdade(19);
				b1.setMatricula(00500);
				b1.setNome("Danilo");
				b1.setSexo("M");
				b1.PagarMensalidade();
		
				// Técnico
				t1.setCurso("S.I.");
				t1.setIdade(21);
				t1.setMatricula(777);
				t1.setNome("Roberto");
				t1.setSexo("M");
				t1.Praticar();
				t1.PagarMensalidade();
				t1.setRegistroProfissional("Analista de Sistemas");
				
				// Professor
				p1.setEspecialidade("Direito");
				p1.setIdade(38);
				p1.setNome("Anderson");
				p1.setSalario(4800);
				p1.setSexo("M");
				p1.receberAumento();
		
		
	}

}