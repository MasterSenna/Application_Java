package test;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroFuncionariosTest {
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n**** Cadastro de Funcionários ****");
            System.out.println("1. Cadastrar novo funcionário");
            System.out.println("2. Exibir lista de funcionários");
            System.out.println("3. Atualizar informações de um funcionário");
            System.out.println("4. Remover funcionário");
            System.out.println("5. Sair do programa");
            System.out.println();

            System.out.print("\n****Escolha uma opção (1-5): **** ");
            opcao = scanner.nextInt();
            
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
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void removerFuncionario(Scanner scanner) {
        System.out.println("\n**** Remover Funcionário ****");
        System.out.print("Digite o nome do funcionário que deseja remover: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        Funcionario funcionario = buscarFuncionarioPorNome(nome);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        listaFuncionarios.remove(funcionario);
        System.out.println("Funcionário removido com sucesso!");
    }

    public static void cadastrarFuncionario(Scanner scanner) {
        System.out.print("Digite o nome do funcionário: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        int idade;
        do {
            System.out.print("Digite a idade do funcionário (entre 18 e 100 anos): ");
            System.out.println();
            idade = scanner.nextInt();
            scanner.nextLine();

            if (idade <= 0 || idade >= 100) {
                System.out.println("Cadastre uma idade válida (entre 18 e 99 anos).");
                System.out.println();
            } else if (idade < 18) System.out.println();
                                                        {
                System.out.println("O funcionário deve ter 18 anos ou mais.");
            }
        } while (idade <= 0 || idade >= 100 || idade < 18);

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, idade, cargo);
        listaFuncionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static void exibirListaFuncionarios() {
        System.out.println("\n**** Lista de Funcionários ****");
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario);
            }
        }
    }

    public static void atualizarFuncionario(Scanner scanner) {
        System.out.println("\n**** Atualizar Funcionário ****");
        System.out.print("Digite o nome do funcionário que deseja atualizar: ");
        scanner.nextLine();
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

        int novaIdade;
        do {
            System.out.print("Digite a nova idade do funcionário (entre 18 e 100 anos): ");
            novaIdade = scanner.nextInt();
            scanner.nextLine();

            if (novaIdade <= 0 || novaIdade > 100) {
                System.out.println("Cadastre uma idade válida (entre 18 e 100 anos).");
            }
        } while (novaIdade <= 0 || novaIdade > 100);
        funcionario.setIdade(novaIdade);

        System.out.print("Digite o novo cargo do funcionário: ");
        String novoCargo = scanner.nextLine();
        funcionario.setCargo(novoCargo);

        System.out.println("Informações do funcionário atualizadas com sucesso!");
    }

    public static Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario != null && funcionario.getNome() != null && funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }
}
