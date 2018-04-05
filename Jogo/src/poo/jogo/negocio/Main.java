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
		String nome;
		String escolha;
		float carteira;
		float valor;
		ArrayList<CartaInterface> maoJogadores;
		
		try {
			scan = new Scanner(System.in);
			n = new Negocio();
			System.out.println("------Blackjack UPE Caruaru------");
			while (true) {
				scan = new Scanner(System.in);
				System.out.println("Deseja adicionar algum jogador? [sim/nao]");
				scan.hasNext();
				escolha = scan.nextLine();
				if (escolha.equals("nao") || escolha.equals("n")){	//caso escolha não, então sai do loop
					break;
				}
				else if (escolha.equals("sim") || escolha.equals("s") ) {//caso escolha sim, então vai digitar os dados
					System.out.println("Digite o nome do Jogador que vai adicionar");
					scan.hasNext();
					nome = scan.nextLine();
					System.out.println("Digite o valor de cr�dito que "+nome+" possui");
					scan.hasNext();
					carteira = Float.parseFloat(scan.nextLine());
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
			//scan.close();
			ArrayList<String> a = n.listarNomeDosjogadores();
			
			//LISTAGEM
			System.out.println("Jogadores já Cadastrados!");
			for(int i=0; i < a.size(); i++) System.out.println(a.get(i));
			//scan = new Scanner(System.in);
			while(true) {
				System.out.println("Informe a quantidade de jogadores:");	
				try {
					scan.hasNext();
					quant = Integer.parseInt(scan.nextLine());
					if(quant >= 1 &&  quant <= 7){
						break;
					} else {
						System.out.println("Quantidade max permitida é 7 e a minima é 1"); //condicao de erro
					} 
				}catch(Exception e) {
					System.out.println("Você não digitou um número inteiro!");
				}
			}
			
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
					i--;
				}
			}
			//scan.close();

			//APOSTA
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				//scan = new Scanner(System.in);
				System.out.println("Jogador " + n.getNome(i) + " digite o valor da sua aposta");
				scan.hasNext();
				valor = scan.nextFloat();
				n.solicitarAposta(i,  valor);
			}
			//scan.close();
			
			//DISTRIBUIR
			System.out.println("Distribuindo cartas");
			n.distribuir();
			maoJogadores = n.getBancaMao();
			System.out.println("A banca possui: "+maoJogadores.get(0).getNome()+" de "+maoJogadores.get(0).getNaipe());
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				maoJogadores = n.getJogadorMao(i);
				System.out.println(n.getNome(i)+" possui:");
				System.out.println(maoJogadores.get(0).getNome()+" de "+maoJogadores.get(0).getNaipe());
				System.out.println(maoJogadores.get(1).getNome()+" de "+maoJogadores.get(1).getNaipe());
				System.out.println("Pontos: "+n.getPontosJogadorAtivo(i)  + "\n");
			}
			
			
			
			
			//JOGAR
			for (int i = 0; i < n.quantidadeJogadoresAtivos(); i++) {
				do  {
					scan = new Scanner(System.in);
					System.out.println("jogador "+n.getNome(i)+", pega ou para?");
					scan.hasNext();
					escolha = scan.nextLine();
					if (escolha.equals("pega")) {
						try{
							n.pegaCarta(i);
						}catch (Exception e){
							System.err.println(e.getMessage());
							break;
						}finally {
							maoJogadores = n.getJogadorMao(i);
							System.out.println(n.getNome(i)+" recebeu:");
							for (int j = 0; j < maoJogadores.size(); j++) {
								System.out.println(maoJogadores.get(j).getNome()+" de "+maoJogadores.get(j).getNaipe());
							}
							System.out.println("Pontos: "+n.getPontosJogadorAtivo(i) + "\n");
						}
						
					}
					else if (escolha.equals("para")) {
						break;
					}
					else {
						System.out.println("Escolha incorreta, por favor escolha novamente");
					}
				}while (true);
			}
			//IA DA BANCA
			maoJogadores = n.getBancaMao();
			System.out.println("Vez da Banca");
			System.out.println("Banca Possui:");
			System.out.println(maoJogadores.get(0).getNome()+" de "+maoJogadores.get(0).getNaipe());
			System.out.println(maoJogadores.get(1).getNome()+" de "+maoJogadores.get(1).getNaipe());
			
			while(true) {
				if (n.IaDaBanca() == true) {
					System.out.println("Banca puxa!");
					try{
						n.pegaCarta(-1);	//-1 � O ID DA BANCA
						
					}catch (Exception e) {
						System.err.println(e.getMessage());
						break;
					}finally {
						maoJogadores = n.getBancaMao();
						System.out.println("Banca recebeu:");
						for (int i = 0; i < maoJogadores.size(); i++) {
							System.out.println(maoJogadores.get(i).getNome()+" de "+maoJogadores.get(i).getNaipe());
						}
						System.out.println("Pontos: "+n.getPontosJogadorAtivo(-1)+"\n");
					}
				}else {
					System.out.println("Banca Parou");
					break;
				}
			}
			
			
			
			
			
			//FIM DO JOGO
			try{
				
				System.out.println(n.resultado());
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			n.fecharBanco();
			
		}catch(Exception e) {
		System.err.println(e.getMessage());
		}
	}
}