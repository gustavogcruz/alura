package br.com.alura.screenmatch.desafios.tres;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class GitHubApi {
	
	private String endereco = "https://api.github.com/users/";
	private String login;
	private String id;
	private String localizacao;
	private String status;
	private String usuario;	
	
	public GitHubApi() {

	}
	
	public GitHubApi(GitHubApiDTO usuarioGIT) {
		this.id = usuarioGIT.id();
		this.login = usuarioGIT.login();
		this.localizacao = usuarioGIT.location();
		this.status = usuarioGIT.status();
	}
	
	public void realizaBuscaUsuario() {

	try {	
		
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.endereco + this.usuario)).build();
	
	HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	String json = response.body();
	
	Gson gson = new Gson();
	GitHubApiDTO usuarioDTO = gson.fromJson(json, GitHubApiDTO.class);
	GitHubApi usuarioGit = new GitHubApi(usuarioDTO);
	
	if (response.statusCode() == 404) {
		throw new ErroConsultaGitHubException("Usuário não encontrado! Tente novamente.");		
	}			System.out.println(usuarioGit);
	
    } catch (IOException | InterruptedException e) {
        System.out.println("Opss… Houve um erro durante a consulta à API do GitHub.");
        e.printStackTrace();
    } catch (ErroConsultaGitHubException e) {
        System.out.println(e.getMessage());
    }
		
}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuário localizado: [login=" + login + ", id=" 
	+ id + ", localizacao=" + localizacao 
	+ ", status=" + status + "]";
	}
	
	
}
