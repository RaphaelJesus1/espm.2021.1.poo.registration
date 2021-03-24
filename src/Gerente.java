
public class Gerente extends Empregado{
	private double salario, bonus;
	
	public Gerente(String nome, String cpf, String matricula, double salario, double bonus) {
		super(nome, cpf, matricula);
		this.salario = salario;
		this.bonus = bonus;
	}
	
	public double calcularBonus() {
		return salario * bonus;
	}
}
