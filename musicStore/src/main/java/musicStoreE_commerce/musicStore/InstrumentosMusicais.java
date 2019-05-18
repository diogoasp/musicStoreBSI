package musicStoreE_commerce.musicStore;

public class InstrumentosMusicais extends Produto implements iEnvio{

	private String modelo;
	private String tipo;
	private String anoFabricacao;
	private String fabricante;
	private double valorFrete;
	
	public InstrumentosMusicais() {}
	
	public InstrumentosMusicais(double preco, String nome, String descricao, long codBarras, String modelo, String tipo, String anoFabricacao, String fabricante, double valorFrete) {
		this.setAnoFabricacao(anoFabricacao);
		this.setCodBarras(codBarras);
		this.setDescricao(descricao);
		this.setFabricante(fabricante);
		this.setModelo(modelo);
		this.setNome(nome);
		this.setPreco(preco);
		this.setTipo(tipo);
		this.setValorFrete(valorFrete);
		this.setCod(2);
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getValorFrete() {
		double frete = this.CalcularFrete();
		return frete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	@Override
	public double getPreco() {
		double preco = this.calcularPreco();
		return preco;
	}

	public double calcularPreco() {
		double valorTotal = this.preco + (this.preco*0.39);
		return valorTotal;
	}

	public double CalcularFrete(){
		double frete = valorFrete+(valorFrete*0.25);
		return frete;
	}


}
