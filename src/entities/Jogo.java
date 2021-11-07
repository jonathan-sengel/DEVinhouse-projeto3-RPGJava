package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import enums.AcaoPorta;
import enums.Dificuldade;
import enums.Motivacao;
import enums.Porta;
import enums.TipoArma;
import enums.TipoClasse;

public class Jogo {

	private static Scanner scan = new Scanner(System.in);

	private static int jogarDado(int numeroMax) {
		Random r = new Random();
		return r.nextInt(numeroMax) + 1;
	}

	private Dificuldade dificuldade;
	private Motivacao motivacao;
	private AcaoPorta acaoPorta;
	private List<Arma> armasNoJogo = new ArrayList<>();
	private boolean emCombate = false;

	public Jogo() {
		armasNoJogo.add(new Arma("SHORT SWORD", 25, 32, TipoArma.ESPADA));
		armasNoJogo.add(new Arma("SERPENT SWORD", 18, 35, TipoArma.ESPADA));
		armasNoJogo.add(new Arma("SMALL AXE", 15, 34, TipoArma.MACHADO));
		armasNoJogo.add(new Arma("DRAGON LANCE", 21, 30, TipoArma.LANCA));
		armasNoJogo.add(new Arma("ANGELIC STAFF", 27, 40, TipoArma.CETRO));
		armasNoJogo.add(new Arma("LEGENDARY STAFF", 31, 37, TipoArma.CETRO));
		armasNoJogo.add(new Arma("PANTERA CLAWS", 22, 32, TipoArma.BRACELETE));
		armasNoJogo.add(new Arma("ELEVEN BOW", 27, 32, TipoArma.ARCO));
		armasNoJogo.add(new Arma("LIGHT CROSSBOW", 35, 44, TipoArma.ARCO));
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Motivacao getMotivacao() {
		return motivacao;
	}

	public void setMotivacao(Motivacao motivacao) {
		this.motivacao = motivacao;
	}

	public AcaoPorta getAcaoPorta() {
		return acaoPorta;
	}

	public void setAcaoPorta(AcaoPorta acaoPorta) {
		this.acaoPorta = acaoPorta;
	}

	public List<Arma> getArmasNoJogo() {
		return armasNoJogo;
	}

	public boolean isEmCombate() {
		return emCombate;
	}

	public void passarPorta(Personagem jogador) {
		Roteiro.passarPelaPorta(acaoPorta.texto());
		if (acaoPorta.equals(AcaoPorta.ANDANDO)) {
			int danoAleatorio = jogarDado(10);
			jogador.receberAtaque(danoAleatorio);
			System.out.println("\nVocê recebeu " + danoAleatorio + " de dano | Vida: " + jogador.getVida());
		}
	}

	public void entrarEmCombate(Jogador jogador, boolean atacarPrimeiro, Porta porta) throws Exception {

		Combate cb = new Combate(jogador, gerarInimigo(porta), dificuldade);

		boolean mortePlayer = false, morteIni = false;
		do {

			if (atacarPrimeiro) {
				morteIni = cb.ataqueJogador(jogarDado(20));
				if (morteIni) {
					System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés!");
					return;
				}

				mortePlayer = cb.ataqueInimigo(jogarDado(20));
				if (mortePlayer) {
					throw new Exception("Voce não estava preparado para a força do inimigo. "
							+ jogador.getMotivacao().textoDerrota());
				}
			} else {
				mortePlayer = cb.ataqueInimigo(jogarDado(20));
				if (mortePlayer) {
					throw new Exception("Voce não estava preparado para a força do inimigo. "
							+ jogador.getMotivacao().textoDerrota());
				}
				morteIni = cb.ataqueJogador(jogarDado(20));
				if (morteIni) {
					System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés!");
					return;
				}
			}
			System.out.println();
			System.out.println("O que deseja?");
			System.out.println("0 - FUGIR");
			System.out.println("1 - ATACAR");
			System.out.print("Selecione: ");

			int opc = scan.nextInt();
			emCombate = opc == 1 ? true : false;
			if (!emCombate) {
				throw new Exception("Arregou!!! Seu fujão!");
			}
			System.out.println();
		} while (isEmCombate());
	}

	public boolean validarSeAtaca() {
		System.out.println("O que deseja?");
		System.out.println("0 - ESPERAR");
		System.out.println("1 - ATACAR");
		System.out.print("Selecione: ");
		boolean opc = scan.nextInt() == 1 ? true : false;
		System.out.println("\nEntrando em combate...");
		return opc;
	}

	public Inimigo gerarInimigo(Porta porta) {
		Inimigo inimigo;
		if (porta.equals(Porta.DIREITA)) {
			inimigo = new Inimigo("JASON", TipoClasse.CAVALEIRO, 0.30);
			inimigo.setArma(armasNoJogo.get(1));
		} else if (porta.equals(Porta.ESQUERDA)) {
			inimigo = new Inimigo("DUMBLEDOR", TipoClasse.MAGO, 0.35);
			inimigo.setArma(armasNoJogo.get(4));
		} else {
			inimigo = new Inimigo("ALUCARD", TipoClasse.LUTADOR, 0.45);
			inimigo.setArma(armasNoJogo.get(6));
		}
		return inimigo;
	}
}
