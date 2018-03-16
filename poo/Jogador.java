package poo;

public class Jogador implements JogadorInteface {
	
	private int ID;
	private String nome;
	private Mao mao;
	boolean estourou;
	
	public Jogador(int iD, String nome, Mao mao) {
		this.ID = iD;
		this.nome = nome;
		this.mao = mao;
		this.estourou = false;
	}

	public String getNome() {
		return this.nome;
	}

	public int getID() {
		return this.ID;
	}
	
	public int pontos() {
		int pontos = mao.getPontos();
		if(pontos > 21) {
			this.estourou = true;
		}
		return pontos;
	}
	
	public void parar() {
		//passar para o proximo
	}
	public void  receberCarta(){ 
		//pegar a carta;;;;
		//mostrar carta a todos;;;;
		//ver se estourou/;;;;;
	}

}
