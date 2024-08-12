package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;

import java.util.HashSet;
import java.util.List;


public class TestaAlunos {
	
	public static void main(String[] args) {
		Collection<String> alunos = new HashSet<>();
		alunos.add("Gustavo Cruz");
		alunos.add("Luciana Neves");
		alunos.add("Théo Castro");
		alunos.add("Ana Neves");
		alunos.add("Gustavo Cruz"); // elemento repetido é ignorado ao ser usar SET
		
		alunos.remove("Ana Neves");
		boolean anaEstaMatriculada = alunos.contains("Ana Neves");		
		System.out.println(anaEstaMatriculada);
		
		System.out.println(alunos.size());
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		//System.out.println(alunos);
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		System.out.println(alunosEmLista);
		System.out.println(alunosEmLista.get(1));
		
		//Collections.sort(alunos);
		
			
	}

}
