package poo.jogo.entidades.interf;

import java.util.ArrayList;

public interface MaoInterface {

	public void receberCartas(CartaInterface carta);
	
	public boolean estourar();
	
	public ArrayList<CartaInterface> getCartas();
	
	public int getPontos();
	
	
}
