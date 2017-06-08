import java.io.Serializable;
import java.util.Scanner;

public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Vendedor vendedor;
	private int quantidadeItens;
	private float valor,
				  desconto;
	private float valorTotal;
	private String nomeDoVendedor;
	private String nomedoProduto;
	
	//set valores
	public Venda(Produto produto, Vendedor vendedor, int quantidadeItens) {
		this.produto 			= produto;
		this.vendedor			= vendedor;
		this.quantidadeItens	= quantidadeItens;
	}
	
	public Venda(){
		super();
	}
		
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public float getDesconto() {
		return desconto;
	}
	
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
	// EFETUAR DESCONTO
	public void efetuarDesconto(float descontoProduto) {
		
		float valorDaVenda = (produto.getValorVenda());
		float valorFinal = (valorDaVenda - desconto);
		
		this.setDesconto(valorFinal);
		//this.setValor(valorFinal);
	}
	
	
	//CALCULAR VALOR
	public void calcularValor(int quantidadeDeItens, float valorDaVenda, float desconto){
		float vlrDaVenda = (valorDaVenda * quantidadeDeItens) - desconto;
		this.setValorTotal(vlrDaVenda);
	}
	
	
	//CALCULAR COMISSAO
	public float calcularComissao(float valorDaVenda, int quantidadeDeItens, float comissaoDoVendedor, boolean promocao) {
		
		float comissao = (valorDaVenda * quantidadeDeItens * comissaoDoVendedor) / 100;
		if (promocao) {
			comissao = comissao / 2;
		}
		
		return comissao;
}
	
	public void fazerVenda(){
		// SCAN and ARQUIVO
		Scanner scan = new Scanner(System.in);
		Arquivo arquivo	= new Arquivo();
		
		//  NOME DO PRODUTO and LER ARQUIVO
		System.out.println("Informe o Nome do Produto: ");
		nomedoProduto = scan.nextLine();
		arquivo.lerObjeto(nomedoProduto);
		Produto produto = (Produto)arquivo.lerObjeto(nomedoProduto);
		
		// NOME DO VENDEDOR and LER ARQUIVO
		System.out.println("Informe o Nome do Vendedor: ");
		nomeDoVendedor = scan.nextLine();
		arquivo.lerObjeto(nomeDoVendedor);
		Vendedor vendedor = (Vendedor)arquivo.lerObjeto(nomeDoVendedor);
		
		// QUANTIDADE DE ITENS A SEREM VENDIDOS
		System.out.println("Informe o número de Produtos a serem vendidos.");
		int quantidadeItens = scan.nextInt();
		this.setQuantidadeItens(quantidadeItens);
		//System.out.println(this.getQuantidadeItens());
		//Venda venda	= new Venda(produto, vendedor, quantidadeItens);	
	}
	
	//EXIBIR NA TELA INFORMAÇÕES
		public void imprimeNaTela(){
			// LER ARQ VENDEDOR
			//float valor = 0;
			Arquivo arquivo = new Arquivo();
			
			arquivo.lerObjeto(nomeDoVendedor);
			Vendedor vendedor = (Vendedor)arquivo.lerObjeto(nomeDoVendedor);
			
			// INFORMAÇÕES DO VENDEDOR
			System.out.println("\n---");
			System.out.println("Informações do vendedor:");
			System.out.format("Nome: %s\nCódigo: %s\n", vendedor.getNome(), vendedor.getCodigo());
			
			// LER ARQ PRODUTO
			arquivo.lerObjeto(nomedoProduto);
			Produto produto = (Produto)arquivo.lerObjeto(nomedoProduto);
			
			// COMISSÂO DO VENDEDOR
			System.out.format("Comissão: %f", calcularComissao(produto.getValorVenda(), this.getQuantidadeItens(), vendedor.getComissao(), produto.isBoolPromocao()));
			
			/* QUANTIDADE DE ITENS
			 * CÓDIGO
			 * DESCRIÇÃO
			 * VALOR DA VENDA
			 */
			System.out.format("\nQuantidade de Itens: %d\nCodigo: %s\nDescrição: %s\nValor: %f\n",this.getQuantidadeItens(), produto.getCodigo(), produto.getDescricao() , produto.getValorVenda());
			
			// PROMOÇÃO? & VALOR DO DESCONTO
			if(produto.isBoolPromocao()){
				System.out.println("Promocão Ativada!");
				//DESCONTO
				System.out.format("Desconto: %f\n", produto.getDesconto());
			}else{
				System.out.println("Sem Promoção");
			}
			System.out.println();
			
			//VALOR TOTAL DO PRODUTO
			calcularValor(this.quantidadeItens, this.valor, this.desconto);
			valor = (this.valor * this.quantidadeItens);
			System.out.println(this.quantidadeItens);
			System.out.println("e---");
			System.out.println(valor);
			System.out.format("Valor: %f\n", this.valorTotal);
			System.out.println("e---");
			
		}
	
}
