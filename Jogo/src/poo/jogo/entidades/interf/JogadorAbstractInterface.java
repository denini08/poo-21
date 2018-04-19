package poo.jogo.entidades.interf;

import java.util.ArrayList;

public interface JogadorAbstractInterface {
	
	public String getNome();
	
	public int pontos();
	
	public void setCarteira(float saldo);
	
	public float getCarteira();
	
	public ArrayList<CartaInterface> getCartasDaMao();
	
	public MaoInterface getMao();
	
	public boolean estorou();
	
	public void  solicitarCarta(BancaInterface banca);
	

}
