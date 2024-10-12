package br.com.alura.screenmatch.desafios.tres;

public class Quadrado implements Forma{
	   double lado;

	    @Override
	    public double calcularArea() {
	        return lado * lado;
	    }

}
