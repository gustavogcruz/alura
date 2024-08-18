package br.com.alura;

import java.io.IOException;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;

public class ListarAbrigoCommand implements Command {

	@Override
	public void execute() {
		try {

			ClientHttpConfiguration client = new ClientHttpConfiguration();
			AbrigoService abrigoService = new AbrigoService(client);

			abrigoService.listarAbrigos();
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
