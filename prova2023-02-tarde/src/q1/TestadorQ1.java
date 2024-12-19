package q1;

/**
 * Questão 1 (4 pontos).
 * 
 * Crie classes para representar dados sobre uma empresa com suas unidades organizacionais 
 * (departamentos estruturados em setores) e seus funcionários (lotados em setores). 
 * 
 * Siga o diagrama UML fornecido (diagrama-q1.png). (O diagrama mostra alguns atributos e 
 * algumas operações, mas não é exaustivo quanto aos atributos e operações. 
 * Adicione aqueles que foram necessários.)
 * 
 * Implemente funcionalidade nas suas classes para calcular o salário médio de uma 
 * unidade organizacional, assim como para consultar os funcionários nela lotados 
 * (direta ou indiretamente).
 * 
 * Atenção às indicações de navegabilidade e às cardinalidades.
 * 
 * Sua implementação deve permitir a transferência de um funcionário para outro setor.
 * 
 * Crie um testador para suas classes. 
 * 
 */

public class TestadorQ1 {
	public static void main(String[] args) {
		// Criando empresa
		Empresa empresa = new Empresa();

		// Criando departamentos
		Departamento dep1 = new Departamento();
		Departamento dep2 = new Departamento();

		// Criando setores
		Setor setor1 = new Setor();
		Setor setor2 = new Setor();
		Setor setor3 = new Setor();

		// Adicionando setores aos departamentos
		dep1.adicionarSetor(setor1);
		dep1.adicionarSetor(setor2);
		dep2.adicionarSetor(setor3);

		// Criando funcionários
		Funcionario func1 = new Funcionario(3000);
		Funcionario func2 = new Funcionario(3500);
		Funcionario func3 = new Funcionario(4000);

		// Adicionando funcionários aos setores
		setor1.adicionarFuncionario(func1);
		setor2.adicionarFuncionario(func2);
		setor3.adicionarFuncionario(func3);

		// Adicionando departamentos à empresa
		empresa.adicionarDepartamento(dep1);
		empresa.adicionarDepartamento(dep2);

		// Testando cálculo de salário médio
		System.out.println("Salário médio do departamento 1: " + dep1.getSalarioMedio());
		System.out.println("Salário médio do departamento 2: " + dep2.getSalarioMedio());

		// Testando consulta de funcionários
		System.out.println("Funcionários do departamento 1: " + dep1.getFuncionarios().size());
		System.out.println("Funcionários do departamento 2: " + dep2.getFuncionarios().size());

		// Transferência de funcionário
		setor1.removerFuncionario(func1);
		setor3.adicionarFuncionario(func1);

		System.out.println("Funcionários do setor 1 após transferência: " + setor1.getFuncionarios().size());
		System.out.println("Funcionários do setor 3 após transferência: " + setor3.getFuncionarios().size());

		// Testando cálculo de salário médio após transferência
		System.out.println("Salário médio do departamento 1 após transferência: " + dep1.getSalarioMedio());
		System.out.println("Salário médio do departamento 2 após transferência: " + dep2.getSalarioMedio());

		// Imprimindo departamento
		System.out.println(dep1);
	}
}
 
