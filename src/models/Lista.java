package models;

public class Lista {

    private No inicio;
    private int tamanho;

    public void inserir(int valor) {
        No no = new No();
        no.setValor(valor);
        no.setProximo(inicio);
        inicio = no;
        tamanho++;
    }

    public void inserir(String str) {
        No no = new No();
        no.setStr(str);
        no.setProximo(inicio);
        inicio = no;
        tamanho++;
    }

    public int buscar(int valor) {
        No no = inicio;
        while (no != null) {
            if (no.getValor() == valor) {
                return no.getValor();
            }
            no = no.getProximo();
        }
        return -1;
    }

    public int buscar(String valor) {
        No no = inicio;
        while (no != null) {
            if (no.getStr().equals(valor)) {
                return no.getValor();
            }
            no = no.getProximo();
        }
        return -1;
    }

    public void remover(int valor) {

        if (valor == inicio.getValor()) {
            inicio = inicio.getProximo();
        } else {
            No no = inicio.getProximo();
            No anterior = inicio;

            while (no != null) {
                if (valor == no.getValor()) {
                    anterior.setProximo(no.getProximo());
                }
                anterior = no;
                no = no.getProximo();
            }
        }
        tamanho--;
    }

    public void remover(String valor) {

        if (valor.equals(inicio.getStr())) {
            inicio = inicio.getProximo();
        } else {
            No no = inicio.getProximo();
            No anterior = inicio;

            while (no != null) {
                if (valor.equals(no.getStr())) {
                    anterior.setProximo(no.getProximo());
                }
                anterior = no;
                no = no.getProximo();
            }
        }
        tamanho--;
    }

    public String getListaValor() {
        String strLista = "";
        No no = inicio;

        int i = 0;
        while (no != null) {
            if (i == tamanho - 1) {
                strLista += no.getValor();
            } else {
                strLista += no.getValor() + ", ";
            }

            no = no.getProximo();
            i++;
        }
        return strLista;
    }

    public String getListaStr() {
        String strLista = "";
        No no = inicio;

        int i = 0;
        while (no != null) {
            if (i == tamanho - 1) {
                strLista += no.getStr();
            } else {
                strLista += no.getStr() + ", ";
            }

            no = no.getProximo();
            ++i;
        }
        return strLista;
    }
}
