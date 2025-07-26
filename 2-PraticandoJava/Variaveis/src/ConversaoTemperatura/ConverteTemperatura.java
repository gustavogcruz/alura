package ConversaoTemperatura;

public class ConverteTemperatura {

	public static void main(String[] args) {

		// Fahrenheit = (Celsius * 9 / 5) + 32
		int celsius = 20;
		double fahrenheit;

		fahrenheit = (celsius * 9 / 5) + 32;

		System.out.println("A temperatura em graus Fahrenheit é: " + fahrenheit);
	}

}
