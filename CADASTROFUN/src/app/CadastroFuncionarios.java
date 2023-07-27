package app;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroFuncionarios {
	private static List<Funcionario> listaFuncionarios = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		System.out.println("Bem-vindo ao Sistema de Cadastro de Funcionários SennaDev!");
		System.out.println("**********************************************************");

		do {
			System.out.println("\n********** Cadastro de Funcionários **********");
			System.out.println("1. Cadastrar novo funcionário");
			System.out.println("2. Exibir lista de funcionários");
			System.out.println("3. Atualizar informações de um funcionário");
			System.out.println("4. Remover funcionário");
			System.out.println("5. Sair do programa");
			System.out.print("\nEscolha uma opção (1-5): ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer

			switch (opcao) {
			case 1:
				cadastrarFuncionario(scanner);
				break;
			case 2:
				exibirListaFuncionarios();
				break;
			case 3:
				atualizarFuncionario(scanner);
				break;
			case 4:
				removerFuncionario(scanner);
				break;
			case 5:
				System.out.println("\nEncerrando o programa. SennaDev Agradecea:) Até logo!");
				System.out.println("_____________________________________________________");

				break;
			default:
				System.out.println("\nOpção inválida. Tente novamente.");
			}
		} while (opcao != 5);

		scanner.close();
	}

	// Restante do código (as funções cadastradas, exibirListaFuncionarios, etc.)
	// permanecem inalteradas.

	public static void cadastrarFuncionario(Scanner scanner) {
		System.out.println("\n********** Cadastrar Funcionário **********");
		System.out.print("Digite o nome do funcionário: ");
		String nome = scanner.nextLine();

		int idade;
		do {
			System.out.print("Digite a idade do funcionário (entre 18 e 99 anos): ");
			idade = scanner.nextInt();
			scanner.nextLine(); // Consumir quebra de linha

			if (idade <= 0 || idade > 100) {
				System.out.println("Cadastre uma idade válida (entre 18 e 99 anos).");
			} else if (idade < 18) {
				System.out.println("O funcionário deve ter 18 anos ou mais.");
			}
		} while (idade <= 0 || idade > 100 || idade < 18);

		System.out.print("Digite o cargo do funcionário: ");
		String cargo = scanner.nextLine();

		Funcionario funcionario = new Funcionario(nome, idade, cargo);
		listaFuncionarios.add(funcionario);

		System.out.println("\nFuncionário cadastrado com sucesso!");
	}

	public static void exibirListaFuncionarios() {
		System.out.println("\n********** Lista de Funcionários **********");
		if (listaFuncionarios.isEmpty()) {
			System.out.println("Não há funcionários cadastrados.");
		} else {
			for (Funcionario funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}
		}
	}

	public static void atualizarFuncionario(Scanner scanner) {
		System.out.println("\n********** Atualizar Funcionário **********");
		System.out.print("Digite o nome do funcionário que deseja atualizar: ");
		String nome = scanner.nextLine();

		Funcionario funcionario = buscarFuncionarioPorNome(nome);

		if (funcionario == null) {
			System.out.println("Funcionário não encontrado.");
			return;
		}

		System.out.println("\nInformações atuais do funcionário:");
		System.out.println(funcionario);

		System.out.print("Digite o novo nome do funcionário: ");
		String novoNome = scanner.nextLine();
		funcionario.setNome(novoNome);

		int idade;
		do {
			System.out.print("Digite a nova idade do funcionário (entre 18 e 99 anos): ");
			idade = scanner.nextInt();
			scanner.nextLine();

			if (idade < 18 || idade >= 100) {
				System.out.println("Cadastre uma idade válida (entre 18 e 99 anos).");
			}
		} while (idade < 18 || idade >= 100);
		funcionario.setIdade(idade);

		System.out.print("Digite o novo cargo do funcionário: ");
		String novoCargo = scanner.nextLine();
		funcionario.setCargo(novoCargo);

		System.out.println("\nInformações do funcionário atualizadas com sucesso!");
	}

	public static void removerFuncionario(Scanner scanner) {
		System.out.println("\n********** Remover Funcionário **********");
		System.out.print("Digite o nome do funcionário que deseja remover: ");
		String nome = scanner.nextLine();

		Funcionario funcionario = buscarFuncionarioPorNome(nome);

		if (funcionario == null) {
			System.out.println("Funcionário não encontrado.");
			return;
		}

		listaFuncionarios.remove(funcionario);
		System.out.println("Funcionário removido com sucesso!");
	}

	private static Funcionario buscarFuncionarioPorNome(String nome) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario != null && funcionario.getNome() != null && funcionario.getNome().equalsIgnoreCase(nome)) {
				return funcionario;
			}
		}
		return null;
	}
}
