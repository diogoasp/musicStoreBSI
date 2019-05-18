package musicStoreE_commerce.musicStore;

import javax.swing.JOptionPane;

public class InserirProdutos {

	public static void main(String[] args) {
		Connection mongo = new Connection();
		Controller controller = new Controller(mongo);
		String nome;
		Double preco;
		Long codBarras;
		String descricao;
		
		int quantidade;
		
		quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos deseja adicionar ao Banco de Dados?"));
		
		Produto ListaProduto;
		for(int i = 0; i < quantidade; i++) {
			int check = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de produto:\n\n1 - Mídia Digital\n2 - Mídia Física\n3 - Instrumentos Musicais"));
			if(check == 1) {
				nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
				preco = Double.parseDouble(JOptionPane.showInputDialog("Insira o preco do produto: R$"));
				descricao = JOptionPane.showInputDialog("Insira a descrição do produto: ");
				codBarras = Long.parseLong(JOptionPane.showInputDialog("Insira o código de barras do produto: "));
				String artista = JOptionPane.showInputDialog("Insira o nome do artista: ");
				String estudio = JOptionPane.showInputDialog("Insira o nome do estúdio: ");
				String dataLancamento = JOptionPane.showInputDialog("Insira o ano de lancamento: ");
				String formato = JOptionPane.showInputDialog("Insira o formato: ");
				ListaProduto = new MidiaDigital(preco, nome, codBarras, descricao, artista, estudio, dataLancamento, formato);
				controller.insertProduto(ListaProduto);
			}
			if(check == 2) {
				JOptionPane.showConfirmDialog(null, "Em contrução");
			}
			if(check == 3) {
				JOptionPane.showConfirmDialog(null, "Em contrução");
			}
		}
		mongo.closeConnection();

	}

}
