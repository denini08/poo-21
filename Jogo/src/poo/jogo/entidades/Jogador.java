package poo.jogo.entidades;


import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.estados.jogador.Esperar;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.JogadorInterface;

public class Jogador extends JogadorAbstract implements JogadorInterface {
	
	private float valorDaAposta;
	private EstadoJogador estado_atual;

	public Jogador(String nome, float saldo) {
		super(nome, saldo);
		this.valorDaAposta = 0;
		this.estado_atual = getEstadoEsperar();
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
	
	public void executar(BancaInterface banca) {
		
		this.estado_atual.Executar(banca);
	}
	
	public void setEstado_atual(EstadoJogador estadoJogador) {
		this.estado_atual = estadoJogador;
	}
	
	public EstadoJogador getEstado_atual() {
		
		return this.estado_atual;
	}
	
	
	//ESTADOS
	
	
	protected EstadoJogador getEstadoEsperar() {
		return new Esperar();
	}

}
