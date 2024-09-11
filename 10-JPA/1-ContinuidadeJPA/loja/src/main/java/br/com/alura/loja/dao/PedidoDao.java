package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;


public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
}
	
	public BigDecimal valorTotalPedido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		 return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVendasObj() {
		String jpql = "SELECT produto.nome, "
					+ "SUM(item.quantidade), "
					+ "MAX(pedido.dataPedido) "
					+ "FROM Pedido pedido "
					+ "JOIN pedido.itens item "
					+ "JOIN item.produto produto " 
					+ "GROUP BY produto.nome, item.quantidade, pedido.dataPedido "
					+ "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, Object[].class)
				.getResultList();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendasVo() {
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo"
					+ "(produto.nome, "
					+ "SUM(item.quantidade) as quantidadeTotal, "
					+ "MAX(pedido.dataPedido)) "
					+ "FROM Pedido pedido "
					+ "JOIN pedido.itens item "
					+ "JOIN item.produto produto " 
					+ "GROUP BY produto.nome "
					+ "ORDER BY quantidadeTotal DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}
	
	public Pedido buscarPedidoComCliente (Long id) { //carrega junto o relacionamento que é lazy
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
