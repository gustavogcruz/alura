package br.com.alura.screenmatch.principal;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloDTO;

public class PrincipalComBusca {
	
	public static void main(String[] args) throws IOException, InterruptedException {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String busca = "";
			List<Titulo> titulos = new ArrayList<>();
			
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder()
					.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
					.setPrettyPrinting()
					.create();
			
			while (!busca.equalsIgnoreCase("sair!")) {
			
			System.out.println("Digite um filme para busca:");
			busca = scanner.nextLine();
			
			if(busca.equalsIgnoreCase("sair")) {
				break;
			}
			
			String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ","+") + "&apikey=e5e16f8a";
			
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
				// System.out.println(response.body());

				String json = response.body();
				System.out.println(json);

				TituloDTO MeuTituloOmdb = gson.fromJson(json, TituloDTO.class);
				System.out.println(MeuTituloOmdb);		
	
				// try {
				Titulo MeuTitulo = new Titulo(MeuTituloOmdb);
//				
//				FileWriter escrita = new FileWriter("filmes.txt");
//				escrita.write(MeuTitulo.toString());
//				escrita.close();
				
				
//				FileReader leitura = new FileReader("filmes.txt");
//
//				int data = leitura.read();
//				while (data != -1) {
//				    System.out.print((char) data);
//				     data = leitura.read();
//				}
//				leitura.close();
//				System.out.println(" Leitura arquivo! ");
				
				System.out.println(MeuTitulo);
				titulos.add(MeuTitulo);					

			} catch (NumberFormatException e) {
				System.out.println("Ocorreu um erro: ");
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Algum erro de argumento na busca, verifique o termo utilizado.");
				System.out.println(e.getMessage());
			} catch(ErroDeConversaoDeAnoException e) {
				System.out.println(e.getMessage());
			} 
}				System.out.println(titulos);
				
				FileWriter escrita = new FileWriter("filmes.json");
				escrita.write(gson.toJson(titulos));
				escrita.close();

				System.out.println("Programa finalizou corretamente!");

	}  
}
