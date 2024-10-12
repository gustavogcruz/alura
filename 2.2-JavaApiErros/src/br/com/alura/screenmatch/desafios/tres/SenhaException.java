package br.com.alura.screenmatch.desafios.tres;

public class SenhaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String mensagem;

	public SenhaException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		return this.mensagem;
	}
	
	

}
