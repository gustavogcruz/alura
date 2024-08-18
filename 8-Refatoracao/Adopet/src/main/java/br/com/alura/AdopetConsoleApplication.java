package br.com.alura;

//Modificador private: o método só pode ser acessado dentro da mesma classe.
//Modificador public: o método pode ser acessado de qualquer classe.
//Modificador default (sem modificador explícito): o método pode ser acessado apenas por classes que estão no mesmo pacote.
//Modificador protected: o método só pode ser acessado através de herança.

import java.util.Scanner;

public class AdopetConsoleApplication {		


	public static void main(String[] args) {
		
		CommandExecutor commandExecutor = new CommandExecutor();
		System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
		
		try {
			int opcaoEscolhida = 0;
			while (opcaoEscolhida != 5) {
				exibirMenu();

				String textoDigitado = new Scanner(System.in).nextLine();
				opcaoEscolhida = Integer.parseInt(textoDigitado);
				
				switch (opcaoEscolhida) {
					case 1 -> commandExecutor.executeCommand(new ListarAbrigoCommand());
					case 2 -> commandExecutor.executeCommand(new CadastrarAbrigoCommand());
					case 3 -> commandExecutor.executeCommand(new ListarPetsAbrigoCommand());
					case 4 -> commandExecutor.executeCommand(new ImportarPetsAbrigoCommand());
					case 5 -> System.exit(0);
					default -> opcaoEscolhida = 0;
				}
			}
			System.out.println("Finalizando o programa...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void exibirMenu() {
		System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
		System.out.println("1 -> Listar abrigos cadastrados");
		System.out.println("2 -> Cadastrar novo abrigo");
		System.out.println("3 -> Listar pets do abrigo");
		System.out.println("4 -> Importar pets do abrigo");
		System.out.println("5 -> Sair");		
	}

}
