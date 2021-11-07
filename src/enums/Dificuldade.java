package enums;

public enum Dificuldade {
	FACIL(1.00, 0.80), NORMAL(1.00, 1.00), DIFICIL(0.90, 1.00);

	private double modAtaqueJogador;
	private double modAtaqueInimigo;

	private Dificuldade(double modAtaqueJogador, double modAtaqueInimigo) {
		this.modAtaqueJogador = modAtaqueJogador;
		this.modAtaqueInimigo = modAtaqueInimigo;
	}

	public double getModAtaqueJogador() {
		return modAtaqueJogador;
	}

	public double getModAtaqueInimigo() {
		return modAtaqueInimigo;
	}

}
