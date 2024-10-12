package br.com.alura.screenmatch.desafios.dois;

import java.util.ArrayList;

public class Produto {
	
	private String nome;
	private float preco;
	private int quantidade;
	
	
	public Produto(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getNome() {
		return nome;
	}


	public float getPreco() {
		return preco;
	}	
	
	@Override
	public String toString() {		
		return "Nome do Produto: " + this.getNome() + " Preço: R$ " + this.getPreco();
	}
	
	public static void main(String[] args) {        
        
        Produto produto1 = new Produto("Chá", 5.99f);
        Produto produto2 = new Produto("Café", 19.99f);
        ProdutoPerecivel produto3 = new ProdutoPerecivel("Donarem", 59.99f);
        
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);
        listaDeProdutos.add(produto3);
        //System.out.println(listaDeProdutos);
        
        System.out.println("Produto na posição ZERO: " + listaDeProdutos.get(0).getNome());
        
        System.out.println("Lista de Pessoas:");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto);
        }
		
	}	

}
