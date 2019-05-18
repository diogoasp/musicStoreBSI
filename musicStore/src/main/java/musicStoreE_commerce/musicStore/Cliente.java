package musicStoreE_commerce.musicStore;

import javax.swing.JOptionPane;

public class Cliente {
	private String cpf;
	private String nome;
	private String endereco;
	
	public Cliente(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setEndereco() {
		this.endereco = JOptionPane.showInputDialog("Qual é o seu endereço?");
	}
}
