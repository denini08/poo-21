package poo.jogo.entidades.interf;

public interface BancaInterface extends JogadorAbstractInterface{
	
	public CartaInterface retirarCarta();	//puxar uma carta do baralho
	
	public int getQuantBaralho();	//saber a quantidade de cartas que há no baralho atualmente
	
	public void embaralhar();	//embaralhar o baralho
	
	public void  solicitarCarta();
	
	
	
	//COMUNICAÇÃO COM A BANCA 
	
	public void pegarCarta(JogadorInterface jogador);

	public void vinteEUm(JogadorInterface jogador);
	
	public void estourou(JogadorInterface jogador);
	
	public void parar(JogadorInterface jogador);
	
}
