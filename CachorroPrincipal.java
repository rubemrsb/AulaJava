//package br.unipe.java.unidade1;

import java.util.Scanner;

public class CachorroPrincipal {
	
	public static void main(String[] args){
		
		Scanner leitor = new Scanner(System.in);
		
		Cachorro cachorro =  new Cachorro();
		
		System.out.println("Informe o nome do cachorro: ");
		cachorro.nome = leitor.nextLine();
		cachorro.late();
	}

}
