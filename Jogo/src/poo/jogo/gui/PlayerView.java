package poo.jogo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import poo.jogo.entidades.Jogador;
import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.interf.BancaInterface;

public class PlayerView extends JPanel implements EstadoJogador{
	private JPanel cartas = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private TitledBorder borda;
	
	public PlayerView (Jogador jogador) {
		super(new BorderLayout());
		this.ConstruirInterface(jogador);
	}
	
	public void ConstruirInterface (Jogador jogador) {
		this.add(cartas, BorderLayout.NORTH);
		this.borda = new TitledBorder(jogador.getNome());
		cartas.setBorder(borda);
		cartas.setBackground(new Color(35, 142, 35));
		borda.setTitleColor(Color.black);
		jogador.
	}

	@Override
	public void maoJogavel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maoVinteEUm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maoEstorou() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maoAlterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Executar(BancaInterface banca) {
		// TODO Auto-generated method stub
		
	}
}
