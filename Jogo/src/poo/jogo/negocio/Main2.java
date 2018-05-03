package poo.jogo.negocio;

import java.util.Scanner;

import poo.jogo.negocio.interf.NegocioInterface;

public class Main2 {
	public static void main (String[] args) {
		Scanner scan = null;
		String nome;
		String escolha;
		float carteira;
		NegocioInterface n;
		try {
			scan = new Scanner(System.in);
			System.out.println("------Blackjack UPE Caruaru------");
			while (true) {
				scan = new Scanner(System.in);
				System.out.println("Deseja adicionar algum jogador? [sim/nao]");
				scan.hasNext();
				escolha = scan.nextLine();
				if (escolha.equals("nao") || escolha.equals("n")){	//caso escolha não, então sai do loop
					break;
				}
				else if (escolha.equals("sim") || escolha.equals("s") ) {//caso escolha sim, entÃ£o vai digitar os dados
					System.out.println("Digite o nome do Jogador que vai adicionar");
					scan.hasNext();
					nome = scan.nextLine();
					System.out.println("Digite o valor de crédito que "+nome+" possui");
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

		}catch (Exception e) {
			
		}
			}
}
