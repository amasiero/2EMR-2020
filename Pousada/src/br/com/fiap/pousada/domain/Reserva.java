package br.com.fiap.pousada.domain;

import java.time.LocalDate;
import java.time.ZoneOffset;

import br.com.fiap.pousada.helper.DateHelper;

public class Reserva {
	private Long id;
	private Quarto quarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private Integer qtdePessoas;
	
	public Reserva(Long id, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, Integer qtdePessoas) {
		this(quarto, dataEntrada, dataSaida, qtdePessoas);
		this.id = id;
	}

	public Reserva(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, Integer qtdePessoas) {
		super();
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.qtdePessoas = qtdePessoas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public Integer getQtdePessoas() {
		return qtdePessoas;
	}
	
	@Override
	public String toString() {
		return String.format("Reserva #%s -> {\n\tQuarto nro: %s, \n\tData de entrada: %s, "
				+ "\n\tData de saída: %s, \n\tQtde. Pessoas: %s, \n\tValor Total: R$ %.2f \n}", 
				id, quarto.getNumero(), DateHelper.toText(dataEntrada), 
				DateHelper.toText(dataSaida), qtdePessoas, calculaValorHospedagem());
	}

	public Double calculaValorHospedagem() {
		Long entrada = dataEntrada.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
		Long saida = dataSaida.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
		
		Long dias = (saida - entrada) / 1000 / 60 / 60 / 24;
		
		return dias * quarto.getValorDiaria();
	}
	
	
}
