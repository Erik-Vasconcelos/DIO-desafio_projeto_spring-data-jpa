package one.digitalinnovation.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import one.digitalinnovation.bc.model.Bootcamp;
import one.digitalinnovation.bc.model.Conteudo;
import one.digitalinnovation.bc.model.Curso;
import one.digitalinnovation.bc.model.Desenvolvedor;
import one.digitalinnovation.bc.model.Mentoria;

class TestDesenvolvedor {
	
	@Test
	void testeInscreverSe() {
		Conteudo conteudo1 = new Mentoria("Mentoria Java", "Java avançado", LocalDate.of(2023, 03, 24));
		Conteudo conteudo2 = new Curso("Jsp", "Jsp moderno", 20);
		
		Bootcamp bootcamp = new Bootcamp("Java back-end", "bootcamp com foco no desenvolvimento back-end", LocalDate.of(2023, 03, 22), LocalDate.of(2023, 04, 16));
		bootcamp.addConteudo(conteudo1);
		bootcamp.addConteudo(conteudo2);
		
		Desenvolvedor dev1 = new Desenvolvedor("Paulo");
		assertEquals(0, dev1.getConteudosInscritos().size());
		
		dev1.inscreverSe(bootcamp);
		assertEquals(2, dev1.getConteudosInscritos().size());
	}

	@Test
	void testeCalculoTotalXp() {
		Conteudo conteudo1 = new Mentoria("Mentoria Java", "Java avançado", LocalDate.of(2023, 03, 24));
		
		Conteudo conteudo2 = new Curso("Jsp", "Jsp moderno", 20);
		
		Bootcamp bootcamp = new Bootcamp("Java back-end", "bootcamp com foco no desenvolvimento back-end", LocalDate.of(2023, 03, 22), LocalDate.of(2023, 04, 16));
		bootcamp.addConteudo(conteudo1);
		bootcamp.addConteudo(conteudo2);
		
		Desenvolvedor dev1 = new Desenvolvedor("Paulo");
		dev1.inscreverSe(bootcamp);
		
		dev1.progredir();
		
		//XP_PADRAO: 10 + mentoria: 15
		assertEquals(25, dev1.getTotalXp());
	}

}
