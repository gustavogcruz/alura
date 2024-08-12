// define um contrato
//quem assina o contrato tem obrigações
//Precisa implementar - setSenha() e autentica()

public abstract interface Autenticavel {

	public abstract void setSenha(int senha);

	public abstract boolean autentica(int senha);

}
