package br.com.snoutatelier.model;

public abstract class Produto {

	private int id;
	private String nome;
	private double preco;

	// CONSTRUTOR
	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	// GETTERS SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// METODO TOSTRING
	@Override
	public String toString() {
		return "ID: " + id + ", Nome: " + nome + ", Preço: R$" + preco;
	}
}
