package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.negocio.interf.NegocioInterface;

public class Main {

	public static void main(final String[] args)  {
		NegocioInterface n;
		try {
			n = new Negocio();
			
			ArrayList<String> a = n.listarNomeDosjogadores();
			
			for(int i=0; i < a.size(); i++) System.out.println(a.get(i));
			n.solicitarAposta();	//a fazer
			n.distribuir();
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				System.out.println("jogador "+n.getNome(i)+", pega ou passa?");
				//scanf(scolha);
			}
			
		}catch(Exception e) {
			
		}
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	

}
