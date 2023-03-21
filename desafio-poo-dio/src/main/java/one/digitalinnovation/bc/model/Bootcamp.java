package one.digitalinnovation.bc.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe modelo da entidade bootcamp
 * 
 * @author erikv
 * @since 21/03/2023
 * 
 */
public class Bootcamp {

	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Set<Conteudo> conteudos = new LinkedHashSet<>();
	private Set<Desenvolvedor> desenvolvedores = new HashSet<>();

	public Bootcamp(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public boolean addConteudo(Conteudo conteudo) {
		if(!conteudos.contains(conteudo)) {
			conteudos.add(conteudo);
			
			return true;
		}
		return false;
	}

	public Set<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(Set<Conteudo> conteudos) {
		if(conteudos != null) {
			if(conteudos.size() > 0) {
				this.conteudos = conteudos;				
			}
		}
	}
	
	public Set<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores;
	}

	public void setDesenvolvedores(Set<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudos, dataFim, dataInicio, descricao, desenvolvedores, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(conteudos, other.conteudos) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(desenvolvedores, other.desenvolvedores) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNome()).append("{\n")
			.append("\tdescricao = ").append(descricao).append("\n")
			.append("\tdataInicio = ").append(dataInicio).append("\n")
			.append("\tdataFim").append(dataFim).append("\n")
			.append("}\n");
		return builder.toString();
	}

}
