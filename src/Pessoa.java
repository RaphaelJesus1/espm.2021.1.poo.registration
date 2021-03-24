
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
	
	@Override
	public boolean equals(Object obj) {
		String auxCpf;
		if(obj instanceof Pessoa) {
			auxCpf = ((Pessoa) obj).cpf;
			if(cpf.equals(auxCpf)) {
				return true;
			}
		}
		return false;
	}
}
