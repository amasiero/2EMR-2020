package br.com.fiap.biblioteca.model;

public class Biblioteca {

	private Livro[] livros;
	private int totalLivros;
	
	public Biblioteca() {
		this(10);
	}
	
	public Biblioteca(int quantidadeLivros) {
		this.livros = new Livro[quantidadeLivros];
		this.totalLivros = -1;
	}
	
	public int tamanho() {
		return this.totalLivros + 1;
	}
	
	public boolean cheia() {
		return this.totalLivros >= this.livros.length;
	}
	
	public boolean vazia() {
		return this.totalLivros < 0;
	}
	
	public void adiciona(Livro livro) {
		if (this.cheia()) System.err.println("Biblioteca com capacidade máxima atingida.");
		this.totalLivros++;
		this.livros[this.totalLivros] = livro;
	}
	
	public Livro consulta(String titulo) {
		
		for(Livro livro : this.livros) {
			if(livro.getTitulo()
					.toUpperCase()
					.contains(titulo.toUpperCase())) {
				return livro;
			}
		}
		
		return null;
	}
	
	public Livro remove(Livro livro) {
		Livro livroRemovido = null;
		boolean removido = false;
		
		for(int i = 0; i < this.totalLivros; i++) {
			if(livro.getTitulo()
					.equalsIgnoreCase(this.livros[i].getTitulo())
				&& !removido
			) {
				livroRemovido = this.livros[i];
				removido = true;
			}
			
			if (removido) {
				this.livros[i] = this.livros[i+1];
			}	
		}
		
		this.totalLivros--;
		return livroRemovido;
	}
	
	public void atualiza(Livro livro) {
		this.remove(livro);
		this.adiciona(livro);
	}
}
