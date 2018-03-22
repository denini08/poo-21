package poo.jogo.negocio;

import poo.jogo.entidades.Baralho;
import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;

public class Main1 {

	public static void main(String[] args) throws Exception {
		BaralhoInterface b = new Baralho(1);
		for (int i = 0; i < 52; i++) {
			CartaInterface c = b.retirarCarta();
			System.out.println(c.getNome()+" de "+c.getNaipe());
		}
	}

}
