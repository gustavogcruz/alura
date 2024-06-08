//private - apenas visível dentro da classe
//protected - visível dentro da classe e também para as filhas (relacionado com a herança)
//public - visível em todo lugar
// Não pode instanciar essa classe, é abstrata

public abstract class Funcionario {

	private String nome;
	private String cpf;
	private double salario;

	public Funcionario() {

	}
	
	// metodo sem corpo, não a implementação na classe mãe. As filhas são obrigadas a implementar.
	public abstract double getBonificacao();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
