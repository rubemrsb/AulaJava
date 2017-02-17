package br.unipe.java.unidade1;

import java.util.Scanner;

public class Soma {
	

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int soma = 0;
		System.out.println("Digite o primeiro número a ser somado: ");
		Scanner leitor = new Scanner(System.in);
		x = leitor.nextInt();
		
		System.out.println("Digite o segundo número: ");
		Scanner leitor2 = new Scanner(System.in);
		y = leitor2.nextInt();
		
		soma = x+y;
		System.out.println(soma);
		leitor.close();
		leitor2.close();
		

	}
}
