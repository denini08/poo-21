package poo.jogo.entidades;

import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.entidades.interf.MaoInterface;

public class Jogador implements JogadorInterface {
	
	private String nome;
	private float Carteira;
	private MaoInterface mao;

	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public float getCarteira() {
		return Carteira;
	}

	public int pontos() {
		return this.mao.getPontos();
	}

	public float fazerAposta() {
		return 0;
	}
	
	public void solicitarCarta(CartaInterface c) {
		this.mao.receberCartas(c);
	}

	public void parar() {
		
	}

}
