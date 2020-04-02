
public class Estacionamento {
	
	private Ticket ticket;
	
	public void entra(Veiculo veiculo) {
		this.ticket = new Ticket(veiculo);
	}
	
	public void sai() {
		this.ticket.calculaValor();
	}
	
	public String relatorio() {
		return this.ticket.toString();
	}

}
