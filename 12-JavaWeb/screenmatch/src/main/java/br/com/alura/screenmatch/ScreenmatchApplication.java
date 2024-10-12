package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerieDTO;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ConsumoAPI consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=e5e16f8a");
		System.out.println(json);
		
		ConverteDados conversor = new ConverteDados();
		DadosSerieDTO dados = conversor.obterDados(json, DadosSerieDTO.class);
		System.out.println(dados);
	}

}
