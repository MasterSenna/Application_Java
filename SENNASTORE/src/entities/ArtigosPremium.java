
package entities;
public class ArtigosPremium extends Produto {
	private double adicionalPremium;
	public ArtigosPremium(String codigo, String nome, double valor, int estoque, double adicionalPremium) {
		super(codigo, nome, valor, estoque);
		this.adicionalPremium = adicionalPremium;
	}
	public double getAdicionalPremium() {
		return adicionalPremium;
	}
	public void setAdicionalPremium(double adicionalPremium) {
		this.adicionalPremium = adicionalPremium;
	}
	@Override
	public double valorCompra(int quantidadeCompra) {
		return (getValor() + adicionalPremium) * quantidadeCompra;
	}
	@Override
	public String toString() {
		return "Artigos Premium - " + super.toString() + ", Adicional Premium: R$" + adicionalPremium;
	}
}
