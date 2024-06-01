
public class TestaGetSet {
	
	public static void main(String[] args) {
		Conta conta = new Conta(0,0);
		//conta.numero = 1337;
		conta.setNumero(-1000);
		System.out.println(conta.getNumero());
		conta.setAgencia(-40);
		System.out.println(conta.getAgencia());;
		
		Cliente luciana = new Cliente();
		conta.setTitular(luciana);
		luciana.setNome("Luciana Neves");
		System.out.println(luciana.getNome());
		
		Cliente lucio = conta.getTitular();
		lucio.setProfissao("Dono Bar");
		System.out.println(lucio.getProfissao());
		
		System.out.println(lucio);
		System.out.println(luciana);		
		System.out.println(conta.getTitular());
		
	}

}
