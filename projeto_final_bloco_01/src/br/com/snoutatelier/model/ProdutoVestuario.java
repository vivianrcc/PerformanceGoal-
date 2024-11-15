package br.com.snoutatelier.model;

public class ProdutoVestuario extends Produto {

	private String tamanho;

	// CONSTRUTOR
	public ProdutoVestuario(int id, String nome, double preco, String tamanho) {
		super(id, nome, preco);
		this.tamanho = tamanho;
	}

	// GETTERS SETTERS
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

}
