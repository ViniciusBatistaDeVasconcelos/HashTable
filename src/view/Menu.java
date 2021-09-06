package view;

import java.util.Scanner;

import models.chaining.TabelaHashChaining;

public class Menu {

	public static Scanner scanner = new Scanner(System.in);

	public static String getMenu() {

		String str = "\n\n" + "--------------------------- <Menu> ---------------------------\n" + " 1) Chaining\n"
				+ " 2) Linear Probing\n" + " 3) Linear Probing Bidirectional\n" + " 4) Linear Probing Fixed Increment\n"
				+ " 5) Linear Probing Double Hashing\n" + " 6) Chaining \t\t\t\tSTRING\n"
				+ " 7) Linear Probing \t\t\tSTRING\n" + " 8) Linear Probing Bidirectional \tSTRING\n"
				+ " 9) Linear Probing Fixed Increment \tSTRING\n" + "10) Linear Probing Double Hashing \tSTRING\n"
				+ "11) Sair\n" + "--------------------------------------------------------------\n";
		return str;
	}

	public static String getSubMenu() {
		return "\n-------------------------------------------------------------\n 1) Inserir\t 2) Buscar\t 3) Apagar\t 4) Sair\n";
	}

	public static void main(String[] args) throws Exception {
		int escolhaMenu;
		do {
			System.out.println(getMenu());
			System.out.println("Escolha uma Opção: ");
			escolhaMenu = scanner.nextInt();

			switch (escolhaMenu) {

			case 1:
				System.out.println("Digite o tamanho da tabela:");
				int tamanhoTabela = scanner.nextInt();
				TabelaHashChaining tabelaHashChaining = new TabelaHashChaining(tamanhoTabela);

				int escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								tabelaHashChaining.inserir(inserir);
								System.out.println(tabelaHashChaining.getTabelaValor());
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(tabelaHashChaining.getTabelaValor());
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (tabelaHashChaining.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println(tabelaHashChaining.getTabelaValor());
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						// excluir
						tabelaHashChaining.remover(excluir);
						System.out.println(tabelaHashChaining.getTabelaValor());
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);

				break;
			case 2:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				models.linearProbing.TabelaHash linearProbing = new models.linearProbing.TabelaHash(tamanhoTabela);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								linearProbing.inserir(inserir);
								System.out.println(linearProbing);
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(linearProbing);
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (linearProbing.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						System.out.println(linearProbing);
						// excluir
						linearProbing.remover(excluir);
						System.out.println(linearProbing);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 3:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				models.linearProbingBidirectional.TabelaHash linearProbingBidirectional = new models.linearProbingBidirectional.TabelaHash(
						tamanhoTabela);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								linearProbingBidirectional.inserir(inserir);
								System.out.println(linearProbingBidirectional);
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(linearProbingBidirectional);
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (linearProbingBidirectional.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						System.out.println(linearProbingBidirectional);
						// excluir
						linearProbingBidirectional.remover(excluir);
						System.out.println(linearProbingBidirectional);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 4:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				System.out.println("Digite o incremento:");
				int incremento = scanner.nextInt();
				models.linearProbingFixedIncrement.TabelaHash linearProbingFixedIncrement = new models.linearProbingFixedIncrement.TabelaHash(
						tamanhoTabela, incremento);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								linearProbingFixedIncrement.inserir(inserir);
								System.out.println(linearProbingFixedIncrement);
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(linearProbingFixedIncrement);
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (linearProbingFixedIncrement.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						System.out.println(linearProbingFixedIncrement);
						// excluir
						linearProbingFixedIncrement.remover(excluir);
						System.out.println(linearProbingFixedIncrement);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 5:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				models.linearProbingDoubleHashing.TabelaHash linearProbingDoubleHashing = new models.linearProbingDoubleHashing.TabelaHash(
						tamanhoTabela);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								linearProbingDoubleHashing.inserir(inserir);
								System.out.println(linearProbingDoubleHashing);
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(linearProbingDoubleHashing);
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (linearProbingDoubleHashing.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						System.out.println(linearProbingDoubleHashing);
						// excluir
						linearProbingDoubleHashing.remover(excluir);
						System.out.println(linearProbingDoubleHashing);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 6:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				TabelaHashChaining tabelaHashChainingString = new TabelaHashChaining(tamanhoTabela);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 0 quando quiser parar...");
						int inserir;

						do {
							inserir = scanner.nextInt();
							if (inserir != 0) {
								// inserir
								tabelaHashChainingString.inserir(inserir);
								System.out.println(tabelaHashChainingString.getTabelaString());
							}
						} while (inserir != 0);
						break;
					case 2:
						System.out.println(tabelaHashChainingString.getTabelaString());
						System.out.println("Digite o valor que deseja buscar:");
						int buscar = scanner.nextInt();
						// buscar
						if (tabelaHashChainingString.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						int excluir = scanner.nextInt();
						System.out.println(tabelaHashChainingString.getTabelaString());
						// excluir
						tabelaHashChainingString.remover(excluir);
						System.out.println(tabelaHashChainingString.getTabelaString());
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 7:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				models.HashString hashString = new models.HashString(tamanhoTabela, "models.linearProbing");

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 's' quando quiser parar...");
						String inserir;

						do {
							inserir = scanner.next();
							if (!inserir.equals("s")) {
								// inserir
								hashString.inserir(inserir);
								System.out.println(hashString);
							}
						} while (!inserir.equals("s"));
						break;
					case 2:
						System.out.println(hashString);
						System.out.println("Digite o valor que deseja buscar:");
						String buscar = scanner.next();
						// buscar
						if (hashString.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						String excluir = scanner.next();
						System.out.println(hashString);
						// excluir
						hashString.remover(excluir);
						System.out.println(hashString);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 8:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				hashString = new models.HashString(tamanhoTabela, "models.linearProbingBidirectional");

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 's' quando quiser parar...");
						String inserir;

						do {
							inserir = scanner.next();
							if (!inserir.equals("s")) {
								// inserir
								hashString.inserir(inserir);
								System.out.println(hashString);
							}
						} while (!inserir.equals("s"));
						break;
					case 2:
						System.out.println(hashString);
						System.out.println("Digite o valor que deseja buscar:");
						String buscar = scanner.next();
						// buscar
						if (hashString.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						String excluir = scanner.next();
						System.out.println(hashString);
						// excluir
						hashString.remover(excluir);
						System.out.println(hashString);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 9:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				System.out.println("Digite o incremento:");
				incremento = scanner.nextInt();
				hashString = new models.HashString(tamanhoTabela, "models.linearProbingFixedIncrement", incremento);

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 's' quando quiser parar...");
						String inserir;

						do {
							inserir = scanner.next();
							if (!inserir.equals("s")) {
								// inserir
								hashString.inserir(inserir);
								System.out.println(hashString);
							}
						} while (!inserir.equals("s"));
						break;
					case 2:
						System.out.println(hashString);
						System.out.println("Digite o valor que deseja buscar:");
						String buscar = scanner.next();
						// buscar
						if (hashString.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						String excluir = scanner.next();
						System.out.println(hashString);
						// excluir
						hashString.remover(excluir);
						System.out.println(hashString);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 10:
				System.out.println("Digite o tamanho da tabela:");
				tamanhoTabela = scanner.nextInt();
				hashString = new models.HashString(tamanhoTabela, "models.linearProbingDoubleHashing");

				escolhaSubMenu = 4;
				do {
					System.out.println(getSubMenu());
					System.out.println("Selecione uma operação:");
					escolhaSubMenu = scanner.nextInt();
					switch (escolhaSubMenu) {
					case 1:
						System.out.println("Digite 's' quando quiser parar...");
						String inserir;

						do {
							inserir = scanner.next();
							if (!inserir.equals("s")) {
								// inserir
								hashString.inserir(inserir);
								System.out.println(hashString);
							}
						} while (!inserir.equals("s"));
						break;
					case 2:
						System.out.println(hashString);
						System.out.println("Digite o valor que deseja buscar:");
						String buscar = scanner.next();
						// buscar
						if (hashString.buscar(buscar) == -1) {
							System.out.println("Não foi encontrado");
						} else {
							System.out.println("Foi encontrado");
						}
						break;
					case 3:
						System.out.println("Digite o valor que deseja excluir:");
						String excluir = scanner.next();
						System.out.println(hashString);
						// excluir
						hashString.remover(excluir);
						System.out.println(hashString);
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + escolhaSubMenu);
					}
				} while (escolhaSubMenu != 4);
				break;
			case 11:
				System.out.println("Finalizado com sucesso!");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + escolhaMenu);
			}
		} while (escolhaMenu != 11);

	}
}
