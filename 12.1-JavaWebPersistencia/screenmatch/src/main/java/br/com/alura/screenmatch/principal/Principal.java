package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.screenmatch.model.DadosSerieDTO;
import br.com.alura.screenmatch.model.DadosTemporadaDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + (System.getenv("OMBD_KEY"));
    private List<DadosSerieDTO> dadosSeries = new ArrayList<>();
    private  List<DadosTemporadaDTO> temporadas = new ArrayList<>();
    private SerieRepository repository;
    
    

    public Principal(SerieRepository repository) {
		this.repository = repository;
	}

	public void exibeMenu() {
    	var opcao = -1;
    	while(opcao !=0) {
        var menu = """
                1 - Buscar séries
                2 - Buscar episódios
                3 - Listar séries buscadas
                              
                0 - Sair                                 
                """;

        System.out.println(menu);
        opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao) {
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 3:
            	listarSeriesBuscadas();
            	break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
 }

    private void buscarSerieWeb() {
        DadosSerieDTO dados = getDadosSerie();
        Serie serie = new Serie (dados);
        //dadosSeries.add(dados);
        repository.save(serie);
        System.out.println(dados);
    }

    private DadosSerieDTO getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerieDTO dados = conversor.obterDados(json, DadosSerieDTO.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        DadosSerieDTO dadosSerie = getDadosSerie(); 
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var json = consumo.obterDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporadaDTO dadosTemporada = conversor.obterDados(json, DadosTemporadaDTO.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }
    
    private void listarSeriesBuscadas() {
    	
    	List<Serie> series = //new ArrayList<>();
    	repository.findAll();
//    	series = dadosSeries.stream()
//    	.map(d -> new Serie(d))
//    	.collect(Collectors.toList());
    	series.stream()
    	.sorted(Comparator.comparing(Serie::getGenero))
    	.forEach(System.out::println);
    }
}