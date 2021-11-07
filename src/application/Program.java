package application;

import java.util.List;
import java.util.Scanner;

import entities.Arma;
import entities.Help;
import entities.Jogador;
import entities.Jogo;
import entities.Roteiro;
import enums.AcaoPorta;
import enums.Dificuldade;
import enums.Escolha;
import enums.Motivacao;
import enums.Porta;
import enums.Sexo;
import enums.TipoClasse;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Jogo jogo = new Jogo();

		try {
			System.out.println("Bem vindo(a) à BATALHA FINAL!\n");
			System.out.print("Informe seu nome: ");
			String nome = scan.nextLine();

			Sexo sexo = Sexo.valueOf(Help.gerarOpcoes(Sexo.values(), "Selecione o Sexo:"));
			TipoClasse classe = TipoClasse.valueOf(Help.gerarOpcoes(TipoClasse.values(), "Selecione a Classe:"));
			Jogador player1 = new Jogador(nome, classe, sexo);
			List<Arma> armasDisponiveisPlayer1 = player1.verificarArmasDisponives(jogo.getArmasNoJogo());

			Arma arma = (Arma) Help.gerarOpcoes(armasDisponiveisPlayer1, "Selecione a Arma:");
			player1.setArma(arma);
			System.out.println("\nDados do Jogador: \n" + player1);

			Dificuldade dificuldade = Dificuldade
					.valueOf(Help.gerarOpcoes(Dificuldade.values(), "Defina a Dificuldade:"));
			jogo.setDificuldade(dificuldade);

			System.out.println("\nIniciando jogo... \nQuando estiver pronto, aperte ENTER...");
			scan.nextLine();

			Roteiro.ato1();
			Roteiro.ato2();

			Motivacao motivacao = Motivacao.valueOf(Help.gerarOpcoes(Motivacao.values(), "Qual é a sua motivação?"));
			player1.setMotivacao(motivacao);
			Roteiro.ato3(player1.getMotivacao().textoInicial());

			Roteiro.ato4();
			Roteiro.ato5();

			Escolha escolha = Escolha.valueOf(Help.gerarOpcoes(Escolha.values(), "Deseja seguir ou desistir?"));
			if (escolha.equals(Escolha.DESISTIR)) {
				Roteiro.desistir();
				System.out.println();
				throw new Exception("Fim de jogo!");
			}

			Roteiro.continuar();
			Roteiro.porta();
			AcaoPorta acaoPorta = AcaoPorta.valueOf(Help.gerarOpcoes(AcaoPorta.values(), "Como deseja passar pela porta?"));
			jogo.setAcaoPorta(acaoPorta);
			jogo.passarPorta(player1);

			Roteiro.ato6();
			Roteiro.portaDireita(Porta.DIREITA.texto());
			
			jogo.entrarEmCombate(player1, jogo.validarSeAtaca(), Porta.DIREITA);
			Roteiro.derrotaArmeiro();
			System.out.println("Deseja pegar a armadura?");
			System.out.println("0 - NÃO");
			System.out.println("1 - SIM");
			System.out.print("Selecione: ");
			boolean opcao = scan.nextInt() == 1 ? true : false;
			if (opcao) {
				Roteiro.pegarArmadura();
				player1.addDefesa(5);
			} else {
				Roteiro.naoPegarArmadura();
			}
			Roteiro.ato7();
			Roteiro.portaEsquerda(Porta.ESQUERDA.texto());

			jogo.entrarEmCombate(player1, jogo.validarSeAtaca(), Porta.ESQUERDA);

			Roteiro.derrotaAlquimista();
			System.out.println("Deseja beber a poção?");
			System.out.println("0 - NÃO");
			System.out.println("1 - SIM");
			System.out.print("Selecione: ");
			opcao = scan.nextInt() == 1 ? true : false;
			if (opcao) {
				Roteiro.pegarPocao();
				player1.restaurarVida();
			} else {
				Roteiro.naoPegarPocao();
			}

			Roteiro.ato8();
			Roteiro.ato9();

			Roteiro.portaCentral(Porta.CENTRAL.texto());
			jogo.entrarEmCombate(player1, jogo.validarSeAtaca(), Porta.CENTRAL);

			Roteiro.derrotaCapitao(player1.getMotivacao().textoVitoria());
			Roteiro.fechamento();

			System.out.println();
			System.out.println("FIMMMM!!!!!!!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			scan.close();
			System.out.println();
			System.out.println("Jogo encerrado!");

		}
	}

}
