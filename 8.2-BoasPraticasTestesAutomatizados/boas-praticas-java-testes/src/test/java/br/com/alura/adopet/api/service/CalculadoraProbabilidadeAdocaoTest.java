package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import br.com.alura.adopet.api.model.Abrigo;

class CalculadoraProbabilidadeAdocaoTest {
	
	@Test
	@DisplayName("Probabilidade alta para gatos jovens com peso baixo")
	void probabilidadeAltaCenario01() {
		//idade 4 anos e peso 4kg - ALTA
		
		//ARRANGE - Triple A
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
				"Abrigo feliz",
				"31996969696",
				"abrigofeliz@email.com.br"));
		
		 Pet pet = new Pet(new CadastroPetDto(
				 		TipoPet.GATO,
				 		"Miau",
				 		"Siames",
				 		4,
				 		"Cinza",
				 		4.0f),abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		
		//ACT
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		//ASSERT
		Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
		
	}
	
	@Test
	@DisplayName("Probabilidade média para gatos idosos com peso baixo")
	void probabilidadeMediaCenario02() {
		//idade 15 anos e peso 4kg
		
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
				"Abrigo feliz",
				"31996969696",
				"abrigofeliz@email.com.br"));
		
		 Pet pet = new Pet(new CadastroPetDto(
				 		TipoPet.GATO,
				 		"Miau",
				 		"Siames",
				 		15,
				 		"Cinza",
				 		4.0f),abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
		
	}

}
