package poo.jogo.negocio;

import poo.jogo.entidades.Carta;
import poo.jogo.entidades.Mao;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.MaoInterface;
import poo.jogo.enums.CartaEnum;

public class TESTE6 {
	public static void main(String[] args) {
		
		/*for(CartaEnum i : CartaEnum.values()) {
			System.out.println(i.name());
		}*/
		
		
		CartaInterface carta;
		try {
			carta = new Carta("AS", "OUROS");
			if (carta.getNome().name().equals("AS")) {
				System.out.println("sim");
			}
			System.out.println("sd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
