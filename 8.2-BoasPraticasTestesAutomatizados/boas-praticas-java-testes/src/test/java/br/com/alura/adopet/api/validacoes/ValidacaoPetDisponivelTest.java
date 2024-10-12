package br.com.alura.adopet.api.validacoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;

class ValidacaoPetDisponivelTest {
	
	

	@Test
	void deveriaPermitirSolicitacaoDeAdocaoPet() {
		
		//ARRANGE
		SolicitacaoAdocaoDto dto = new SolicitacaoAdocaoDto(
				1l,
				1l, "Motivo Qualquer");
		
		ValidacaoPetDisponivel validacao = new ValidacaoPetDisponivel();
		
		//ACT
		validacao.validar(dto);
		
		//ASSERT + ACT
		Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
		
	}

}
