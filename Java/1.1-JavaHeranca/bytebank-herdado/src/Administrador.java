
public class Administrador extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Administrador() {
		//composição - tem um AutenticacaoUtil
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		//System.out.println("Herdado Administrador");
		return this.autenticador.autentica(senha);
	}

	@Override
	public double getBonificacao() {
		System.out.println("Herdado Administrador");
		return 50;
	}

}
