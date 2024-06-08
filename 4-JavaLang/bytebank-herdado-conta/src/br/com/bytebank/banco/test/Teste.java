// sobrecarga - muda parâmetros
// sobreescrita - não muda parâmetros (herança).

package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		System.out.println("*");
		System.out.println(3);
		System.out.println(false);
		
		ContaCorrente cc = new ContaCorrente(22, 33);
		Object cp = new ContaPoupanca(44, 55);
		
		System.out.println(cc);
		System.out.println(cp);

	}	

}
