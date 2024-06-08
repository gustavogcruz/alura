package br.com.bytebank.banco.test;

public class Thread {

	public static void main(String[] args) {
		
		Thread t = new Thread(() -> System.out.println("rodando ..."));
		
		t.start();
	}

}
