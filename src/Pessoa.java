
public class Pessoa {
	protected String nome, cpf;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Nome : "+ nome + "\n"
				+ "CPF: " + cpf;
	}
}
