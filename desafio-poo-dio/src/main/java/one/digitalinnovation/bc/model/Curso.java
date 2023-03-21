package one.digitalinnovation.bc.model;

/**
 * Classe concreta curso que herda da classe abstrata conteudo
 * @author erikv
 * @since 21/03/2023
 * 
 */
public class Curso extends Conteudo{
	
	private int cargaHoraria;
	private double xpPorHoraCurso = 0.5;

	public Curso(String titulo, String descricao, int cargaHoraria) {
		super(titulo, descricao);
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso(String titulo, String descricao, int cargaHoraria, double xpPorHoraCurso) {
		super(titulo, descricao);
		this.cargaHoraria = cargaHoraria;
		this.xpPorHoraCurso = xpPorHoraCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public double getXpPorHoraCurso() {
		return xpPorHoraCurso;
	}

	public void setXpPorHoraCurso(double xpPorHoraCurso) {
		this.xpPorHoraCurso = xpPorHoraCurso;
	}

	@Override
	public double calcularXp() {
		return getXpPadrao() + (cargaHoraria * xpPorHoraCurso) ;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso {")
				.append("Título = ").append(getTitulo()).append(", ")
				.append("Descrição = ").append(getDescricao()).append(", ")
				.append("Carga horária = ").append(getCargaHoraria()).append(", ")
				.append("Xp = ").append(calcularXp());
		builder.append("}");
		
		return builder.toString();
	}
	
}
