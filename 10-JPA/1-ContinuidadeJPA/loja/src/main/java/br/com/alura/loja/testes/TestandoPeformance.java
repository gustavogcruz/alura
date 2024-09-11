package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class TestandoPeformance {
	
	public static void main(String[] args) {
		
		EntityManager em  = JPAUtil.getEntityManager();
		
		PedidoDao daoPe = new PedidoDao(em);
		Pedido pedido = daoPe.buscarPedidoComCliente(2L);
		
		//Pedido pedido = em.find(Pedido.class, 13L);
		//System.out.println(pedido.getDataPedido());
		//System.out.println(pedido.getItens().size());
		em.close();
		
		System.out.println(pedido.getCliente().getDadosPessoais());
	}

}
