package br.com.fiap.pousada.exception;

public class ReservaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ReservaException() {
		this("Ocorreu um erro durante a reserva.");
	}
	
	public ReservaException(String msg) {
		super(msg);
	}
}
