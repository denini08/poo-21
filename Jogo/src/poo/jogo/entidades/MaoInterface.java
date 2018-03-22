package poo.jogo.entidades.interf;

import java.util.ArrayList;

import poo.jogo.entidades.Carta;
import poo.jogo.entidades.interf.CartaInterface;

public interface MaoInterface {

	public void receberCarta(CartaInterface c);
	
	public boolean estourar();
	
	public int pontos();
	public int getPonto();
	
	public ArrayList<CartaInterface> getCartas();
}
