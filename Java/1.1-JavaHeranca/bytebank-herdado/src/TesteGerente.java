
public class TesteGerente {

	public static void main(String[] args) {

		Gerente gerente = new Gerente();
		gerente.setNome("Luciana Neves de Souza Cruz");
		gerente.setCpf("0123467910");
		gerente.setSalario(10000.0);
		gerente.setSenha(22222);

		System.out.println("Nome Funcionário: " + gerente.getNome());
		System.out.println("Salário: R$ " + gerente.getSalario());
		System.out.println("Bonificação: R$ " + gerente.getBonificacao());

		boolean autenticou = gerente.autentica(22222);
		System.out.println("Senha OK? " + autenticou);

	}

}
