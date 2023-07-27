package entities;

import java.util.ArrayList;
import java.util.List;

public class Mercadinho {
    private String nome;
    private List<Produto> estoque;

    public Mercadinho(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
    }

    public void comprarProduto(String codigo, int quantidade) {
        Produto produto = getProdutoPorCodigo(codigo);
        if (produto != null) {
            int estoqueAtual = produto.getEstoque();
            if (estoqueAtual >= quantidade) {
                produto.setEstoque(estoqueAtual - quantidade);
            } else {
                System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
            }
        } else {
            System.out.println("Produto não encontrado com o código: " + codigo);
        }
    }

    public double calcularValorTotal(List<Produto> carrinho) {
        double valorTotal = 0.0;
        for (Produto produto : carrinho) {
            valorTotal += produto.getValor() * produto.getEstoque();
        }
        return valorTotal;
    }

    public Produto getProdutoPorCodigo(String codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public List<Produto> getEstoque() {
        return estoque;
    }
}
