package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {		
//		cadastrarProduto();
		
		EntityManager em  = JPAUtil.getEntityManager();
		ProdutoDao daoP = new ProdutoDao(em);
		
//		Produto p = daoP.buscarPorId(25L);
//		System.out.println(p.getPreco());
		
//		List<Produto> todos = daoP.buscarPorNomeDaCategoria("CELULARES");
//		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = daoP.buscarPrecoDoProduto("Motorola");
		System.out.println("Preço do Produto: " +precoDoProduto);
	}

//	private static void cadastrarProduto() {
//		Categoria celulares = new Categoria("CELULARES");
//		Produto celular = new Produto("Motorola", "Moto G73", new BigDecimal(1000), celulares );
//
//		
//		EntityManager em  = JPAUtil.getEntityManager();
//		ProdutoDao daoP = new ProdutoDao(em);
//		CategoriaDao daoC = new CategoriaDao(em);
//		
//		em.getTransaction().begin();		
//		daoC.cadastrar(celulares);
//		daoP.cadastrar(celular);
//		
////		celulares.setNome("Carro");
////		em.flush();
////		em.clear();
////		
////		daoC.atualizar(celulares);
////		
////		celulares.setNome("Barco");
////		daoC.atualizar(celulares);
////		em.flush();
////		
////		daoC.remover(celulares);
////		em.flush();
//		
//		em.getTransaction().commit();
//		em.close();
//	}
}
