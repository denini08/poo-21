package poo.jogo.negocio;

import java.util.ArrayList;

import poo.jogo.negocio.interf.NegocioInterface;


public class Main {

	public static void main(final String[] args)  {
		NegocioInterface n;
		
		
		try {
			
			n = new Negocio();
			
			//CRIAR
			/**Deseja adicionar jogador? se sim adicione, se n�o passe. quer adicionar outro? ...**/
			/**tem alguem no banco ? se sim continue , se n�o ... Porfavor adicione um jogador**/
			
			
			
			
			
			ArrayList<String> a = n.listarNomeDosjogadores();
			//LISTAGEM
			System.out.println("Jogadores j� Cadastrados!"); 
			for(int i=0; i < a.size(); i++) System.out.println(a.get(i));
			
			
			
			
			
			//SELE��O
			System.out.println("Digite o nome de cada Jogador que ir� participar do jogo");
			System.out.println("Para finalizar digite '#' ");
			while(true) {
				
				System.out.println("Digite o nome do Jogador! . . .");
				String nome;
				//scaner no nome
				
				if(nome == "#") {
					break;
				}
				n.selecionarJogadores(nome);
			}
			
			
			
			
			//APOSTA
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				System.out.println("Jogador " + n.getNome(i) + "Digite o valor da sua aposta");
				float valor = 0;
				//scanf
				n.solicitarAposta(i,  valor);
			}
			
			
			
			
			
			
			//DISTRIBUIR
			n.distribuir();
			
			
			
			
			
			
			//JOGAR
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				System.out.println("jogador "+n.getNome(i)+", pega ou passa?");
				//scanf(scolha);
			}
			
			
			
			//FIM DO JOGO
			
			
		}catch(Exception e) {}
		
	}
		
}
