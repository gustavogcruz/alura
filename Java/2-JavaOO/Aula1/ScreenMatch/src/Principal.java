import java.io.FilterOutputStream;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelo.Episodio;
import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;

public class Principal {
	
	public static void main(String[] args) {
		
		Filme meuFilme = new Filme();
		meuFilme.setNome("Matrix");
		meuFilme.setAnoDeLancamento(1999);;
		meuFilme.setDuracaoEmMinutos(125);
		
		meuFilme.exibeFichaTecnica();
		
		meuFilme.avalia(4);
		meuFilme.avalia(4);
		meuFilme.avalia(4);
		
		//System.out.println(meuFilme.somaAvaliacao);
		System.out.println(meuFilme.getTotalAvaliacoes());	
		System.out.println(meuFilme.mediaAvaliacoes());
		
		Serie minhaSerie = new Serie();
		minhaSerie.setNome("Lost");
		minhaSerie.setAnoDeLancamento(2004);
		minhaSerie.exibeFichaTecnica();
		minhaSerie.setTemporadas(6);
		minhaSerie.setEpisodiosPorTemporada(8);
		minhaSerie.setMinutosPorEpisodio(25);
		System.out.println("Duração(minutos) para maratonar Lost: " + minhaSerie.getDuracaoEmMinutos());
		
		Filme meuFilme2 = new Filme();
		meuFilme2.setNome("Matrix 2");
		meuFilme2.setAnoDeLancamento(2001);;
		meuFilme2.setDuracaoEmMinutos(125);
		
		
		CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
		calculadoraDeTempo.inclui(meuFilme);
		calculadoraDeTempo.inclui(meuFilme2);
//		System.out.println(calculadoraDeTempo.getTempoTotal());
		calculadoraDeTempo.inclui(minhaSerie);
		System.out.println(calculadoraDeTempo.getTempoTotal());
		
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		filtro.filtra(meuFilme);
		
		Episodio episodio = new Episodio();
		episodio.setNumero(1);
		episodio.setSerie(minhaSerie);
		episodio.setTotalVisualizacoes(50);
		filtro.filtra(episodio);
		
	}

}
