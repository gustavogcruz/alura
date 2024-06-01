package br.com.alura.screenmatch.modelo;

public class Serie extends Title{
	
	private int temporadas;
	private int episodiosPorTemporada;
	private boolean ativa;
	private int minutosPorEpisodio;
	
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	
	public int getTemporadas() {
		return temporadas;
	}
	
	public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
		this.episodiosPorTemporada = episodiosPorTemporada;
	}
	
	public int getEpisodiosPorTemporada() {
		return episodiosPorTemporada;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void setMinutosPorEpisodio(int minutosPorEpisodio) {
		this.minutosPorEpisodio = minutosPorEpisodio;
	}
	
	public int getMinutosPorEpisodio() {
		return minutosPorEpisodio;
	}
	
	@Override	
	public int getDuracaoEmMinutos() {
		return temporadas * episodiosPorTemporada * minutosPorEpisodio;
		
	}

}
