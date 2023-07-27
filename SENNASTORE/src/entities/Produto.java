package entities;
public abstract class Produto {
	private String codigo;
	private String nome;
	private double valor;
	private int estoque;
	public Produto(String codigo, String nome, double valor, int estoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.estoque = estoque;
	}
	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double novoValor) {
		this.valor = novoValor;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int novoEstoque) {
		this.estoque = novoEstoque;
	}
	// Métodos abstratos
	public abstract double valorCompra(int quantidadeCompra);
	// Método para incluir estoque
	public void incluirEstoque(int quantidade) {
		if (quantidade > 0) {
			estoque += quantidade;
		}
	}
	// Método para tirar estoque
	public void tirarEstoque(int quantidade) {
		if (quantidade > 0 && quantidade <= estoque) {
			estoque -= quantidade;
		}
	}
	@Override
	public String toString() {
		return "Código: " + codigo + ", Nome: " + nome + ", Valor: R$" + valor + ", Estoque: " + estoque;
	}
}

