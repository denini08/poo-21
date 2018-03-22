package poo.jogo.entidades;

import java.util.ArrayList;

import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.entidades.interf.MaoInterface;

public class Jogador implements JogadorInterface {
	
	private String nome;
	private float Carteira;
	private float valorDaAposta;
	private MaoInterface mao;

	public Jogador(String nome, float saldo) {
		this.nome = nome;
		this.Carteira = saldo;
	}
	
	public String getNome() {
		return this.nome;
	}

	public float getCarteira() {
		return Carteira;
	}
	
	public void setCarteira(float saldo) {    //Para somar apenas passar o valor 
		this.Carteira = this.Carteira + saldo;//para subtrair bastar passar negativo
	}
	
	public float getValorDaAposta() {
		return this.valorDaAposta;
	}
	
	public int pontos() {
		return this.mao.getPontos();
	}

	public boolean fazerAposta(float valor) {
			if(this.Carteira >= valor) {
				this.valorDaAposta = valor;
				return true;
		}
			return false;
	}
	
	public void solicitarCarta(CartaInterface c) {
		this.mao.receberCartas(c);
	}
	
	public ArrayList<CartaInterface> getMao(){
		return this.mao.getCartas();
	}


}
