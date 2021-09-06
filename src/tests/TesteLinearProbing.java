package tests;

import models.linearProbing.TabelaHash;

public class TesteLinearProbing {

	public static void main(String[] args) throws Exception {

		TabelaHash tabela = new TabelaHash(3);

//		tabela.inserir(3);
//		tabela.inserir(6);
//		tabela.inserir(12);

//		tabela.inserir(2);
//		tabela.inserir(5);
//		tabela.inserir(8);

		tabela.inserir(4);
		tabela.inserir(7);
		tabela.inserir(10);

		System.out.println(tabela);

		tabela.remover(4);

		System.out.println(tabela);

	}

}
