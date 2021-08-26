package tests;

import models.linearProbing.TabelaHashLinearProbingString;

public class TabelaHashLinearProbingStringTeste {

	public static void main(String[] args) {

		TabelaHashLinearProbingString tabela = new TabelaHashLinearProbingString(10);
		
		tabela.inserir("mario");
		tabela.inserir("claudio");
		tabela.inserir("antonio");
		tabela.inserir("maria");
		tabela.inserir("ana");
		tabela.inserir("joão");
		tabela.inserir("vinicius");
		tabela.inserir("vinicius");
		tabela.inserir("antonio");
		
		
		System.out.println(tabela);
		
		tabela.remover("claudio");
		
		System.out.println(tabela);
	}
}
