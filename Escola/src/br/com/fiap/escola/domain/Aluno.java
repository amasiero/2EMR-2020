package br.com.fiap.escola.domain;

/**
 * 
 * Comentário Javadoc
 *
 */
public class Aluno {

	private Long id;
	private Long rm;
	private String nome;
	private Boolean ativo;
	private Double nota1;
	private Double nota2;
	
	public Aluno(Long id, Long rm, String nome, Boolean ativo, Double nota1, Double nota2) {
		this(rm, nome, ativo, nota1, nota2);
		this.id = id;
	}

	public Aluno(Long rm, String nome, Boolean ativo, Double nota1, Double nota2) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.ativo = ativo;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public Double getNota1() {
		return nota1;
	}

	public Double getNota2() {
		return nota2;
	}
	
	@Override
	public String toString() {
		return String.format("Aluno: { id: %s, rm: %s, nome: %s,"
				+ " nota 1: %.1f, nota 2: %.1f, %s }",
				this.id, this.rm, this.nome, this.nota1, this.nota2,
				(this.ativo ? "ativo" : "inativo"));
	}
 
}
