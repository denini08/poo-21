package poo.jogo.entidades;


import java.util.Iterator;
import java.util.Scanner;

import poo.jogo.entidades.estados.EstadoJogador;
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
	
	protected void setValorAposta(float valor) {
		this.valorDaAposta = valor;
	}
	
	public float getValorDaAposta() {
		return this.valorDaAposta;
	}
	
	//CARTAS
	public void solicitarCarta(BancaInterface banca) {
		super.solicitarCarta(banca);
	}
	
	// ITERAÇÃO DE ESTADOS
	public void FazerAposta(BancaInterface banca) {
		setEstado_atual(getEstadoApostando());		//ESTADO APOSTANDO
		this.estado_atual.Executar(banca);
	}
	
	public void jogar(BancaInterface banca) {
		this.setEstado_atual(getEstadoJogar());
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
	
	protected EstadoJogador getEstadoApostando() {
		return new Apostando();
	}
	
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
			//ver se o cara estourou ae chama maoEstourou();
			//perguntar se o cara quer carta;
			//se ele quiser entrega a carta
			//se nao coloca ele em Parar;
			
			if(querSolicitarCarta()) { // perguntar ao user se ele quer puxar
				banca.pegarCarta(Jogador.this);
				//
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

	private class Apostando implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void maoVinteEUm() {
		
			
		}

		@Override
		public void maoEstorou() {
			
			
		}

		@Override
		public void maoAlterar() {
			
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			int valor;
			Scanner scan = new Scanner(System.in);
			while(true) {
				System.out.println("Jogador "+ getNome() + " voce dejesa apostar 10 ou 50?");
				scan.hasNext();
				valor = scan.nextInt();
				if(valor == 10 || valor == 50 || valor == 100) {
					setValorAposta(valor);
					break;
				} else {
					System.out.println("Voce digitou um valor incorreto");
				}
				
			}
			setEstado_atual(getEstadoEsperar());
			
			//scan.close();
		}
		
	}
}
