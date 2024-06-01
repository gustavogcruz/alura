package primeiroprograma;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Esse é o Screen Match");		
		System.out.println("Filme: Top Gun - Maverick");  
		
		int anoDeLancamentoFilme = 2022;
		System.out.println("Ano de Lançamento " + anoDeLancamentoFilme);
		
		boolean incluidoNoPlano = true;
		
		double notaDoFilme = 8.1;
		
		double media  = (notaDoFilme + 6.3 + 7) / 3;
		System.out.println(String.format("A média é %.2f", media));		
		
		String sinopse = "Sinopse - Tom Cruise cai com o avião e fim de filme";
		System.out.println(sinopse);
		
		int classificacao = (int) (media/2);
		System.out.println("Média Casting Int: " + classificacao);

	}

}
