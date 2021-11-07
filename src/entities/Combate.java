package entities;

import enums.Dificuldade;

public class Combate {

	private int turno;
	private Jogador j;
	private Inimigo i;
	private Personagem vencedor;
	private Dificuldade dificuldade;

	public Combate(Jogador p1, Inimigo in, Dificuldade dificuldade) {
		this.j = p1;
		this.i = in;
		this.dificuldade = dificuldade;
		this.turno = 1;
	}

	public int getTurno() {
		return turno;
	}

	public Jogador getJ() {
		return j;
	}

	public Inimigo getI() {
		return i;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Personagem getVencedor() {
		return vencedor;
	}

	public boolean ataqueJogador(int dado) {

		int dano;
		if (dado == 1) {
			System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
		}
		if (dado == 20) {
			dano = (int) ((j.obterValorAtaque() + dado) * dificuldade.getModAtaqueJogador());
			i.receberAtaque(dano);
			System.out.println("Você acertou um ataque crítico! Você atacou com a/o " + j.getArma().getNome()
					+ " e causou " + dano + " de dano no inimigo! ");
		}
		if (dado > 1 && dado < 20) {
			dano = (int) ((j.obterValorAtaque() + dado - i.getDefesa()) * dificuldade.getModAtaqueJogador());
			i.receberAtaque(dano);
			System.out.println(
					"Você atacou com a/o " + j.getArma().getNome() + " e causou " + dano + " de dano no inimigo! ");
		}
		turno++;
		return i.getVida() <= 0 ? true : false;
	}

	public boolean ataqueInimigo(int dado) {
		int dano;
		if (dado == 1) {
			System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
		}
		if (dado == 20) {
			dano = (int) ((i.obterValorAtaque() + dado) * dificuldade.getModAtaqueInimigo());
			j.receberAtaque(dano);
			System.out.println("O inimigo acertou um ataque crítico! Você sofreu " + dano + " de dano e agora possui "
					+ j.getVida() + " pontos de vida.");
		}
		if (dado > 1 && dado < 20) {
			dano = (int) ((i.obterValorAtaque() + dado - j.getDefesa()) * dificuldade.getModAtaqueInimigo());
			j.receberAtaque(dano);
			System.out.println("O inimigo atacou! Voce sofreu " + dano + " de dano e agora possui " + j.getVida()
					+ " pontos de vida.");
		}
		turno++;
		return j.getVida() <= 0 ? true : false;
	}

}
