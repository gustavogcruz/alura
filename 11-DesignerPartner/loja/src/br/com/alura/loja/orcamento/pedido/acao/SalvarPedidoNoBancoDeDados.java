package br.com.alura.loja.orcamento.pedido.acao;

import br.com.alura.loja.orcamento.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido{

	@Override
	public void executarAcao(Pedido pedido) {
		System.out.println("Salvando pedido no banco de dados!");		
	}
	

}
