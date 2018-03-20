package poo.jogo.persistencia.interf;

import java.util.ArrayList;

public interface PersistenciaInterface {
	
	public boolean inserirJogador(String nome, int saldo);
	
	public int saldoJogador(String nome) throws Exception;
	
	public ArrayList<String> listarJogadores();
	
	public boolean removerJogador(String nome);
	
	public void editarSaldo(String nome, int saldo);
}
