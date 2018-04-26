package poo.jogo.entidades.estados.jogador;

import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.interf.BancaInterface;
import poo.jogo.entidades.interf.JogadorInterface;
import poo.jogo.entidades.Jogador;

public class Esperar implements EstadoJogador{

	@Override
	public void maoJogavel() {
		
		//setEstado_atual();
		
	}

	@Override
	public void maoVinteEUm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maoEstorou() {
		// NAO FAZ NADA
		
	}

	@Override
	public void maoAlterar() {
		//notify
		System.out.println("Mão alterada!");
		
	}

	@Override
	public void Executar(BancaInterface banca) {
		// NAO FAZ NADA
		
	}

	
	
}
