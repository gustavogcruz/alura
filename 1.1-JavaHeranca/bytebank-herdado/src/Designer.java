//Editor Video é um funcionário, herda da classe Funcionario
public class Designer extends Funcionario{
	
	public Designer() {
		
	}
	
	public double getBonificacao() {
		System.out.println("Herdado Designer");
		//return super.getBonificacao() + 200;
		return 200;
	}	

}
