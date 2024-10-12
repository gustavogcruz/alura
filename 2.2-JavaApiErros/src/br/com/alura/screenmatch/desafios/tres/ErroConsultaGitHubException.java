package br.com.alura.screenmatch.desafios.tres;

public class ErroConsultaGitHubException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String mensagem;

	public ErroConsultaGitHubException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		return this.mensagem;
	}

}
