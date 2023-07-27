package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Mercadinho;
import entities.Produto;

public class MecadoSena {
    public static void main(String[] args) {
        Mercadinho mercadinho = new Mercadinho("Mercadinho da Maria");

        Produto arroz = new Produto("001", "Arroz", 10.50, 10);
        Produto feijao = new Produto("002", "Feijão", 5.75, 5);
        Produto oleo = new Produto("003", "Óleo", 8.90, 8);

        mercadinho.adicionarProduto(arroz);
        mercadinho.adicionarProduto(feijao);
        mercadinho.adicionarProduto(oleo);

        Scanner leia = new Scanner(System.in);
        List<Produto> carrinho = new ArrayList<>();

        char opcao = 0;
        do {
            System.out.println("\n====================================");
            System.out.println("           Mercadinho Sena");
            System.out.println("====================================");
            System.out.println("Escolha os produtos:");

            for (Produto produto : mercadinho.getEstoque()) {
                System.out.println(produto.getCodigo() + " - " + produto.getNome() + " (R$" + produto.getValor() + ")");
            }

            System.out.print("Digite o código do produto desejado: ");
            String codigoProduto = leia.next();

            Produto produtoEscolhido = mercadinho.getProdutoPorCodigo(codigoProduto);
            if (produtoEscolhido == null) {
                System.out.println("Produto não encontrado com o código: " + codigoProduto);
                continue;
            }

            System.out.print("Digite a quantidade desejada: ");
            int quantidade;
            while (true) {
                try {
                    quantidade = Integer.parseInt(leia.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade inválida. Digite um número inteiro.");
                }
            }

            if (produtoEscolhido.getEstoque() < quantidade) {
                System.out.println("Estoque insuficiente para o produto: " + produtoEscolhido.getNome());
                continue;
            }

            mercadinho.comprarProduto(codigoProduto, quantidade);
            carrinho.add(new Produto(produtoEscolhido.getCodigo(), produtoEscolhido.getNome(), produtoEscolhido.getValor(), quantidade));

            System.out.print("Deseja comprar mais produtos? (S/N): ");
            opcao = leia.next().toUpperCase().charAt(0);
        } while (opcao == 'S');

        // Calculando o valor total da compra
        double valorTotalCompra = mercadinho.calcularValorTotal(carrinho);

        // Exibindo carrinho de compras
        System.out.println("\nCarrinho de Compras:");
        for (Produto produto : carrinho) {
            System.out.println(produto.getNome() + " - Quantidade: " + produto.getEstoque() + " - Valor: R$" + (produto.getValor() * produto.getEstoque()));
        }

        // Exibindo valor total da compra
        System.out.println("Valor total da compra: R$" + valorTotalCompra);

        leia.close();
    }
}
