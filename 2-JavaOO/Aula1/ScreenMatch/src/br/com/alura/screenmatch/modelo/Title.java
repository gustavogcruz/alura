package br.com.alura.screenmatch.modelo;

public class Title {
	
		private String nome;
		private int anoDeLancamento;
		private boolean incluindoNoPlano;
		private double somaAvaliacao;
		private int totalAvaliacoes;
		private int duracaoEmMinutos;
		
		public void exibeFichaTecnica() {
			System.out.println("Nome : " + nome);
			System.out.println("Ano de Lançamento: " + anoDeLancamento);
			//System.out.println("Tempo Duração Filme: " + duracaoEmMinutos);
		}
		
		public void avalia (double nota) {
			somaAvaliacao += nota;
			totalAvaliacoes++;
		}
		
		public double mediaAvaliacoes() {
			return somaAvaliacao / totalAvaliacoes;
		}
		
		public int getTotalAvaliacoes( ) {
			return totalAvaliacoes;
		}
		
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setAnoDeLancamento(int anoDeLancamento) {
			this.anoDeLancamento = anoDeLancamento;
		}
		
		public int getAnoDeLancamento() {
			return anoDeLancamento;
		}
		
		public void setIncluindoNoPlano(boolean incluindoNoPlano) {
			this.incluindoNoPlano = incluindoNoPlano;
		}
		
		
		public void setDuracaoEmMinutos(int duracaoEmMinutos) {
			this.duracaoEmMinutos = duracaoEmMinutos;
		}
		
		public int getDuracaoEmMinutos() {
			return duracaoEmMinutos;
		}
}
