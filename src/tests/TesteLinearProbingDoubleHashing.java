package tests;

import models.linearProbingDoubleHashing.TabelaHash;

public class TesteLinearProbingDoubleHashing {

	public static void main(String[] args) throws Exception {

		TabelaHash tabela = new TabelaHash(7);

//		tabela.inserir(18);
//		tabela.inserir(41);
//		tabela.inserir(22);
//		tabela.inserir(44);
//		tabela.inserir(59);
//		tabela.inserir(32);
//		tabela.inserir(31);
//		tabela.inserir(73);
//		tabela.inserir(48);
//		tabela.inserir(6);
//		tabela.inserir(13);
//		tabela.inserir(34);
//		tabela.inserir(7);
//		tabela.inserir(49);
//		tabela.inserir(14);
//		tabela.inserir(35);
		tabela.inserir(3);
		tabela.inserir(10);
		tabela.inserir(07);

		System.out.println(tabela);

		tabela.remover(3);

		System.out.println(tabela);

	}

}
