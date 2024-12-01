package br.com.alura.screenmatch.desafio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosDTO(
		List<DadosDTO> modelos	
		
		) {

}
