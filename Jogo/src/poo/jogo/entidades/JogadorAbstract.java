package poo.jogo.entidades;

import java.util.ArrayList;

import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.MaoInterface;
import poo.jogo.persistencia.BD;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public abstract class JogadorAbstract {
	
	private String nome;
	protected float Carteira;
	private MaoInterface mao ;
	private PersistenciaInterface bd;

	public JogadorAbstract(String nome, float saldo) {
		this.nome = nome;
		this.Carteira = saldo;
		this.mao = new Mao();
		this.bd = new Persistencia();
	}
	
	public String getNome() {
		return this.nome;
	}

	public float getCarteira() {
		return Carteira;
	}
	
	public void setCarteira(float saldo) {    //Para somar apenas passar o valor 
		try{
			this.Carteira = this.Carteira + saldo;	//para subtrair bastar passar negativo
			bd.editarSaldo(nome, this.Carteira);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
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
