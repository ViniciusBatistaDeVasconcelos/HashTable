package models;

public class Primo {
	private static Primo instancia = new Primo();

	public static Primo get() {
		return instancia;
	}

	public boolean verificar(int numero) {
		int total = 0;
		for (int i = 1; i <= numero; i++) {
			if ((numero % i) == 0) {
				total++;
			}
		}
		return total == 2 || numero == 1 ? true : false;
	}
}
