package br.com.alura.screenmatch.modelo;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Filme extends Title implements Classificavel{
	
	private String diretor;
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public int getClassificacao() {
				
		return (int) (mediaAvaliacoes() /2) ;
	}

}
