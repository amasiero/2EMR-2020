package br.com.fiap.estacionamento.modelo;

public class Estacionamento {
	
	private Avulso ticket;
	
	public void entra(Veiculo veiculo) {
		this.ticket = new Avulso(veiculo);
	}
	
	public void sai() {
		this.ticket.calculaValor();
	}
	
	public String relatorio() {
		return this.ticket.toString();
	}

}
