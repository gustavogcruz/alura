package br.com.alura.screenmatch.desafio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class ConsultaCep {

	public EnderecoDTO buscaEndereco(String cep) {
		
		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");		
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(endereco)
				.build();
		try {

			HttpResponse<String> response = HttpClient.newHttpClient()
					.send(request,BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), EnderecoDTO.class);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível obter o endereço a partir do CEP informado.");  
		}

	}

}
