package poo.jogo.persistencia.interf;

import java.util.ArrayList;

public interface PersistenciaInterface {
	
	public boolean buscarJogador(String nome);
	
	public boolean inserirJogador(String nome, float saldo);
	
	public float saldoJogador(String nome) throws Exception;
	
	public ArrayList<String> listarJogadores();
	
	public boolean removerJogador(String nome);
	
	public void editarSaldo(String nome, float saldo) throws Exception;
}
