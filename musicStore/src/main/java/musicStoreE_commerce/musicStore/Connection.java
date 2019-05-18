package musicStoreE_commerce.musicStore;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;

import javax.swing.JOptionPane;


public class Connection {
	 MongoClient mongoClient;
	 MongoDatabase database;
	 MongoCollection<Document> collection;
	 String db = "musicStore";
	 
	 public Connection(){
		 mongoClient = MongoClients.create();
		 database = mongoClient.getDatabase(db);
	 }
	 
	 public String listCollections() {
		 String list = "";
		 for (String name : database.listCollectionNames()) {
            list += name + "\n";
         }
		 return list;
	 }
	 
	 public boolean setCollection(String collection) {
		 this.collection = database.getCollection(collection, Document.class);
		 return true;		 
	 }
	 
	 public boolean insertDocument(MidiaFisica produto) {
		 Document doc = new Document("nome",produto.getNome())
				 		.append("preco", produto.getPreco())
		 				.append("codigoBarras",produto.getCodBarras())
		 				.append("descricao", produto.getDescricao())
		 				.append("tipo", produto.getTipo())
		 				.append("artista", produto.getartista())
		 				.append("estudio", produto.getEstudio())
		 				.append("dataLancamento", produto.getDataLancamento())
		 				.append("valorFrete", produto.getValorFrete());
		 collection.insertOne(doc);
		 return true;		 
	 }
	 
	 public boolean insertDocument(InstrumentosMusicais produto) {
		 Document doc = new Document("nome",produto.getNome())
				 		.append("preco", produto.getPreco())
		 				.append("codigoBarras",produto.getCodBarras())
		 				.append("descricao", produto.getDescricao())
		 				.append("tipo", produto.getTipo())
		 				.append("fabricante", produto.getFabricante())
		 				.append("modelo", produto.getModelo())
		 				.append("dataFabricacao", produto.getAnoFabricacao())
		 				.append("valorFrete", produto.getValorFrete());
		 collection.insertOne(doc);
		 return true;		 
	 }
	 
	 public boolean insertDocument(MidiaDigital produto) {
		 Document doc = new Document("nome",produto.getNome())
				 		.append("preco", produto.getPreco())
		 				.append("codigoBarras",produto.getCodBarras())
		 				.append("descricao", produto.getDescricao())
		 				.append("formato", produto.getFormato())
		 				.append("artista", produto.getartista())
		 				.append("estudio", produto.getEstudio())
		 				.append("dataLancamento", produto.getDataLancamento());
		 collection.insertOne(doc);
		 return true;		 
	 }
	 
	 public long countDocuments(){
		 long count = collection.countDocuments();
		 return count;
	 }
	 
	 public Document find(String id) {
		 Document doc = collection.find(eq("_id", new ObjectId(id))).first();
		 return doc;		 
	 }
	 
	 public String findOne() {
		 String text = collection.find().first().toJson();
		 return text;
	 }
	 
	 public String show(String key, int value) {
		 String text = "";
		 MongoCursor<Document> cursor = collection.find(gt(key, value)).iterator();
		 try {
		     while (cursor.hasNext()) {
		         text += cursor.next().toJson()+"\n";
		     }
		 } finally {
		     cursor.close();
		 }
		 return text;
	 }
	 
	 public String show(String key, String value) {
		 String text = "";
		 MongoCursor<Document> cursor = collection.find(eq(key, value)).iterator();
		 try {
		     while (cursor.hasNext()) {
		         text += cursor.next().toJson()+"\n";
		     }
		 } finally {
		     cursor.close();
		 }
		 return text;
	 }
	 
	 public String show() {
		 String text = "";
		 MongoCursor<Document> cursor = collection.find().iterator();
		 try {
		     while (cursor.hasNext()) {
		         text += cursor.next().toJson()+"\n";
		     }
		 } finally {
		     cursor.close();
		 }
		 return text;
	 }
	 
