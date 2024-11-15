package br.com.snoutatelier.controller;

import java.util.ArrayList;
import java.util.Optional;

import br.com.snoutatelier.model.Produto;
import br.com.snoutatelier.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	@Override
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}

	@Override
	public void listarProdutos() {
		if (listaProdutos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			System.out.println("Lista de Produtos:");
			for (Produto produto : listaProdutos) {
				System.out.println(
						"ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: R$" + produto.getPreco());
			}
		}
	}

	@Override
	public void atualizarProduto(Produto produto) {
		Optional<Produto> produtoExistente = listaProdutos.stream().filter(p -> p.getId() == produto.getId())
				.findFirst();

		if (produtoExistente.isPresent()) {
			int index = listaProdutos.indexOf(produtoExistente.get());
			listaProdutos.set(index, produto);
			System.out.println("Produto atualizado com sucesso!");
		} else {
			System.out.println("Produto não encontrado para atualização.");
		}
	}

	@Override
	public void excluirProduto(int id) {
		Produto produto = buscarProdutoPorId(id);
		if (produto != null) {
			listaProdutos.remove(produto);
			System.out.println("Produto excluído com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	@Override
	public Produto buscarProdutoPorId(int id) {
		return listaProdutos.stream().filter(produto -> produto.getId() == id).findFirst().orElse(null);
	}

	// MéETODO PATA ACESSAR LIOSTA DE PRODUTOS
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
}
