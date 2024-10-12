package br.com.alura.screenmatch.desafios.tres;

public class Circulo implements Forma{
	double raio;

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

}
