package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	public DadosPessoais() { // JPA exige um construtor padrão		
	}
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	@Override
	public String toString() {		
		return "Detalhe Cliente [Nome: " + nome 
		+ ", CPF: " + cpf + "]";
	}
}
