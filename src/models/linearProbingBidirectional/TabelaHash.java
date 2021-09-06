package models.linearProbingBidirectional;

import models.Chave;
import models.Primo;

public class TabelaHash {

	private int tamanho;
	private int qtdDisponivel;
	private int[][] tabela;
	private int incremento;

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
		incremento = 0;
		int i = indice;
		boolean direcao = true;

		System.out.println("h(" + valor + ") = " + valor + " % " + tamanho + " = " + indice);

		do {
			if (tabela[i][0] == 0) {
				tabela[i][0] = valor;
				tabela[i][1] = indice;
				qtdDisponivel--;
				break;
			}
			incremento++;
			if (indice == 0) {
				i = indice + incremento;
				direcao = true;
			} else if (direcao && tabela[tabela.length - 1][0] != 0) {
				direcao = false;
				incremento--;
			} else if (direcao && indice + incremento <= tabela.length - 1) {
				i = indice + incremento;
				direcao = false;
				incremento--;
			} else if (!direcao && indice - incremento >= 0) {
				i = indice - incremento;
				direcao = true;
			}
		} while (incremento < tabela.length);
		return i;
	}

	public int buscar(int valor) {

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		incremento = 0;
		int i = indice;
		boolean direcao = true;

		do {
			if (tabela[i][0] == valor) {
				return i;
			}
			incremento++;
			if (indice == 0) {
				i = indice + incremento;
				direcao = true;
			} else if (direcao && tabela[tabela.length - 1][0] != 0) {
				direcao = false;
				incremento--;
			} else if (direcao && indice + incremento <= tabela.length - 1) {
				i = indice + incremento;
				direcao = false;
				incremento--;
			} else if (!direcao && indice - incremento >= 0) {
				i = indice - incremento;
				direcao = true;
			}
		} while (incremento < tabela.length);
		return -1;
	}

	public int[] remover(int valor) {

		int posicaoValor = buscar(valor);
		if (posicaoValor == -1) {
			System.out.println(valor + " não foi encontrado!");
			return new int[0];
		}

		int indice = Chave.getInstancia().gerarChave(valor, tamanho);
		incremento = 0;
		int i = indice;
		int anterior = indice;
		boolean direcao = true;
		boolean liberado = false;
		int qtdIndicesIguais = 0;
		do {
			if (tabela[i][0] == valor && tabela[i][1] == indice) {
				anterior = i;
				liberado = true;
			}
			if (liberado && tabela[i][1] == indice) {
				tabela[anterior][0] = tabela[i][0];
				tabela[anterior][1] = tabela[i][1];
				anterior = i;
			}
			if (tabela[i][1] == indice) {
				qtdIndicesIguais++;
			}

			incremento++;
			if (indice == 0) {
				i = indice + incremento;
				direcao = true;
			} else if (direcao && tabela[tabela.length - 1][0] != 0) {
				direcao = false;
				incremento--;
			} else if (direcao && indice + incremento <= tabela.length - 1) {
				i = indice + incremento;
				direcao = false;
				incremento--;
			} else if (!direcao && indice - incremento >= 0) {
				i = indice - incremento;
				direcao = true;
			}
		} while (incremento < tabela.length);
		if (qtdIndicesIguais == 1) {
			tabela[indice][0] = 0;
			tabela[indice][1] = 0;
		}
		tabela[anterior][0] = 0;
		tabela[anterior][1] = 0;
		
		qtdDisponivel++;
		
		incremento = 0;
		i = indice;
		direcao = true;
		do {
			if (tabela[i][1] == anterior) {
				tabela[anterior][0] = tabela[i][0];
				tabela[anterior][1] = tabela[i][1];
				tabela[i][0] = 0;
				tabela[i][1] = 0;
				break;
			}
			incremento++;
			if (direcao && indice + incremento <= tabela.length - 1) {
				i = indice + incremento;
				direcao = false;
				incremento--;
			} else if (!direcao && indice - incremento >= 0) {
				i = indice - incremento;
				direcao = true;
			}
		} while (incremento < tabela.length);

		int[] indices = new int[tamanho];
		for (int j = 0; j < tamanho; j++) {
			indices[j] = tabela[j][0];
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
