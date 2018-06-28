package poo.jogo.gui;


import javax.swing.border.Border;

import poo.jogo.entidades.Carta;

public class VCard extends Carta {

	private String imagem;
	private String imagemCortada;
	
	public VCard(String nome, String naipe, String imagem,String imagemCortada) throws Exception {
		super(nome, naipe);
		this.imagem = imagem;
		this.imagemCortada = imagemCortada;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getImagemCortada() {
		return imagemCortada;
	}

	public void setImagemCortada(String imagemCortada) {
		this.imagemCortada = imagemCortada;
	}
	
}
