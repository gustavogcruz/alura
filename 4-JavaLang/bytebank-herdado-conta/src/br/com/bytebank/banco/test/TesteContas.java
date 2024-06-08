package br.com.bytebank.banco.test;

import br.com.bytebank.banco.especial.ContaEspecial;

// ctrl + shift + o - importa pacotes

import br.com.bytebank.banco.modelo.CalculadorImposto;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SeguroDeVida;

public class TesteContas {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(111, 222);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		CalculadorImposto imposto = new CalculadorImposto();
		imposto.registra(seguro);		
		imposto.registra(cc);
		
		
		ContaPoupanca cp = new ContaPoupanca(222, 333);
		cp.deposita(200.00);
		
		ContaEspecial ce = new ContaEspecial(123, 456);
		ce.getSaldo();
		
		//cc.transfere(10.0, cp);
		System.out.println("Corrente: R$ " + cc.getSaldo());
		System.out.println("Imposto: R$: " + imposto.getTotalImposto());
		//System.out.println("Poupança: R$ " + cp.getSaldo());	
		
	}

}
