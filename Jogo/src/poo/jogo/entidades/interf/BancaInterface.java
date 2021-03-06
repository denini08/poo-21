package poo.jogo.entidades.interf;

import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.gui.VCard;

public interface BancaInterface extends JogadorAbstractInterface{
	
	
	public CartaInterface retirarCarta();	//puxar uma carta do baralho
	
	public int getQuantBaralho();	//saber a quantidade de cartas que h� no baralho atualmente
	
	public void embaralhar();	//embaralhar o baralho

	
	public void obterJogadores(JogadorInterface jogador) throws Exception;
	
	public void iniciar();
	public EstadoJogador getEstado_atual();
	
	
	
	//COMUNICA��O COM A BANCA 
	
	public void pegarCarta(JogadorInterface jogador);

	public void vinteEUm(JogadorInterface jogador);
	
	public void estourou(JogadorInterface jogador);
	
	public void parar(JogadorInterface jogador);
	
	
	//VIEW
	
	public void iniciarV(int quant_jogadores);

	public void pegarCartaV(JogadorInterface jogador);
	
	public VCard solicitarCartaV(BancaInterface banca);
	
}
