
public class CriaConta {
	
	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 200;
		//System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		//System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		//System.out.println(segundaConta.saldo);
		
		System.out.println("Primeira conta tem: R$ " + primeiraConta.saldo);
		System.out.println("Segunda conta tem: R$ " + segundaConta.saldo);
		
		if(primeiraConta == segundaConta) {
			System.out.println("Mesma Conta");
		} else {
			System.out.println("Contas Diferentes");
		}
		
	}
}