	Block<Document> printBlock = new Block<Document>() {
	     //@Override
	     public void apply(final Document document) {
	         System.out.println(document.toJson());
	     }
	};
	
	public boolean updateOne(String id) {
		String key = JOptionPane.showInputDialog(null, "Que campo do documento deseja alterar?");
		String value = JOptionPane.showInputDialog(null, "Qual o novo valor do campo?");
		if(key == "age")
			collection.updateOne(eq("_id", new ObjectId(id)), new Document("$set", new Document(key, Integer.parseInt(value))));
		else
			collection.updateOne(eq("_id", new ObjectId(id)), new Document("$set", new Document(key, value)));
		return true;
	}
	
	public boolean updateMany() {
		int crit = Integer.parseInt(JOptionPane.showInputDialog("\nSelecione o critério:"+
												  "\n1 - Igual"+
												  "\n2 - Maior que"+
												  "\n3 - Menor que"));
		String filter = JOptionPane.showInputDialog(null, "Que campo serviá como filtro?");
		String filterValue = JOptionPane.showInputDialog(null, "Qual valor do filtro?");
		String key = JOptionPane.showInputDialog(null, "Que campo do documento deseja alterar?");
		String value = JOptionPane.showInputDialog(null, "Qual o novo valor do campo?");
		switch(crit) {
		case 1:
			if(key.equalsIgnoreCase("age"))
				collection.updateMany(eq(filter, Integer.parseInt(filterValue)), new Document("$set", new Document(key, Integer.parseInt(value))));
			else
				collection.updateMany(eq(filter, filterValue), new Document("$set", new Document(key, value))); 
			break;
		case 2: 
			if(key.equalsIgnoreCase("age"))
				collection.updateMany(gt(filter, Integer.parseInt(filterValue)), new Document("$set", new Document(key, Integer.parseInt(value))));
			else
				collection.updateMany(gt(filter, filterValue), new Document("$set", new Document(key, value))); 
			break;
		case 3: 
			if(key.equalsIgnoreCase("age"))
				collection.updateMany(lt(filter, Integer.parseInt(filterValue)), new Document("$set", new Document(key, Integer.parseInt(value))));
			else
				collection.updateMany(lt(filter, filterValue), new Document("$set", new Document(key, value))); 
			break;
		}
		return true;
	}
	 
	public boolean deleteDocument(String id) {
		 collection.deleteOne(eq("_id", new ObjectId(id)));
		 return true;		 
	 }
	
	public DeleteResult deleteMany() {
		int crit = Integer.parseInt(JOptionPane.showInputDialog("\nSelecione o critério:"+
				  "\n1 - Igual"+
				  "\n2 - Maior que"+
				  "\n3 - Menor que"));
		String filter = JOptionPane.showInputDialog(null, "Que campo serviá como filtro?");
		String filterValue = JOptionPane.showInputDialog(null, "Qual valor do filtro?");
		DeleteResult deleteResult = null;
		switch(crit) {
			case 1:
				if(filter.equalsIgnoreCase("age"))
					deleteResult = collection.deleteMany(eq(filter, Integer.parseInt(filterValue)));
				else
					deleteResult = collection.deleteMany(eq(filter, filterValue));
				break;
			case 2: 
				if(filter.equalsIgnoreCase("age"))
					deleteResult = collection.deleteMany(gt(filter, Integer.parseInt(filterValue)));
				else
					deleteResult = collection.deleteMany(gt(filter, filterValue));
				break;
			case 3: 
				if(filter.equalsIgnoreCase("age"))
					deleteResult = collection.deleteMany(lt(filter, Integer.parseInt(filterValue)));
				else
					deleteResult = collection.deleteMany(lt(filter, filterValue));
				break;
		}
		return deleteResult;
	}
	 
	public boolean createIndex(String key, int type) {
		collection.createIndex(new Document(key, type));
		return true;
	}
	
	public void closeConnection() {
		mongoClient.close();
	}
	
}
