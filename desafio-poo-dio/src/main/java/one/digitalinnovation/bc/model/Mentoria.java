package one.digitalinnovation.bc.model;

import java.time.LocalDate;

/**
 * Classe concreta mentoria que herda da classe abstrata conteudo
 * 
 * @author erikv
 * @since 21/03/2023
 * 
 */
public class Mentoria extends Conteudo {

	private LocalDate dataMentoria;
	private double xpBonus = 0;

	public Mentoria(String titulo, String descricao, LocalDate dataMentoria) {
		super(titulo, descricao);
		this.dataMentoria = dataMentoria;
	}

	public Mentoria(String titulo, String descricao, LocalDate dataMentoria, double xpBonus) {
		super(titulo, descricao);
		this.dataMentoria = dataMentoria;
		this.xpBonus = xpBonus;
	}

	public LocalDate getDataMentoria() {
		return dataMentoria;
	}

	public void setDataMentoria(LocalDate dataMentoria) {
		this.dataMentoria = dataMentoria;
	}
	
	public double getXpBonus() {
		return xpBonus;
	}

	public void setXpBonus(double xpBonus) {
		this.xpBonus = xpBonus;
	}

	@Override
	public double calcularXp() {
		return getXpPadrao() + 15.0 + xpBonus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mentoria {")
			.append("Título = ").append(getTitulo()).append(", ")
			.append("Descrição = ").append(getDescricao()).append(", ")
			.append("Data da mentoria = ").append(getDataMentoria().toString()).append(", ")
			.append("Xp bonus = ").append(getXpBonus()).append(", ")
			.append("Xp total = ").append(calcularXp());
		builder.append("}");

		return builder.toString();
	}

}
