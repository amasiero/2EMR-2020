package br.com.fiap.estacionamento.modelo;

public class Pagamento {

	private Veiculo veiculo;
	private double valor;
	
	public Pagamento(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.valor = 0.0;
	}

	public Pagamento(Veiculo veiculo, double valor) {
		this(veiculo);
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
