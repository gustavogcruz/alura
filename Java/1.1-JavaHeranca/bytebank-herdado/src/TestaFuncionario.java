
public class TestaFuncionario {

	public static void main(String[] args) {
		EditorVideo theo = new EditorVideo();
		theo.setNome("Theo Castro");
		theo.setCpf("012345678910");
		theo.setSalario(1320.00);
		//theo.setTipo(1);
		
		System.out.println("Nome Funcionário: " + theo.getNome());
		System.out.println("Salário: R$ " + theo.getSalario());
		System.out.println("Bonificação: R$ " + theo.getBonificacao());
		
	}

}
