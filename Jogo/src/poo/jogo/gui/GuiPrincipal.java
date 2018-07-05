package poo.jogo.gui;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import poo.jogo.entidades.Carta;

public class GuiPrincipal extends JFrame implements GuiPrincipalInterface{
	private static final long serialVersionUID = 1L;
	private ArrayList<JPanel> paineisJogadores;
	private ArrayList<JPanel> paineisInfoJogadores;
	private int quantidadeJogadores;
	private ArrayList<String> jogadores;
	private ArrayList<CartasMao> cartasMao;
	
	
	
	public GuiPrincipal (int quant) {
		cartasMao = new ArrayList<CartasMao>(this.quantidadeJogadores);
		
		this.quantidadeJogadores = quant + 1;
		this.paineisJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);
		this.paineisInfoJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);
		this.jogadores = new ArrayList<>(quantidadeJogadores);
		
		for (int i = 0; i < this.quantidadeJogadores; i++) {
			JPanel painelTemp = new JPanel();
			JPanel painelInfo = new JPanel();
			this.paineisJogadores.add(painelTemp);
			this.paineisInfoJogadores.add(painelInfo);
			cartasMao.add(i, null);
			
		}
		this.setTitle("Mesa");
		this.setSize(1024, 860);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		this.criarPaineis();
		
		//Cartas mao
