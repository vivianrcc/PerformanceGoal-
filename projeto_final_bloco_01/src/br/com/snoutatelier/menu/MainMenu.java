package br.com.snoutatelier.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.snoutatelier.controller.ProdutoController;
import br.com.snoutatelier.model.Produto;
import br.com.snoutatelier.model.ProdutoVestuario;

public class MainMenu {

	private static Scanner scanner = new Scanner(System.in);
	private static ProdutoController produtoController = new ProdutoController(); 

	public static void main(String[] args) {
		int option;
		do {
			// EXIBINDO AS OPÇÕES
			System.out.println("\n--------------- Snout Atelier -------------");
			System.out.println("------------- 1. Cadastrar Produto ---------");
			System.out.println("------------- 2. Listar Produtos -------------");
			System.out.println("------------- 3. Atualizar Produto -----------");
			System.out.println("------------- 4. Excluir Produto -------------");
			System.out.println("------------- 5. Comprar Produto -------------");
			System.out.println("------------- 6. Exibir Preço -----------------");
			System.out.println("------------- 7. Sair -------------------------");
			System.out.print("Escolha uma opção: ");

			try {
				option = scanner.nextInt();
				scanner.nextLine();  

				switch (option) {
				case 1:
					cadastrarProduto();
					break;
				case 2:
					listarProdutos();
					break;
				case 3:
					atualizarProduto();
					break;
				case 4:
					excluirProduto();
					break;
				case 5:
					comprarProduto();
					break;
				case 6:
					exibirPreco();
					break;
				case 7:
					System.out.println("Saindo do sistema...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira um número.");
				scanner.next(); 
				option = -1;
			}
		} while (option != 7);
	}

	// METODOS CRIADOS PARA CADA CASE
	private static void cadastrarProduto() {
		System.out.println("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o preço do produto: ");
		double preco = scanner.nextDouble();
		scanner.nextLine(); 
		System.out.println("Digite o tamanho do produto (para vestuário): ");
		String tamanho = scanner.nextLine();

		Produto produto = new ProdutoVestuario(1, nome, preco, tamanho);
		produtoController.cadastrarProduto(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}

	// LISTANDO TODOS OS PRODUTOS CADASTRADOS
	private static void listarProdutos() {
		if (produtoController.getListaProdutos().isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			System.out.println("Lista de Produtos:");
			for (Produto produto : produtoController.getListaProdutos()) {
				System.out.println(
						"ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: R$" + produto.getPreco());
			}
		}
	}

	// ATUALIZANDO PRODUTO
	private static void atualizarProduto() {
		System.out.println("Digite o ID do produto que deseja atualizar: ");
		int id = scanner.nextInt();
		scanner.nextLine(); 
		Produto produto = produtoController.buscarProdutoPorId(id);

		if (produto != null) {
			System.out.println("Produto encontrado. Digite o novo nome: ");
			produto.setNome(scanner.nextLine());
			System.out.println("Digite o novo preço: ");
			produto.setPreco(scanner.nextDouble());
			scanner.nextLine(); 
			if (produto instanceof ProdutoVestuario) {
				System.out.println("Digite o novo tamanho: ");
				((ProdutoVestuario) produto).setTamanho(scanner.nextLine());
			}
			System.out.println("Produto atualizado com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	// EXCLUINDO PRODUTO
	private static void excluirProduto() {
        System.out.println("Digite o ID do produto que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Produto produto = produtoController.buscarProdutoPorId(id);

        if (produto != null) {
            produtoController.excluirProduto(id);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
	}

	// MÉTODO PARA COMPRAR PRODUTO
	private static void comprarProduto() {
		System.out.println("Digite o ID do produto que deseja comprar: ");
		int id = scanner.nextInt();
		Produto produto = produtoController.buscarProdutoPorId(id);

		if (produto != null) {
			System.out.println("Você comprou o produto: " + produto.getNome());
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	// EXIBINDO O PREÇO DO PRODUTO
	private static void exibirPreco() {
		System.out.println("Digite o ID do produto para exibir o preço: ");
		int id = scanner.nextInt();
		Produto produto = produtoController.buscarProdutoPorId(id);

		if (produto != null) {
			System.out.println("O preço do produto " + produto.getNome() + " é: R$" + produto.getPreco());
		} else {
			System.out.println("Produto não encontrado.");
		}
	}
}

