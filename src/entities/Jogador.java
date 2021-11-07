package entities;

import enums.Motivacao;
import enums.Sexo;
import enums.TipoClasse;

public class Jogador extends Personagem {

	private Sexo sexo;
	private Motivacao motivacao;

	public Jogador() {

	}

	public Jogador(String nome, TipoClasse classe, Sexo sexo) {
		super(nome, classe);
		this.sexo = sexo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Motivacao getMotivacao() {
		return motivacao;
	}

	public void setMotivacao(Motivacao motivacao) {
		this.motivacao = motivacao;
	}

}
