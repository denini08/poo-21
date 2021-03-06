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
		this.calcularPontos();
	}
	
	public void exibirCartas() {
		for(CartaInterface i : cartas) {
			System.out.println("\t" + i.getNome()+" de "+i.getNaipe());
		}
	}

	private void calcularPontos(){
		this.ponto = 0;
		int quantidadeAS = 0;
		for(int i=0 ; i < cartas.size(); i++){
			this.ponto += this.cartas.get(i).getValor();
			if (this.cartas.get(i).getNome().name().equals("AS")) {
				quantidadeAS++;
			}
		}
		while (quantidadeAS > 0 && this.ponto > 21) {
			this.ponto = this.ponto - 10;
			quantidadeAS--;
		}
	}
	
	public int getPontos() {
		return this.ponto;
	}

	public boolean estourar(){
		if(ponto > 21){
			return true;
		}
		return false;
	}
	
	public ArrayList<CartaInterface> getCartas(){
		return this.cartas;
	}
	
}