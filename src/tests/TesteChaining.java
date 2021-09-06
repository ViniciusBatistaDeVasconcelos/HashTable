package tests;

import models.chaining.TabelaHashChaining;

public class TesteChaining {

	public static void main(String[] args) throws Exception {
		TabelaHashChaining tabela = new TabelaHashChaining(7);

		tabela.inserir(2);
		tabela.inserir(6);
		tabela.inserir(13);
		tabela.inserir(13);
		tabela.inserir(12);
		tabela.inserir(7);
		tabela.inserir(56);
		tabela.inserir(89);
		tabela.inserir(76);
		tabela.inserir(76);
		tabela.inserir(14);
		tabela.inserir(736);
		tabela.inserir(37);
		System.out.println(tabela.getTabelaValor());

		TabelaHashChaining tabela1 = new TabelaHashChaining(13);

		tabela1.inserir("Mario");
		tabela1.inserir("Mario");
		tabela1.inserir("Claudio");
		tabela1.inserir("Antonio");
		tabela1.inserir("Maria");
		tabela1.inserir("Ana");
		tabela1.inserir("João");
		tabela1.inserir("Vinicius");
		tabela1.inserir("Vinicius");

		System.out.println(tabela1.buscar("to") != -1 ? "Encontrado" : "Não encontrado");
		System.out.println(tabela1.getTabelaString());
		tabela1.remover("João");
		System.out.println(tabela1.getTabelaString());

	}
}
