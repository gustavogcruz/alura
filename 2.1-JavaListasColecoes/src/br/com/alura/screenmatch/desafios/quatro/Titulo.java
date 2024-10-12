package br.com.alura.screenmatch.desafios.quatro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Titulo implements Comparable<Titulo>{
	
	private String nome;
	
	public Titulo(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		
		return this.nome;
	}
	
	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}
	
	public static void main(String[] args) {
		
		Titulo t1 = new Titulo("Lost");
		Titulo t2 = new Titulo("Avatar");
		Titulo t3 = new Titulo("Matrix");
		Titulo t4 = new Titulo("DogVille");
		
		List<Titulo> listaTitulos;
			listaTitulos = new LinkedList<>();
			listaTitulos.add(t3);
			listaTitulos.add(t4);
			System.out.println(listaTitulos);
			
			Collections.sort(listaTitulos);
			System.out.println("Ordenado pelo nome:\n" + listaTitulos);
			
			listaTitulos = new ArrayList<>();
			listaTitulos.add(t1);
			listaTitulos.add(t2);
			System.out.println(listaTitulos);
			
			Collections.sort(listaTitulos);
			System.out.println("Ordenado pelo nome:\n" + listaTitulos);
		
	}

}
