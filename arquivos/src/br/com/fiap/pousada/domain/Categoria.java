package br.com.fiap.pousada.domain;

public enum Categoria {
	VIP("V.I.P."), APARTAMENTO("Apartamento");
	
	private String value;
	
	private Categoria(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
