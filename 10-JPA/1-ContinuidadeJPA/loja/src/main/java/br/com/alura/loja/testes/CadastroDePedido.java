 package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		
		EntityManager em  = JPAUtil.getEntityManager();
		
		ProdutoDao daoPr = new ProdutoDao(em);			
//		Produto produto = daoPr.buscarPorId(2L);
		
		List<Produto> todos = daoPr.buscarPorParametrosCriteria(null, null, LocalDate.of(2024, 9, 6));
		todos.forEach(p -> System.out.println(p));
		
		//Cliente cliente = new Cliente("Théo", "123456");
//		ClienteDao daoCl = new ClienteDao(em);
//		Cliente cliente = daoCl.buscarPorId(2L);	
//		em.getTransaction().begin();	
	
//		daoCl.cadastrar(cliente);		
		
//		Pedido pedido = new Pedido(cliente);
//		pedido.adicionarItem(new ItemPedido(1, pedido, produto));		
//		PedidoDao daoPe = new PedidoDao(em);
//		daoPe.cadastrar(pedido);	
		
				
//		BigDecimal totalPedido = daoPe.valorTotalPedido();
//		System.out.println("VALOR TOTAL: " + totalPedido);
		
//		List<Object[]> relatorio = daoPe.relatorioDeVendasObj();
//		for (Object[] obj : relatorio) {
//			System.out.println(obj[0]);
//			System.out.println(obj[1]);
//			System.out.println(obj[2]);
//		}
		
//		List<RelatorioDeVendasVo> relatorio2 = daoPe.relatorioDeVendasVo();
//		relatorio2.forEach(System.out::println);
//		
//		em.getTransaction().commit();
//		em.close();
		
	}

}
