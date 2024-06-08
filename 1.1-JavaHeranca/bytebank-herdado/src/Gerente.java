//Gerente é um funcionário, herda da classe Funcionario
public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Gerente() {
		//composição - tem um AutenticacaoUtil
		this.autenticador = new AutenticacaoUtil();
	}
	
	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		//System.out.println("Herdado Gerente");
		return this.autenticador.autentica(senha);
	}

	public double getBonificacao() {
		System.out.println("Herdado Gerente");
		// return super.getBonificacao() + super.getSalario();
		return super.getSalario();
	}

}
