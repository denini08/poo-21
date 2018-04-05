package poo.jogo.entidades;

import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;

public class Banca extends Jogador implements BancaInterface{
	
	private BaralhoInterface baralho;
	

	public Banca(String nome, float saldo) throws Exception {
		super(nome,saldo);
		this.baralho = new Baralho(4);
	}
	
	public CartaInterface retirarCarta() {
		return this.baralho.retirarCarta();
	}
	
	public int getQuantBaralho() {
		return this.baralho.getQuantidadeCartas();
	}
	
	public void embaralhar() {
		this.baralho.embaralhar();
	}
}
