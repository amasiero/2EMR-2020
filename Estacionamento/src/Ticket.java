import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	
	private Veiculo veiculo;
	private Date entrada;
	private Date saida;
	private double valor;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Ticket(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.entrada = new Date();
	}
	
	public Ticket(Veiculo veiculo, Date entrada) {
		this(veiculo);
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
	
	public String entradaParaTexto() {
		return this.sdf.format(this.entrada);
	}
	
	public Date getSaida() {
		return this.saida;
	}
	
	public String saidaParaTexto() {
		return this.saida == null ? " estacionado " : this.sdf.format(this.saida);
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void calculaValor() {
		this.saida = new Date();
		long diferenca = this.saida.getTime() - this.entrada.getTime();
		int horas = (int) (diferenca / 1000 / 60 / 60);
		int minutos = (int) (diferenca / 1000 / 60) - (horas * 60);
		
		this.valor = horas * 3;
		if (minutos > 0) {
			this.valor += 3; // this.valor = this.valor + 3
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(veiculo);
		sb.append(" | ");
		sb.append(entradaParaTexto());
		sb.append(" | ");
		sb.append(saidaParaTexto());
		sb.append(" | R$ ");
		sb.append(valor);
		return sb.toString();
	}
	
}















