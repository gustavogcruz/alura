package br.com.alura.screenmatch.desafios.quatro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaNumeros {
	
	public static void main(String[] args) {
		
		List<Integer> listaNumeros = new ArrayList<>();
		listaNumeros.add(10);
		listaNumeros.add(1);
		listaNumeros.add(0);
		listaNumeros.add(11);
		listaNumeros.add(6);
		
		System.out.println(listaNumeros);
		Collections.sort(listaNumeros);
		System.out.println("Lista Crescente:\n" + listaNumeros);
		
	}

}
