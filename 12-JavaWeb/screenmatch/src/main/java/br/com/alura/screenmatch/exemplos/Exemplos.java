package br.com.alura.screenmatch.exemplos;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Exemplos {
	
	//public static void main(String[] args) {
//		
//		//stream - fluxo de dados
//		List<String> nomes = Arrays
//				.asList("Ana", "Théo", "Luciana");
//			nomes.stream()
//			.sorted() // operação intermediária
//			//.limit(2)
//			.filter(n -> n.startsWith("A"))
//			.map(n -> n.toLowerCase())
//			//.forEach(n -> System.out.println(n));
//			.forEach(System.out::println); //operação final
		
/*começamos com o número 0 e adicionamos 1 a cada iteração para gerar uma sequência numérica*/		
//		Stream.iterate(0, n -> n + 1)
//	     .limit(10)
//	     .forEach(System.out::println);
		
/*O método flatMap é uma operação intermediária que é usada para transformar um Stream de coleções em um Stream de elementos*/		
//		List<List<String>> list = List.of(
//				  List.of("a", "b"),
//				  List.of("c", "d")
//				);
//
//				Stream<String> stream = list.stream()
//				  .flatMap(Collection::stream);
//
//				stream.forEach(System.out::println);
		
/*somamos todos os números da lista usando o método reduce().*/		
//		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//		Optional<Integer> result = numbers.stream().reduce(Integer::sum);
//		result.ifPresent(System.out::println);
//}

}
