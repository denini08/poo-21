package poo.jogo.entidades;

import java.util.ArrayList;
import java.util.Random;

import poo.jogo.entidades.interf.BaralhoInterface;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.enums.CartaEnum;
import poo.jogo.enums.NaipesEnum;

public class Baralho implements BaralhoInterface{
	
	//ArrayLista com as cartas do jogo
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	//Construtor: Passar por parametro a quantidade de jogos que serão utilizados
	public Baralho(int quantidade) throws Exception{
		this.initBaralho(quantidade);
		this.embaralhar();	//por fim o baralho é embaralhado
		
	}
	
	private void initBaralho(int quantidade) throws Exception{
		if (quantidade <= 0) throw new Exception("É preciso que tenha pelo menos um baralho");
		int k;
		Carta cartaTemp;
		for (k = 0; k < quantidade; k++) {	//for da quantidade de jogos(baralho)
			for (NaipesEnum j : NaipesEnum.values()) {	//for dos naipes do baralho
				for (CartaEnum i : CartaEnum.values()) {	//for das cartas do naipe
					cartaTemp = new Carta(i.name(), j.name());	//o objeto é criado
					cartas.add(cartaTemp);	//e depois é adicionado no ArrayList
				}
			}
		}
	}
	
	//puxar uma carta do baralho
	public CartaInterface retirarCarta() {
		return cartas.remove(cartas.size() - 1);
	}
	
	//Saber a quantidade de cartas no baralho
	public int getQuantidadeCartas() {
		return cartas.size();
	}
	
	
	public void embaralhar() {
		int tamanho = this.cartas.size();
		Random gerador = new Random();	//gerador de números randomico
		ArrayList<Carta> baralhoTemp = new ArrayList<Carta>();	//array temporario para armazenar as cartas embaralhadas
		for (int i = 0; i < tamanho; i++) {
			int index = gerador.nextInt(cartas.size());	//gera o indice da carta que será puxada, número máximo é o limite de cartas no baralho
			baralhoTemp.add(cartas.remove(index));	//é adicionado no array temporário
		}
		cartas = baralhoTemp;	//por fim é colocado no array da classe
	}
}
