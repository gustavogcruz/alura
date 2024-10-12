package br.com.alura.screenmatch.desafios.um;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class PrincipalBuscaReceita {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite uma receita para busca:");
		var busca = leitura.nextLine();
		
		String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + busca;		
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco)).build();
		
		   HttpResponse<String> response = client
				     .send(request, BodyHandlers.ofString()); 
		
		   System.out.println(response.body());
   
	}

}
