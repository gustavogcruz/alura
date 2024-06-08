
public class TesteSistema {
	public static void main(String[] args) {
		
		Autenticavel g = new Gerente();
		g.setSenha(2222);
		
		Autenticavel a = new Administrador();
		a.setSenha(3333);
		
		Autenticavel c = new Cliente();
		c.setSenha(2222);
		
		SistemaInterno si = new SistemaInterno();
		si.autentica(g);
		si.autentica(a);
		si.autentica(c);
	}

}
