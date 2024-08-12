package br.com.alura;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona((new Aula("Trabalhando com LinkedList", 21)));
		javaColecoes.adiciona((new Aula("Criando uma Aula", 20)));
		javaColecoes.adiciona((new Aula("Modelando com coleções", 22)));

		Aluno a1 = new Aluno("Théo Castro", 01);
		Aluno a2 = new Aluno("Ana Neves", 02);
		Aluno a3 = new Aluno("Luciana Neves", 03);
		Aluno a4 = new Aluno("Gustavo Cruz", 04);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		javaColecoes.matricula(a4);

		System.out.println("Todos os alunos matriculados: ");
//		javaColecoes.getAlunos().forEach(a -> {
//			System.out.println(a);
//		});
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		while (iterador.hasNext()) {
			Aluno proximo = iterador.next();
			System.out.println(proximo);
		}
		
		

//		System.out.println("O Aluno a1 está matriculado?");
//		System.out.println(javaColecoes.estaMatriculado(a1));
//		
//		Aluno a5 = new Aluno("Gustavo Cruz", 04);
//		System.out.println("E este Gustavo, está matriculado?");
//		System.out.println(javaColecoes.estaMatriculado(a5));
//		
//		System.out.println("O a1 é equals ao a5?");
//		System.out.println(a4.equals(a5));
//		
//		// obrigatoriamente o seguinte é true
//		
//		System.out.println("Hashcode: " + (a5.hashCode() == a5.hashCode()));
//		
//		System.out.println("Tamanho: " + javaColecoes.getAlunos().size());
		
		
		
	}

}
