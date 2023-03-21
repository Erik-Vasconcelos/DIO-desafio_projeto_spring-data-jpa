package one.digitalinnovation.bc.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe modelo da entidade desenvolvedor
 * @author erikv
 * @since 21/03/2023
 * 
 */
public class Desenvolvedor {
	
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	public Desenvolvedor(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desenvolvedor other = (Desenvolvedor) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nome).append("{\n")
			.append("\tXp = ")
			.append(getTotalXp());
			
		builder.append("\n\tconteudosInscritos = [")
			.append(getConteudoFormatado(conteudosInscritos))
			.append("\n\t]\n");
		
		builder.append("\tconteudosConcluidos = [")
			.append(getConteudoFormatado(conteudosConcluidos))
			.append("\n\t]")
			.append("\n}\n");
		
		return builder.toString();
	}
	
	private StringBuilder getConteudoFormatado(Set<Conteudo> setConteudo) {
		StringBuilder builder = new StringBuilder();
		
		for(Conteudo conteudo : setConteudo) {
			builder.append("\n\t\t{")
				.append(conteudo)
				.append("}");
		}
		return builder;
	}
	
	public void progredir() {
		if(conteudosInscritos.size() > 0) {
			Conteudo conteudo = conteudosInscritos.stream().findFirst().get();
			conteudosConcluidos.add(conteudo);
			conteudosInscritos.remove(conteudo);
		}
	}
	
	public void inscreverSe(Bootcamp bootcamp) {
		conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDesenvolvedores().add(this);
	}
	
	public double getTotalXp() {
		return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
	}

}
