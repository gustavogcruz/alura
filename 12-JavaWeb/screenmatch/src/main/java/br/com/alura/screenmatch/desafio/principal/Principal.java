package br.com.alura.screenmatch.desafio.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.desafio.model.DadosDTO;
import br.com.alura.screenmatch.desafio.model.ModelosDTO;
import br.com.alura.screenmatch.desafio.model.VeiculoDTO;

public class Principal {
	
	
	private Scanner leitura = new Scanner(System.in);
	private static final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
	private ConsumoAPI consumoApi = new ConsumoAPI();
	private ConverteDados conversor = new ConverteDados();
	
	public void exibeMenu() {
		var menu = """
			   *** Tabela FIPE - Opções ***
				   Carro
				   Moto
				   Caminhão			   
				Digite uma das opções para consultar:
				""";
		
		System.out.println(menu);
		var opcao = leitura.nextLine();
		
		String endereco; 
		
		if(opcao.toLowerCase().contains("car")) {
			endereco = URL_BASE + "carros/marcas";
		} else if(opcao.toLowerCase().contains("mot")) {
			endereco = URL_BASE + "motos/marcas";
		} else {
			endereco = URL_BASE + "caminhoes/marcas";
		}
		
		var json = consumoApi.obterDados(endereco);	
		//System.out.println(json);
		var marcas = conversor.obterLista(json, DadosDTO.class);
		marcas.stream()
				.sorted(Comparator.comparing(DadosDTO::codigo))
				.forEach(System.out::println);
		
		System.out.println("\nInforme o código da marca para obter os modelos:");
		var codigoMarca = leitura.nextLine();
		
		endereco = endereco + "/" + codigoMarca + "/modelos";
		json = consumoApi.obterDados(endereco);
		var modeloLista = conversor.obterDados(json, ModelosDTO.class);
		System.out.println("/nModelos da marca");
		modeloLista.modelos().stream()
		.sorted(Comparator.comparing(DadosDTO::codigo))
		.forEach(System.out::println);
		
		System.out.println("\nDigite um trecho do modelo a ser buscado:");
		var nomeModelo = leitura.nextLine();
		
		List<DadosDTO> modelosFiltrados = modeloLista.modelos().stream()
				.filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
				.collect(Collectors.toList());
		
		System.out.println("\nModelos Filtrados: ");
		modelosFiltrados.forEach(System.out::println);
		
		System.out.println("\nDigite o código do modelo buscado:");
		var codigoModelo = leitura.nextLine();
		
		endereco = endereco + "/" + codigoModelo + "/anos";
		json = consumoApi.obterDados(endereco);
		List<DadosDTO> anos = conversor.obterLista(json, DadosDTO.class);
		
		System.out.println("\nAnos do modelo: ");
		anos.forEach(System.out::println);
		
		
		List<VeiculoDTO> veiculos = new ArrayList<>();
		for(int i = 0; i < anos.size(); i++) {
			var enderecoAnos = endereco + "/" + anos.get(i).codigo();
			json = consumoApi.obterDados(enderecoAnos);
			VeiculoDTO veiculo = (conversor.obterDados(json, VeiculoDTO.class));
			veiculos.add(veiculo);
		}
		
		System.out.println("\nModelo filtrado por anos: ");
		veiculos.forEach(System.out::println);
		

	}	

}
