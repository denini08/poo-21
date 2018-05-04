package poo.jogo.entidades.interf;

import poo.jogo.entidades.estados.EstadoJogador;

public interface JogadorInterface extends JogadorAbstractInterface{
	
	public boolean FazerAposta();
	
	public boolean fazerAposta(float valor);
	
	public float getValorDaAposta();
	
	public void executar(BancaInterface banca);
	
	public void setEstado_atual(EstadoJogador estadoJogador);
	
	public EstadoJogador getEstado_atual();
	
	public void ganhou();
	
	public void perdeu();
	
	public void empatou();
	
	public void vinteEUm();
	
}
