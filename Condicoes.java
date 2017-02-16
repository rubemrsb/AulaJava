package br.unipe.java.unidade1;

import java.util.Scanner;

public class Condicoes {

	public static void main(String[] args) {
		int z = 0;
		Scanner leitor = new Scanner(System.in);
		z = leitor.nextInt();
		if (z == 10) {
			System.out.println("z e igual a 10:)");
		} else {
			System.out.println("z nao e igual a 10");
		}
		leitor.close();
	}

}
