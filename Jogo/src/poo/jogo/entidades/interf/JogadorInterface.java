package poo.jogo.entidades.interf;

public interface JogadorInterface {

	public String getNome();
	
	public void setCarteira(float saldo);
	
	public float getCarteira();
	
	public int pontos();
	
	public float fazerAposta();
	
	public void  solicitarCarta(CartaInterface carta);
	
	public void parar();
}
