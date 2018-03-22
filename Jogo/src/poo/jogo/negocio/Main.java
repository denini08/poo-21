package poo.jogo.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import poo.jogo.entidades.interf.CartaInterface;
import poo.jogo.negocio.interf.NegocioInterface;


public class Main {

	public static void main(final String[] args)  {
		
		
		NegocioInterface n;
		Scanner scan = null;
		int quant;
		boolean continua;
		String nome;
		String escolha;
		float carteira;
		float valor;
		ArrayList<CartaInterface> maoJogadores;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("------Blackjack UPE Caruaru------");
			n = new Negocio();
			continua = false;	//condição para parar o loop
			while (continua == false) {
				scan = new Scanner(System.in);
				System.out.println("Deseja adicionar algum jogador? [sim/nao]");
				scan.hasNext();
				escolha = scan.nextLine();
				if (escolha.equals("nao")){	//caso escolha não, então sai do loop
					continua = true;
				}
				else if (escolha.equals("sim")) {//caso escolha sim, então vai digitar os dados
					System.out.println("Digite o nome do Jogador que vai adicionar");
					scan.hasNext();
					nome = scan.nextLine();
					System.out.println("Digite o valor de crédito que "+nome+" possui");
					scan.hasNext();
					carteira = scan.nextFloat();
					try {
						n.adicionarJogador(nome, carteira);
						System.out.println("O jogador "+nome+" foi adicionado com sucesso com o saldo de "+carteira);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else
					System.out.println("Opção não aceita, por favor digite novamente");
			}
			scan.close();
			ArrayList<String> a = n.listarNomeDosjogadores();
			//LISTAGEM
			System.out.println("Jogadores já Cadastrados!");
			for(int i=0; i < a.size(); i++) System.out.println(a.get(i));
			scan = new Scanner(System.in);
			System.out.println("Informe a quantidade de jogadores:");
			scan.hasNext();
			quant = scan.nextInt();
			for (int i = 0; i < quant; i++) {
				scan = new Scanner(System.in);
				System.out.println("Informe o nome do jogador "+(i+1)+":");
				scan.hasNextLine();
				nome = scan.nextLine();
				try {
					n.selecionarJogadores(nome);
					System.out.println("Jogador "+nome+" entrou");
				}catch( Exception e) {
					System.out.println(e.getMessage());
				}
			}
			scan.close();

			//APOSTA
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				scan = new Scanner(System.in);
				System.out.println("Jogador " + n.getNome(i) + " digite o valor da sua aposta");
				scan.hasNext();
				valor = scan.nextFloat();
				n.solicitarAposta(i,  valor);
			}
			scan.close();
			
			//DISTRIBUIR
			System.out.println("Distribuindo cartas");
			n.distribuir();
			System.out.println("A banca possui:");
			maoJogadores = n.getBancaMao();
			System.out.println("A banca possui: "+maoJogadores.get(0).getNome()+" de "+maoJogadores.get(0).getNaipe());
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				maoJogadores = n.getJogadorMao(i);
				System.out.println(n.getNome(i)+" possui:");
				System.out.println(maoJogadores.get(0).getNome()+" de "+maoJogadores.get(0).getNaipe());
				System.out.println(maoJogadores.get(1).getNome()+" de "+maoJogadores.get(1).getNaipe());
			}
			
			
			
			
			//JOGAR
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				continua = false;
				do  {
					scan = new Scanner(System.in);
					System.out.println("jogador "+n.getNome(i)+", pega ou passa?");
					scan.hasNext();
					escolha = scan.nextLine();
					if (escolha.equals("pega")) {
						n.pegaCarta(i);
						continua = true;
					}
					else if (escolha.equals("passa")) {
						continue;
					}
					else {
						System.out.println("Escolha incorreta, por favor escolha novamente");
						continua = false;
					}
				}while (continua == false);
			}
			
			
			
			//FIM DO JOGO
			n.resultado();
			
			
		}catch(Exception e) {}
		
	}
		
}
