package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.entidades.Banca;
import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.negocio.interf.NegocioInterface;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Negocio implements NegocioInterface{
	
	PersistenciaInterface bd = null;
	BancaInterface banca = null;
	ArrayList<JogadorInterface> jogadores = null;
	
	
	public Negocio() throws Exception{
		this.bd = new Persistencia();
		this.banca = initBanca("BANCA");
		this.jogadores = new ArrayList<JogadorInterface>();
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
		
		throw new Exception("Falha ao seelcionar o jogador " + nome);
		
	}
	
	
	
	public void depositarNaCarteira(String nome, float deposito) throws Exception { //DEPOSITO COMPLETO
		int indice = obterIndiceDoArray(nome);
		this.jogadores.get(indice).setCarteira(deposito);
		bd.editarSaldo(nome, this.jogadores.get(indice).getCarteira());
	}
	

	public void solicitarAposta() {
		//CRIAR FOR PARA PRECORRER ARRAYLIST<JOGADORES...> RETIRANDO E TESTANDO SALDO DA APOSTA 
		//PARA CONTA UNIVERSAL(VAR) E O QUE PENSAR MAIS
		
	}

	@Override
	public void embaralhar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void distribuir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jogar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resultado() {
		// TODO Auto-generated method stub
		
	}






	
	

}
