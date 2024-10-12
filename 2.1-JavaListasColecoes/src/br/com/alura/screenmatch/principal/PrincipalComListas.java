package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections; // metodo estático
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
	
	public static void main(String[] args) {
		
		Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
		meuFilme.avalia(9);
		Filme outroFilme = new Filme("Avatar", 2023);
		outroFilme.avalia(6);
		Serie lost = new Serie("Lost", 2000);
		Serie dragao = new Serie("A Casa do Dragão", 2022);
		
		ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        lista.add(dragao);
        
//        System.out.println("Tamanho da Lista de Filmes: " + lista.size());
//        System.out.println("Primeiro filme: " + lista.get(0).getNome());
//        System.out.println("toString do filme: " + lista.get(0).toString());
//        System.out.println("toString do serie: " + lista.get(3).toString());
//        System.out.println(lista);
        
        //System.out.println("Lista de Titulos:\n");
        for (Titulo item : lista) {
			//System.out.println(item.getNome());
			if(item instanceof Filme filme && filme.getClassificacao() > 2) {
			//Filme filme = (Filme)item; - Java 8 - O item é um Filme, trate ele como Filme
			//System.out.println("Classificação " + filme.getClassificacao());
			}
		}
        
        //System.out.println("\nLambda");
        //lista.forEach(nome -> System.out.println(nome)); // a partir do Java 8, foi adicionado na interface List, 
        //a qual a classe ArrayList implementa, um novo método chamado forEach. A expressão lambda nome -> System.out.println(nome)
        
        //Method Reference
        //System.out.println("\nMethod Reference");
        //lista.forEach(System.out::println);
        
        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Xuxa");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");        
        
        //System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        //System.out.println("Depois da ordenação:\n" + buscaPorArtista);
        
        //Ordenação de titulo - falta forma de comparação
        Collections.sort(lista); // compareTo
        System.out.println("Ordenando por Título:\n" + lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por Ano de Lançamento:\n" + lista);
        
	}

}
