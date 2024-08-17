package br.com.alura;

//Modificador private: o método só pode ser acessado dentro da mesma classe.
//Modificador public: o método pode ser acessado de qualquer classe.
//Modificador default (sem modificador explícito): o método pode ser acessado apenas por classes que estão no mesmo pacote.
//Modificador protected: o método só pode ser acessado através de herança.

import java.util.Scanner;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

public class AdopetConsoleApplication {

	public static void main(String[] args) {
		System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
		
		ClientHttpConfiguration client = new ClientHttpConfiguration();
		AbrigoService abrigoService = new AbrigoService(client);
		PetService petService = new PetService(client);
		
		try {
			int opcaoEscolhida = 0;
			while (opcaoEscolhida != 5) {
				System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
				System.out.println("1 -> Listar abrigos cadastrados");
				System.out.println("2 -> Cadastrar novo abrigo");
				System.out.println("3 -> Listar pets do abrigo");
				System.out.println("4 -> Importar pets do abrigo");
				System.out.println("5 -> Sair");

				String textoDigitado = new Scanner(System.in).nextLine();
				opcaoEscolhida = Integer.parseInt(textoDigitado);

				if (opcaoEscolhida == 1) {
					abrigoService.listarAbrigos();
				} else if (opcaoEscolhida == 2) {
					abrigoService.cadastrarAbrigo();
				} else if (opcaoEscolhida == 3) {
					petService.listarPetsAbrigo();
				} else if (opcaoEscolhida == 4) {
					petService.importarPetsAbrigo();
				} else if (opcaoEscolhida == 5) {
					break;
				} else {
					System.out.println("NÚMERO INVÁLIDO!");
					opcaoEscolhida = 0;
				}
			}
			System.out.println("Finalizando o programa...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
