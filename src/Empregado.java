
public class Empregado extends Pessoa{
	protected String matricula;
	
	public Empregado(String nome, String cpf, String matricula) {
		super(nome, cpf);
		this.matricula = matricula;
	}
}
