package musicStoreE_commerce.musicStore;

//import java.util.Date;

public abstract class Album extends Produto{
	
	protected String artista;
	protected String estudio;
	protected String dataLancamento;
	
	public Album(double preco, String nome, long codBarras,  String descricao, String artista, String estudio, String dataLancamento) {
		this.setPreco(preco);
		this.setCodBarras(codBarras);
		this.setDescricao(descricao);
		this.setNome(nome);
		this.setArtista(artista);
		this.setDataLancamento(dataLancamento);
		this.setEstudio(estudio);
	}

	public Album() {}
	
	public String getartista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}
