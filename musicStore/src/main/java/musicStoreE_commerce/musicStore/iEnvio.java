package musicStoreE_commerce.musicStore;

interface iEnvio {
	abstract public double CalcularFrete();
	public abstract double calcularPreco();
	public abstract double getValorFrete();
	public abstract void setValorFrete(double valorFrete);
}
