mportluis java.util.Scanner;

public class Principal {

	private static Scanner scan;

	public static void main(String[] args){
		
		Menu menu = new Menu();
		Produto  produto 	= new Produto();
		Vendedor vendedor 	= new Vendedor();
		Venda 	 venda 		= new Venda();
		
		
		//fazerVenda  fazervenda	= new fazerVenda();
		scan = new Scanner(System.in);
		boolean loop = true;
		String opcao;
		do{
			
			//Menu
			menu.exibeMenu();
			
			opcao = scan.nextLine();
			
			switch(opcao){
				case "1":
					//CADASTRAR PRODUTO
					produto.cadastrarProduto();
					break;
				case "2":
					//CADASTRAR VENDEDOR
					vendedor.cadastrarVendedor();
					vendedor = new Vendedor(vendedor.getNome(), vendedor.getEndereco(), vendedor.getCodigo(), vendedor.getComissao());
					break;
				case "3":
					//PROCURAR PRODUTO
					produto.procurarProduto();
					break;
				case "4":
					//PRODUCRAR VENDEDOR
					vendedor.procurarVendedor();
					break;
				case "5":
					//int quantidadeItens = (Integer) null;
					venda.fazerVenda();
					venda.imprimeNaTela();
					//System.out.println(venda.getQuantidadeItens());
					//venda.imprimeNaTela();
					break;
					
				case "0":
					loop = false;
					break;
				default:
					System.out.println("Digite uma opção valida");
					break;
					
					
			}
		}while(loop);
		
	}
}
