package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String mensagem;

	public ErroDeConversaoDeAnoException(String mensagem) {
			this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		return this.mensagem;
	}
}
