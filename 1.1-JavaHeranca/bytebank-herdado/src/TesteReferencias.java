
public class TesteReferencias {
	
	public static void main(String[] args) {
		
		Gerente g1 = new Gerente();		
		//g1.setNome("Luciana Neves de Souza Cruz");
		//String nome = g1.getNome();
		g1.setSalario(10000.0);
		
		EditorVideo e1 = new EditorVideo();
		//e1.setNome("Théo Castro");
		e1.setSalario(2000.00);
		
		Designer d1 = new Designer();
		//d1.setNome("Ana Neves");
		d1.setSalario(3000.00);
		
		//gerente.autentica(2222);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g1);
		controle.registra(e1);
		controle.registra(d1);
		
		//System.out.println(nome);
		System.out.println(controle.getSoma());
		
	}

}
