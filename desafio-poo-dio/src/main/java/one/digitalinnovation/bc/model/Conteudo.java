package one.digitalinnovation.bc.model;

/**
 * Classe abstrata de conteudos do bootcamp
 * @author erikv
 * @since 21/03/2023
 * 
 */
public abstract class Conteudo {

	private static final double XP_PADRAO = 10.0;
	private String titulo;
	private String descricao;
	
	public Conteudo(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public static double getXpPadrao() {
		return XP_PADRAO;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public abstract double calcularXp();
	
}
