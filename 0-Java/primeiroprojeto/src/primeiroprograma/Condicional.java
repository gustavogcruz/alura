package primeiroprograma;

public class Condicional {
	
	public static void main(String[] args) {
		
		int anoLancamento = 2022;
		boolean incluidoNoPlano = true;
		double notaDoFilme = 8.1;
		String tipoPlano = "plus";
		
		if ( anoLancamento >= 2022 ) {
			System.out.println("Lançamentos que clientes estão curtindo!");
		} else {
			System.out.println("Filme retrô que vale a pena assistir!");
		}
		
		if (incluidoNoPlano == true && tipoPlano.equals("plus")) {
			System.out.println("Filme Liberado");
		} else {
			System.out.println("Deu ruim Pobre!");
		}
			
	}
}
