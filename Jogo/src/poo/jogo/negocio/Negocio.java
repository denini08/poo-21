package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.entidades.Banca;
import poo.jogo.entidades.Baralho;
import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.negocio.interf.NegocioInterface;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Negocio implements NegocioInterface{
	
	private PersistenciaInterface bd = null;
	private BancaInterface banca = null;
	private ArrayList<JogadorInterface> jogadores = null;
	private BaralhoInterface baralho = null;
	
	
	public Negocio() throws Exception{
		this.bd = new Persistencia();
		this.banca = initBanca("BANCA");
		this.jogadores = new ArrayList<JogadorInterface>();
	}

	public int quantidadeJogadoresAtivos() {
		return this.jogadores.size();
	}
	
	public String getNome(int indice) {
		return this.jogadores.get(indice).getNome();
	}

	private BancaInterface initBanca(String nomeBanca) throws Exception { //INICIALIZAÇÃO DA BANCA
		BancaInterface banca;
		if(bd.buscarJogador(nomeBanca)) {
			float saldo = bd.saldoJogador(nomeBanca);
			banca = new Banca(nomeBanca, saldo);
		}else {
			banca = new Banca(nomeBanca, 0);
		}
		
		return banca;
	}
	
	private int obterIndiceDoArray(String nome) throws Exception {
		for(int i = 0; i < jogadores.size(); i++ ) {
			if(jogadores.get(i).getNome().equals(nome)) return i;
		}
		throw new Exception("Falha ao encontrar o jogador " + nome);
	}

	
	
	public void adicionarJogador(String nome, float saldo) throws Exception { 
		if(bd.inserirJogador(nome, saldo)) {
			throw new Exception("Jogador " + nome + "Adicionado com sucesso!");
		}
		
		throw new Exception("Falha ao adicionar o jogador " + nome);
	}

	
	
	public ArrayList<String> listarNomeDosjogadores() { //LISTAR NOMES QUE EXISTE NO BANCO
		return bd.listarJogadores();
	}
	
	
	
	public void selecionarJogadores(String nome) throws Exception { //SELEÇÃO PELO NOME
		if(this.bd.buscarJogador(nome)) {
			this.jogadores.add(new Jogador(nome, bd.saldoJogador(nome)));
			throw new Exception("Jogador " + nome + "selecionado!");
		}
		
		throw new Exception("Falha ao selecionar o jogador " + nome);
		
	}
	
	
	
	public void depositarNaCarteira(String nome, float deposito) throws Exception { //DEPOSITO COMPLETO
		int indice = obterIndiceDoArray(nome);
		this.jogadores.get(indice).setCarteira(deposito);
		bd.editarSaldo(nome, this.jogadores.get(indice).getCarteira());
	}
	

	public void solicitarAposta(int indice, float valor) {
		this.jogadores.get(indice).fazerAposta(valor);
		
		
	}

	@Override
	public void embaralhar() throws Exception {
		// TODO Auto-generated method stub
		this.baralho = new Baralho(4);
	}

	@Override
	public void distribuir() {
		int i;
		banca.solicitarCarta( this.baralho.retirarCarta() );	//puxa a 1ª carta para a banca
		banca.solicitarCarta( this.baralho.retirarCarta() );	//puxa a 2ª carta para a banca
		for (i = 0; i < jogadores.size(); i++) {	//for pra pecorrer todos os jogadores
			jogadores.get(i).solicitarCarta( this.baralho.retirarCarta() );	//puxa a 1ª carta para o jogador
			jogadores.get(i).solicitarCarta( this.baralho.retirarCarta() );	//puxa a 2ª carta para o jogador
		}
	}

	@Override
	public void jogar() {
		boolean fim = false;
		while (fim == false) {
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resultado() {
		// TODO Auto-generated method stub
		
	}






	
	

}
