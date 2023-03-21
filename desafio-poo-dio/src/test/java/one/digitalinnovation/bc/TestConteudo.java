package one.digitalinnovation.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import one.digitalinnovation.bc.model.Conteudo;
import one.digitalinnovation.bc.model.Curso;
import one.digitalinnovation.bc.model.Mentoria;

class TestConteudo {

	@Test
	void testeCalculoXpMentoria() {
		Conteudo conteudo1 = new Mentoria("Mentoria Tdd", "Domine tdd", LocalDate.of(2023, 03, 24), 20);
		
		//(XP_PADRAO: 10 + mentoria: 15 + bonus: 20) = 45
		assertEquals(45, conteudo1.calcularXp());
	}
	
	@Test
	void testeCalculoXpCurso() {
		Conteudo conteudo2 = new Curso("Estrutura de dados", "Aprenda estrutura de dados com Java", 6);
		
		//(XP_PADRAO: 10 + curso: 10 + (cargaHoraria: 6 * xpPorHoraCurso: 0.5)) = 13
		assertEquals(13, conteudo2.calcularXp());
	}

}
