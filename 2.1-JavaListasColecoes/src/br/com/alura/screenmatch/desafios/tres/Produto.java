package br.com.alura.screenmatch.desafios.tres;

import java.util.ArrayList;

public class Produto {
	
	private String nome;
	private float preco;
	
	Produto(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	
//	public ArrayList<?> mediaPreco() {				
//		float soma = 0;	
//		
//		ArrayList<Produto> lista = new ArrayList<>();
//		
//		for (Produto produto : lista) {
//			produto.getPreco();	
//		}	
//		soma+=soma/lista.size();
//		return lista;		
//	}
}
