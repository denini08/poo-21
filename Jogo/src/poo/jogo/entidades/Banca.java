package poo.jogo.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.JOptionPane;

/*import poo.jogo.entidades.Jogador.Esperar;
import poo.jogo.entidades.Jogador.Estourou;
import poo.jogo.entidades.Jogador.Jogar;
import poo.jogo.entidades.Jogador.Parar;
import poo.jogo.entidades.Jogador.VinteEUm;*/
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
	private ArrayList<JogadorInterface> jogadoresTodos;
	
	

	public Banca(String nome, float saldo) throws Exception {
		super(nome,saldo);
		this.baralho = new Baralho(4);
		this.jogadoresEstourou = new ArrayList<JogadorInterface>();
		this.jogadoresVinteEUm = new ArrayList<JogadorInterface>();
		this.jogadoresParou = new ArrayList<JogadorInterface>();
		this.jogadoresTodos = new ArrayList<JogadorInterface>();
		this.Estado_atualBanca = getBancaFazerApostas();
	}
	
	public EstadoJogador getEstado_atual() {
		
		return this.Estado_atualBanca;
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
	
	
	protected void solicitarCarta() {
		super.solicitarCarta(this);
		
	}

		
	//INIT
	
	public void obterJogadores(JogadorInterface jogador) throws Exception {
		for (int i = 0; i < this.jogadoresTodos.size(); i++) {
			if (this.jogadoresTodos.get(i).getNome().equals(jogador.getNome())) {
				throw new Exception ("Jogador já está na mesa");
			}
		}
		this.jogadoresTodos.add(jogador);
		System.out.println(jogador.getNome());
	}
	
	public void iniciar() {
		this.Estado_atualBanca.Executar(this);  //deve comecar em getBancaFazerApostas();
	}

	public void iniciarV() {
		setEstado_atualBanca(getVBancaFazerApostas());
		this.Estado_atualBanca.Executar(this);  //deve comecar em getBancaFazerApostas();
	}
	
	//COMUNICACAO
	
	@Override
	public void pegarCarta(JogadorInterface jogador) {
		//this.jogadoresQuerCarta.add(jogador);
		jogador.solicitarCarta(this);
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
	
	
	
	private void setEstado_atualBanca(EstadoJogador estado) {
		this.Estado_atualBanca = estado;
	}
	
	private EstadoJogador getEstado_atualBanca() {
		return this.Estado_atualBanca;
	}
	
	
	
	//ESTADOS SET
	
	protected EstadoJogador getBancaFazerApostas() {
		return new BancaFazerApostas();
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
		return new BancaJogar(); //é pra usar o de jogador! SDS! IA DA BANCA
	}
	
	//ESTADOS VIEW
	
	protected EstadoJogador getVBancaFazerApostas() {
		return new VBancaFazerApostas();
	}
		
	protected EstadoJogador getVEstadoEsperar() {
		return new VBancaEsperar();
	}

	protected EstadoJogador getVEstadoEstourou() {
		return new VBancaEstourou();
	}
	
	protected EstadoJogador getVDistribuirCartas() {
		return new VBancaDistribuirCartas();
	}
	
	protected EstadoJogador getVEstadoParar() {
		return new VBancaParar();
	}
	
	protected EstadoJogador getVEstadoVinteEUm() {
		return new VBancaVinteEUm();
	}
	
	protected EstadoJogador getVEstadoJogar() {
		return new VBancaJogar();
	}

	
	
	
	//ESTADOS IMPLEMENTS
	
	private class BancaJogar implements EstadoJogador{  //IA DA BANCA!!!


		@Override
		public void maoJogavel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void maoVinteEUm() {
			System.out.println("A banca fez 21!");
			setEstado_atualBanca(getEstadoVinteEUm());
			
		}

		@Override
		public void maoEstorou() {
			System.err.println("Banca Estorou!");
			setEstado_atualBanca(getEstadoEstourou());
		}

		@Override
		public void maoAlterar() {
			if(estorou()) {
				maoEstorou();
			}else if(pontos() == 21) {
				maoVinteEUm();
			}
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			int deQuantosEstouGanhando = 0;
			
			
			for (int i = 0; i < jogadoresParou.size(); i++) {	//CHECAR SE TODOS ESTOURARAM
				if (banca.pontos() > jogadoresParou.get(i).pontos()) {
					deQuantosEstouGanhando++;
				}
			}
			
			if(deQuantosEstouGanhando == jogadoresParou.size() && jogadoresVinteEUm.size() == 0){	//SE A BANCA TIVER GANHANDO DE TODOS
				setEstado_atualBanca(getEstadoParar());
				
			
			}else if (deQuantosEstouGanhando == 0  && jogadoresVinteEUm.size() >= 0){		//SE A BANCA TIVER PERDENDO DE TODOS OS VIVOS
				banca.solicitarCarta(banca);
				maoAlterar();
			
				
			}else if (banca.pontos() < 17) {
				banca.solicitarCarta(banca);
				maoAlterar();
				
				
			}else {
				setEstado_atualBanca(getEstadoParar());
			}
			System.out.println("\n Banca Tem: ");
			getMao().exibirCartas();
			
			
			getEstado_atualBanca().Executar(banca);
		}
		
	}

	private class BancaEsperar implements EstadoJogador{	//FAZER TODOS OS JOGADORES JOGAREM

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
			for (JogadorInterface jogador:jogadoresTodos) {
				jogador.getEstado_atual().Executar(banca);
			}
			setEstado_atualBanca(getEstadoJogar());		//vai para ia da banca
			getEstado_atualBanca().Executar(banca);
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
			//DISTRIBUIR
			System.out.println("Distribuindo cartas");
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < jogadoresTodos.size(); i++) {	//for pra pecorrer todos os jogadores
					jogadoresTodos.get(i).solicitarCarta(banca);	//puxa a carta para o jogador
					System.out.println("\n " + jogadoresTodos.get(i).getNome() + " Tem: ");
					jogadoresTodos.get(i).getMao().exibirCartas();
				}
				banca.solicitarCarta(banca);	//puxa a  carta para a banca
				
			}
			System.out.println("\n Banca Tem: ");
			System.out.println("\t"+banca.getMao().getCartas().get(0).getNome()+" de "+banca.getMao().getCartas().get(0).getNaipe());
			
			
			System.out.println("\n ----FIM DA DISTRIBUIÇÃO DE CARTAS----\n\n");
			if(banca.pontos() == 21) {
				maoVinteEUm();
			}else {
				maoJogavel();
				for (int i = 0; i < jogadoresTodos.size(); i++){
					jogadoresTodos.get(i).jogar(banca);
				}
			}
			getEstado_atual().Executar(banca);
			
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
				System.out.println(jogador.getMao().getPontos());
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
	
	private class BancaFazerApostas implements EstadoJogador{

		@Override
		public void maoJogavel() {
			// NAO TEM MAO AINDA
			
		}

		@Override
		public void maoVinteEUm() {
			//  NAO TEM MAO AINDA
			
		}

		@Override
		public void maoEstorou() {
			//  NAO TEM MAO AINDA
			
		}

		@Override
		public void maoAlterar() {
			//  NAO TEM MAO AINDA
			
		}

		@Override
		public void Executar(BancaInterface banca) {
			for(int i = 0 ; i < jogadoresTodos.size(); ++i) {
				jogadoresTodos.get(i).FazerAposta(banca);
			}
			setEstado_atualBanca(getDistribuirCartas());
			getEstado_atualBanca().Executar(banca);
			
		}
		
	}
	
	//VIEW ESTADOS
	
	private class VBancaEsperar extends BancaEsperar{
		
		public void Executar(BancaInterface banca) {
			for (JogadorInterface jogador:jogadoresTodos) {
				jogador.getEstado_atual().Executar(banca);
			}
			setEstado_atualBanca(getVEstadoJogar());		//vai para ia da banca
			getEstado_atualBanca().Executar(banca);
		}
	}

	private class VBancaEstourou extends BancaEstourou{
		
		public void Executar(BancaInterface banca) {
			
			String viewGanhador = "";
			String viewPrededor = "";
			Iterator<JogadorInterface> i = jogadoresParou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhouV();
				viewGanhador += "\t" + jogador.getNome() + "\n";
			}
			
			i = jogadoresVinteEUm.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhouV();
				viewGanhador += "\t" + jogador.getNome() + "\n";
			}
			
			i = jogadoresEstourou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.perdeuV();
				viewPrededor += "\t" + jogador.getNome() + "\n";
			}
			
			POPUPResVenceu(viewGanhador);
			POPUPResPerdeu(viewPrededor);
		}

	}

	private class VBancaDistribuirCartas extends BancaDistribuirCartas{
		
		public void maoJogavel() {
			
			setEstado_atualBanca(getVEstadoEsperar());
			
		}

		public void maoVinteEUm() {
			setEstado_atualBanca(getVEstadoVinteEUm());
		}
		
		public void Executar(BancaInterface banca) {
			//DISTRIBUIR
			System.out.println("Distribuindo cartas");
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < jogadoresTodos.size(); i++) {	//for pra pecorrer todos os jogadores
					jogadoresTodos.get(i).solicitarCarta(banca);	//puxa a carta para o jogador
					System.out.println("\n " + jogadoresTodos.get(i).getNome() + " Tem: ");
					jogadoresTodos.get(i).getMao().exibirCartas(); 
					//AQUI COLOCAR AS CARTAS VIEW
				}
				banca.solicitarCarta(banca);	//puxa a  carta para a banca
				
			}
			System.out.println("\n Banca Tem: ");
			System.out.println("\t"+banca.getMao().getCartas().get(0).getNome()+" de " + banca.getMao().getCartas().get(0).getNaipe());
			//AQUI COLOCAR AS CARTAS VIEW DA BANCA
			
			
			System.out.println("\n ----FIM DA DISTRIBUIÇÃO DE CARTAS----\n\n");
			if(banca.pontos() == 21) {
				maoVinteEUm();
			}else {
				maoJogavel();
				for (int i = 0; i < jogadoresTodos.size(); i++){
					jogadoresTodos.get(i).jogarV(banca);
				}
			}
			getEstado_atual().Executar(banca);
			
		}
	}

	private class VBancaParar extends BancaParar{
		
		public void Executar(BancaInterface banca) {
			String viewPerdedor = "";
			String viewEmpatou = "";
			String viewGanhador = "";
			String viewBlackJack = "";
			
			Iterator<JogadorInterface> i = jogadoresParou.iterator();
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				if(jogador.getMao().getPontos() == banca.getMao().getPontos()) {
					jogador.empatouV();
					viewEmpatou += "\t" + jogador.getNome() + "\n";
				} else if(jogador.getMao().getPontos() > banca.getMao().getPontos()) {
					jogador.ganhouV();
					viewGanhador += "\t" + jogador.getNome() + "\n";
				} else {
					jogador.perdeuV();
					viewPerdedor += "\t" + jogador.getNome() + "\n";
				}
				System.out.println(jogador.getMao().getPontos());
			}
			
			i = jogadoresVinteEUm.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.ganhouV();
				viewGanhador += "\t" + jogador.getNome() + "\n";
			}
			
			i = jogadoresEstourou.iterator();
			
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				jogador.perdeuV();
				viewPerdedor += "\t" + jogador.getNome() + "\n";
			}
			
			POPUPResBlackjack(viewBlackJack);
			POPUPResEmpatar(viewEmpatou);
			POPUPResPerdeu(viewPerdedor);
			POPUPResVenceu(viewGanhador);
		}
		
	}

	private class VBancaVinteEUm extends BancaVinteEUm{
		
		public void Executar(BancaInterface banca) {

			Iterator<JogadorInterface> i = jogadoresTodos.iterator();
			String viewPerdedor = "";
			String viewEmpatou = "";
			while(i.hasNext()) {
				JogadorInterface jogador = (JogadorInterface) i.next();
				if(jogador.getMao().getPontos() == 21) {
					jogador.empatouV();
					viewEmpatou += "\t" + jogador.getNome() + "\n";
				}else {
					jogador.perdeuV();
					viewPerdedor += "\t" + jogador.getNome() + "\n";
				}
			}
			
			POPUPResEmpatar(viewEmpatou);
			POPUPResPerdeu(viewPerdedor);
			
		}
	}

	private class VBancaFazerApostas extends BancaFazerApostas{
		
		public void Executar(BancaInterface banca) {
			for(int i = 0 ; i < jogadoresTodos.size(); ++i) {
				jogadoresTodos.get(i).FazerApostaV(banca);
			}
			setEstado_atualBanca(getVDistribuirCartas());
			getEstado_atualBanca().Executar(banca);
			
		}
	}

	private class VBancaJogar extends BancaJogar{
		
		public void maoVinteEUm() {
			JOptionPane.showMessageDialog(null, "BANCA fez BlackJack");
			setEstado_atualBanca(getVEstadoVinteEUm());
			
		}

		
		public void maoEstorou() {
			JOptionPane.showMessageDialog(null, " Banca Estourou");
			setEstado_atualBanca(getVEstadoEstourou());
		}

		
		public void maoAlterar() {
			if(estorou()) {
				maoEstorou();
			}else if(pontos() == 21) {
				maoVinteEUm();
			}
			
		}

		
		public void Executar(BancaInterface banca) {
			int deQuantosEstouGanhando = 0;
			
			
			for (int i = 0; i < jogadoresParou.size(); i++) {	//CHECAR SE TODOS ESTOURARAM
				if (banca.pontos() > jogadoresParou.get(i).pontos()) {
					deQuantosEstouGanhando++;
				}
			}
			
			if(deQuantosEstouGanhando == jogadoresParou.size() && jogadoresVinteEUm.size() == 0){	//SE A BANCA TIVER GANHANDO DE TODOS
				setEstado_atualBanca(getVEstadoParar());
				
			
			}else if (deQuantosEstouGanhando == 0  && jogadoresVinteEUm.size() >= 0){		//SE A BANCA TIVER PERDENDO DE TODOS OS VIVOS
				banca.solicitarCarta(banca);
				maoAlterar();
			
				
			}else if (banca.pontos() < 17) {
				banca.solicitarCarta(banca);
				maoAlterar();
				
				
			}else {
				setEstado_atualBanca(getVEstadoParar());
			}
			System.out.println("\n Banca Tem: ");
			//SET CARTAS PARA GUI TODO
			getMao().exibirCartas();
			
			
			getEstado_atualBanca().Executar(banca);
		}
	}
	
	private void POPUPResPerdeu(String res) {
		if(!res.isEmpty()){
	
			JOptionPane.showMessageDialog(null, "Perdedor(es) : \n" + res);
		}
	}
	
	private void POPUPResVenceu(String res) {
		if(!res.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Ganhador(es) : \n" + res);
		}
	}
	
	private void POPUPResEmpatar(String res) {
		if(!res.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Empatar : \n" + res);
		}
	}
	
	private void POPUPResBlackjack(String res) {
		if(!res.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "BlackJack('s) : \n" + res);
		}
	}
}
