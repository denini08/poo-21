package poo.jogo.gui;

import java.util.ArrayList;

import javax.swing.JLabel;

public class CartasMao {
	private VCard carta;
	private JLabel labelCartMaior;
	
	public CartasMao(VCard carta, JLabel labelCartMaior ) {
		this.carta = carta;
		this.labelCartMaior = labelCartMaior;
	}
	
	public void setCarta(VCard carta, JLabel novaLabel ) {
		this.carta = carta;
		this.labelCartMaior = novaLabel;
	}
	
	public VCard getUltimaCarta() throws Exception {
		if (carta == null) throw new Exception(); 
		 return carta;
	}
	
	public JLabel getLabelMaior() throws Exception {
		if (labelCartMaior == null) throw new Exception(); 
		return labelCartMaior;
	}
}