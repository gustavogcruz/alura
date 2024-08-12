package br.com.alura;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestaRecibo {
	
	public static void main(String[] args) {
		
		Recibo rec1 = new Recibo("Loja", 01);		
		Recibo rec2 = new Recibo("Casa", 02);
		Recibo rec3 = new Recibo("Bar", 03);
		
		
		Set<Recibo> recibos = new TreeSet<>(new Comparator<Recibo>() {

			@Override
			public int compare(Recibo recibo, Recibo outroRecibo) {
				return recibo.getDescricao().compareTo(outroRecibo.getDescricao()); 
			}
			
		});
		recibos.add(rec1);
		recibos.add(rec2);
		recibos.add(rec3);
		//recibos.remove(rec3);
		System.out.println(recibos);
		
	}

}
