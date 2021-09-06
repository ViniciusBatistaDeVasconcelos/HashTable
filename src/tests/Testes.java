package tests;

import java.util.Iterator;

import models.Primo;

public class Testes {
	public static void main(String[] args) {
		System.out.println(Primo.get().verificar(4) ? "É primo" : "Não é primo");

		int[] array = new int[0];
		for (int i = 0; i < array.length; i++) {
			System.out.println(i);
		}
	}
}
