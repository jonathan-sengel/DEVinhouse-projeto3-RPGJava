package enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoClasse {
	CAVALEIRO(28, 25, 20, 300), MAGO(18, 15, 18, 420), FADA(22, 20, 25, 380), LUTADOR(23, 25, 23, 280);

	private int forcaBase;
	private int vitalidadeBase;
	private int agilidadeBase;
	private int vidaBase;

	TipoClasse(int forca, int vitalidade, int agilidade, int vida) {
		this.forcaBase = forca;
		this.vitalidadeBase = vitalidade;
		this.agilidadeBase = agilidade;
		this.vidaBase = vida;
	}

	public int getForcaBase() {
		return forcaBase;
	}

	public int getVitalidadeBase() {
		return vitalidadeBase;
	}

	public int getAgilidadeBase() {
		return agilidadeBase;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public int defesaBase() {
		return vitalidadeBase + agilidadeBase;
	}

	public List<TipoArma> tiposDeArmasDisponiveis() {
		List<TipoArma> tipos = new ArrayList<>();
		switch (this) {
		case CAVALEIRO:
			tipos.add(TipoArma.ESPADA);
			tipos.add(TipoArma.MACHADO);
			tipos.add(TipoArma.LANCA);
			break;
		case MAGO:
			tipos.add(TipoArma.CETRO);
			break;
		case FADA:
			tipos.add(TipoArma.ARCO);
			break;
		case LUTADOR:
			tipos.add(TipoArma.MACHADO);
			tipos.add(TipoArma.BRACELETE);
			break;
		default:
			break;
		}
		return tipos;
	}

	@Override
	public String toString() {
		return name() + " -> " + "Força: " + forcaBase + " | Defesa: " + defesaBase() + " | Vida: " + vidaBase;
	}
}
