package exercicios;

public class CelsiusFahrenheit {

	public static void main(String[] args) {
		
		double temperaturaCelsius = 10;		

		double conversaoF = (temperaturaCelsius * 1.8) + 32;
		int conversaoIntF = (int) conversaoF;
		
		//System.out.println("Celsius para Fahrenheit: " + conversaoF);
		//System.out.println("Celsius para Fahrenheit: " + conversaoIntF);
		
        String mensagem = String.format("A temperatura de %f Celsius é equivalente a %f Fahrenheit", temperaturaCelsius, conversaoF);
        System.out.println(mensagem);
        
        System.out.println("A temperatura em Fahrenheit inteira é: " + conversaoIntF);

	}

}
