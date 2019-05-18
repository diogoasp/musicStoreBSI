package musicStoreE_commerce.musicStore;

public class Venda {
	protected double preco;
	protected Produto[] produtos;
	protected Produto[] enviar;
	private String data;
	
	public Venda(String data, Produto[] produtos) {
		this.setData(data);
		this.produtos = produtos;
		verificarEnviavel();
		this.setPreco();
	}
	
	private void verificarEnviavel() {
		int contadorEnviaveis = 0;
		for(int i = 0; i < produtos.length; i++) 
			if(produtos[i] instanceof iEnvio) contadorEnviaveis++;
		if(contadorEnviaveis>0) {
			this.enviar = new Produto[contadorEnviaveis];
			contadorEnviaveis = 0;
			for(int i = 0; i < produtos.length; i++) {
				if(produtos[i] instanceof iEnvio) {
					this.enviar[contadorEnviaveis] = produtos[i];
					contadorEnviaveis++;
				}
			}
		}
		
	}
	
	public double getPreco() {
		return preco;
	}
	private void setPreco() {
		for(int i = 0; i < produtos.length; i++) {
			this.preco += produtos[i].getPreco();
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String gerarVenda(Cliente cliente) {
		String dadosEnvio = "";
		double frete = 0;
		if(enviar != null) {
			Envio v2 = new Envio(enviar);
			frete = v2.CalcularFrete();
			dadosEnvio = v2.gerarEnvio(cliente)+"\nFrete: R$" + frete;
		}
		String mensagem =   "\nComprador: " + cliente.getNome()+
							"\nCPF: " + cliente.getCpf()+
							"\nData: " + this.getData()+
							dadosEnvio+
							"\nValor: R$" + this.getPreco()+
							"\nValor Total: R$" + (this.getPreco()+frete);
		return mensagem;
	}
	
	public String listagemProdutos() {
		String mensagem = "";
		for(int i = 0; i < produtos.length; i++) {
			mensagem += "Nome: "+produtos[i].getNome()+
						"\nProduto: "+produtos[i].getDescricao()+
						"\nCódigo de barras do Produto: "+produtos[i].getCodBarras()+"\n\n";
		}
		return mensagem;
	}
	
}
