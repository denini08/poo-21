package poo.jogo.entidades;

import java.util.ArrayList;
import java.util.Random;

import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;

public class Baralho implements BaralhoInterface{

	//Strings est�ticas que ser�o usadas para criar as cartas
	private static String[] numeracao = {"AS", "DOIS", "TRES", "QUATRO", "CINCO", "SEIS", "SETE", "OITO", "NOVE", "DEZ", "VALETE", "DAMA", "REI"};
	private static String[] naipes = {"OUROS", "PAUS", "COPAS", "ESPADAS"};
	
	//ArrayLista com as cartas do jogo
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	//Construtor: Passar por parametro a quantidade de jogos que ser�o utilizados
	public Baralho(int quantidade){
		int i,j,k;
		Carta cartaTemp;
		for (k = 0; k < quantidade; k++) {	//for da quantidade de jogos
			for (j = 0; j < 4; j++) {	//for dos naipes do baralho
				for (i = 0; i < 13; i++) {	//for das cartas do naipe
					cartaTemp = new Carta(numeracao[i], naipes[j]);	//o objeto � criado
					cartas.add(cartaTemp);	//e depois � adicionado no ArrayList
				}
			}
		}
		this.embaralhar(quantidade);	//por fim o baralho � embaralhado
	}
	
	//puxar uma carta do baralho
	public CartaInterface retirarCarta() {
		return cartas.remove(cartas.size() - 1);
	}
	
	//Saber a quantidade de cartas no baralho
	public int getQuantidadeCartas() {
		return cartas.size();
	}
	
	
	private void embaralhar(int quantidade) {
		Random gerador = new Random();	//gerador de n�meros randomico
		ArrayList<Carta> baralhoTemp = new ArrayList<Carta>();	//array temporario para armazenar as cartas embaralhadas
		for (int i = 0; i < 52 * quantidade; i++) {
			int index = gerador.nextInt(cartas.size());	//gera o indice da carta que ser� puxada, n�mero m�ximo � o limite de cartas no baralho
			baralhoTemp.add(cartas.remove(index));	//� adicionado no array tempor�rio
		}
		cartas = baralhoTemp;	//por fim � colocado no array da classe
	}
}
