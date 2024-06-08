
public class TesteReferencia {
	
	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		System.out.println("Saldo da Primeira Conta: R$ " + primeiraConta.saldo);
		
		Conta segundaConta = primeiraConta;
		System.out.println("Saldo da Segunda Conta: R$ " + segundaConta.saldo);
		
		segundaConta.saldo += 100;
		
		System.out.println("Saldo da Primeira Conta: R$ " + primeiraConta.saldo);		
		System.out.println("Saldo da Segunda Conta: R$ " + segundaConta.saldo);
		
		if(primeiraConta == segundaConta) {
			System.out.println("Mesma Conta");
		}
		
	}

}
