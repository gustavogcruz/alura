package br.com.bytebank.banco.modelo;

//herda atributos, metodos da classe mãe, mas não o construtor
public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
	
    @Override
    public String toString() {    	
    	return "ContaPoupança - " + super.toString();
    }

}
