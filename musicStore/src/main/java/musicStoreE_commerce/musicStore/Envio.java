package musicStoreE_commerce.musicStore;

import java.util.Calendar;
import java.util.Date;

public class Envio{
	
	private Calendar calendar = Calendar.getInstance();
	private Date dataEnvio;
	protected Produto[] produto;
	private double frete;

	public Envio(Produto[] produto) {
		this.produto = produto;
		this.setDataEnvio();
	}
	
	private Date getDataEnvio() {
		return dataEnvio;
	}

	private void setDataEnvio() {
		calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_WEEK_IN_MONTH, 10, 00);
		this.dataEnvio = calendar.getTime();
	}
	
	public String gerarEnvio(Cliente cliente) {
		cliente.setEndereco();
		String mensagem =   "\nData de Envio: " + this.getDataEnvio()+
							"\nEndereço de Entrega: " + cliente.getEndereco();
		return mensagem;
	}
	
	public double CalcularFrete() {
		int l = produto.length;
		for(int i = 0; i < l; i++) {
			this.frete += ((iEnvio) produto[i]).getValorFrete();
		}
		return frete;
	}
	
}
