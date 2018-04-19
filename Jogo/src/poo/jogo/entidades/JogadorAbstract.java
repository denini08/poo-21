package poo.jogo.entidades;

import java.util.ArrayList;

import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.MaoInterface;

public abstract class JogadorAbstract {
	
	private String nome;
	protected float Carteira;
	private MaoInterface mao ;

	public JogadorAbstract(String nome, float saldo) {
		this.nome = nome;
		this.Carteira = saldo;
		this.mao = new Mao();
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
	
	public int pontos() {
		return this.mao.getPontos();
	}
	
	public void solicitarCarta(BancaInterface banca) {
		this.mao.receberCartas(banca.retirarCarta());
	}
	
	public ArrayList<CartaInterface> getCartasDaMao(){
		return this.mao.getCartas();
	}

	public MaoInterface getMao() {
		return this.mao;
	}
	
	public boolean estorou() {
		return this.mao.estourar();
	}

	
}
