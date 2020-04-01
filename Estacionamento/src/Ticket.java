import java.util.Date;

public class Ticket {
	
	private Veiculo veiculo;
	private Date entrada;
	private Date saida;
	private double valor;
	
	public Ticket(Veiculo veiculo, Date entrada) {
		this.veiculo = veiculo;
		this.entrada = entrada;
	}
	
	public Ticket(Veiculo veiculo, Date entrada, Date saida, double valor) {
		this(veiculo, entrada);
		this.saida = saida;
		this.valor = valor;
	}
	
	public Veiculo getVeiculo() {
		return this.veiculo;
	}
	
	public Date getEntrada() {
		return this.entrada;
	}
	
	public Date getSaida() {
		return this.saida;
	}
	
	public double getValor() {
		return this.valor;
	}
	
}
