package br.com.alura.screenmatch.desafios.tres;

import java.util.ArrayList;

public class Palavras {
	
	public static void main(String[] args) {
		
		String ana = "Ana";
		String theo = "Théo";
		String luciana = "Luciana";
		
		ArrayList<String> lista = new ArrayList<>();
		lista.add(ana);
		lista.add(theo);
		lista.add(luciana);
		
		//for-each
		for (String nomes : lista) {
			System.out.println(nomes);
		}
		
		//method references
		lista.forEach(System.out::println);
		
		//lambda
		lista.forEach(nomes -> System.out.println(nomes));	
		
	}	
}
