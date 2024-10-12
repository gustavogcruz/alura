package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.desafio.EnderecoDTO;

public class GeradorDeArquivo {
	
	public void geraArquivoJson(EnderecoDTO endereco) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter escrita = new FileWriter(endereco.cep() + ".json");
		escrita.write(gson.toJson(endereco));
		escrita.close();
	}

}
