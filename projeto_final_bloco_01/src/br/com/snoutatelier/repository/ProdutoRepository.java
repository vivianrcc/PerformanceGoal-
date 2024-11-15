package br.com.snoutatelier.repository;

import br.com.snoutatelier.model.Produto;

public interface ProdutoRepository {
	
	void cadastrarProduto(Produto produto);

	void listarProdutos();

	void atualizarProduto(Produto produto);

	void excluirProduto(int id);

	Produto buscarProdutoPorId(int id);
}
