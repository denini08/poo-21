package poo.jogo.persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;


import poo.jogo.persistencia.interf.BDInterface;
import poo.jogo.persistencia.interf.PersistenciaInterface;

public class Persistencia implements PersistenciaInterface {
	
	private BD bd;
	private BDInterface bdInter;
	
	public Persistencia() {
		bdInter = bd.getInstance();
	}
	
	
	public boolean inserirJogador(String nome, int saldo) {
		
		if(saldoJogador(nome) == -1) {
			Document doc = new Document("nome",nome).append("carteira", saldo);
			bdInter.inserirJogador(doc);
			return true;
		}
		return false;
	}


	public int saldoJogador(String nome) {
		int res = -1;
		Document doc = new Document("nome",nome);
		FindIterable<Document> pesquisa = bdInter.buscarJogador(doc);
		if(pesquisa != null) {
			for (Document document : pesquisa ) {
				res = document.getInteger("carteira");
			}
		}
		return res;
	}

	public ArrayList<String> listarJogadores() {
		ArrayList<String> vetor = new ArrayList<String>();
		FindIterable<Document> pesquisa = bdInter.listarJogadores();
		if(pesquisa != null) {
			for (Document document : pesquisa ) {
				vetor.add(document.getString("nome"));
			}
		}
		return vetor;
	}

	public boolean removerJogador(String nome) {
		Document doc = new Document("nome",nome);
		bdInter.deletarJogador(doc);
		if(bdInter.buscarJogador(doc) == null) {
			return true;
		}		
		return false;
	}
	
	public void editarSaldo(String nome, int saldo) {
		
		Document docOld = new Document("nome",nome);
		Document docNew = new Document("carteira", saldo);
		bdInter.editarJogador(docOld, docNew);
	}

}
