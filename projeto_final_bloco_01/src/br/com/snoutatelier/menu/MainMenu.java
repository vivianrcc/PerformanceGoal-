package br.com.snoutatelier.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

	private static Scanner scanner = new Scanner(System.in);

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

	private static void cadastrarProduto() {
		System.out.println("Função de cadastro de produto.");
	}

	private static void listarProdutos() {
		System.out.println("Função para listar produtos.");
		
	}

	private static void atualizarProduto() {
		System.out.println("Função para atualizar produto.");
		
	}

	private static void excluirProduto() {
		System.out.println("Função para excluir produto.");
		
	}

	private static void comprarProduto() {
		System.out.println("Função para comprar produto.");
		
	}

	private static void exibirPreco() {
		System.out.println("Função para exibir preço.");
		
	}
}
