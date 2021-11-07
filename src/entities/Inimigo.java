package entities;

import enums.TipoClasse;

public class Inimigo extends Personagem {

	private double modificador;

	public Inimigo(String nome, TipoClasse classe, double modificador) {
		super(nome, classe);
		this.modificador = modificador;
		this.setVida((int) (getVida() * modificador));
	}

	public double getModificador() {
		return modificador;
	}

}
