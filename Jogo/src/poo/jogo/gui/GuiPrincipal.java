package poo.jogo.gui;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiPrincipal extends JFrame implements GuiPrincipalInterface{
	private static final long serialVersionUID = 1L;
	private ArrayList<JPanel> paineisJogadores;
	private ArrayList<JPanel> paineisInfoJogadores;
	private int quantidadeJogadores;
	private ArrayList<String> jogadores;
	
	
	
	
	public GuiPrincipal (int quant) {
		this.quantidadeJogadores = quant + 1;
		this.paineisJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);
		this.paineisInfoJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);
		this.jogadores = new ArrayList<>(quantidadeJogadores);
		
		for (int i = 0; i < this.quantidadeJogadores; i++) {
			JPanel painelTemp = new JPanel();
			JPanel painelInfo = new JPanel();
			this.paineisJogadores.add(painelTemp);
			this.paineisInfoJogadores.add(painelInfo);
		}
		this.setTitle("Mesa");
		this.setSize(1024, 860);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		this.criarPaineis();
		}
	
	private void criarPaineis() {
		int WidthInfo = 600;
		int HeighInfo = 25;
		int WidthPainel = 600;
		int HeighPainel = 120;
		int yPar = 0;
		int yImpar = 0;

		
		
		
		
		for (int i = 0; i < quantidadeJogadores; i++) {
			JPanel painelInfoJogador = this.paineisInfoJogadores.get(i);
			JPanel painelJogador = this.paineisJogadores.get(i);
			
			
			painelInfoJogador.add(new JLabel("Nome: "));  //getComponent(0)
			painelInfoJogador.add(new JLabel("Estado: ")); //getComponent(1)
			painelInfoJogador.add(new JLabel("Aposta: ")); //getComponent(2)
			
			painelInfoJogador.setBackground(Color.PINK);
			painelInfoJogador.setSize(WidthInfo, HeighInfo);
			painelJogador.setBackground(Color.BLUE);
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
		
	}
	

	private void addBanca() {
		this.inserirJogador("Banca", "Comencando");
		
	}

	@Override
	public void inserirCartas(String nomeJogador, VCard Carta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirJogador(String nomeJogador, String estadoJogador) {
		this.jogadores.add(nomeJogador);
		this.setEstado(nomeJogador, estadoJogador);
		this.setAposta(nomeJogador, 1500);
		this.setNomeJogador(nomeJogador);
		
	}

	@Override
	public void setEstado(String nomeJogador, String estadoJogador) {
		Integer index  = null ;
		
		for(int i = 0 ; i < this.jogadores.size(); i++) {			//encontrando a posicao do jogador no array
			if(this.jogadores.get(i).equals(nomeJogador)) {
				index = i;
				break;
			}
		}
		
		if(index == null ) {
			System.out.println("fudeo SetEstado");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(1);
		j.setText("Estado: " + estadoJogador);
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
			System.out.println("fudeo setAposta");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(2);
		j.setText("Valor Apostado:" + valor);
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
			System.out.println("fudeo setAposta");
			return;
		}
		
		JLabel j = (JLabel) this.paineisInfoJogadores.get(index).getComponent(0);
		j.setText("Nome: " + nomeJogador);
		
	}

	public static void main (String[] args) {
		GuiPrincipal janela = new GuiPrincipal(1);
		janela.setVisible(true);
		
		janela.inserirJogador("Denini", "Espearando");
	}

}
