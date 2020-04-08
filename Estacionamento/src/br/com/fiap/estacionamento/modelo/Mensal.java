package br.com.fiap.estacionamento.modelo;

import java.util.Date;

public class Mensal extends Pagamento {
	private Date dataContrato;
	private int diaPagamento;

	public Mensal(Veiculo veiculo, Date dataContrato, int diaPagamento, double valor) {
		super(veiculo, valor);
		this.dataContrato = dataContrato;
		this.diaPagamento = diaPagamento;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public int getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

}
