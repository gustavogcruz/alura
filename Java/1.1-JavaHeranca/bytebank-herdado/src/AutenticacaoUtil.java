
public class AutenticacaoUtil {

	private int senha;

	public void setSenha(int senha) {
		this.senha = senha;

	}

	public boolean autentica(int senha) {
		System.out.println("Herdado Autenticação Útil");
		if (this.senha == senha) {
			return true;
		} else {

			return false;
		}
	}

}
