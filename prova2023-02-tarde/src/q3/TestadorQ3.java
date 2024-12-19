package q3;

import java.util.Scanner;

/**
 * Questão 3 (3 pontos).
 * 
 * Crie as classes que estão faltando, e implemente-as para completar
 * o código abaixo. Atenção: Você não pode alterar o código abaixo!
 * 
 * Assuma que a entrada padrão é usada da seguinte forma:
 * - Na primeira linha, é dado no nome da universidade
 * - Na segunda linha, o nome de um curso
 * - Na terceira linha, o número de disciplinas a serem criadas
 * Nos próximas 3*numContas linhas:
 * - A primeira linha de cada par identifica o nome da disciplina
 * - A segunda linha de cada par identifica o identificador da disciplina
 * - A terceira linha identifica os identificadores das disciplinas que são pré-requisitos
 *
 * A saída deve estar em conformidade com o exemplo abaixo:
 * (Dica: use LinkedHashMap para guardar as disciplinas em Curso para que as 
 * disciplinas sejam armazenadas na ordem entrada. Se você usar HashMap, não 
 * há garantia da saída ficar em ordem.)
 * 
Exemplo de entrada: ------------------
UFES
Engenharia de Computação
5
Programação I
INF1001
Pré-requisitos: N/A
Programação II
INF2002
Pré-requisitos: INF1001
Sistemas Operacionais
INF5500
Pré-requisitos: N/A
Redes de Computadores
INF4400
Pré-requisitos: N/A
Processamento Paralelo e Distribuído
INF3123
Pré-requisitos: INF4400, INF5500

Saída correspondente: ---------------------
Universidade: UFES
Curso: Engenharia de Computação
Disciplinas:
Programação I, sem pré-requisitos
Programação II, pré-requisitos: Programação I
Sistemas Operacionais, sem pré-requisitos
Redes de Computadores, sem pré-requisitos
Processamento Paralelo e Distribuído, pré-requisitos: Redes de Computadores, Sistemas Operacionais

 */

public class TestadorQ3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String nomeUniversidade = scanner.nextLine();
		String nomeCurso = scanner.nextLine();
	
		Universidade univ = new Universidade(nomeUniversidade);
		Curso curso = univ.criaCurso(nomeCurso);

		int nDisciplinas = scanner.nextInt();
		scanner.nextLine(); // Despreza o \n.
		
		String idDisciplina, nomeDisciplina;
		
		for (int i = 0; i < nDisciplinas; i++) {
			nomeDisciplina = scanner.nextLine();
			idDisciplina = scanner.nextLine();

			Disciplina disciplina = curso.criaDisciplina(idDisciplina, nomeDisciplina);
			
			Scanner preScanner = new Scanner(scanner.nextLine());
			preScanner.next();
			preScanner.useDelimiter(",");

			while(preScanner.hasNext())
			{
				String idPre = preScanner.next();
				if (!idPre.trim().equals("N/A"))
					curso.estabelecePreReq(disciplina, idPre.trim());
			}
			preScanner.close();
		}

		System.out.println(univ);
		
		scanner.close();
	}

}
