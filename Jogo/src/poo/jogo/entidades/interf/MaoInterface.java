package poo.jogo.entidades.interf;

import poo.jogo.entidades.Carta;

public interface MaoInterface {

	public void receberCartas(Carta carta);
	
	public boolean estourar();
	
	public int pontos();
}
