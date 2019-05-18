package musicStoreE_commerce.musicStore;

import javax.swing.JOptionPane;

public class testeProdutos {

	public static void main(String[] args) {
		
		Connection mongo = new Connection();
		Controller controller = new Controller(mongo);
		
		mongo.setCollection("produtos");
		
//		mongo.updateMany();
//		System.out.println(mongo.show());
		
		int quantidade = 3;
		String mensagem;
		
		Produto[] ListaProduto = new Produto[quantidade];
		
		ListaProduto[0] = controller.getProduto("5c9ab91918f3065b9992e795");
		ListaProduto[1] = controller.getProduto("5c9ab91a18f3065b9992e797");
		ListaProduto[2] = controller.getProduto("5c9ab91a18f3065b9992e799");

		System.out.println(ListaProduto[0].getPreco());
		System.out.println(ListaProduto[1].getPreco());
		System.out.println(ListaProduto[2].getPreco());
		
		Venda v1 = new Venda("23/03/2019", ListaProduto);
		Cliente c1 = new Cliente("159.161.317-55", "Diogo");
		
		mensagem = "\nLista de Produtos:\n" + v1.listagemProdutos();
		JOptionPane.showMessageDialog(null, mensagem);
		JOptionPane.showMessageDialog(null, v1.gerarVenda(c1));
		mongo.closeConnection();
		
	}
}	
	


