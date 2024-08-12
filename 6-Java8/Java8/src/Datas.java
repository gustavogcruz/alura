import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasParis = LocalDate.of(2024, Month.JULY, 31);		
		int dias = olimpiadasParis.getDayOfMonth() - hoje.getDayOfMonth();		
		System.out.println(dias);
		
		Period periodo = Period.between(hoje, olimpiadasParis);
		System.out.println(periodo.getDays());
		
		LocalDate proximasOlimpiadas = olimpiadasParis.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		LocalTime intervalo = LocalTime.of(23, 15);
		System.out.println(intervalo);
		
	}
}
