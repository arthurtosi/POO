package simulado_q2;

import java.util.Random;

/**
 * Questão 2. Crie uma classe para representar personagens "Pokemón". 
 * 
 * Assuma que cada tipo de Pokemón tem um número específico de "pontos" 
 * de vitalidade, e um par de números de "danos" que ele pode causar
 * em seus oponentes durante um ataque.
 * 
 * Por exemplo, um Blastoise tem 180 pontos de vitalidade e pode causar 30 ou 120
 * pontos de dano.
 * Um Pikachu tem 60 pontos de vitalidade e pode causar 10 ou 50 pontos de dano.
 * Um Charizard tem 120 pontos de vitalidade e sempre causa 0 ou 100 pontos de dano.
 * 
 * Todos os Pokemón devem implementar os métodos da interface PersonagemDeLuta<T> (abaixo).
 * (dica: declare "public class Pokemon implements PersonagemDeLuta<Pokemon>").
 * 
 * O método atacar, deve sortear um número de pontos de 
 * dano dentre aqueles que o pokemon atacante pode causar e subtrair aquele número de 
 * pontos do Pokemón atacado. 
 * Por exemplo, quando um Pikachu ataca um Blastoise, ele pode causar 10 ou 50 pontos
 * de dano, levando o Blastoise a ficar com 170 ou 130 pontos de vitalidade.
 * 
 * Se o Pokemon atacado ficar com 0 pontos de vitalidade, o método atacar retorna true.
 * Caso contrário retorna false.
 * 
 * Todos os Pokemón devem ter um método void regenera(), que reinicializa o número
 * de pontos de vitalidade.
 * 
 * Obs.:
 * 
 * O sorteio de pontos do ataque pode ser feito usando a classe Random e o 
 * método nextBoolean (veja exemplo de uso abaixo).
 * 		// exemplo de uso
 *		Random r = new Random();
 *		r.nextBoolean();  // retorna true ou false aleatoriamente
 * 
 * Não altere este arquivo!
 * 
 */

/**
 * Interface que especifica métodos para classes que implementem personagens de luta 
 * em jogo de batalha.
 * 
 * Um personagem de luta pode atacar outros personagens do tipo especificado. Eles
 * são caracterizados por um número de pontos de vitalidade e podem se regenerar. 
 * 
 * @param T Class que indica com que outro tipo de objeto um personagem pode lutar.
 */
interface PersonagemDeLuta<T> 
{
	public boolean atacar(T personagemAtacado);
	public void regenera();
	public int getPontosVitalidade();
}

/**
 * Não altere a classe abaixo
 *
 */

class Pokemon implements PersonagemDeLuta<Pokemon>
{
	private int pontosVitalidadeAtual;
	private int pontosVitalidade;
	private int dano1;
	private int dano2;

	private boolean nextBoolean ()
	{
		Random r = new Random();
		return r.nextBoolean();
	}
	
	public Pokemon(int pontosVitalidade, int dano1, int dano2)
	{
		this.pontosVitalidade = pontosVitalidade;
		this.pontosVitalidadeAtual = pontosVitalidade;
		this.dano1 = dano1;
		this.dano2 = dano2;
	}
	
	public boolean atacar(Pokemon personagemAtacado)
	{
		int dano;
		if (nextBoolean())
			dano = dano2;
		else
			dano = dano1;
		
		personagemAtacado.pontosVitalidadeAtual -= dano;
		if (personagemAtacado.pontosVitalidadeAtual <= 0)
			return true;
		return false;
	}
	
	public void regenera()
	{
		this.pontosVitalidadeAtual = this.pontosVitalidade;
	}
	
	public int getPontosVitalidade()
	{
		return pontosVitalidadeAtual;
	}
}

/**
 * Não altere a classe abaixo
 *
 */
class Pikachu extends Pokemon
{
	public Pikachu()
	{
		super(60,10,50);
	}	
}

/**
 * Não altere a classe abaixo
 *
 */
class Charizard extends Pokemon
{
	public Charizard()
	{
		super(120,0,100);
	}	
}

/**
 * Não altere a classe abaixo
 *
 */
class Blastoise extends Pokemon
{
	public Blastoise()
	{
		super(180,30,120);
	}	
}

/**
 * Não altere a classe abaixo
 *
 */
public class App {

	public static void main(String[] args) {
		Pikachu p = new Pikachu();
		Blastoise b = new Blastoise();
		System.out.println("Pikachu com "+	p.getPontosVitalidade()+" pontos.");
		System.out.println("Blastoise com "+b.getPontosVitalidade()+" pontos.");
		
		System.out.println("Pikachu ataca Blastoise!");
		p.atacar(b);
		
		System.out.println("Pikachu com "+p.getPontosVitalidade()+" pontos.");
		System.out.println("Blastoise com "+b.getPontosVitalidade()+" pontos.");

		System.out.println("Blastoise regenera!");
		b.regenera();
		System.out.println("Pikachu com "+p.getPontosVitalidade()+" pontos.");
		System.out.println("Blastoise com "+b.getPontosVitalidade()+" pontos.");
	}
}