package poo.jogo.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardView extends JLabel{
	private ImageIcon icone;
	
	public CardView(VCard carta) {
		this.getImagem( carta.getImagem());
		this.setIcon(icone);
		this.setBackground(Color.white);
		this.setOpaque(true);
	}
	
	private void getImagem (String nome) {
		java.net.URL url = this.getClass().getResource(nome);
		this.icone = new ImageIcon(url);
	}
}
