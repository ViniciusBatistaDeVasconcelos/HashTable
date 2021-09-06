package models.chaining;

import models.Chave;
import models.Primo;

public class TabelaHashChaining {

	private int tamanho;
	private Lista[] tabela;

	public TabelaHashChaining(int tamanho) throws Exception {
		if (!Primo.get().verificar(tamanho)) {
			throw new Exception("O tamanho precisa ser um número primo");
		}
		this.tamanho = tamanho;
		tabela = new Lista[tamanho];

		for (int i = 0; i < tamanho; i++) {
			tabela[i] = new Lista();
		}
	}

	public void inserir(int valor) {
		if (buscar(valor) != -1) {
			System.out.println(valor + " já inserido!");
			return;
		}

		System.out.println("Valor: " + valor + "\t\t" + valor + " % " + tamanho + " = "
				+ Chave.getInstancia().gerarChave(valor, tamanho));
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].inserir(valor);
	}

	public int buscar(int valor) {
		return tabela[Chave.getInstancia().gerarChave(valor, tamanho)].buscar(valor);
	}

	public void remover(int valor) {
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].remover(valor);
	}

	public void inserir(String valor) {

		if (buscar(valor) != -1) {
			System.out.println(valor + " já inserido!");
			return;
		}

		System.out.print("Valor: " + valor + "\t\tASCII => ");
		char[] caracteres = new char[valor.length()];
		int valorNumerico = 0;
		for (int i = 0; i < valor.length(); i++) {
			caracteres[i] = valor.charAt(i);
			valorNumerico += i * (int) caracteres[i];
			if (i == valor.length() - 1) {
				System.out.print("(" + i + " * " + (int) caracteres[i] + ") ");
			} else {
				System.out.print("(" + i + " * " + (int) caracteres[i] + ") + ");
			}
		}
		System.out.println(" = " + valorNumerico);
		System.out.println(
				">>> " + valorNumerico + " % " + tamanho + " = " + Chave.getInstancia().gerarChave(valor, tamanho));

		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].inserir(valor);
	}

	public int buscar(String valor) {
		return tabela[Chave.getInstancia().gerarChave(valor, tamanho)].buscar(valor);
	}

	public void remover(String valor) {
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].remover(valor);
	}

	public String getTabelaValor() {
		String strTabela = "\nTamanho: " + tamanho + "\n";

		for (int i = 0; i < tabela.length; i++) {
			strTabela += "| " + i + "\t| " + tabela[i].getListaValor() + "\n";
		}
		return strTabela;
	}

	public String getTabelaString() {
		String strTabela = "\nTamanho: " + tamanho + "\n";

		for (int i = 0; i < tabela.length; i++) {
			strTabela += "| " + i + "\t| " + tabela[i].getListaStr() + "\n";
		}
		return strTabela;
	}
}
