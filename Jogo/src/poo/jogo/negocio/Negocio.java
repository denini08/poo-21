package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.negocio.interf.NegocioInterface;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Negocio implements NegocioInterface{
	
	private PersistenciaInterface bd = null;
	private ArrayList<JogadorInterface> jogadores = null;
	
	
	public Negocio() throws Exception{
		this.bd = new Persistencia();
		this.jogadores = new ArrayList<JogadorInterface>();
		
	}
	
	//SE QUISER COLOCAR A BANCA NO BANCO DE DADOS
	/*public BancaInterface initBanca(String nomeBanca) throws Exception { //INICIALIZAÇÃO DA BANCA
		BancaInterface banca;
		if(bd.buscarJogador(nomeBanca)) {
			float saldo = bd.saldoJogador(nomeBanca);
			banca = new Banca(nomeBanca, saldo);
		}else {
			banca = new Banca(nomeBanca, 0);
		}
	
		return banca;
	}*/
	
	//ADICIONAR JOGADOR NO ANCO DE DADOS
	public void adicionarJogador(String nome, float saldo) throws Exception { 
		if(bd.inserirJogador(nome, saldo)) {
			return;
		}
		
		throw new Exception("Falha ao adicionar o jogador " + nome);
	}
	
	//LISTAR OS JOGADORES QUE ESÃO NO BANCO
	public ArrayList<String> listarNomeDosjogadores() { //LISTAR NOMES QUE EXISTE NO BANCO
		return bd.listarJogadores();
	}
	
	//SELECIONA O JOGADOR DO BANCO E RETORNA ELE PRARA SER ADICIONADO NO ARRAYLIST DA BANCA
	public JogadorInterface selecionarJogadores(String nome) throws Exception { //SELEÇÃO PELO NOME
		if(this.bd.buscarJogador(nome)) {
			return new Jogador(nome, bd.saldoJogador(nome));
		}
		throw new Exception("Falha ao selecionar o jogador " + nome);
	}

	//FECHA O BANCO DE DADOS
	public void fecharBanco () {
		this.bd.fecharBanco();
	}
	
	
	
	
	
	
	//PROVAVELMENTE VAI SAIR
	public int quantidadeJogadoresAtivos() {
		return this.jogadores.size();
	}	
	
	//BANCO
	/*
	public void depositarNaCarteira(String nome, float deposito) throws Exception { //DEPOSITO COMPLETO
		int indice = obterIndiceDoArray(nome);
		this.jogadores.get(indice).setCarteira(deposito);
		bd.editarSaldo(nome, this.jogadores.get(indice).getCarteira());
	}*/
	
	//APOSTAS
	/*
	private int obterIndiceDoArray(String nome) throws Exception {
		for(int i = 0; i < jogadores.size(); i++ ) {
			if(jogadores.get(i).getNome().equals(nome)) return i;
		}
		throw new Exception("Falha ao encontrar o jogador " + nome);
	}
	

	public void solicitarAposta(int indice, float valor) throws Exception {
		if (!this.jogadores.get(indice).fazerAposta(valor)) {
			throw new Exception("Saldo insuficiente");
		}
	}*/
	
	

	//MÉTODO DE DISTRIBUIR
	/*public void distribuir() {
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < jogadores.size(); i++) {	//for pra pecorrer todos os jogadores
				jogadores.get(i).solicitarCarta( this.banca );	//puxa a carta para o jogador
			}
			banca.solicitarCarta();	//puxa a  carta para a banca
		}
	}*/
	
	//MÉTODO PRA O JOGADOR PEGAR CARTA
	/*public void pegaCarta(int indiceJogador) throws Exception {
		if (indiceJogador ==  -1) {	//-1 E O ID DA BANCA
			this.banca.solicitarCarta();
			return;
		}
		this.jogadores.get(indiceJogador).solicitarCarta(this.banca);
		if(!this.jogadores.get(indiceJogador).getMao().estourar()) {
			return;
		}
		 throw new Exception("Jogador Estorou!\n");
	}*/


	//RESULTADO
	/*public String resultado() throws Exception {
		//PEGAR CASH DA BANCA - FALAR COM OS PARÇAS
		String res = "";
		int pontosDaBanca = this.banca.pontos();
		res += "Pontuação da Banca: " + pontosDaBanca + "\n";
		
		for(int i = 0 ; i < quantidadeJogadoresAtivos(); i++) {
			int pontosDoJogador =  this.jogadores.get(i).pontos();
			res += "Jogador " +  this.jogadores.get(i).getNome() + ",sua Pontuação é de : " + pontosDoJogador; ;
			if(this.jogadores.get(i).getMao().estourar()) {
				
				float saque = (float) (this.jogadores.get(i).getValorDaAposta());
				depositarNaCarteira(this.jogadores.get(i).getNome(), -saque);
				res += " Perdeu!\n";
				
			}else if(this.banca.estorou()) {
				float deposito = (float) (this.jogadores.get(i).getValorDaAposta() * 2.5);
				depositarNaCarteira(this.jogadores.get(i).getNome(), deposito);
				res += " Ganhou!\n";
			}else if(pontosDoJogador > pontosDaBanca) {
				
				float deposito = (float) (this.jogadores.get(i).getValorDaAposta() * 2.5);
				depositarNaCarteira(this.jogadores.get(i).getNome(), deposito);
				res += " Ganhou!\n";
				
			}else if(pontosDoJogador < pontosDaBanca) {
				
				float saque = (float) (this.jogadores.get(i).getValorDaAposta());
				depositarNaCarteira(this.jogadores.get(i).getNome(), -saque);
				res += " Perdeu!\n";
				
				
			}else {
				
				res += " Empatou!\n";				
				
			}
		}
		
		return res;
	}*/
	
	
	//PONTOS
	/*public int getPontosJogadorAtivo(int indice) {
		if (indice == -1) {	//-1 E O ID DA BANCA
			return this.banca.pontos();
		}
		return this.jogadores.get(indice).getMao().getPontos();
	}*/

	
	//JOGADA DA BANCA
	/*public boolean IaDaBanca() {
		int deQuantosEstouGanhando = 0;
		boolean res;
		for (int i = 0; i < this.quantidadeJogadoresAtivos(); i++) {	//CHECAR SE TODOS ESTOURARAM
			if (!this.jogadores.get(i).estorou()) {
				if (this.banca.pontos() > this.jogadores.get(i).pontos()) {
					deQuantosEstouGanhando++;
				}
			}else {
				deQuantosEstouGanhando++;
			}
		}
		if(deQuantosEstouGanhando == this.quantidadeJogadoresAtivos()){
			res = false;
		
		}else if (deQuantosEstouGanhando == 0){
			res = true;
		}else if (this.banca.pontos() < 17) {
			res = true;
			
		}else {
			res = false;
		}
		return res;
	}*/

}
