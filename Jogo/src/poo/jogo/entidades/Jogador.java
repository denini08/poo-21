package poo.jogo.entidades;


import poo.jogo.entidades.interf.JogadorInterface;

public class Jogador extends JogadorAbstract implements JogadorInterface {
	
	
	private float valorDaAposta;

	public Jogador(String nome, float saldo) {
		super(nome, saldo);
		this.valorDaAposta = 0;
	}
	
	public float getValorDaAposta() {
		return this.valorDaAposta;
	}

	public boolean fazerAposta(float valor) {
			if(this.Carteira >= valor) {	//SE O SALDO FOR MENOR QUE O VALOR DA APOSTA
				this.valorDaAposta = valor;
				return true;
		}
			return false;
	}

}
