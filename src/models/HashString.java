package models;

public class HashString {

	private int tamanho;
	private String type;
	private String[] tabela;

	private models.linearProbing.TabelaHash linearProbing;
	private models.linearProbingBidirectional.TabelaHash linearProbingBidirectional;
	private models.linearProbingDoubleHashing.TabelaHash linearProbingDoubleHashing;
	private models.linearProbingFixedIncrement.TabelaHash linearProbingFixedIncrement;

	public HashString(int tamanho, String type) throws Exception {
		this.tamanho = tamanho;
		this.type = type;
		tabela = new String[tamanho];

		switch (type) {
		case "models.linearProbing": {
			linearProbing = new models.linearProbing.TabelaHash(tamanho);
			break;
		}
		case "models.linearProbingBidirectional": {
			linearProbingBidirectional = new models.linearProbingBidirectional.TabelaHash(tamanho);
			break;
		}
		case "models.linearProbingDoubleHashing": {
			linearProbingDoubleHashing = new models.linearProbingDoubleHashing.TabelaHash(tamanho);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}

	public HashString(int tamanho, String type, int incremento) throws Exception {
		this.tamanho = tamanho;
		this.type = type;
		tabela = new String[tamanho];

		switch (type) {
		case "models.linearProbingFixedIncrement": {
			linearProbingFixedIncrement = new models.linearProbingFixedIncrement.TabelaHash(tamanho, incremento);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}

	public int inserir(String valor) {
		int chave = Chave.getInstancia().gerarCodigoASCII(valor);
		int indice = -1;

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

		switch (type) {
		case "models.linearProbing": {
			indice = linearProbing.inserir(chave);
			break;
		}
		case "models.linearProbingBidirectional": {
			indice = linearProbingBidirectional.inserir(chave);
			break;
		}
		case "models.linearProbingDoubleHashing": {
			indice = linearProbingDoubleHashing.inserir(chave);
			break;
		}
		case "models.linearProbingFixedIncrement": {
			indice = linearProbingFixedIncrement.inserir(chave);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		if (indice != -1 && indice != -2) {
			tabela[indice] = valor;
		}
		return indice;
	}

	public int buscar(String valor) {
		int chave = Chave.getInstancia().gerarCodigoASCII(valor);
		int indice = -1;
		switch (type) {
		case "models.linearProbing": {
			indice = linearProbing.buscar(chave);
			break;
		}
		case "models.linearProbingBidirectional": {
			indice = linearProbingBidirectional.buscar(chave);
			break;
		}
		case "models.linearProbingDoubleHashing": {
			indice = linearProbingDoubleHashing.buscar(chave);
			break;
		}
		case "models.linearProbingFixedIncrement": {
			indice = linearProbingFixedIncrement.buscar(chave);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		return indice;
	}

	public int[] remover(String valor) {
		int chave = Chave.getInstancia().gerarCodigoASCII(valor);
		int[] indices = new int[tamanho];
		switch (type) {
		case "models.linearProbing": {
			indices = linearProbing.remover(chave);
			break;
		}
		case "models.linearProbingBidirectional": {
			indices = linearProbingBidirectional.remover(chave);
			break;
		}
		case "models.linearProbingDoubleHashing": {
			indices = linearProbingDoubleHashing.remover(chave);
			break;
		}
		case "models.linearProbingFixedIncrement": {
			indices = linearProbingFixedIncrement.remover(chave);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

		String[] aux = new String[tamanho];
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (tabela[j] != null) {
					if (indices[i] == Chave.getInstancia().gerarCodigoASCII(tabela[j])) {
						aux[i] = tabela[j];
					}
				}
			}
		}
		tabela = aux;
		return indices;
	}

	@Override
	public String toString() {
		String str = "--------------------------------------------------------------\n";
		str += "MOD\t| indice| ASCII\t\t| Value\n";
		str += "--------------------------------------------------------------\n";

		for (int j = 0; j < tabela.length; j++) {
			if (tabela[j] != null) {
				str += j + "\t| " + Chave.getInstancia().gerarChave(tabela[j], tamanho) + "\t| "
						+ Chave.getInstancia().gerarCodigoASCII(tabela[j]) + "\t\t| " + tabela[j] + "\n";
			} else {
				str += j + "\t| \t| \t\t|\n";
			}
		}
		return str;
	}
}
