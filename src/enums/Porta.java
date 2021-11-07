package enums;

public enum Porta {
	ESQUERDA, DIREITA, CENTRAL;

	public String texto() {
		switch (this) {
		case DIREITA:
			return "Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala espa�osa, com v�rios equipamentos de batalha pendurados nas paredes e dispostos em arm�rios e mesas. Voc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o.\r\n"
					+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s. Ali, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, est� um dos capit�es do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posi��o de combate. Ele avan�a em sua dire��o.";
		case ESQUERDA:
			return "Voc� retorna � sala anterior e se dirige � porta da esquerda. Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem v�rios potes e garrafas de vidro com conte�dos misteriosos e de cores diversas, e voc� entende que o capit�o que vive ali, realiza experimentos com diversos ingredientes, criando po��es utilizadas pelos soldados para aterrorizar a regi�o.\r\n"
					+ "No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo. Um orque horrendo, de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.";
		case CENTRAL:
			return "L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados �s paredes.\r\n"
					+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.";
		default:
			return "";
		}
	}
}
