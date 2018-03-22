package poo.jogo.entidades;

import poo.jogo.entidades.interf.BancaInterface;

public class Banca extends Jogador implements BancaInterface{
	

	public Banca(String nome, float saldo) {
		super(nome,saldo);
		
	}
	
}
