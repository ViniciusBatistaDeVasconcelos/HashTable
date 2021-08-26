package models;

public class TabelaHashChaining {

	private int tamanho;
	private Lista[] tabela;

	public TabelaHashChaining(int tamanho) {
		this.tamanho = tamanho;
		tabela = new Lista[tamanho];

		for (int i = 0; i < tamanho; i++) {
			tabela[i] = new Lista();
		}
	}

	public void inserir(int valor) {
		System.out.println("Valor: " + valor + "\t\t" + valor + " % " + tamanho + " = "
				+ Chave.getInstancia().gerarChave(valor, tamanho));
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].inserir(valor);
	}

	public void buscar(int valor) {
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].buscar(valor);
	}

	public void remover(int valor) {
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].remover(valor);
	}

	public void inserir(String valor) {

		System.out.print("Valor: " + valor + "\t\tASCII => ");
		char[] caracteres = new char[valor.length()];
		int valorNumerico = 0;
		for (int i = 0; i < valor.length(); i++) {
			caracteres[i] = valor.charAt(i);
			valorNumerico += (int) caracteres[i];
			if (i == valor.length() - 1) {
				System.out.print((int) caracteres[i] + " ");
			} else {
				System.out.print((int) caracteres[i] + " + ");
			}
		}
		System.out.println(" = " + valorNumerico);
		System.out.println(
				">>> " + valorNumerico + " % " + tamanho + " = " + Chave.getInstancia().gerarChave(valor, tamanho));

		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].inserir(valor);
	}

	public void buscar(String valor) {
		tabela[Chave.getInstancia().gerarChave(valor, tamanho)].buscar(valor);
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
