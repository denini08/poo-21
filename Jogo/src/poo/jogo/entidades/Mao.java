package poo.jogo.entidades;
import java.util.ArrayList;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.MaoInterface;


public class Mao implements MaoInterface{
	private int ponto;
	private ArrayList<CartaInterface> cartas;
	
	public Mao() {
		this.ponto = 0;
		this.cartas = new ArrayList<CartaInterface>();
	}
	

	public void receberCartas(CartaInterface c){
		cartas.add(c);
		pontos();
	}

	private int pontos(){
		this.ponto = 0;
		for(int i=0 ; i < cartas.size(); i++){
			this.ponto += this.cartas.get(i).getValor();
		}
		estourar();
		return ponto;
	}

	public boolean estourar(){
		if(ponto > 21){
			return true;
		}
		return false;
	}
	
	public int getPontos(){
		return this.ponto;
	}
	
	public ArrayList<CartaInterface> getCartas(){
		return this.cartas;
	}
	


}