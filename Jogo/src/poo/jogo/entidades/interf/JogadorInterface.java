package poo.jogo.entidades.interf;

public interface JogadorInterface {

	public String getNome();
	
	public int pontos();
	
	public float fazerAposta();
	
	public void  solicitarCarta(CartaInterface carta);
	
	public void parar();
}
