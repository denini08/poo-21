package poo.jogo.negocio;

import poo.jogo.entidades.Baralho;
import poo.jogo.entidades.Carta;
import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.enums.CartaEnum;
import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) throws Exception {
		/*ArrayList<CartaEnum> baralho = new ArrayList();
		for(CartaEnum i : CartaEnum.values()) {
			baralho.add(i);
		}
		for (int i = 0; i < baralho.size(); i++) {
			System.out.println(baralho.get(i));
		}
		
		Carta carta = new Carta("TRES", "OUROS");
		System.out.println(carta.getValor());
		carta.setValorAs();
		System.out.println(carta.getValor());*/
		
		Baralho b = new Baralho(1);
		System.out.println("\n");
		int cont = b.getQuantidadeCartas();
		for (int i = 0; i <cont; i++) {
			Carta c = (Carta) b.retirarCarta();
			System.out.println(c.getNome()+" de "+c.getNaipe());
		}
	}

}
