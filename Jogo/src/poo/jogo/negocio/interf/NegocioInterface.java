package poo.jogo.negocio.interf;

import java.util.ArrayList;


import poo.jogo.entidades.interf.JogadorInterface;

public interface NegocioInterface {
		
		public void adicionarJogador(String nome, float saldo) throws Exception;
		
		public ArrayList<String> listarNomeDosjogadores();
		
		public JogadorInterface selecionarJogadores(String nome) throws Exception;
		
		public void fecharBanco();
		
		//public void distribuir();
				
		//public String resultado() throws Exception;
		
		//public int quantidadeJogadoresAtivos();
		
		//public void pegaCarta(int indiceJogador) throws Exception;
		
		//public int getPontosJogadorAtivo(int indice);
		
		//public boolean IaDaBanca();
		
		
		
}
