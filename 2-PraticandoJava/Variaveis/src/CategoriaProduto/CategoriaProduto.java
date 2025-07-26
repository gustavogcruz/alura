package CategoriaProduto;

public class CategoriaProduto {

	public static void main(String[] args) {

		double preco = 201.00;
		String categoria = "";

		if (preco <= 50.00) {
			categoria = "Econômico";
		} else if (preco > 50.00 && preco <= 200.00) {
			categoria = "Intermediáro";
		} else
			categoria = "Premium";

		System.out.println("Categoria do produto: " + categoria);
	}

}
