package poo.jogo.entidades;

import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.enums.CartaEnum;
import poo.jogo.enums.NaipesEnum;

public class Carta implements CartaInterface{

	private CartaEnum nome;
	private NaipesEnum naipe;
	
	//Construtor: Nome da carta e o seu naipe, escrito de formar Maíuscula e sem acentos
	Carta (String nome, String naipe){
		this.nome = CartaEnum.valueOf(nome);
		this.naipe = NaipesEnum.valueOf(naipe);
	}
	
	//Receber o valor da carta, já definido no Enum
	public int getValor() {
		return this.nome.getValor();
	}
	
	//saber o naipe da carta
	public NaipesEnum getNaipe() {
		return this.naipe;
	}

	//saber o nome da carta
	public CartaEnum getNome() {
		return this.nome;
	}


}
