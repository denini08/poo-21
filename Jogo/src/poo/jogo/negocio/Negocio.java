package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.negocio.interf.NegocioInterface;
import poo.jogo.persistencia.Persistencia;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Negocio{
	
	public static void main(String[] args) {
		
		PersistenciaInterface bd = new Persistencia();
		
		bd.inserirJogador("caio", 20);
		
		try {
			int res = bd.saldoJogador("josé");
			System.out.println("SALDO é de : " + res);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//ArrayList<String> s = bd.listarJogadores();
		
		//for(int i = 0; i < s.size(); i++) {
		//	System.out.println(s.get(i));
		//}
		
		//bd.editarSaldo("geovanne", 15);
		//bd.removerJogador("geovanne");
		
		
	}
	

}
