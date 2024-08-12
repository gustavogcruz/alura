package br.com.alura;

public class Recibo {
	
	private String descricao;
	private int numero;
	
	
	
	public Recibo(String descricao, int numero) {		
		this.descricao = descricao;
		this.numero = numero;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return "Descrição: " + this.getDescricao() + " Número: " + this.getNumero();

	}

}
