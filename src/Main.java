import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		int opcao;
		
		do {
			opcao = Integer.parseInt(showInputDialog(gerarMenu()));
			
			switch (opcao) {
			case 1:
				//1. Cadastrar empregado
				Empregado novoEmpregado = cadastrarEmpregado(pessoas);
				if(novoEmpregado == null) { // se retornar null o empregado j� havia sido cadastrado.
					showMessageDialog(null, "O empregado j� est� cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					pessoas.add(novoEmpregado);
				}
				break;
			case 2:
				//2. Cadastrar cliente
				Cliente novoCliente = cadastrarCliente(pessoas);
				if(novoCliente == null) { // se retornar null o empregado j� havia sido cadastrado.
					showMessageDialog(null, "O cliente j� est� cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					pessoas.add(novoCliente);
				}
				break;
			case 3:
				//3. Pesquisar
				pesquisar(pessoas);
				break;
			case 4:
				//4. Listar empregados
				break;
			case 5:
				//5. Listar Clientes
				break;
			case 6:
				//6. Remover
			}
			
		} while(opcao != 7);

	}
	
	private static int pesquisarIndexPorCpf(String cpf, ArrayList<Pessoa> lista) {
		return lista.indexOf(new Pessoa("", cpf)); // verifica se um objeto com cpf parecido existe. Se sim, retorna seu �ndice, se n�o retorna -1
	}
	
	public static void pesquisar(ArrayList<Pessoa> lista) {
		String cpf = showInputDialog("CPF").trim();
		int i = pesquisarIndexPorCpf(cpf, lista); // identifica se o cpf consta no sistema e retorna o �ndice na lista
		
		if(i != -1) {
			String msg = lista.get(i).toString(); // dados da pessoa
			
			if(lista.get(i) instanceof Cliente) { // classifica��o de acordo com a classe
				msg += "\n\n� um(a) cliente";
			} else if(lista.get(i) instanceof Vendedor){
				msg += "\n\n� um(a) vendedor(a)";
			} else {
				msg += "\n\n� gerente";
			}
			showMessageDialog(null, msg); 
		} else {
			showMessageDialog(null, "Pessoa n�o encontrada", "Erro", JOptionPane.ERROR_MESSAGE); // caso n�o exista registro
		}
	} 
	
	public static Cliente cadastrarCliente(ArrayList<Pessoa> lista) {
		String cpf = showInputDialog("CPF").trim();
		int aux = pesquisarIndexPorCpf(cpf, lista); //verifica se o cliente j� foi cadastrado no sistema
		if(aux != -1) { return null; } //se foi cadastrado retorna null
		
		String nome = showInputDialog("Nome do cliente").trim();
		double divida = Double.parseDouble(showInputDialog("Insira o valor da d�vida do cliente"));
		
		Cliente cliente = new Cliente(nome, cpf, divida);
		return cliente;
	}
	
	public static Empregado cadastrarEmpregado(ArrayList<Pessoa> lista) {
		String cpf = showInputDialog("CPF").trim();
		int aux = pesquisarIndexPorCpf(cpf, lista); //verifica se o cliente j� foi cadastrado no sistema
		if(aux != -1) { return null; } //se foi cadastrado retorna null
		
		String nome = showInputDialog("Nome do empregado").trim();
		String matricula = showInputDialog("Matr�cula").trim();
		
		Object[] opcoes = {"Gerente", "Vendedor"}; // bot�es de escolha personalizados
		int i = showOptionDialog(null, "Qual tipo de empregado quer cadastrar?","Submenu", //painel de escolha: vendedor ou gerente
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
		
		if(i == 0) { //op��o gerente
			double salario = Double.parseDouble(showInputDialog("Sal�rio"));
			double bonus = Double.parseDouble(showInputDialog("% B�nus"));
			Gerente gerente = new Gerente(nome, cpf, matricula, salario, bonus);
			return gerente;
			
		} else { //op��o vendedor
			double totalDasVendas = Double.parseDouble(showInputDialog("Total das vendas"));
			double comissao = Double.parseDouble(showInputDialog("% Comiss�o"));
			Vendedor vendedor = new Vendedor(nome, cpf, matricula, totalDasVendas, comissao);
			return vendedor;
		}
	}
	
	public static String gerarMenu() {
		return "Escolha uma opera��o:\n"
				+ "\t 1. Cadastrar empregado \n"
				+ "\t 2. Cadastrar cliente \n"
				+ "\t 3. Pesquisar \n"
				+ "\t 4. Listar empregados \n"
				+ "\t 5. Listar clientes \n"
				+ "\t 6. Remover \n"
				+ "\t 7. Finalizar";
	}

}
