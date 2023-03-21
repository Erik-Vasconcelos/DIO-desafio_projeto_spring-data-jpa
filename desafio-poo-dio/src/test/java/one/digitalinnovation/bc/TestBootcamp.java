package one.digitalinnovation.bc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import one.digitalinnovation.bc.model.Bootcamp;
import one.digitalinnovation.bc.model.Conteudo;
import one.digitalinnovation.bc.model.Curso;
import one.digitalinnovation.bc.model.Mentoria;

class TestBootcamp {

	@Test
	void testeAddConteudoRepetido() {
		Conteudo conteudo1 = new Mentoria("Mentoria Java", "Java avancado", LocalDate.of(2023, 03, 24));
		Conteudo conteudo2 = new Curso("Junit", "Introdução a testes unitários", 5);
		
		Bootcamp bootcamp = new Bootcamp("Java developer", "bootcamp banco Pam", LocalDate.of(2023, 03, 22), LocalDate.of(2023, 04, 16));
		assertTrue(bootcamp.addConteudo(conteudo1));
		assertTrue(bootcamp.addConteudo(conteudo2));

		assertFalse(bootcamp.addConteudo(conteudo1));
	}

}
