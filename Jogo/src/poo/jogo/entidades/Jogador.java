package poo.jogo.entidades;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.CartaInterface;
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
	
	protected boolean querSolicitarCarta() {
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("jogador " + getNome() +", pega ou para?");
			scan.hasNext();
			String escolha = scan.nextLine();
			if (escolha.equals("pega") || escolha.equals("s")) {
				return true;
			}
			else if (escolha.equals("para") || escolha.equals("n")) {
				return false;
			}
			else {
				System.out.println("Escolha incorreta, por favor escolha novamente");
			}
		}
		//scan.close();
	}
	
	public float getValorDaAposta() {
		return this.valorDaAposta;
	}
	
	//CARTAS
	public void solicitarCarta(BancaInterface banca) {
		super.solicitarCarta(banca);
		System.out.println("\n " + getNome() + " Tem: ");
		getMao().exibirCartas();
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
		setCarteira(valorDaAposta * 1.5f);
		System.out.println(getNome() + "Ganhou!! Seu saldo atual eh" + getCarteira());
		
	}
	
	public void perdeu() {
		setCarteira(-valorDaAposta);
		System.out.println(getNome() + "Perdeu!! Seu saldo atual eh" + getCarteira());
	}
	
	public void empatou() {
		System.out.println(getNome() + "Empatou!! Seu saldo atual eh" + getCarteira());
	}
	
	public void vinteEUm() {
		setCarteira(valorDaAposta * 2.5f);
		System.out.println(getNome() + "Ganhou com 21!! Seu saldo atual eh" + getCarteira());
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
			banca.estourou(Jogador.this); 	//adicionando ao arraylist de jogadores estourados
			
		}

	}
	
	private class Jogar implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void maoVinteEUm() {
			setEstado_atual(getEstadoVinteEUm());
			
		}

		@Override
		public void maoEstorou() {
			
			setEstado_atual(getEstadoEstourou());
			
		}

		@Override
		public void maoAlterar() {
			//NOTIFY
			if(estorou()) {
				maoEstorou();
			} else if (pontos() == 21 ) {
				maoVinteEUm();
			}
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			
			if(querSolicitarCarta()) { // perguntar ao user se ele quer puxar
				banca.pegarCarta(Jogador.this);
				maoAlterar();
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
			
			banca.parar(Jogador.this); 	//adicionando ao arraylist de jogadores parados
			
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
