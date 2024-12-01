package br.com.alura.screenmatch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import br.com.alura.screenmatch.service.traducao.ConsultaMyMemory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "series")
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	private Categoria genero;
	
	private String atores;
	private String sinopse;
	private String poster;
	private Integer totalTemporadas;
	private Double avaliacao;
	
	@Transient
	private List<Episodio> episodios = new ArrayList<>();
	
	public Serie() {};

	public Serie(DadosSerieDTO dadosSerie) {
		this.titulo = dadosSerie.titulo();
		this.totalTemporadas = dadosSerie.totalTemporadas();
		this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
		this.atores = dadosSerie.atores();
		this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();
		this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
		this.poster = dadosSerie.poster();
	}
	
	
	
	public List<Episodio> getEpisodios() {
		return episodios;
	}



	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getGenero() {
		return genero;
	}

	public void setGenero(Categoria genero) {
		this.genero = genero;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getTotalTemporadas() {
		return totalTemporadas;
	}

	public void setTotalTemporadas(Integer totalTemporadas) {
		this.totalTemporadas = totalTemporadas;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", genero=" + genero + ", atores=" + atores + ", sinopse=" + sinopse
				+ ", poster=" + poster + ", totalTemporadas=" + totalTemporadas + ", avaliacao=" + avaliacao + "]";
	}
}
