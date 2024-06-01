
public class TesteValores {
	
	public static void main(String[] args) {
		Conta conta = new Conta(12,34);
		
		// conta está inconsistente
		//conta.setAgencia(-50);
		//conta.setNumero(-100);		
		//System.out.println(conta.getAgencia());
		
		Conta conta2 = new Conta(123,345);
		Conta cont32 = new Conta(1234,3456);
		
		System.out.println(Conta.getTotal());
		
	}

}
