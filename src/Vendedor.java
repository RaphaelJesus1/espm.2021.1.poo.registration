
public class Vendedor extends Empregado{
	private double totalDasVendas, comissao;
	
	public Vendedor(String nome, String cpf, String matricula, double totalDasVendas, double comissao) {
		super(nome, cpf, matricula);
		this.totalDasVendas = totalDasVendas;
		this.comissao = comissao;
	}
}
