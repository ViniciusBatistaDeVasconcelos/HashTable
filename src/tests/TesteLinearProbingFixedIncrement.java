package tests;

import models.linearProbingFixedIncrement.*;

public class TesteLinearProbingFixedIncrement {

	public static void main(String[] args) throws Exception {

		TabelaHash tabela = new TabelaHash(7, 2);

		tabela.inserir(3);
		tabela.inserir(10);
		tabela.inserir(24);
		tabela.inserir(12);

		System.out.println(tabela);

		tabela.remover(3);
		tabela.remover(10);
		System.out.println(tabela.buscar(12));
		System.out.println(tabela);

	}
}
