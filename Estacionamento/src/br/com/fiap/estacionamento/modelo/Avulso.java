package br.com.fiap.estacionamento.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Avulso extends Pagamento {
	
	private Date entrada;
	private Date saida;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Avulso(Veiculo veiculo) {
		super(veiculo);
		this.entrada = new Date();
	}
	
	public Avulso(Veiculo veiculo, Date entrada) {
		this(veiculo);
		this.entrada = entrada;
	}
	
	public Avulso(Veiculo veiculo, Date entrada, Date saida, double valor) {
		this(veiculo, entrada);
		this.saida = saida;
		super.setValor(valor);
	}
	
	public Date getEntrada() {
		return this.entrada;
	}
	
	public String entradaParaTexto() {
		return this.sdf.format(this.entrada);
	}
	
	public Date getSaida() {
		return this.saida;
	}
	
	public String saidaParaTexto() {
		return this.saida == null ? " estacionado " : this.sdf.format(this.saida);
	}
	
	public void calculaValor() {
		this.saida = new Date();
		long diferenca = this.saida.getTime() - this.entrada.getTime();
		int horas = (int) (diferenca / 1000 / 60 / 60);
		int minutos = (int) (diferenca / 1000 / 60) - (horas * 60);
		
		super.setValor(horas * 3);
		if (minutos > 0) {
			super.setValor(super.getValor() + 3);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getVeiculo());
		sb.append(" | ");
		sb.append(entradaParaTexto());
		sb.append(" | ");
		sb.append(saidaParaTexto());
		sb.append(" | R$ ");
		sb.append(super.getValor());
		return sb.toString();
	}
	
}















