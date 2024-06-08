
public class TesteSacaValorNegativo {
	
	public static void main(String[] args) {
		
		Conta contaDaLuciana = new Conta();
		contaDaLuciana.deposita(100);
		System.out.println(contaDaLuciana.saca(110)); // retorna falso e não realiza o saque
		//System.out.println(contaDaLuciana.getSaldo());
		
		//proibido: acesso direto ao atributo
		//contaDaLuciana.saldo -=101;
		System.out.println(contaDaLuciana.getSaldo());
		
	}

}
