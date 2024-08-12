public class Conta {
	
	private double saldo; //private - somente a própria classe pode ler / modificar
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total; // static - percente a classe Conta e não ao objeto Conta
	
	//construtor padrão
	public Conta(int agencia, int numero) {
		Conta.total++;
		//System.out.println("o total de contas é: " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("estou criando uma conta com o número: " + this.numero);
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}
		
	public boolean transfere (double valor, Conta destino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			destino.deposita(valor);
			return true;
		} 
		return false;
		}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero (int numero) {
		if(numero <=0) {
			System.out.println("Número Inválido");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia (int agencia) {
		if(agencia <= 0) {
			System.out.println("Número Inválido");
			return;
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}	