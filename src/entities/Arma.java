package entities;

import java.util.Random;

import enums.TipoArma;

public class Arma {
	private String nome;
	private int ataqueMin;
	private int ataqueMax;
	private TipoArma tipo;

	public Arma() {

	}

	public Arma(String nome, int ataqueMin, int ataqueMax, TipoArma tipo) {
		this.nome = nome;
		this.ataqueMin = ataqueMin;
		this.ataqueMax = ataqueMax;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getAtaqueMin() {
		return ataqueMin;
	}

	public int getAtaqueMax() {
		return ataqueMax;
	}

	public TipoArma getTipo() {
		return tipo;
	}

	public int getValorAtaque() {
		Random r = new Random();
		return r.nextInt((ataqueMax - ataqueMin) + 1) + ataqueMin;
	}

	@Override
	public String toString() {
		return nome + " (" + tipo + ") ";
	}
}
