package poo.jogo.entidades.interf;

import poo.jogo.enums.CartaEnum;
import poo.jogo.enums.NaipesEnum;

public interface CartaInterface {
	
	public int getValor();	//saber o valor da carta
	public NaipesEnum getNaipe();	//Saber o naipe da carta
	public CartaEnum getNome();	//saber qual a carta, o seu nome
}
