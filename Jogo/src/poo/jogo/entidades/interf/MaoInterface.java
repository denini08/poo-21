package poo.jogo.entidades.interf;

import java.util.ArrayList;

public interface MaoInterface {

	public void receberCartas(CartaInterface carta);
	
	public boolean estourar();
	
	public int getPontos();
	
	public ArrayList<CartaInterface> getCartas();
}
