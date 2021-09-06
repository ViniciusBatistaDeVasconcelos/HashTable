package tests;

import models.linearProbingBidirectional.TabelaHash;

public class TesteLinearProbingBidirectional {

	public static void main(String[] args) throws Exception {

		models.linearProbingBidirectional.TabelaHash tabela = new TabelaHash(13);

		tabela.inserir(3);
		tabela.inserir(10);
		tabela.inserir(17);
		tabela.inserir(24);
		tabela.inserir(31);
		tabela.inserir(2);
		tabela.inserir(38);
		tabela.inserir(4);
		tabela.inserir(5);
		tabela.inserir(6);
		tabela.inserir(7);
		tabela.buscar(3);

		System.out.println(tabela);
		tabela.remover(17);
		tabela.remover(31);
		System.out.println(tabela);
		/*
		 * tabela.remover(24); System.out.println(tabela); tabela.remover(17);
		 * System.out.println(tabela);
		 * 
		 * System.out.println(Chave.getInstancia().potencia(5, 3));
		 */

	}

}
