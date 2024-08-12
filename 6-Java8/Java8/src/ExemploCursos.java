import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
    
}


public class ExemploCursos {
	public static void main(String[] args) {
		
	    List<Curso> cursos = new ArrayList<Curso>();
	    cursos.add(new Curso("Python", 45));
	    cursos.add(new Curso("JavaScript", 150));
	    cursos.add(new Curso("Java 8", 113));
	    cursos.add(new Curso("C++", 55));
	    
	    cursos.sort(Comparator.comparing(Curso::getAlunos));
	    //cursos.forEach(System.out::println); method reference - possui limitações
	    //cursos.forEach( c -> System.out.println(c.getNome()));
	    
//	    cursos.stream()
//	    .filter(c -> c.getAlunos() >= 100)
//	    .map(c -> c.getAlunos()) // OU Curso::getAlunos
//	    .forEach(total -> System.out.println(total)); //OU System.out::println
	    //.forEach(c -> System.out.println(c.getNome()));
	    //cursos.forEach( c -> System.out.println(c.getNome())); - retorna a coleção original
	    
//	    OptionalDouble media = cursos.stream()
//	    .filter(c -> c.getAlunos() >= 100)
//	    .mapToInt(Curso::getAlunos)
//	    .average();
//	    
//	    System.out.println(media);
	    
	    Stream<String> nomes = cursos.stream()
	    		.map(Curso::getNome);
	    //System.out.println(nomes);
	    
//	   cursos.stream()
//	    .filter(c -> c.getAlunos() >= 100)
//	    .findAny()
//	    .ifPresent(c -> System.out.println(c.getNome()));
//	   
//	   Optional<Curso> OptionalCurso = 	   cursos.stream()
//	    .filter(c -> c.getAlunos() >= 100)
//	    .findAny();
	    
//	    Curso curso = OptionalCurso.orElse(null);
//	    System.out.println(curso.getNome());
	    
//	    OptionalCurso.ifPresent(c -> System.out.println(c.getNome()));
	    
   
//	    cursos = cursos.stream()
//	    .filter(c -> c.getAlunos() >= 100)
//	    .collect(Collectors.toList());
	    
	    cursos.stream()
	    .filter(c -> c.getAlunos() >= 100)
	    .collect(Collectors.toMap(
	    		c -> c.getNome(),
	    		c -> c.getAlunos()))
	    .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos "));
	    //System.out.println(map);
	    
//	    cursos.stream()
//	    .forEach(c -> System.out.println(c.getNome()));
		
	}

}
