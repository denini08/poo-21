package poo.jogo.entidades.interf;

public interface BancaInterface extends JogadorInterface{
	
	public CartaInterface retirarCarta();	//puxar uma carta do baralho
	public int getQuantBaralho();	//saber a quantidade de cartas que há no baralho atualmente
	public void embaralhar();	//embaralhar o baralho
	
}
