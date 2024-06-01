package br.com.alura.screenmatch.modelo;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Episodio implements Classificavel{
	
	private int numero;
	private String nome;
	private Serie serie;
	private int totalVisualizacoes;
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setTotalVisualizacoes(int totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;
	}
	
	public int getTotalVisualizacoes() {
		return totalVisualizacoes;
	}

	@Override
	public int getClassificacao() {
		 if (totalVisualizacoes > 100) {
			 return 4;
		 } else	if (totalVisualizacoes > 50 ){
			 return 2;
		 } else return 1;	
	}

}
