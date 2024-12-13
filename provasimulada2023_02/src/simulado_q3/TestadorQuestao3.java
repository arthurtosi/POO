package simulado_q3;

import java.util.Scanner;

/**
 * Questão 3.
 * 
 * Crie as classes que estão faltando, e implemente-as para completar
 * o código abaixo. Atenção: Você não pode alterar o código abaixo!
 * 
 * Assuma que a entrada padrão é usada da seguinte forma:
 * - Na primeira linha, é dado no nome do banco
 * - Na segunda linha, o nome de uma agência 
 * - Na terceira linha, o número de contas a serem criadas (numContas)
 * Nos próximas 2*numContas linhas:
 * - A primeira linha de cada par identifica o nome do cliente para uma conta
 * - A segunda linha de cada par identifica o saldo daquela conta
 *   (com um número em ponto flutuante)
 *
 * A saída deve estar em conformidade com o exemplo abaixo:
 * 
Entrada: ------------------
Banco do Brasil
Jardim da Penha
3
João Paulo Almeida
1000
Barrack Obama
1000000.50
Bob Dylan
900000

Saída: ---------------------
Nome do Banco: Banco do Brasil
Agência: Jardim da Penha, saldo médio: 633666.8333333334
 */

public class TestadorQuestao3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String nomeBanco = scanner.nextLine();
		String nomeAgencia = scanner.nextLine();
	
		Banco banco = new Banco(nomeBanco);
		Agencia agencia = banco.criaAgencia(nomeAgencia);

		int numContas = scanner.nextInt();
		scanner.nextLine(); // Despreza o \n.
		
		String nomeCliente;
		
		for (int i = 0; i < numContas; i++) {
			nomeCliente = scanner.nextLine();
			double saldoInicial = scanner.nextDouble();
			scanner.nextLine(); // Despreza o \n.

			Conta conta = new Conta(nomeCliente, saldoInicial);
			agencia.adicionaConta(conta);
		}

		System.out.println(banco);
		
		scanner.close();
	}

}
