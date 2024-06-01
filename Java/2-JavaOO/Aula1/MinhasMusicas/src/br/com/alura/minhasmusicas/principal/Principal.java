package br.com.alura.minhasmusicas.principal;

import br.com.alura.minhasmusicas.modelos.MnhasPreferidas;
import br.com.alura.minhasmusicas.modelos.Musica;
import br.com.alura.minhasmusicas.modelos.Podcast;

public class Principal {

	public static void main(String[] args) {
		
		Musica minhaMusica = new Musica();
		
		minhaMusica.setTitulo("Piano Bar");
		minhaMusica.setCantor("EngHaw");
		minhaMusica.setAlbum("Varias Variaveis");
		
		for(int i=0; i < 2000; i++) {
			minhaMusica.reproduz();
		}
		
		for(int i=0; i < 500; i++) {
			minhaMusica.curte();
		}
		
		Podcast meuPodcast = new Podcast();
		
		meuPodcast.setTitulo("Bela Bunda");
		meuPodcast.setApresentador("Jonny Bravo");
		
		for(int i=0; i < 1000; i++) {
			meuPodcast.reproduz();
		}
		
		for(int i=0; i < 500; i++) {
			meuPodcast.curte();
		}
		
		MnhasPreferidas preferidas = new MnhasPreferidas();
		preferidas.inclui(minhaMusica);
		preferidas.inclui(meuPodcast);

	}

}
