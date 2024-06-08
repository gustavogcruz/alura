
public class TestaBanco {
	
	public static void main(String[] args) {
		
		Cliente theo = new Cliente();
		theo.nome = "Theo Castro";
		theo.cpf = "222.222.222-22";
		theo.profissao = "criança";
		
		Conta contaDoTheo = new Conta();
		contaDoTheo.deposita(100);
		
		//associa o cliente Theo a contaDoTheo
		contaDoTheo.titular = theo;
		System.out.println(contaDoTheo.titular.nome);
		
	}

}
