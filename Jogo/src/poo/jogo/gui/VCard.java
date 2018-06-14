package poo.jogo.gui;


import javax.swing.border.Border;

import poo.jogo.entidades.Carta;

public class VCard extends Carta {

	private String imagem;
	
	public VCard(String nome, String naipe, String imagem) throws Exception {
		super(nome, naipe);
		this.imagem = imagem;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
		
}
