package br.com.alura.loja.desconto;

import java.math.BigDecimal;
import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoComValorAcimaDeQuinhentos extends Desconto{

	public DescontoParaOrcamentoComValorAcimaDeQuinhentos(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
			System.out.println("Desconto acima de 500");
			return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
	}

}
