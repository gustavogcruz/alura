package br.com.alura.screenmatch.desafios.tres;

import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {
		
//		Cachorro cachorro1 = new Cachorro();
//		cachorro1.setNome("Toto");
//		
//		Cachorro cachorro2 = new Cachorro();
//		cachorro2.setNome("Bolt");
//		
//		Animal animal1 = new Animal();
//		animal1.setNome("Layla");
//		
//		System.out.println("Lista de Animais:\n");
//		ArrayList<Cachorro> lista = new ArrayList<>();
//			//lista.add(animal1);
//			lista.add(cachorro1);
//			lista.add(cachorro2);			
//		
//		for (Cachorro dog : lista) {
//			System.out.println(dog.getNome());
//			if(dog instanceof Animal animal) {
//				System.out.println("Classificação " + dog.calculaIdadeHumana(0));
//			}
//		}	
		
		
//        Animal animal = new Cachorro();
//
//        if (animal instanceof Cachorro) {
//            Cachorro cachorro = (Cachorro) animal;
//            
//            System.out.println("Agora você pode usar o objeto 'cachorro' como um Cachorro.");
//        } else {
//            System.out.println("O objeto não é um Cachorro.");
//        }
		

//		Produto produto1 = new Produto("Café", 19.99f);
//		Produto produto2 = new Produto("Chá", 9.99f);
//		
//		ArrayList<Produto> lista = new ArrayList<>();
//		lista.add(produto1);
//		lista.add(produto2);
//		
//		float soma = 0;
//		for (Produto produto : lista) {
//			 soma+= produto.getPreco();		
//		}
//		 double mediaPreco = (soma / lista.size());	
//		System.out.printf("Media preço: R$ %.2f %n",mediaPreco);
		
//        Circulo circulo = new Circulo();
//        circulo.raio = 5;
//
//        Quadrado quadrado = new Quadrado();
//        quadrado.lado = 4;
//
//        // Lista de formas
//        ArrayList<Forma> listaFormas = new ArrayList<>();
//        listaFormas.add(circulo);
//        listaFormas.add(quadrado);
//
//        // Calcular e imprimir a área de cada forma
//        for (Forma forma : listaFormas) {
//            System.out.println("Área: " + forma.calcularArea());
//        }
		
        ContaBancaria conta1 = new ContaBancaria(101, 1500.0);
        ContaBancaria conta2 = new ContaBancaria(102, 2500.0);
        ContaBancaria conta3 = new ContaBancaria(103, 1800.0);
        ContaBancaria conta4 = new ContaBancaria(104, 3200.0);

        ArrayList<ContaBancaria> listaContas = new ArrayList<>();
        listaContas.add(conta1);
        listaContas.add(conta2);
        listaContas.add(conta3);
        listaContas.add(conta4);

        ContaBancaria contaMaiorSaldo = listaContas.get(0);
        for (ContaBancaria conta : listaContas) {
            if (conta.getSaldo() > contaMaiorSaldo.getSaldo()) {
                contaMaiorSaldo = conta;
            }
        }

        System.out.println("Conta com o maior saldo - Número: " + contaMaiorSaldo.getNumero() +
                ", Saldo: " + contaMaiorSaldo.getSaldo());
		
	}
}
