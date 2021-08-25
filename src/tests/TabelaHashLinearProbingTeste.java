package tests;

import models.TabelaHashLinearProbing;

public class TabelaHashLinearProbingTeste {

    public static void main(String[] args) {

        TabelaHashLinearProbing tabela = new TabelaHashLinearProbing(13);

        tabela.inserir(15);
        /*tabela.inserir(2);
        tabela.inserir(3);
        tabela.inserir(4);
        tabela.inserir(5);
        tabela.inserir(6);
        tabela.inserir(7);*/

        //int e = 15;
        //System.out.println(tabela.buscar(e) ? e + " encontrado." : e + " não encontrado.");
        
        System.out.println(tabela);
        
        tabela.remover(15);
        
        System.out.println(tabela);

    }

}
