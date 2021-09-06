package models.linearProbing;

import models.Chave;
import models.Primo;

public class TabelaHash {

	private int tamanho;
	private int qtdDisponivel;
	private int[][] tabela;

	public TabelaHash(int tamanho) throws Exception {
		if (!Primo.get().verificar(tamanho)) {
			throw new Exception("O tamanho precisa ser um número primo");
		}
		this.tamanho = tamanho;
		this.qtdDisponivel = tamanho;
		this.tabela = new int[tamanho][2];
	}

	public int inserir(int valor) {

		if (qtdDisponivel == 0) {
			System.out.println("Tabela cheia! " + valor + " não foi inserido.");
			return -1;
		}
		if (buscar(valor) != -1) {
			System.out.println(valor + " já inserido!");
			return -2;
		}

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;

		System.out.println("h(" + valor + ") = " + valor + " % " + tamanho + " = " + indice);

		int i = indice;
		do {
			if (tabela[i][0] == 0) {

				tabela[i][0] = valor;
				tabela[i][1] = indice;
				qtdDisponivel--;
				break;
			}

			if (i == tabela.length - 1 && tabela[i][0] != 0) {
				i = 0;
				pesquisa = indice;
			} else {
				i++;
			}
		} while (i < pesquisa);
		return i;
	}

	public int buscar(int valor) {
		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;

		int i = indice;
		do {
			if (tabela[i][0] == valor) {
				return i;
			}

			if (i == tabela.length - 1 && tabela[i][0] != 0) {
				i = 0;
				pesquisa = indice;
			} else {
				i++;
			}
		} while (i < pesquisa);

		return -1;
	}

	public int[] remover(int valor) {

		int posicaoValor = buscar(valor);
		if (posicaoValor == -1) {
			System.out.println(valor + " não foi encontrado!");
			return new int[0];
		}

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;
		int anterior = indice;
		boolean liberado = false;
		int i = indice;
		do {

			if (tabela[i][0] == valor && tabela[i][1] == indice) {
				anterior = i;
				liberado = true;
			}
			if (liberado && tabela[i][0] != 0 && tabela[i][1] == indice) {

				tabela[anterior][0] = tabela[i][0];
				tabela[anterior][1] = tabela[i][1];
				anterior = i;
			}

			if (i == tabela.length - 1) {
				i = 0;
				pesquisa = indice;
			} else {
				i++;
			}
		} while (i < pesquisa);

		tabela[anterior][0] = 0;
		tabela[anterior][1] = 0;
		
		qtdDisponivel++;
		
		pesquisa = tabela.length;
		int k = indice;
		do {
			if (k != tabela[k][1] && 0 != tabela[k][0] && tabela[tabela[k][1]][0] == 0) {
				tabela[tabela[k][1]][0] = tabela[k][0];
				tabela[tabela[k][1]][1] = tabela[k][1];
				tabela[k][0] = 0;
				tabela[k][1] = 0;
			}

			if (k == tabela.length - 1 && tabela[k][0] != 0) {
				k = 0;
				pesquisa = indice;
			} else {
				k++;
			}
		} while (k < pesquisa);

		int[] indices = new int[tamanho];
		for (int l = 0; l < tamanho; l++) {
			indices[l] = tabela[l][0];
		}
		return indices;
	}

	@Override
	public String toString() {

		String str = "--------------------------\n";
		str += "mod\t| value\t| indice\n";
		str += "--------------------------\n";

		for (int j = 0; j < tabela.length; j++) {
			if (tabela[j][0] != 0) {
				str += j + "\t| " + tabela[j][0] + "\t| " + tabela[j][1] + "\n";
			} else {
				str += j + "\t| \t| \n";
			}
		}
		return str;
	}
}
