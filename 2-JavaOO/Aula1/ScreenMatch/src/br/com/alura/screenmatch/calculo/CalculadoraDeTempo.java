package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelo.Title;

public class CalculadoraDeTempo {
	private int tempoTotal = 0;
	
	public int getTempoTotal() {
		return this.tempoTotal;
	}
	
//	public void inclui(Filme f) {
//		this.tempoTotal += f.getDuracaoEmMinutos();
//	}
//	
//	public void inclui(Serie s) {
//		this.tempoTotal += s.getDuracaoEmMinutos();
//	}
	
	public void inclui(Title t) {
		System.out.println("Adicionando: " + t);
		this.tempoTotal += t.getDuracaoEmMinutos();
		
	}


}
