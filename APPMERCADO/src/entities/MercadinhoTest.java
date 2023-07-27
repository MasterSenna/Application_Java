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

        do {
            System.out.println("\n**** Cadastro de Funcionários ****");
            System.out.println("1. Cadastrar novo funcionário");
            System.out.println("2. Exibir lista de funcionários");
            System.out.println("3. Atualizar informações de um funcionário");
            System.out.println("4. Remover funcionário");
            System.out.println("5. Sair do programa");
            System.out.print("Escolha uma opção (1-5): ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    exibirListaFuncionarios();
                    break;
                case 3:
                    atualizarFuncionario();
                    break;
                case 4:
                    removerFuncionario();
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

    private static void cadastrarFuncionario() {
        // ...
    }

    private static void exibirListaFuncionarios() {
        // ...
    }

    private static void atualizarFuncionario() {
        // ...
    }

    private static void removerFuncionario() {
        // ...
    }

    private static Funcionario buscarFuncionarioPorNome(String nome) {
        // ...
    }
}
