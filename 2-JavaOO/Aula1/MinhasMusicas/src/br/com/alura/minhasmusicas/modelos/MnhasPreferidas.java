package br.com.alura.minhasmusicas.modelos;

public class MnhasPreferidas {
	
	public void inclui(Audio audio) {
		System.out.println(audio);
		if (audio.getClassificacao() >= 9) {
			System.out.println("Sucesso");
		} else {
			System.out.println("Da pra ouvir");
		}
	}

}
