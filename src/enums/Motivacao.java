package enums;

public enum Motivacao {
	VINGANCA, GLORIA;

	public String textoInicial() {
		switch (this) {
		case VINGANCA:
			return "Imagens daquela noite tr�gica invadem sua mente. Voc� nem precisa se esfor�ar para lembrar, pois essas mem�rias est�o sempre presentes, mesmo que de pano de fundo, quando voc� tem outros pensamentos em foco, elas nunca o deixaram. Elas s�o o combust�vel que te fizeram chegar at� aqui. E voc� sabe que n�o ir� desistir at� ter vingado a morte daqueles que foram - e pra sempre ser�o - sua fonte de amor e desejo de continuar vivo. O maldito l�der finalmente pagar� por tanto mal causado na vida de tantos (e principalmente na sua).";
		case GLORIA:
			return "Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os abertos, bardos criando can��es sobre seus feitos her�icos, nobres te presenteando com j�ias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilan�as. Desde j�, voc� sente o amor do p�blico, te louvando a cada passo que d� pelas ruas, depois de destruir o vil�o que tanto assombrou a paz de todos. Por�m, voc� sabe que ainda falta o �ltimo ato dessa hist�ria. Voc� se concentra na miss�o. A gl�ria o aguarda, mas n�o antes da �ltima batalha.";
		default:
			return "";
		}
	}

	public String textoDerrota() {
		switch (this) {
		case VINGANCA:
			return "N�o foi poss�vel concluir sua vingan�a, e agora resta saber \n" + "se algu�m se vingar� por voc�.";
		case GLORIA:
			return "A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por \n" + "seu(sua) pr�ximo(a) her�i(na).";
		default:
			return "";
		}
	}

	public String textoVitoria() {
		switch (this) {
		case VINGANCA:
			return "Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.";
		case GLORIA:
			return "O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou.";
		default:
			return "";
		}
	}
}
