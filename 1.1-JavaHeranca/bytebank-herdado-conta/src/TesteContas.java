
public class TesteContas {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(111, 222);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		CalculadorImposto imposto = new CalculadorImposto();
		imposto.registra(seguro);		
		imposto.registra(cc);
		
		
		ContaPoupanca cp = new ContaPoupanca(222, 333);
		cp.deposita(200.00);
		
		//cc.transfere(10.0, cp);
		System.out.println("Corrente: R$ " + cc.getSaldo());
		System.out.println("Imposto: R$: " + imposto.getTotalImposto());
		//System.out.println("Poupança: R$ " + cp.getSaldo());	
		
	}

}
