package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotNull;
 
//DTO - Data Transformer Object
public record AprovacaoAdocaoDTO(
		
		@NotNull
		Long idAdocao) {

}
