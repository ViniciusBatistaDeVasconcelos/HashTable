package models.linearProbing;

import models.Chave;

public class TabelaHashLinearProbing {

	private int tamanho;
	private int qtdDisponivel;
	private int[][] tabela;

	public TabelaHashLinearProbing(int tamanho) {
		this.tamanho = tamanho;
		this.qtdDisponivel = tamanho;
		this.tabela = new int[tamanho][2];
	}

	public void inserir(int valor) {

		if (buscar(valor)) {
			System.out.println(valor + " já inserido!");
			return;
		}
		if (qtdDisponivel == 0) {
			System.out.println("Tabela cheia! " + valor + " não foi inserido.");
			return;
		}

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;

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
	}

	public boolean buscar(int valor) {
		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;

		int i = indice;
		do {
			if (tabela[i][0] == valor) {
				return true;
			}

			if (i == tabela.length - 1 && tabela[i][0] != 0) {
				i = 0;
				pesquisa = indice;
			} else {
				i++;
			}
		} while (i < pesquisa);

		return false;
	}

	public void remover(int valor) {
		if (!buscar(valor)) {
			System.out.println(valor + " não foi encontrado!");
			return;
		}

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		int pesquisa = tabela.length;

		/* passo 1 - identificar a posiÃ§Ã£o do valor na tabela */
		int posicaoValor = 0;
		int j = indice;
		do {
			if (tabela[j][0] == valor) {
				posicaoValor = j;
			}

			if (j == tabela.length - 1 && tabela[j][0] != 0) {
				j = 0;
				pesquisa = indice;
			} else {
				j++;
			}
		} while (j < pesquisa);

		/* passo 2 - excluir elemento e reorganizar os elementos com mesmo indice */
		pesquisa = tabela.length;

		int anterior = posicaoValor;

		int i = posicaoValor == tabela.length - 1 && tabela[posicaoValor][1] != indice ? 0 : posicaoValor;
		do {
			if (tabela[i][0] != 0 && tabela[i][1] == indice) {

				tabela[anterior][0] = tabela[i][0];
				tabela[anterior][1] = tabela[i][1];
				tabela[i][0] = 0;
				tabela[i][1] = 0;
				anterior = i;
			}
			if (i == tabela.length - 1 && tabela[i][0] != 0) {
				i = 0;
				pesquisa = indice;
			} else {
				i++;
			}
		} while (i < pesquisa);

		/*
		 * passo 3 - verificar se tem algum outro elemento fora da sua posiÃ§Ã£o
		 * original
		 */

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
	}

	@Override
	public String toString() {
		String str = "mod\t| value\t| indice\n";

		for (int j = 0; j < tabela.length; j++) {
			str += j + "\t| " + tabela[j][0] + "\t| " + tabela[j][1] + "\n";
		}
		return str;
	}
}
