package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "informatica")
public class Informatica extends Produto{
	
	private String marca;
	private Integer modelo;
	
	public Informatica() {		
	}	

	public Informatica(String autor, Integer numeroDePaginas) {
		this.marca = autor;
		this.modelo = numeroDePaginas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

}
