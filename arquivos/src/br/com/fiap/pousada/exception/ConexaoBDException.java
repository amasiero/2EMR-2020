package br.com.fiap.pousada.exception;

public class ConexaoBDException extends Exception {

	private static final long serialVersionUID = 4129654199470964809L;

	public ConexaoBDException() {
		this("N�o foi poss�vel fazer a conex�o com o banco de dados.");
	}
	
	public ConexaoBDException(String msg) {
		super(msg);
	}
}
