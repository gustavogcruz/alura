package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	@Test
	public void naoDeveCadastrarUsuarioComCpfForaDoPadrao() {
				//nulo ou sem padrão com ponto e hifen
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Usuario("123.456.7.89-00", "Theo", LocalDate.parse("2020-01-12"), "theozinho@email.com"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Usuario("", "Theo", LocalDate.parse("2020-01-12"), "theozinho@email.com"));
	}	

}
