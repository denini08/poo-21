package poo.jogo.entidades.interf;

import java.util.ArrayList;

public interface JogadorInterface {

	public String getNome();
	
	public void setCarteira(float saldo);
	
	public float getCarteira();
	
	public int pontos();
	
	public boolean fazerAposta(float valor);
	
	public void  solicitarCarta(CartaInterface carta);
	
	public float getValorDaAposta();
	
	public ArrayList<CartaInterface> getCartasDaMao();
	
	public MaoInterface getMao();
}
