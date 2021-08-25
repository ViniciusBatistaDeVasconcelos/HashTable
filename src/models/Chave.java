package models;

public class Chave {

    private static Chave instancia = new Chave();

    public static Chave getInstancia() {
        return instancia;
    }

    public int gerarChave(int valor, int tamanho) {
        return valor % tamanho;
    }

    public int gerarChave(String valor, int tamanho) {
        char[] caracteres = new char[valor.length()];
        int valorNumerico = 0;

        for (int i = 0; i < valor.length(); i++) {
            caracteres[i] = valor.charAt(i);
            valorNumerico += (int) caracteres[i];
        }
        return valorNumerico % tamanho;
    }
}
