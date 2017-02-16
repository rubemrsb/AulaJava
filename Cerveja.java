package br.unipe.java.unidade1;

import java.util.Scanner;

public class Cerveja {
	
	public static void main(String[] args) {
		int cervejas = 0;
		
		Scanner leitor = new Scanner(System.in);
		cervejas = leitor.nextInt();
		
		while(cervejas > 0){
			System.out.println(cervejas+" cervejas na freezer.");
			System.out.println("Pego uma garrafa, passo pra frente.");
			cervejas--;
			System.out.println("Agora são "+cervejas+" cervejas na freezer.");
		}
		leitor.close();
	}

}
