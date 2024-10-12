package br.com.alura.screenmatch.desafios.tres;

public class Senha {	

	private String senha;	
	
	public void verificaSenha() {
		
		if (this.senha.length() < 8) {
			throw new SenhaException ("Senha possui menos de 8 digitos");
		} else {
			System.out.println("Senha cadastrada com sucesso");
		}		
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
