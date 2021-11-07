package entities;

import java.util.List;
import java.util.Scanner;

public class Help {
	public static Scanner scan = new Scanner(System.in);

	public static String gerarOpcoes(Enum<?>[] enumOpcoes, String texto) {
		int opcao;
		do {
			System.out.println();
			System.out.println(texto);
			for (Enum<?> enum1 : enumOpcoes) {
				System.out.println(enum1.ordinal() + " - " + enum1);
			}
			opcao = obterOpcao();
			if (opcao < 0 || opcao >= enumOpcoes.length) {
				System.out.println("Opção inválida!");
			}
		} while (opcao < 0 || opcao >= enumOpcoes.length);

		return enumOpcoes[opcao].name();
	}

	public static Object gerarOpcoes(List<?> arrayOpcoes, String texto) {
		int opcao;
		do {
			System.out.println();
			System.out.println(texto);
			for (int i = 0; i < arrayOpcoes.size(); i++) {
				System.out.println(i + " - " + arrayOpcoes.get(i));
			}
			opcao = obterOpcao();
			if (opcao < 0 || opcao >= arrayOpcoes.size()) {
				System.out.println("Opção inválida!");
			}
		} while (opcao < 0 || opcao >= arrayOpcoes.size());
		return arrayOpcoes.get(opcao);
	}

	private static int obterOpcao() {
		System.out.print("Selecione: ");
		int opcao = scan.nextInt();
		scan.nextLine();
		return opcao;
	}

	public static void pularLinha() {
		System.out.println();
		System.out.print("Aperte ENTER para prosseguir...");
		scan.nextLine();
	}

	public static void imprimirNaTela(String titulo, String texto) {
		texto = quebraLinhas(texto, 100);
		System.out.println();
		System.out.println(titulo);
		System.out.println(texto);
		pularLinha();
	}

	public static String quebraLinhas(String textoBruto, int qtdCaracteres) {
		String[] textoEmArray = textoBruto.split("");
		int contador = qtdCaracteres;
		StringBuilder stringFormatada = new StringBuilder();
		for (int i = 0; i <= textoEmArray.length; i++) {
			if (i != 0 && i % qtdCaracteres == 0 && contador >= i) {
				for (int b = i - qtdCaracteres; b < i; b++) {
					stringFormatada.append(textoEmArray[b]);
				}
				stringFormatada.insert(stringFormatada.lastIndexOf(" ") + 1, "\n");
				contador = i + qtdCaracteres;
			}
		}
		int difCaracteres = textoEmArray.length % qtdCaracteres;
		for (int i = difCaracteres; i > 0; i--) {
			stringFormatada.append(textoEmArray[textoEmArray.length - i]);
		}
		return stringFormatada.toString();
	}
}
