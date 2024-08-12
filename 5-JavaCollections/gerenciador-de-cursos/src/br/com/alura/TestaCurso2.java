package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestaCurso2 {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona((new Aula("Trabalhando com LinkedList", 21)));
		javaColecoes.adiciona((new Aula("Criando uma Aula", 20)));
		javaColecoes.adiciona((new Aula("Modelando com coleções", 22)));
		
		//System.out.println(javaColecoes.getAulas());
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes.toString());
	}

}
