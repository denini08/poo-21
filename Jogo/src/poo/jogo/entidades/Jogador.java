package poo.jogo.entidades;

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

	public void setCarteira(float carteira) {
		Carteira = carteira;
	}
	
	@Override
	public int pontos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float fazerAposta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void solicitarCarta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		
	}





}
