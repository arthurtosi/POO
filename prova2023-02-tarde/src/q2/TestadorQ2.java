package q2;

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
