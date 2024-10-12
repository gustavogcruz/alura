package br.com.alura.screenmatch.desafios.um;

import java.util.ArrayList;

public class Pessoa {
	
	private String nome;
	private int idade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
	return "Nome Pessoa: " + this.getNome();
	}
	
	public static void main(String[] args) {
		
		var pessoa = new Pessoa();
        pessoa.setNome("Ana");
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Theo");
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Luciana");
        
        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        listaDePessoas.add(pessoa1);
        listaDePessoas.add(pessoa3);
        listaDePessoas.add(pessoa);
        
        System.out.println("Tamanho da Lista de Pessoas: " + listaDePessoas.size());
        System.out.println("Nome da Primeia Pessoa: " + listaDePessoas.get(0).getNome());
        //System.out.println(listaDePessoas);
        
        System.out.println("Lista de Pessoas:");
        for (Pessoa pessoa4 : listaDePessoas) {
            System.out.println(pessoa4);
        }		
		
	}

}
