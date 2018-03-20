package poo.jogo.entidades;
import java.util.ArrayList;
import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.entidades.interf.MaoInterface;


public class Mao implements MaoInterface{
	private int ponto;
	private ArrayList<CartaInterface> cartas = new ArrayList<CartaInterface>();

	public void receberCarta(CartaInterface c){
		cartas.add(c);
		pontos();
	}

	public int pontos(){
	
		for(int i=0 ; i < cartas.size(); i++){
			this.ponto = this.cartas.get(i).getValor();
		}
		estourar();
		return ponto;
	}

	public boolean estourar(){
		if(ponto > 21){
			System.out.println("FODEU!");
			return true;
		}
		return false;
	}
	
	public int getPonto(){
		return this.ponto;
	}
}