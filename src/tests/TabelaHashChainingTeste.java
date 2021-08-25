package tests;

import models.TabelaHashChaining;

public class TabelaHashChainingTeste {

    public static void main(String[] args) {
        TabelaHashChaining tabela = new TabelaHashChaining(7);

        tabela.inserir(2);
        tabela.inserir(6);
        tabela.inserir(13);
        tabela.inserir(12);
        tabela.inserir(7);
        tabela.inserir(56);
        tabela.inserir(89);
        tabela.inserir(76);
        tabela.inserir(14);
        tabela.inserir(736);
        tabela.inserir(37);
        System.out.println(tabela.getTabelaValor());
        
        
        TabelaHashChaining tabela1 = new TabelaHashChaining(13);

        tabela1.inserir("mario");
        tabela1.inserir("claudio");
        tabela1.inserir("antonio");
        tabela1.inserir("maria");
        tabela1.inserir("ana");
        tabela1.inserir("joão");
        tabela1.inserir("vinicius");
        
        System.out.println(tabela1.getTabelaString());
    }
}
