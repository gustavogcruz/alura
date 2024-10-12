package br.com.alura.screenmatch.desafio;

public record EnderecoDTO(
		String cep,
		String logradouro,
		String localidade,
		String bairro,
		String uf) {
}
