package br.com.alura.loja.desconto;

import java.math.BigDecimal;
import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoAcimaDeCincoItens extends Desconto{	
	
	public DescontoParaOrcamentoAcimaDeCincoItens(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {	
		System.out.println("Desconto acima de 5 itens");
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getQuantidadeItens() > 5;
	}
	
}
