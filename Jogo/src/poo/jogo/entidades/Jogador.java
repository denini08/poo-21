package poo.jogo.entidades;


import java.util.Iterator;

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
	
	
	
	// ITERAÇÃO DE ESTADOS
	
	public void executar(BancaInterface banca) {
		
		this.estado_atual.Executar(banca);
	}
	
	public void setEstado_atual(EstadoJogador estadoJogador) {
		this.estado_atual = estadoJogador;
	}
	
	public EstadoJogador getEstado_atual() {
		
		return this.estado_atual;
	}
	
	
	//RESULTADOS
	
	public void ganhou() {
		//notify ganhou
	}
	
	public void perdeu() {
		
	}
	
	public void empatou() {
		
	}
	
	public void vinteEUm() {
		
	}
	
	
	//ESTADOS SET
	
	
	protected EstadoJogador getEstadoEsperar() {
		return new Esperar();
	}
	
	protected EstadoJogador getEstadoEstourou() {
		return new Estourou();
	}
	
	protected EstadoJogador getEstadoJogar() {
		return new Jogar();
	}
	
	protected EstadoJogador getEstadoParar() {
		return new Parar();
	}
	
	protected EstadoJogador getEstadoVinteEUm() {
		return new VinteEUm();
	}

	
	
	
	//ESTADOS IMPLEMENTS

	private class Esperar implements EstadoJogador{

		@Override
		public void maoJogavel() {
			
			setEstado_atual(getEstadoJogar());
			
		}

		@Override
		public void maoVinteEUm() {
		
			setEstado_atual(getEstadoVinteEUm());
			
		}

		@Override
		public void maoEstorou() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoAlterar() {
			//notify
			System.out.println("Mão alterada!");
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			// NAO FAZ NADA
			
		}
	}
		
	
		
	private class Estourou implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoVinteEUm() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoEstorou() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoAlterar() {
			// NAO FAZ NADA
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			banca.estourou(Jogador.this);
			
		}

	}
	
	
	
	private class Jogar implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void maoVinteEUm() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoEstorou() {
			
			setEstado_atual(getEstadoEstourou());
			
		}

		@Override
		public void maoAlterar() {
			//NOTIFY
			System.out.println("aLTEROU");
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			if(querSolicitarCarta()) { // perguntar ao user se ele quer puxar
				
				banca.pegarCarta(Jogador.this);
			} else {
				setEstado_atual(getEstadoParar());
			}
			
			estado_atual.Executar(banca);
			
			
		}

	}
	
	
	private class Parar implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoVinteEUm() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoEstorou() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoAlterar() {
			// NAO FAZ NADA
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			
			banca.parar(Jogador.this);
			
		}

	}
	
	
	private class VinteEUm implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoVinteEUm() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoEstorou() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoAlterar() {
			// NAO FAZ NADA
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			banca.vinteEUm(Jogador.this);
			
		}

	}

}
