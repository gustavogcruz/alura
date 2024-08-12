//Assina o contrato de Autenticavel, eh um autenticavel
public class Cliente implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Cliente() {
		//composição - tem um AutenticacaoUtil
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		//System.out.println("Herdado Cliente");
		return this.autenticador.autentica(senha);
	}

}
