package br.com.alura.screenmatch.desafios.dois;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
	
	private LocalDate dataValidade;

	public ProdutoPerecivel(String nome, float preco/*, LocalDate dataValidade*/) {
		super(nome, preco);
		//this.dataValidade = dataValidade;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
}
