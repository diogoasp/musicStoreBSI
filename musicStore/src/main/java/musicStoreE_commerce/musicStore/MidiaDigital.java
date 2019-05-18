package musicStoreE_commerce.musicStore;

//import java.util.Date;

public class MidiaDigital extends Album{
	
	private String formato;

	public MidiaDigital() {}
	
	public MidiaDigital(double preco, String nome, long codBarras, String descricao, String artista, String estudio, String dataLancamento, String formato) {
		super(preco, nome, codBarras, descricao, artista, estudio, dataLancamento);
		this.setFormato(formato);
		this.setCod(0);
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
}
