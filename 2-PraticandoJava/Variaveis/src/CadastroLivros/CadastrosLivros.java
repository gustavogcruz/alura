package CadastroLivros;

public class CadastrosLivros {

	public static void main(String[] args) {

		String titulo = "O Pequeno Príncipe";
		String autor = "Antoine de Saint-Exupéry";
		int paginas = 96;
		double preco = 39.9;
		char categoria = 'F';
		String categoriaDescricao;

		if (categoria == 'F') {
			categoriaDescricao = "Ficção";
		} else if (categoria == 'N') {
			categoriaDescricao = "N - Não-ficção";
		} else if (categoria == 'T') {
			categoriaDescricao = "T - Tecnologia";
		} else if (categoria == 'H') {
			categoriaDescricao = "H - História";
		} else {
			categoriaDescricao = "Categoria Inválida";
		}

		System.out.println("Livro cadastrado: + \"" + titulo + "\"" + " de " + autor + ". Ele possui " + paginas
				+ " páginas, custa R$ " + preco + " e pertence à categoria " + categoriaDescricao);
	}

}
