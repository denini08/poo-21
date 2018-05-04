package poo.jogo.entidades.interf;

import poo.jogo.entidades.estados.EstadoJogador;

public interface JogadorInterface extends JogadorAbstractInterface{
	
	public void FazerAposta(BancaInterface banca);
	
	public void jogar(BancaInterface banca);
	
	public void solicitarCarta(BancaInterface banca);
	
	public float getValorDaAposta();
	
	public void setEstado_atual(EstadoJogador estadoJogador);
	
	public EstadoJogador getEstado_atual();
	
	public void ganhou();
	
	public void perdeu();
	
	public void empatou();
	
	public void vinteEUm();
	
}
