import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");
		
		//Comparator<String> comparador = new ComparadorPorTamanho();		
		//Collections.sort(palavras, comparador); - Interface LIST possui o metódo sort
		//palavras.sort(new Comparator<String>() {

//			@Override
//			public int compare(String s1, String s2) {
//				if(s1.length() < s2.length())
//					return -1;
//				if(s1.length() > s2.length())
//					return 1;
//				return 0;
//			}
//			
//		});
		
		//lambda
//		palavras.sort((s1, s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
//		
//		palavras.sort((s1, s2)-> Integer.compare(s1.length(), s2.length()));
		
		//palavras.sort((s1, s2) -> s1.length() - s2.length());
		
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		// desmembrando sort acima
//		Function<String, Integer> funcao = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return s.length();	
//				}			
//		};
		Function<String, Integer> funcao2 = String::length;
		//Function<String, Integer> funcao3 = s -> s.length();
//		Comparator<String> comparador = Comparator.comparing(funcao);
//		palavras.sort(comparador);
		
		System.out.println(palavras);

		// forma antiga de iterar sobre os elementos de um array
//		for (String p : palavras) {
//			System.out.println(p);			
//		}
		
		
//		Consumer<String> consumidor = new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//			System.out.println(s);
//				
//			}			
//		};		
		
		//classe anonima
//		palavras.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//			System.out.println(s);
//				
//			}			
//		});	
		
		//lambda
		palavras.forEach(s -> System.out.println(s));
		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
	}

}


//class ImprimeNaLinha implements Consumer<String> {
//
//	@Override
//	public void accept(String s) {
//	System.out.println(s);
//		
//	}
//	
//}

//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if(s1.length() < s2.length())
//			return -1;
//		if(s1.length() > s2.length())
//			return 1;		
//		return 0;
//	}
//	
//}
