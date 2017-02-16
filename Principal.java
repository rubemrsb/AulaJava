public class Principal {

	public static void main(String[] args){
		ObjetoCarro carro = new ObjetoCarro();
		
		carro.setNomeCarro("Prisma");
		carro.setCorCarro("Prata");
		carro.setMarcaCarro("Chevrolet");
		carro.setMotorCarro("1.4");
		
		System.out.println("-------------Informacoes do veiculo-------------\n");
		System.out.println("-> Nome: "+carro.getNomeCarro());
		System.out.println("\n-> Marca: "+carro.getMarcaCarro());
		System.out.println("\n-> Cor: "+carro.getCorCarro());
		System.out.println("\n-> Motor: "+carro.getMotorCarro());
		System.out.println("\n------------------------------------------------\n");
	}
	
}
