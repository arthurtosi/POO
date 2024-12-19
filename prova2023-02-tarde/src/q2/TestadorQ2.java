package q2;

import java.util.Random;

/**
 * Questão 2 (3 pontos). 
 * 
 * Crie uma classe para representar um jogo de "Pedra, Papel e Tesoura",
 * implementando a interface abaixo.
 * 
 * O sorteio das jogadas deve ser feito na construção de um objeto representando
 * um lance do jogo (no qual dois jogadores fazem simultaneamente uma jogada) e 
 * pode ser feito usando a classe Random e o método nextInt (veja exemplo de uso abaixo).
 * // exemplo de uso
 * Random r = new Random();
 * int n = r.nextInt(3); // 0, 1 ou 2
 * 
 * Não altere este arquivo!
 * 
 */

enum Jogada {
	PEDRA, PAPEL, TESOURA;
}

/**
 * Não altere essa interface.
 */
interface JogoPedraPapelTesoura {
	/**
	 * Indica se houve vencedor.
	 * 
	 * @return retorna true se há vencedor e false se houve empate
	 */
	public boolean haVencedor();

	/**
	 * Retorna a jogada do primeiro jogador.
	 * 
	 * @return jogada escolhida aleatoriamente na construção do objeto
	 */
	public Jogada jogadaJogador1();

	/**
	 * Retorna a jogada do segundo jogador.
	 * 
	 * @return jogada escolhida aleatoriamente na construção do objeto
	 */
	public Jogada jogadaJogador2();

	/**
	 * 
	 * @return 1 ou 2 dependendo do jogador vitorioso.
	 */
	public int getJogadorVencedor();
}

class JogoPedraPapelTesouraImpl implements JogoPedraPapelTesoura {
	private Jogada jogadaJogador1;
	private Jogada jogadaJogador2;
	private int jogadorVencedor;

	public JogoPedraPapelTesouraImpl() {
		Random r = new Random();
 		int n = r.nextInt(3);
		jogadaJogador1 = Jogada.values()[n];
		r = new Random();
		n = r.nextInt(3);
		jogadaJogador2 = Jogada.values()[n];
		if (jogadaJogador1 == jogadaJogador2) {
			jogadorVencedor = 0;
		} else if (jogadaJogador1 == Jogada.PEDRA && jogadaJogador2 == Jogada.TESOURA
				|| jogadaJogador1 == Jogada.PAPEL && jogadaJogador2 == Jogada.PEDRA
				|| jogadaJogador1 == Jogada.TESOURA && jogadaJogador2 == Jogada.PAPEL) {
			jogadorVencedor = 1;
		} else {
			jogadorVencedor = 2;
		}
	}

	@Override
	public boolean haVencedor() {
		return jogadorVencedor != 0;
	}

	@Override
	public Jogada jogadaJogador1() {
		return jogadaJogador1;
	}

	@Override
	public Jogada jogadaJogador2() {
		return jogadaJogador2;
	}

	@Override
	public int getJogadorVencedor() {
		return jogadorVencedor;
	}
}

/**
 * Não altere a classe abaixo
 *
 */
public class TestadorQ2 {

	public static void main(String[] args) {

		JogoPedraPapelTesoura j;
		do {
			j = new JogoPedraPapelTesouraImpl();	// cada instância representa uma "rodada"
			if (j.haVencedor()) {
				if (j.getJogadorVencedor() == 1) {
					System.out.println("O primeiro jogador venceu com " + j.jogadaJogador1() +
							" contra " + j.jogadaJogador2());
				} else {
					System.out.println("O segundo jogador venceu com " + j.jogadaJogador2() +
							" contra " + j.jogadaJogador1());
				}
			} else
				System.out.println("Empate " + j.jogadaJogador1() + " contra " + j.jogadaJogador2());
		} while (!j.haVencedor());
	}

}
