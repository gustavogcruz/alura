
public class TestaContaSemCliente {
	
	public static void main(String[] args) {
		Conta contaDaAna = new Conta ();
		System.out.println(contaDaAna.getSaldo());
		
		// contaDaAna fazendo referência a NULL pelo atributo Titular do objeto Conta
		//System.out.println(contaDaAna.titular);
		
		// acessando atributo Nome sem referência, retorna NullPointerException
		//contaDaAna.titular.nome = "Ana";
		
		contaDaAna.titular = new Cliente();
		System.out.println(contaDaAna.titular);
		contaDaAna.titular.nome = "Ana Neves";
		System.out.println(contaDaAna.titular.nome);
	}
}
