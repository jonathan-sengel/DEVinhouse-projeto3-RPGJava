package entities;

import java.util.ArrayList;
import java.util.List;

import enums.TipoArma;
import enums.TipoClasse;

public abstract class Personagem {
	private Arma arma;
	private String nome;
	private TipoClasse classe;

	private int forca;
	private int vitalidade;
	private int agilidade;
	private int vida;
	private int defesa;

	public Personagem() {

	}

	public Personagem(String nome, TipoClasse classe) {
		this.nome = nome;
		this.classe = classe;
		this.forca = classe.getForcaBase();
		this.vitalidade = classe.getVitalidadeBase();
		this.agilidade = classe.getAgilidadeBase();
		this.vida = classe.getVidaBase();
		this.defesa = classe.defesaBase();
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public String getNome() {
		return nome;
	}

	public TipoClasse getClasse() {
		return classe;
	}

	public int getForca() {
		return forca;
	}

	public int getVitalidade() {
		return vitalidade;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefesa() {
		return defesa;
	}

	public int obterValorAtaque() {
		int valorAtaque = arma.getValorAtaque() + forca;
		return valorAtaque;
	}

	public void receberAtaque(int dano) {
		vida -= dano;
	}

	public void addDefesa(int defesa) {
		this.defesa += defesa;
	}

	public void restaurarVida() {
		this.vida = classe.getVidaBase();
	}

	public List<Arma> verificarArmasDisponives(List<Arma> armasDoJogo) {
		List<Arma> listadeArmas = new ArrayList<>();

		armasDoJogo.forEach(arma -> {
			for (TipoArma tp : getClasse().tiposDeArmasDisponiveis()) {
				if (arma.getTipo() == tp) {
					listadeArmas.add(arma);
				}
			}
		});
		return listadeArmas;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nClasse: " + classe + "\nArma: " + arma;
	}

}
