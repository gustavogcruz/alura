package br.com.alura.screenmatch.desafios.tres;

public class Animal {
	
	private String nome;
	private String raca;
	private int idade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {		
		return "Nome: " + this.getNome() + "\nIdade: " + this.getIdade();
	}
	
	public int calculaIdadeHumana (int idade) {
		return this.idade = (idade * 7);
	}

}
