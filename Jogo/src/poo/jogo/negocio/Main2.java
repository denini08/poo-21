package poo.jogo.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import poo.jogo.entidades.Banca;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.negocio.interf.NegocioInterface;

public class Main2 {
	public static void main (String[] args) {
		Scanner scan = null;
		String nome;
		String escolha;
		float carteira;
		NegocioInterface n = null;
		BancaInterface banca = null;
		int quant;
		try {
			n = new Negocio();
			banca = new Banca("BANCA", 10000);
			scan = new Scanner(System.in);
			System.out.println("------Blackjack UPE Caruaru------");
			while (true) {
				scan = new Scanner(System.in);
				System.out.println("Deseja adicionar algum jogador? [sim/nao]");
				scan.hasNext();
				escolha = scan.nextLine();
				if (escolha.equals("nao") || escolha.equals("n")){	//CASO ESCOLHA NÃO, ENTÃO ELE SAI DO LOOP
					break;
				}	
				else if (escolha.equals("sim") || escolha.equals("s") ) {	//CASO ESCOLHA SIM, ENTÃO VAI DIGITAR OS DADOS
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
				}else {
					System.out.println("Opção não aceita, por favor digite novamente");
				}
			}
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
						System.out.println("Quantidade max permitida é 7 e a minima é 1"); //LIMITE DE JOGADORES
					} 
				}catch(Exception e) {
					System.out.println("Você não digitou um número inteiro!");	//CONDIÇÃO DE ERRO
				}
			}
			for (int i = 1; i <= quant; i++) {
				scan = new Scanner(System.in);
				System.out.println("Informe o nome do jogador "+i+":");
				scan.hasNextLine();
				nome = scan.nextLine();
				try {
					banca.obterJogadores(n.selecionarJogadores(nome));
					System.out.println("Jogador "+nome+" entrou");
				}catch( Exception e) {
					System.out.println(e.getMessage());
					i--;
				}
			}
			
			
			//A PARTIR DAQUI É O INICIO DO JOGO
			banca.iniciar();
			

		}catch (Exception e) {
			
		}
			}
}
