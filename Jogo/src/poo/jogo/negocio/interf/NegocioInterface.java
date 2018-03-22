package poo.jogo.negocio.interf;

import java.util.ArrayList;

public interface NegocioInterface {
		
		public void adicionarJogador(String nome, float saldo) throws Exception;
		
		public ArrayList<String> listarNomeDosjogadores();
		
		public void selecionarJogadores(String nome) throws Exception;
		
		public void depositarNaCarteira(String nome, float deposito) throws Exception;
		
		public void solicitarAposta(int indice, float valor); 
		
		public void embaralhar() throws Exception;
		
		public void distribuir();
		
		public void jogar();
		
		public void resultado();
		
		public int quantidadeJogadoresAtivos();
		
		public String getNome(int indice);
		
		
}
