package br.com.fiap.lista02.exercicio01;

public class Aluno {
	private int matricula;
	private String nome;
	private double prova1;
	private double prova2;
	private double trabalho;
	
	public Aluno(int matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	public double getProva1() {
		return prova1;
	}

	public void setProva1(double prova1) {
		this.prova1 = prova1;
	}

	public double getProva2() {
		return prova2;
	}

	public void setProva2(double prova2) {
		this.prova2 = prova2;
	}

	public double getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(double trabalho) {
		this.trabalho = trabalho;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
	
	public double calculaMedia() {
		double soma = (this.prova1 * 2.5 + this.prova2 * 2.5 + this.trabalho * 2);
		double media = soma / 7;
		return  media;
	}
	
	public double notaParaAvaliacaoFinal() {
		double media = this.calculaMedia();
		if(media < 6  && media >= 4) return 12 - media; 
		return 0;
	}
	
	
}
