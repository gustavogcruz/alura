package br.com.alura;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>(); 	
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas); //retorna uma lista readonly
 	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
//	public int getTempoTotal() {
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
//	}
	
	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		return "[Curso: " + this.getNome() + ", Tempo total: " + this.getTempoTotal() + ","
				+ "aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
		
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos); //retorna uma conjunto readonly
	}

	public boolean estaMatriculado(Aluno aluno) {		
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {		
		for (Aluno aluno : alunos) {
			if(aluno.getNumeroMatricula() == numero);
				return aluno;
		}
		throw new NoSuchElementException("Matricula não encontrada " + numero);
		
	}
	
	public Aluno buscaMatriculaMap(int numero) {
		if(!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException("Matricula não encontrada " + numero);	
		}
		return matriculaParaAluno.get(numero);
	}
	
	
	
	
}
