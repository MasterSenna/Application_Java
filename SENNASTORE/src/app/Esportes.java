package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.ArtigosEsportes;
import entities.ArtigosPremium;
import entities.Produto;
public class Esportes {
	private static List<Produto> listaProdutos = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		System.out.println("Bem-vindo ao Sistema SennaEsporte - Loja de Artigos Esportivos!");
		System.out.println("***************************************************************");
		do {
			System.out.println("\n********** Menu **********");
			System.out.println("1. Incluir produtos");
			System.out.println("2. Alterar dados dos produtos");
			System.out.println("3. Excluir dados dos produtos");
			System.out.println("4. Comprar produtos");
			System.out.println("5. Exibir lista de produtos");
			System.out.println("6. Sair do programa");
			System.out.print("\nDigite o número da sua opção (1-6): ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer
			switch (opcao) {
			case 1:
				incluirProdutos(scanner);
				break;
			case 2:
				alterarDadosProdutos(scanner);
				break;
			case 3:
				excluirDadosProdutos(scanner);
				break;
			case 4:
				comprarProdutos(scanner);
				break;
			case 5:
				exibirListaProdutos();
				break;
			case 6:
				System.out.println("\nEncerrando o programa. Obrigado por utilizar o Sistema SennaEsporte!");
				System.out.println("*****************************************************************");
				break;
			default:
				System.out.println("\nOpção inválida. Tente novamente.");
			}
		} while (opcao != 6);
		scanner.close();
	}
	public static void incluirProdutos(Scanner scanner) {
		System.out.println("\n********** Incluir Produtos **********");
		System.out.print("Digite o código do produto: ");
		String codigo = scanner.nextLine();
		// Verificar se o código já existe na lista
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo().equals(codigo)) {
				System.out.println("\nJá existe um produto com o código informado. A inclusão não foi realizada.");
				return;
			}
		}
		System.out.print("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.print("Digite o valor do produto: R$");
		double valor = scanner.nextDouble();
		System.out.print("Digite o estoque do produto: ");
		int estoque = scanner.nextInt();
		System.out.println("Tipo de produto (1 - Normal / 2 - Premium): ");
		int tipoProduto = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer
		Produto produto;
		if (tipoProduto == 1) {
			produto = new ArtigosEsportes(codigo, nome, valor, estoque);
		} else if (tipoProduto == 2) {
			System.out.print("Digite o valor adicional premium: R$");
			double adicionalPremium = scanner.nextDouble();
			produto = new ArtigosPremium(codigo, nome, valor, estoque, adicionalPremium);
		} else {
			System.out.println("Tipo de produto inválido. A inclusão não foi realizada.");
			return;
		}
		listaProdutos.add(produto);
		System.out.println("\nProduto incluído com sucesso!");
	}
	public static void alterarDadosProdutos(Scanner scanner) {
		System.out.println("\n********** Alterar Dados dos Produtos **********");
		System.out.print("Digite o código do produto que deseja alterar: ");
		String codigo = scanner.nextLine();
		Produto produto = buscarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não encontrado.");
			return;
		}
		System.out.println("\nDados do produto selecionado:");
		System.out.println(produto);
		System.out.println("\nDigite as novas informações do produto:");
		System.out.print("Nome: ");
		String novoNome = scanner.nextLine();
		produto.setNome(novoNome);
		System.out.print("Valor: R$");
		double novoValor = scanner.nextDouble();
		produto.setValor(novoValor);
		System.out.print("Estoque: ");
		int novoEstoque = scanner.nextInt();
		produto.setEstoque(novoEstoque);
		System.out.println("\nDados do produto atualizados com sucesso!");
	}
	public static void excluirDadosProdutos(Scanner scanner) {
		System.out.println("\n********** Excluir Dados dos Produtos **********");
		System.out.print("Digite o código do produto que deseja excluir: ");
		String codigo = scanner.nextLine();
		Produto produto = buscarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não encontrado.");
			return;
		}
		listaProdutos.remove(produto);
		System.out.println("\nProduto removido com sucesso!");
	}
	public static void comprarProdutos(Scanner scanner) {
		System.out.println("\n********** Comprar Produtos **********");
		System.out.print("Digite o código do produto que deseja comprar: ");
		String codigo = scanner.nextLine();
		Produto produto = buscarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não encontrado.");
			return;
		}
		System.out.println("\nDados do produto selecionado:");
		System.out.println(produto);
		System.out.print("Digite a quantidade que deseja comprar: ");
		int quantidadeCompra = scanner.nextInt();
		if (quantidadeCompra <= 0) {
			System.out.println("\nQuantidade inválida. A compra não foi realizada.");
		} else if (quantidadeCompra > produto.getEstoque()) {
			System.out.println("\nNão há estoque suficiente para realizar a compra.");
		} else {
			double valorCompra = produto.valorCompra(quantidadeCompra);
			produto.tirarEstoque(quantidadeCompra);
			System.out.println("\nCompra realizada com sucesso!");
			System.out.println("Valor total da compra: R$" + valorCompra);
		}
	}
	public static void exibirListaProdutos() {
		System.out.println("\n********** Lista de Produtos **********");
		if (listaProdutos.isEmpty()) {
			System.out.println("Não há produtos cadastrados.");
		} else {
			for (Produto produto : listaProdutos) {
				System.out.println(produto);
				System.out.println("--------------------");
			}
		}
	}
	private static Produto buscarProdutoPorCodigo(String codigo) {
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo().equals(codigo)) {
				return produto;
			}
		}
		return null;
	}
}








