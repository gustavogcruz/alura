package br.com.alura.screenmatch.desafios.tres;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

//		Numeros numeros = new Numeros(4, 2);
//
//		try {
//			numeros.divisao();
//		} catch (ArithmeticException e) {
//			System.out.println("Erro: Número não pode ser divido por ZERO " + e.getMessage());
//		}
		
	
//		@SuppressWarnings("resource")
//		Scanner leitura = new Scanner(System.in);
//		System.out.println("Digite uma senha. (A senha deve possuir mais de 8 digitos)");
//		
//		Senha senha = new Senha();
//		senha.setSenha(leitura.nextLine());
//		
//		try {
//		senha.verificaSenha();	
//		} catch (SenhaException e) {
//			System.out.println(e.getMessage());
//		}
		
		@SuppressWarnings("resource")
     	Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o nome de um usuáro: ");
		
		GitHubApi usuario = new GitHubApi();
		usuario.setUsuario(leitura.nextLine());
		
		try {
		usuario.realizaBuscaUsuario();
		} catch (ErroConsultaGitHubException e) {
			System.out.println(e.getMessage());
		}		
		
	}
}
