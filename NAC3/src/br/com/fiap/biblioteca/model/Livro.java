package br.com.fiap.biblioteca.model;

public class Livro {

	private String titulo;
	private String isbn;
	private int anoLancamento;
	private Autor autor;

	public Livro(String titulo, String isbn, int anoLancamento, Autor autor) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.anoLancamento = anoLancamento;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
