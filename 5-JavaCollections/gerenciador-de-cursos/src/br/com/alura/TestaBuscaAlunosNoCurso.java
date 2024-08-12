package br.com.alura;

public class TestaBuscaAlunosNoCurso {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona((new Aula("Trabalhando com LinkedList", 21)));
		javaColecoes.adiciona((new Aula("Criando uma Aula", 20)));
		javaColecoes.adiciona((new Aula("Modelando com coleções", 22)));

		Aluno a1 = new Aluno("Théo Castro", 01);
		Aluno a2 = new Aluno("Ana Neves", 02);
		Aluno a3 = new Aluno("Luciana Neves", 03);
		Aluno a4 = new Aluno("Gustavo Cruz", 04);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		javaColecoes.matricula(a4);
		
		javaColecoes.estaMatriculado(a4);
		
		System.out.println("Quem é o aluno com matrícula 01 ?");
		Aluno aluno = javaColecoes.buscaMatriculaMap(05);
		System.out.println("O aluno é: " + aluno);
		
	}

}
