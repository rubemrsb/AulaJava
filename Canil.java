package br.unipe.java.unidade1;
/**
 * Clase que define o comportamento para canil.
 * @author Rubem
 *@date 16 february 2017
 *
 */
public class Canil {
	/**
	 * Esse método realiza o alojamento do animal para adoção ou extermínio.
	 */
	
	public void alojar(){
		System.out.println("Alojando Cachorro");
	}
	
	/**
	 * Esse método realiza o exterminio do cachorro
	 * @param nome do animal que será exterminado
	 */
	public void exterminaCachorro(String nome){
		System.out.println("Exterminando Cachorro");
	}
}
