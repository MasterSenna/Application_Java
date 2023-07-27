package entities;

public class Funcionario {
    private String nome;
    private int idade;
    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setCargo(String novoCargo) {
        this.cargo = novoCargo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Cargo: " + cargo;
    }

	public Object getIdade() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCargo() {
		// TODO Auto-generated method stub
		return null;
	}
}
