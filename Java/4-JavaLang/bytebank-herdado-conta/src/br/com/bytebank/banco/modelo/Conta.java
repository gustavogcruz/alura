//FQN - Full Qualified Name - br.com.bytebank.banco.modelo.Conta

// public - visivel em todo lugar (dentro e fora do pacote)
// protected - visivel somente para os filhos
// default (package private) - visivel somente dentro do pacote.
// private - visivel apenas dentro da classe

package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * @author gustavo.cruz
 * @version 0.1
 */

public abstract class Conta {

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
    
    /**
     * Construtor para incializar objeto conta a partir da agência e número
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        Conta.total++;
        System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor); 
    
    /**
     * Valor precisa de maior que o saldo
     * @param valor
     * @return
     */
    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if(this.saca(valor)) {
        		destino.deposita(valor);
        		return true;
        } else {
        		return false;
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
    
    @Override
    public String toString() {    	
    	return "Agência: " + this.getAgencia() + " Número: " + this.getNumero();
    }
}