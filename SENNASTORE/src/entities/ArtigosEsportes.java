package entities;
public class ArtigosEsportes extends Produto {
	public ArtigosEsportes(String codigo, String nome, double valor, int estoque) {
		super(codigo, nome, valor, estoque);
	}
	@Override
	public double valorCompra(int quantidadeCompra) {
		return getValor() * quantidadeCompra;
	}
	@Override
	public String toString() {
		return "Artigos Esportes - " + super.toString();
	}
}




