package br.com.alura.loja.orcamento.pedido.acao;

import br.com.alura.loja.orcamento.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido{
	
	@Override
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviar e-mail com dados do pedido!");
	}

}
