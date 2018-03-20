package poo.jogo.entidades.interf;

import poo.jogo.entidades.Carta;

public interface MaoInterface {

	public void receberCarta(CartaInterface c);
	
	public boolean estourar();
	
	public int pontos();
	public int getPonto();
}
