package poo.jogo.gui;


public interface GuiPrincipalInterface {

	public void inserirCartas(String nomeJogador, VCard Carta);
	
	public void inserirJogador(String nomeJogador, String estadoJogador);
	
	public void setEstado(String nomeJogador, String estadoJogador);
	
	public void setAposta(String nomeJogador, float valor);
	
	public void setPontos(String nomeJogador, int Pontos);
	
	public void setVisible(boolean bool);
	
}
