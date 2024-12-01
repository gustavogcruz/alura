package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerieDTO(
		@JsonAlias("Title") 
		String titulo,
		@JsonAlias("Genre")
		String genero,
		@JsonAlias("Actors")
		String atores,
		@JsonAlias("Plot")
		String sinopse,
		@JsonAlias("Poster")
		String poster,
        @JsonAlias("totalSeasons") 
		Integer totalTemporadas,
        @JsonAlias("imdbRating") 
		String avaliacao) {
}
