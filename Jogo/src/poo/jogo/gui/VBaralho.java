package poo.jogo.gui;

import poo.jogo.entidades.Baralho;
import poo.jogo.enums.CartaEnum;
import poo.jogo.enums.NaipesEnum;

public class VBaralho extends Baralho {

	
	public VBaralho(int quantidade) throws Exception {
		super(quantidade);
	}

	protected void initBaralho(int quantidade)  throws Exception{
		String [] letra = {"d", "c", "s", "h"};
		if (quantidade <= 0) throw new Exception("É preciso que tenha pelo menos um baralho");
		int k;
		VCard cartaTemp;
		for (k = 0; k < quantidade; k++) {	//for da quantidade de jogos(baralho)
			int numeroLetra = 0;
			for (NaipesEnum j : NaipesEnum.values()) {	//for dos naipes do baralho
				int numero = 1;
				for (CartaEnum i : CartaEnum.values()) {	//for das cartas do naipe
					cartaTemp = new VCard(i.name(), j.name(), "\\cartas_bmp\\" + letra[numeroLetra] + "0" + numero, "\\cartas_bmp_cut\\" + letra[numeroLetra] + "0" + numero);
					cartas.add(cartaTemp);	//e depois é adicionado no ArrayList
					numero++;
				}
				numeroLetra++;
			}
		}
	}
	
	
	
}
