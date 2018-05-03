package poo.jogo.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.print.attribute.standard.JobOriginatingUserName;

import poo.jogo.entidades.Jogador.Esperar;
import poo.jogo.entidades.Jogador.Estourou;
import poo.jogo.entidades.Jogador.Jogar;
import poo.jogo.entidades.Jogador.Parar;
import poo.jogo.entidades.Jogador.VinteEUm;
import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.JogadorInterface;

public class Banca extends JogadorAbstract implements BancaInterface{
	
	private BaralhoInterface baralho;
	private EstadoJogador Estado_atualBanca;
	private ArrayList<JogadorInterface> jogadoresEstourou;
	private ArrayList<JogadorInterface> jogadoresVinteEUm;
	private ArrayList<JogadorInterface> jogadoresParou;
	private ArrayList<JogadorInterface> jogadoresQuerCarta;
	private ArrayList<JogadorInterface> jogadoresTodos;
	private ArrayList<JogadorInterface> jogadoresEsperando;
	

	public Banca(String nome, float saldo) throws Exception {
		super(nome,saldo);
		this.baralho = new Baralho(4);
		this.jogadoresEstourou = new ArrayList<JogadorInterface>();
		this.jogadoresVinteEUm = new ArrayList<JogadorInterface>();
		this.jogadoresParou = new ArrayList<JogadorInterface>();
		this.jogadoresQuerCarta = new ArrayList<JogadorInterface>();
		this.jogadoresTodos = new ArrayList<JogadorInterface>();
		this.jogadoresEsperando = new ArrayList<JogadorInterface>();
		this.Estado_atualBanca = getEstadoEsperar();
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
	
	
	public void  solicitarCarta() {
		super.solicitarCarta(this);
	}

		
	//INIT
	
	public void obterJogadores(JogadorInterface jogador) {
		this.jogadoresTodos.add(jogador);
	}
	
	public void iniciar() {
		this.Estado_atualBanca.Executar(this);
	}
	
	//COMUNICACAO
	
	@Override
	public void pegarCarta(JogadorInterface jogador) {
		this.jogadoresQuerCarta.add(jogador);
		
		
	}

	@Override
	public void vinteEUm(JogadorInterface jogador) {
		this.jogadoresVinteEUm.add(jogador);
		
	}

	@Override
	public void estourou(JogadorInterface jogador) {
		this.jogadoresEstourou.add(jogador);
		
	}

	@Override
	public void parar(JogadorInterface jogador) {
		this.jogadoresParou.add(jogador);
		
	}
	
	
	
	
	//ESTADOS SET
	
	private void setEstado_atualBanca(EstadoJogador estado) {
		this.Estado_atualBanca = estado;
	}
	
	private EstadoJogador getEstado_atualBanca() {
		return this.Estado_atualBanca;
	}
	
	protected EstadoJogador getEstadoEsperar() {
		return new BancaEsperar();
	}
	
	protected EstadoJogador getEstadoEstourou() {
		return new BancaEstourou();
	}
	
	protected EstadoJogador getDistribuirCartas() {
		return new BancaDistribuirCartas();
	}
	
	protected EstadoJogador getEstadoParar() {
		return new BancaParar();
	}
	
	protected EstadoJogador getEstadoVinteEUm() {
		return new BancaVinteEUm();
	}
	
	protected EstadoJogador getEstadoJogar() {
		return new BancaJogar(); //é pra usar o de jogador! SDS!
	}

	
	
	
	//ESTADOS IMPLEMENTS

	private class BancaEsperar implements EstadoJogador{

		@Override
		public void maoJogavel() {
			
			//NAO FAZ NADA
			
		}

		@Override
		public void maoVinteEUm() {
		
			//NAO FAZ NADA
			
		}

		@Override
		public void maoEstorou() {
			// NAO FAZ NADA
			
		}

		@Override
		public void maoAlterar() {
			//notify
			//System.out.println("Mão alterada!");
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			//Collections.copy(jogadoresEsperando, jogadoresTodos);
			
			if(!jogadoresEsperando.isEmpty()) {
				JogadorInterface jogador = (JogadorInterface) jogadoresEsperando.get(0);
				jogadoresEsperando.remove(jogador);
				jogador.executar(banca);
			}else {
				setEstado_atualBanca(getEstadoJogar());
				//MOSTRAR CARTA
				getEstado_atualBanca().Executar(banca);
			}
			
		}
	}
		
	
		
	private class BancaEstourou implements EstadoJogador{

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
			Iterator<JogadorInterface> i = jogadoresParou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhou();
			}
			
			i = jogadoresVinteEUm.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhou();
			}
			
			i = jogadoresEstourou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.perdeu();
			}
		}

	}
	
	
	
	private class BancaDistribuirCartas implements EstadoJogador{

		@Override
		public void maoJogavel() {
			setEstado_atualBanca(getEstadoEsperar());
			
		}

		@Override
		public void maoVinteEUm() {
			setEstado_atualBanca(getEstadoVinteEUm());
			//notify
			
		}

		@Override
		public void maoEstorou() {
			
			// NAO FAZ NADA 
			
		}

		@Override
		public void maoAlterar() {
			// NAO FAZ NADA - notify
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			//distribuir
			getEstado_atualBanca().Executar(banca);
			
		}

	}
	
	
	private class BancaParar implements EstadoJogador{

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
			
			Iterator<JogadorInterface> i = jogadoresParou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				if(jogador.getMao().getPontos() == banca.getMao().getPontos()) {
					jogador.empatou();
				} else if(jogador.getMao().getPontos() > banca.getMao().getPontos()) {
					jogador.ganhou();
				} else {
					jogador.perdeu();
				}
			}
			
			i = jogadoresVinteEUm.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhou();
			}
			
			i = jogadoresEstourou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.perdeu();
			}
			
		}

	}
	
	
	private class BancaVinteEUm implements EstadoJogador{

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
			// NAO FAZ NADA - notify
			
		}

		@Override
		public void Executar(BancaInterface banca) {

			Iterator<JogadorInterface> i = jogadoresTodos.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				if(jogador.getMao().getPontos() == 21) {
					jogador.empatou();
				}else {
					jogador.perdeu();
				}
			}
			
		}

	}
	
	

}
