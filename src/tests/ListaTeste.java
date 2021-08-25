package tests;

import models.Lista;
import models.TabelaHashChaining;

public class ListaTeste {

    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);

        System.out.println(lista.getListaValor());
        lista.remover(1);
        lista.remover(5);
        lista.remover(2);
        System.out.println(lista.getListaValor());
        
    }
}
