import java.io.Serializable;
import java.util.Scanner;

public class Produto implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String codigo,
				   nome, 
				   descricao,
				   promocao;
	
	private float valorVenda,
				  valorCusto,
				  desconto;

	private boolean boolPromocao;
	
	
	
	public Produto(String codigo, String nome, String descricao, float valorVenda, float valorCusto, String promocao, boolean boolPromocao, float desconto) {
		super();
		this.codigo 		= codigo;
		this.nome 			= nome;
		this.descricao		= descricao;
		this.valorVenda 	= valorVenda;
		this.valorCusto		= valorCusto;
		this.promocao 		= promocao;
		this.desconto		= desconto;
		this.boolPromocao 	= boolPromocao;
	}
	
	
	public Produto() {
		super();
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}


	public float getValorCusto() {
		return valorCusto;
	}


	public void setValorCusto(float valorCusto) {
		this.valorCusto = valorCusto;
	}


	public String getPromocao() {
		return promocao;
	}


	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}


	public boolean isBoolPromocao() {
		return boolPromocao;
	}


	public void setBoolPromocao(boolean boolPromocao) {
		this.boolPromocao = boolPromocao;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	// CADASTRAR PRODUTO
	public void cadastrarProduto(){
		
		Arquivo arquivo = new Arquivo();
		Scanner scan = new Scanner(System.in);
		String codigo,
		   nome, 
		   descricao,
		   promocao;
		float valorVenda,
		   valorCusto,
		   valorDesconto;
		boolean boolPromocao = true;
		
		System.out.println("Digite o codigo do produto");
		codigo = scan.nextLine();
		
		System.out.println("Digite o nome do produto");
		nome = scan.nextLine();
		
		System.out.println("Digite a descrição do produto");
		descricao = scan.nextLine();
		
		System.out.println("Digite o valor de venda do produto");
		valorVenda = scan.nextFloat();
		
		System.out.println("Digite o valor de custo do produto");
		valorCusto = scan.nextFloat();
		
		//System.out.println("Produto em promoção [digite apenas sim ou não]");
		promocao = scan.nextLine();
		
		
		// SÓ ACEITA SIM OU NÃO
		while(!promocao.equalsIgnoreCase("sim") && !promocao.equals("nao")){
			System.out.println("Produto em promoção [digite apenas sim ou não]");
			promocao = scan.nextLine();
		}
		if (promocao.equalsIgnoreCase("sim")){
			boolPromocao = true;
			System.out.println("Informe o valor do desconto!");
			valorDesconto = scan.nextFloat();
			this.setDesconto(valorDesconto);
			desconto = valorDesconto;
		}
		if(promocao.equalsIgnoreCase("nao")){
			boolPromocao = false;
			desconto = 0;
		}

		Produto produto = new Produto(codigo, nome, descricao, valorVenda, valorCusto, promocao, boolPromocao, desconto);
		arquivo.salvar(produto, nome);
	}
	
	//PRODUCAR PRODUTO
	public void procurarProduto(){
		
		Arquivo arquivo = new Arquivo();
		Produto produto = new Produto();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nome do Produto: ");
		
		nome = scan.nextLine();
		arquivo.lerObjeto(nome);
		produto = (Produto)arquivo.lerObjeto(nome);
		
		System.out.println("--------------------");
		System.out.println("Nome: "		 		+ produto.getNome());
		System.out.println("Código:	" 			+ produto.getCodigo());
		System.out.println("Descrição: " 		+ produto.getDescricao());
		System.out.println("Promoção?: "		+ produto.getPromocao());
		System.out.println("Valor de Custo: " 	+ produto.getValorCusto());
		System.out.println("Valor de Venda:	" 	+ produto.getValorVenda());
		//System.out.println(boolPromocao);
		if(produto.isBoolPromocao()){
			System.out.println("Desconto: "+ produto.getDesconto());
		}
	}
}
