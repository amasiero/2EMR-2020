package br.com.fiap.pousada.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pousada.dao.ReservaDAO;
import br.com.fiap.pousada.exception.ReservaDaoException;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.validation.ReservaValidation;

public class Pousada {
	
	public List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}
	
	public void atualiza() throws ReservaDaoException {
		reservas = new ReservaDAO().consultaTodos();
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void efetuaReserva(Reserva reserva) throws ReservaDaoException, ReservaException {
		
		ReservaValidation.validaDataEntrada(reserva);
		ReservaValidation.validaDataSaida(reserva);
		ReservaValidation.validaQuantidadePessoas(reserva);
		ReservaValidation.validaCapaciadadeMaximaDeQuartos(reservas, reserva.getQuarto().getCategoria());
		
		reserva = new ReservaDAO().salva(reserva);
		reservas.add(reserva);
	}
	
	

}
