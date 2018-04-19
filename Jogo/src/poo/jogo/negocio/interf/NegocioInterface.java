package poo.jogo.negocio.interf;

import java.util.ArrayList;

import poo.jogo.entidades.interf.CartaInterface;

public interface NegocioInterface {
		
		public void adicionarJogador(String nome, float saldo) throws Exception;
		
		public ArrayList<String> listarNomeDosjogadores();
		
		public void selecionarJogadores(String nome) throws Exception;
		
		public void depositarNaCarteira(String nome, float deposito) throws Exception;
		
		public void solicitarAposta(int indice, float valor) throws Exception; 
		
		public void embaralhar() throws Exception;
		
		public void distribuir();
				
		public String resultado() throws Exception;
		
		public int quantidadeJogadoresAtivos();
		
		public String getNome(int indice);
		
		public ArrayList<CartaInterface> getJogadorMao(int indice);
		
		public void pegaCarta(int indiceJogador) throws Exception;
		
		public int getPontosJogadorAtivo(int indice);
		
		public boolean IaDaBanca();
		
		public void fecharBanco();
		
}
