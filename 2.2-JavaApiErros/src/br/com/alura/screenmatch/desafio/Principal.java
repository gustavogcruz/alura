package br.com.alura.screenmatch.desafio;

import java.io.IOException;
import java.util.Scanner;

import br.com.alura.screenmatch.principal.GeradorDeArquivo;

public class Principal {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);		
		ConsultaCep consulta = new ConsultaCep();
		
		System.out.println("Digite um número de CEP para consulta:");
		var cep = leitura.nextLine();
		
		try {
		EnderecoDTO endereco = consulta.buscaEndereco(cep);
		System.out.println(endereco);
		GeradorDeArquivo gerador = new GeradorDeArquivo();
		gerador.geraArquivoJson(endereco);
		}catch (RuntimeException | IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Finalizando a aplicação");
		}				
	}
}
