package musicStoreE_commerce.musicStore;

public class MidiaFisica extends Album implements iEnvio{
	
	private String tipo;
	private double valorFrete;

	public MidiaFisica() {}
	
	public MidiaFisica(double preco, String nome, long codBarras, String descricao, String artista, String estudio, String dataLancamento, String tipo, double valorFrete) {
		super(preco, nome, codBarras, descricao, artista, estudio, dataLancamento);
		this.setTipo(tipo);
		this.setValorFrete(valorFrete);
		this.setCod(1);
	}
	
	

	@Override
	public double getPreco() {
		double preco = this.calcularPreco();
		return preco;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getValorFrete() {
		double frete = this.CalcularFrete();
		return frete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	//Override
	public double CalcularFrete(){
		double frete = this.valorFrete+(this.valorFrete*0.25);
		return frete;
	}
	
	//Override
	public double calcularPreco() {
		double valorTotal = this.preco + (this.preco*0.38);
		return valorTotal;
	}
}