/*		CartasMao c = new CartasMao(null,null);
		cartasMao.add(0, c);*/
		}
	
	private void criarPaineis() {
		int WidthInfo = 600;
		int HeighInfo = 25;
		int WidthPainel = 600;
		int HeighPainel = 120;
		int yPar = 50;
		int yImpar = 50;

		
		
		
		
		for (int i = 0; i < quantidadeJogadores; i++) {
			JPanel painelInfoJogador = this.paineisInfoJogadores.get(i);
			JPanel painelJogador = this.paineisJogadores.get(i);
			
			
			painelInfoJogador.add(new JLabel(""));  //nome getComponent(0)
			painelInfoJogador.add(new JLabel("")); //Estado getComponent(1)
			painelInfoJogador.add(new JLabel("$")); //aposta getComponent(2)
			painelInfoJogador.add(new JLabel(""));	//Pontos getComponent(3)
			
			painelInfoJogador.setBackground(new Color(169, 169, 169, 150));
			painelInfoJogador.setSize(WidthInfo, HeighInfo);
			painelJogador.setBackground(new Color(0, 0, 0, 150));
			painelJogador.setSize(WidthPainel, HeighPainel);
			if (i%2 == 0) {
				painelInfoJogador.setBounds(30, yPar, WidthInfo, HeighInfo);
				yPar = yPar + HeighInfo;
				painelJogador.setBounds(30, yPar, WidthPainel, HeighPainel);
				yPar = yPar + HeighPainel + 10;
			}else {
				painelInfoJogador.setBounds(WidthPainel+140, yImpar, WidthInfo, HeighInfo);
				yImpar = yImpar + HeighInfo;
				painelJogador.setBounds(WidthPainel+140, yImpar, WidthPainel, HeighPainel);
				yImpar = yImpar + HeighPainel + 10;
			}
			
			
			this.add(paineisInfoJogadores.get(i));
			this.add(this.paineisJogadores.get(i));
			
			
			
			
		}
		
		this.addBanca();  //adicionando a banca junto com sua label
		JPanel geral = new JPanel();
		this.add(geral);
		
		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon("..\\Imagem do Jogo\\table.jpg"));
		geral.add(imagem);
		
	}
	

	private void addBanca() {
		this.inserirJogador("BANCA", "ESPERANDO");
		JLabel label = (JLabel) this.paineisInfoJogadores.get(0).getComponent(2);
		label.setText("");
		
	}

	@Override
	public void inserirCartas(String nomeJogador, VCard Carta) {
		Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				break;
			}
		}
		
		System.out.println(index + "  index");
		
		if(index == null ) {
			System.out.println("Index não encontrado - inserirCartas " + nomeJogador);
			return;
		}
		
		
		
		
		JPanel painelJogador = this.paineisJogadores.get(index);		//add a carta nova
		JLabel cartaNova = new JLabel();
		cartaNova.setIcon(new ImageIcon(Carta.getImagem()));
		System.out.println(Carta.getImagem());
		painelJogador.add(cartaNova);
		
		this.repaint();
		
		
		//CARTAS FICAR MENOR
		try {
			JLabel labelcartaMaior = cartasMao.get(index).getLabelMaior();
			VCard cartaMaior = cartasMao.get(index).getUltimaCarta();
			labelcartaMaior.setIcon(new ImageIcon(cartaMaior.getImagemCortada()));
			System.out.println(cartaMaior.getImagemCortada() + "DENINI AQUI");
		} catch (Exception e) {
		
			System.out.println(index + "entrou trycatch");
			CartasMao c = new CartasMao(Carta,cartaNova);
			cartasMao.set(index, c);
			return;
		}
		
		System.out.println(cartasMao.size());
		cartasMao.get(index).setCarta(Carta, cartaNova);
		
		
		
	}

	@Override
	public void inserirJogador(String nomeJogador, String estadoJogador) {
		this.jogadores.add(nomeJogador);
		this.setEstado(nomeJogador, estadoJogador);
		this.setAposta(nomeJogador, 0);
		this.setNomeJogador(nomeJogador);
		
		this.repaint();
		
	}

	@Override
	public void setEstado(String nomeJogador, String estadoJogador) {
		Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				System.out.println(i + nomeJogador + estadoJogador);
				break;
			}
		}
		
		System.out.println(index + "  index");
		
		if(index == null ) {
			System.out.println("Index não encontrado - SetEstado" + nomeJogador);
			
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(1);
		j.setText(estadoJogador);
		
		this.repaint();
	}

	@Override
	public void setAposta(String nomeJogador, float valor) {
		Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				break;
			}
		}
		
		if(index == null ) {
			System.out.println("Index não encontrado - setAposta");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(2);
		j.setText("$" + valor);
		
		this.repaint();
	}
	
	public void setNomeJogador(String nomeJogador) {
	Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				break;
			}
		}
		
		if(index == null ) {
			System.out.println("Index não encontrado - setAposta");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(0);
		j.setText(nomeJogador);
		
		this.repaint();
		
	}

	@Override
	public void setPontos(String nomeJogador, int Pontos) {
		Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				break;
			}
		}
		
		if(index == null ) {
			System.out.println("Index não encontrado - setPontos");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(3);
		j.setText("Pts: " + Pontos);
		
		this.repaint();
		
	}
	
	public void fechar() {
		JLabel label = new JLabel("Criado por::::Denini Gabriel::::Geovanne Alves::::Thyago Oliveira::::Thomás Tabosa::::");
		label.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12));
		JOptionPane.showMessageDialog(null, label, "BLACKJACK - UPE CARUARU", 0, new ImageIcon("..\\Imagem do Jogo\\icon1.png"));//(null, "\t\tBLACKJACK UPE\n\t\tCreate by\n::::Denini Gabriel::::\n::::Geovanne Alves::::\n::::Thyago Oliveira::::\n::::Thomás Tabosa::::");
		this.dispose();
	}
/*	//teste papai NAO APAGAR
	public static void main (String[] args) throws Exception {
				GuiPrincipal janela = new GuiPrincipal(1);
				janela.setVisible(true);
				VCard c = new VCard("AS", "OUROS", "C:\\Users\\Denini\\Desktop\\f2\\g\\poo-21\\cartas_bmp\\c01.png",
						"C:\\Users\\Denini\\Desktop\\f2\\g\\poo-21\\cartas_bmp_cortado\\c01.png");
				VCard d = new VCard("DOIS", "OUROS", "C:\\Users\\Denini\\Desktop\\f2\\g\\poo-21\\cartas_bmp\\c02.png",
						"C:\\Users\\Denini\\Desktop\\f2\\g\\poo-21\\cartas_bmp_cortado\\c02.png");
				janela.inserirJogador("Denini", "Espearando");
				janela.inserirCartas("BANCA", d);
				janela.inserirCartas("BANCA", c);
				janela.inserirCartas("Denini", c);
				janela.inserirCartas("Denini", d);
				//janela.inserirCartas("Denini", d);
			}*/
}
