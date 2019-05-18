package musicStoreE_commerce.musicStore;

public class Controller {
	Connection mongo;
	
	public Controller(Connection mongo) {
		this.mongo = mongo;
	}
	
	public Produto getProduto(String id) {
		org.bson.Document doc = mongo.find(id);
		Produto produto = null;
		if(doc != null) {
			if(Integer.parseInt(doc.getString("cod")) == 0) {
				produto = new MidiaDigital();
				((MidiaDigital) produto).setFormato(doc.getString("formato"));
				((MidiaDigital) produto).setArtista(doc.getString("artista"));
				((MidiaDigital) produto).setEstudio(doc.getString("estudio"));
				((MidiaDigital) produto).setDataLancamento(doc.getString("dataLancamento"));
			}
			if(Integer.parseInt(doc.getString("cod")) == 1) {
				produto = new MidiaFisica();
				((MidiaFisica) produto).setTipo(doc.getString("tipo"));
				((MidiaFisica) produto).setArtista(doc.getString("artista"));
				((MidiaFisica) produto).setEstudio(doc.getString("estudio"));
				((MidiaFisica) produto).setDataLancamento(doc.getString("dataLancamento"));
				((MidiaFisica) produto).setValorFrete(doc.getDouble("valorFrete"));
			}
			if(Integer.parseInt(doc.getString("cod")) == 2) {
				produto = new InstrumentosMusicais();
				((InstrumentosMusicais) produto).setTipo(doc.getString("tipo"));
				((InstrumentosMusicais) produto).setFabricante(doc.getString("fabricante"));
				((InstrumentosMusicais) produto).setModelo(doc.getString("modelo"));
				((InstrumentosMusicais) produto).setAnoFabricacao(doc.getString("dataFabricacao"));
			}
			produto.setNome(doc.getString("nome"));
			produto.setPreco(doc.getDouble("preco"));
			produto.setCodBarras(doc.getLong("codigoBarras"));
			produto.setDescricao(doc.getString("descricao"));
		}
		return produto;
	}
	
	public void insertProduto(Produto[] produto) {
		for(int i = 0; i < produto.length; i++) {
			if(produto[i] instanceof MidiaFisica)
				mongo.insertDocument((MidiaFisica) produto[i]);
			if(produto[i] instanceof InstrumentosMusicais)
				mongo.insertDocument((InstrumentosMusicais) produto[i]);
			if(produto[i] instanceof MidiaDigital)
				mongo.insertDocument((MidiaDigital) produto[i]);
		}
	}
	
	public void insertProduto(Produto produto) {
		
			if(produto instanceof MidiaFisica)
				mongo.insertDocument((MidiaFisica) produto);
			if(produto instanceof InstrumentosMusicais)
				mongo.insertDocument((InstrumentosMusicais) produto);
			if(produto instanceof MidiaDigital)
				mongo.insertDocument((MidiaDigital) produto);
	}
	
	public void close() {
		mongo.closeConnection();
	}
}
