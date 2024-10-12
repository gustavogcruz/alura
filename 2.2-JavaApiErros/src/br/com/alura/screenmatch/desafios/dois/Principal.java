package br.com.alura.screenmatch.desafios.dois;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {
	
	public static void main(String[] args) {
		
		String json = """				
				{"name":"John",
				//"lastname":"Wick",
				//"age":30, 
				"city":BH}""";
		
		//Gson gson = new Gson();
		 Gson gson = new GsonBuilder().setLenient().create();
				 PessoaDTO pessoaJson = gson.fromJson(json, PessoaDTO.class);
		System.out.println(pessoaJson);
		
	}

}
