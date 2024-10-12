package br.com.alura.loja.orcamento.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {
	
	private List<AcaoAposGerarPedido> acoes;	
	
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		super();
		this.acoes = acoes;
	}



	//construtor com injenção de dependencias: repository, service, etc.
	
	public void execute(GeraPedido dados) {
		
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());	
		Pedido pedido = new Pedido (dados.getCliente(), LocalDateTime.now(), orcamento);
		
		System.out.println(pedido);
		
		acoes.forEach(a -> a.executarAcao(pedido));

	}

}
