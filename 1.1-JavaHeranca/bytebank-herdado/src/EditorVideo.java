//Editor Video é um funcionário, herda da classe Funcionario
public class EditorVideo extends Funcionario{
	
	public EditorVideo() {
		
	}
	
	public double getBonificacao() {
		System.out.println("Herdado Editor Video");
		//return super.getBonificacao() + 100;
		return 150;
	}	

}
