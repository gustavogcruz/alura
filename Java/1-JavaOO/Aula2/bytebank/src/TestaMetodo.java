
public class TestaMetodo {
	
	public static void main(String[] args) {
		
		Conta contaTheo = new Conta();
		contaTheo.saldo = 100;
		contaTheo.deposita(50);
		
		System.out.println(contaTheo.saldo);
		
		boolean conseguiuRetirar = contaTheo.saca(20);
		System.out.println(conseguiuRetirar);
		System.out.println(contaTheo.saldo);		
		
		Conta contaAna = new Conta();
		contaAna.deposita(1000);
		System.out.println(contaAna.saldo);
		
		boolean checkTransfer = 
				contaAna.transfere(300,contaTheo);		
		if (checkTransfer) {
			System.out.println("Transferência OK");
		} else {
			System.out.println("Transferência NOK");
		}		
		
		System.out.println(contaAna.saldo);
		System.out.println(contaTheo.saldo);
		
		
	}

}
