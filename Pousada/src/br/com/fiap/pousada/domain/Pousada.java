package br.com.fiap.pousada.domain;

import java.util.ArrayList;
import java.util.List;

public class Pousada {
	
	public List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}

}
