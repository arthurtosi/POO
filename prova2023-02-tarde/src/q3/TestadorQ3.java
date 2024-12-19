package q3;

import java.util.Scanner;
import java.util.Set;


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
import java.util.*;

// Classe Universidade
class Universidade {
	private String nome;
	private Set<Curso> cursos;

	public Universidade(String nome) {
		this.nome = nome;
		this.cursos = new HashSet<>();
	}

	public Curso criaCurso(String nomeCurso) {
		Curso curso = new Curso(nomeCurso);
		cursos.add(curso);
		return curso;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Universidade: ").append(nome).append("\n");
		for (Curso curso : cursos) {
			sb.append(curso).append("\n");
		}
		return sb.toString();
	}
}

// Classe Curso
class Curso {
	private String nome;
	private LinkedHashMap<String, Disciplina> disciplinas;

	public Curso(String nome) {
		this.nome = nome;
		this.disciplinas = new LinkedHashMap<>();
	}

	public Disciplina criaDisciplina(String id, String nomeDisciplina) {
		Disciplina disciplina = new Disciplina(id, nomeDisciplina);
		disciplinas.put(id, disciplina);
		return disciplina;
	}

	public void estabelecePreReq(Disciplina disciplina, String idPreReq) {
		Disciplina preReq = disciplinas.get(idPreReq);
		if (preReq != null) {
			disciplina.adicionarPreRequisito(preReq);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Curso: ").append(nome).append("\nDisciplinas:\n");
		for (Disciplina disciplina : disciplinas.values()) {
			sb.append(disciplina).append("\n");
		}
		return sb.toString();
	}
}

// Classe Disciplina
class Disciplina {
	private String id;
	private String nome;
	private Set<Disciplina> preRequisitos;

	public Disciplina(String id, String nome) {
		this.id = id;
		this.nome = nome;
		this.preRequisitos = new LinkedHashSet<>();
	}

	public void adicionarPreRequisito(Disciplina preRequisito) {
		preRequisitos.add(preRequisito);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		if (preRequisitos.isEmpty()) {
			sb.append(", sem pré-requisitos");
		} else {
			sb.append(", pré-requisitos: ");
			List<String> nomesPreRequisitos = new ArrayList<>();
			for (Disciplina preReq : preRequisitos) {
				nomesPreRequisitos.add(preReq.nome);
			}
			sb.append(String.join(", ", nomesPreRequisitos));
		}
		return sb.toString();
	}
}

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
