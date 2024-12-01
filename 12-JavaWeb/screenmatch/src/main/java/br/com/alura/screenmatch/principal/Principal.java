package br.com.alura.screenmatch.principal;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.DoubleSummaryStatistics;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.Scanner;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import br.com.alura.screenmatch.model.DadosEpisodioDTO;
//import br.com.alura.screenmatch.model.DadosSerieDTO;
//import br.com.alura.screenmatch.model.DadosTemporadaDTO;
//import br.com.alura.screenmatch.model.Episodio;
//import br.com.alura.screenmatch.service.ConsumoAPI;
//import br.com.alura.screenmatch.service.ConverteDados;
//import ch.qos.logback.core.net.SyslogOutputStream;
//
public class Principal {
//	
//	private Scanner leitura = new Scanner(System.in);
//	private static final String ENDERECO = "http://www.omdbapi.com/?t=";
//	private static final String API_KEY ="&apikey=e5e16f8a";
//	private ConsumoAPI consumoApi = new ConsumoAPI();
//	private ConverteDados conversor = new ConverteDados();
//	
public void exibeMenu() {
//		
//		System.out.println("Digite o nome da série para busca:");
//		var nomeSerie = leitura.nextLine();
//		var json = consumoApi.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + API_KEY);		
//		DadosSerieDTO dadosSerie = conversor.obterDados(json, DadosSerieDTO.class);
//		System.out.println(dadosSerie);
//		
//		System.out.println("\nTemporadas");
//		List<DadosTemporadaDTO> temporadas = new ArrayList<>();
//		for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
//			json = consumoApi.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + "&Season=" + i + API_KEY);
//			DadosTemporadaDTO dadosTemporada = conversor.obterDados(json, DadosTemporadaDTO.class);
//			temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println); // method reference
////		
////		for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
////			List<DadosEpisodioDTO> episodiosTemporada = temporadas.get(i).episodios();
////			for (int j = 0; j< episodiosTemporada.size(); j++) {
////				System.out.println(episodiosTemporada.get(j).titulo());
////			}
////		}
//		
////		temporadas
////		.forEach(t -> t.episodios() // expressão lambda
////		.forEach(e -> System.out.println(e.titulo())));
////		
////		List<DadosEpisodioDTO> dadosEpisodios = temporadas.stream() //fluxo de dados
////				.flatMap(t -> t.episodios().stream()) // flatMap - lista dentro de Lista
////				.collect(Collectors.toList()); // toList - lista imutavel
//		
////		System.out.println("\nTop 10 episódios");
////		dadosEpisodios.stream()
////		.filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
////		.peek(e -> System.out.println("Primeiro filtro(N/A) " + e))
////		.sorted(Comparator.comparing(DadosEpisodioDTO::avaliacao).reversed())
////		.peek(e -> System.out.println("Segundo filtro(Ordenação) " + e))
////		.limit(10)
////		.peek(e -> System.out.println("Terceiro filtro(Limite) " + e))
////		.map(e -> e.titulo().toUpperCase())
////		.peek(e -> System.out.println("Quarto filtro(Map) " + e))
////		.forEach(System.out::println);
//		
//		System.out.println("\nEpisódios por Temporada");
//		List<Episodio> episodio = temporadas.stream()
//				.flatMap(t -> t.episodios().stream()
//				.map(d -> new Episodio(t.numero(), d)))
//				.collect(Collectors.toList());
//		
//		episodio.forEach(System.out::println);
//		
////		//busca por algo especifico
////		System.out.println("\nDigite um trecho do título do episodio");
////		var trechoTitulo = leitura.nextLine();
////		Optional<Episodio> episodioBuscado = episodio.stream()
////		.filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
////		.findFirst();
////		
////		if(episodioBuscado.isPresent()) {
////			System.out.println("\nEpisodio encontrado.");
////			System.out.println("Temporada: " + episodioBuscado.get().getTemporada() 
////					+ " Episódio: " + episodioBuscado.get().getNumero());
////		} else
////		{
////			System.out.println("Episodio não encontrado.");
////		}
//		
////		System.out.println("Digite uma data para pesquisar episódios:");
////		var ano = leitura.nextInt();
////				leitura.nextLine();//				
////		
////		LocalDate dataBusca = LocalDate.of(ano, 1, 1);		
////		//formatação data
////		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////		episodio.stream()
////		.filter(e -> e .getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
////	    .forEach(e -> System.out.println(
////	    		"Temporada: " + e.getTemporada() + 
////	    				" Episódio: " + e.getTitulo() +
////	    				" Data Lançamento: " + e.getDataLancamento().format(formatador)	    		
////	    		));	  
//		
//		System.out.println("\nMédia Avaliação por Temporada.");
//		Map<Integer, Double> avaliacoesPorTemporada = episodio
//				.stream()
//				.filter(e -> e.getAvaliacao() > 0.0)
//				.collect(Collectors.groupingBy(Episodio::getTemporada,
//						Collectors.averagingDouble(Episodio::getAvaliacao)));
//		System.out.println(avaliacoesPorTemporada);
//		
//		System.out.println("\nEstátistica Série.");
//		DoubleSummaryStatistics est = episodio
//				.stream()
//				.filter(e -> e.getAvaliacao() > 0.0)
//				.collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//		System.out.println(
//				"Qtd episodios: " + est.getCount() +
//				" Média: " + est.getAverage() + 
//				" Pior episodio: " + est.getMin() + 
//				" Melhor episodio: " + est.getMax());
//	    
	}	
//	
}
