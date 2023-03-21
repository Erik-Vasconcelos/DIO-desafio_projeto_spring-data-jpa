package one.digitalinnovation.bc;

import java.time.LocalDate;

import one.digitalinnovation.bc.model.Bootcamp;
import one.digitalinnovation.bc.model.Conteudo;
import one.digitalinnovation.bc.model.Curso;
import one.digitalinnovation.bc.model.Desenvolvedor;
import one.digitalinnovation.bc.model.Mentoria;

/**
 * Classe de execução
 * @author erikv
 * @since 21/03/2023
 */
public class App {
	public static void main(String[] args) {
		
		Conteudo conteudo1 = new Mentoria("Testes unitário e tdd", "Aprenda como é realizado os teste unitários", LocalDate.of(2023, 03, 24));
		
		Conteudo conteudo2 = new Curso("Orientação a objetos", "Entenda as bases da OO de forma fácil e prática", 20);
		
		Bootcamp bootcamp = new Bootcamp("Java Developer", "Bootcamp Java promovido pelo banco Pan", LocalDate.of(2023, 03, 22), LocalDate.of(2023, 04, 16));
		bootcamp.addConteudo(conteudo1);
		bootcamp.addConteudo(conteudo2);
		
		Desenvolvedor dev1 = new Desenvolvedor("Carlos");
		dev1.inscreverSe(bootcamp);
		dev1.progredir();
		dev1.progredir();
		
		Desenvolvedor dev2 = new Desenvolvedor("Paulo");
		dev2.inscreverSe(bootcamp);
		
		System.out.println(bootcamp);
		
		System.out.println();
		
		System.out.println(dev1);
		System.out.println(dev2);
		
	}
}
