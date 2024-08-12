package br.com.alura;

import java.util.Objects;

public class Aluno {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		if(nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		}
		
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() {
		return "[Aluno: " + this.getNome() + ", matricula: " + this.getNumeroMatricula() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numeroMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(nome, other.nome) && numeroMatricula == other.numeroMatricula;
	}

//	@Override
//	public int compareTo(Aluno outroAluno) {		
//		return this.nome.compareTo(outroAluno.nome);
//	}
	
	
	
	// sempre que se reescrever o metodo equals, deve ser reescrito também o metodo hashcode
	
//	@Override
//	public boolean equals(Object obj) {		
//		Aluno outro = (Aluno) obj;	
//		return this.nome.equals(outro.nome);
//	}
//	
//	@Override
//	public int hashCode() {		
//		return this.nome.hashCode();
//	}
}
