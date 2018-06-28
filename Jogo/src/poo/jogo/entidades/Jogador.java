package poo.jogo.entidades;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
			System.out.println("pega ou para?");
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
	
	private String solicitarPOPUP(String nome) {
		String[] valor = {"pega","para"};
		return valor[slaveSolicitarPOPUP(nome)];
	}
	
	private int slaveSolicitarPOPUP(String nome) {
		Object[] escolhas = {"PEGAR", "PARAR"};
		int index = JOptionPane.showOptionDialog(null, nome + " , você deseja pegar ou puxar?", "Jogar", 0, JOptionPane.INFORMATION_MESSAGE, null, escolhas, 0);
		if(index == JOptionPane.CLOSED_OPTION) {
			System.out.println("fechou miseravel");
			index = slaveSolicitarPOPUP(nome);
		}
		return index;
	}
	
	protected boolean VquerSolicitarCarta() {
		while(true){
			System.out.println("pega ou para?");
			
			String escolha = this.solicitarPOPUP(getNome()); // HIT BUTTON
			
			if (escolha.equals("pega") || escolha.equals("s")) {
				return true;
			}
			if (escolha.equals("para") || escolha.equals("n")) {
				return false;
			}
		}
	}
	
	protected void detalhamentoMao() {
		System.out.println("\n\njogador "+ getNome());
		getMao().exibirCartas();
		System.out.println("\tPontos: "+getMao().getPontos());
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
	
	//ITERAÇÃO DE ESTADOS - VIEW
	
	public void FazerApostaV(BancaInterface banca) {
		setEstado_atual(getVEstadoApostando());		//ESTADO APOSTANDO
		this.estado_atual.Executar(banca);
	}
	
	public void jogarV(BancaInterface banca) {
		this.setEstado_atual(getVEstadoJogar());
		this.estado_atual.Executar(banca);
	}
	
	
	//RESULTADOS
	
	public void ganhou() {
		setCarteira(valorDaAposta * 1.5f);
		System.out.println(getNome() + " Ganhou!! Seu saldo atual é " + getCarteira());
		
	}
	
	public void perdeu() {
		setCarteira(-valorDaAposta);
		System.out.println(getNome() + " Perdeu!! Seu saldo atual é " + getCarteira());
	}
	
	public void empatou() {
		System.out.println(getNome() + " Empatou!! Seu saldo atual é " + getCarteira());
	}
	
	public void vinteEUm() {
		setCarteira(valorDaAposta * 2.5f);
		System.out.println(getNome() + " Ganhou com 21!! Seu saldo atual é " + getCarteira());
	}
	
	// RESULTADOS VIEW
	
	public void ganhouV() {
		setCarteira(valorDaAposta * 1.5f);
		System.out.println(getNome() + " Ganhou!! Seu saldo atual é " + getCarteira());
		//popup ganhou
		
	}
	
	public void perdeuV() {
		setCarteira(-valorDaAposta);
		System.out.println(getNome() + " Perdeu!! Seu saldo atual é " + getCarteira());
		//popup perdeu
	}
	
	public void empatouV() {
		System.out.println(getNome() + " Empatou!! Seu saldo atual é " + getCarteira());
		//popup empatou
	}
	
	public void vinteEUmV() {
		setCarteira(valorDaAposta * 2.5f);
		System.out.println(getNome() + " Ganhou com 21!! Seu saldo atual é " + getCarteira());
		//popup vinte e um 
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
	
	
	//ESTADOS SET VIEW
	
	protected EstadoJogador getVEstadoApostando() {
		return new VApostando();
	}
	
	protected EstadoJogador getVEstadoEsperar() {
		return new VEsperar();
	}
	
	protected EstadoJogador getVEstadoEstourou() {
		return new VEstourou();
	}
	
	protected EstadoJogador getVEstadoJogar() {
		return new VJogar();
	}
	
	protected EstadoJogador getVEstadoParar() {
		return new VParar();
	}
	
	protected EstadoJogador getVEstadoVinteEUm() {
		return new VVinteEUm();
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
				System.out.println("Você estorou");
				maoEstorou();
			} else if (pontos() == 21 ) {
				System.out.println("Você fez um BlackJack!!!");
				maoVinteEUm();
			}
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			detalhamentoMao();
			maoAlterar();
			if (!(getEstado_atual() instanceof Jogar)) {
				return;
			}
			if(querSolicitarCarta()) { // perguntar ao user se ele quer puxar
				banca.pegarCarta(Jogador.this);
			} else {
				setEstado_atual(getEstadoParar());
				return;
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
				System.out.println("Jogador "+ getNome() + " voce dejesa apostar 10 ou 50 ou 100?");
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
	
	
	//VIEW  ESTADOS IMPLEMENT

	private class VApostando extends Apostando {		
		
		private float apostaPOPUP(String nome) {
			float[] valor = {10,50,100};
			return valor[slaveApostaPOPUP(nome)];
		}
		
		private int slaveApostaPOPUP(String nome) {
			Object[] escolhas = {"$10", "$50", "$100"};
			int index = JOptionPane.showOptionDialog(null, nome + " Escolha sua aposta", "Aposta", 0, JOptionPane.INFORMATION_MESSAGE, null, escolhas, 0);
			
			if(index == JOptionPane.CLOSED_OPTION) {
				System.out.println("fechou miseravel");
				index = slaveApostaPOPUP(nome);
			}
			return index;
		}
		
		public void Executar(BancaInterface banca) {
			float valor = apostaPOPUP(getNome());
			setValorAposta(valor);
			setEstado_atual(getVEstadoEsperar());
		}
	}
	
	private class VEstourou extends Estourou{
		
		public void Executar(BancaInterface banca) {
			super.Executar(banca);
		}
	}
	
	private class VEsperar extends Esperar{
		
		public void maoJogavel() {
			setEstado_atual(getVEstadoJogar());
		}
		
		public void maoVinteEUm() {
			setEstado_atual(getVEstadoVinteEUm());
		}
		
		
		
	}
	
	private class VJogar extends Jogar{
		
		
		public void maoVinteEUm() {
			JOptionPane.showMessageDialog(null, getNome() + " BlackJack");
			setEstado_atual(getVEstadoVinteEUm());
			
		}

		public void maoEstorou() {
			JOptionPane.showMessageDialog(null, getNome() + " Estourou");
			setEstado_atual(getVEstadoEstourou());
			
		}
		
		public void maoAlterar() {
			if(estorou()) {
				System.out.println("Você estorou");
				maoEstorou();
			} else if (pontos() == 21 ) {
				System.out.println("Você fez um BlackJack!!!");
				maoVinteEUm();
			}
		}
		
		public void Executar(BancaInterface banca) {
			detalhamentoMao();
			maoAlterar();
			if (!(getEstado_atual() instanceof Jogar)) {
				return;
			}
			if(VquerSolicitarCarta()) { // perguntar ao user se ele quer puxar
				banca.pegarCarta(Jogador.this);
			} else {
				setEstado_atual(getVEstadoParar());
				return;
			}
			estado_atual.Executar(banca);
		}
	
	}
	
	private class VParar extends Parar{
		
		public void Executar(BancaInterface banca) {
			super.Executar(banca);
		}
		
	}
	
	private class VVinteEUm extends VinteEUm{
		public void Executar(BancaInterface banca) {
			super.Executar(banca);
			
		}
		
		}

}
