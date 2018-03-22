package poo.jogo.entidades;

import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.enums.CartaEnum;
import poo.jogo.enums.NaipesEnum;

public class Carta implements CartaInterface{

	private CartaEnum nome;
	private NaipesEnum naipe;
	
	//Construtor: Nome da carta e o seu naipe, escrito de formar Ma�uscula e sem acentos
	Carta (String nome, String naipe) throws Exception{
		try{
			this.nome = CartaEnum.valueOf(nome);
		}catch (Exception e) {
			throw new Exception("Nome da Carta Inv�lido");
		}
		try{
			this.naipe = NaipesEnum.valueOf(naipe);
		}catch (Exception e) {
			throw new Exception("Naipe Incorreto");
		}
	}
	
	//Receber o valor da carta, j� definido no Enum
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
