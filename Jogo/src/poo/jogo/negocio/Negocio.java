package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.negocio.interf.NegocioInterface;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Negocio{
	
	public static void main(String[] args) {
		
		PersistenciaInterface bd = new Persistencia();
		
		bd.inserirJogador("geovanne", 20);
		
		int res = bd.saldoJogador("thiago");
		System.out.println("SALDO é de : " + res);
		
		ArrayList<String> s = bd.listarJogadores();
		
		for(int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
		
		bd.editarSaldo("geovanne", 15);
		//bd.removerJogador("geovanne");
		
		
	}
	

}
