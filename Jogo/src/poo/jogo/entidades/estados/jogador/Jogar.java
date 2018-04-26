package poo.jogo.entidades.estados.jogador;

import poo.jogo.entidades.estados.EstadoJogador;
import poo.jogo.entidades.interf.BancaInterface;

public class Jogar implements EstadoJogador{

	@Override
	public void maoJogavel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maoVinteEUm() {
		// NAO FAZ NADA
		
	}

	@Override
	public void maoEstorou() {
		//setEstado_atual(getEstadoEstourou);
		
	}

	@Override
	public void maoAlterar() {
		//NOTIFY
		System.out.println("aLTEROU");
		
	}

	@Override
	public void Executar(BancaInterface banca) {
		//banca.jogarmais(player.this);
		
	}

}