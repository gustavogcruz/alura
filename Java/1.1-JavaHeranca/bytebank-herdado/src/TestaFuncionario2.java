
public class TestaFuncionario2 {

	public static void main(String[] args) {
		Funcionario2 theo = new Funcionario2();
		theo.setNome("Theo Castro");
		theo.setCpf("012345678910");
		theo.setSalario(1320.00);
		theo.setTipo(2);
		
		System.out.println("Nome Funcionário: " + theo.getNome());
		System.out.println("Salário: R$ " + theo.getSalario());
		System.out.println("Bonificação: R$ " + theo.getBonificacao());
		
	}

}
