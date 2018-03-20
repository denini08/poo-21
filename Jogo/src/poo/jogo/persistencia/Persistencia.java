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
	
	@SuppressWarnings("static-access")
	public Persistencia() {
		bdInter = bd.getInstance();
	}
	
	
	public boolean inserirJogador(String nome, int saldo) {
		
		if(obterDocumento(nome).isEmpty()) {
			Document doc = new Document("nome",nome).append("carteira", saldo);
			bdInter.inserirJogador(doc);
			return true;
		}
		return false;
	}
	
	public int saldoJogador(String nome) throws Exception {
		Document doc = obterDocumento(nome);
		if(doc.isEmpty()) {
			throw new Exception("Erro ao Obter Saldo de " + nome);
		}
		
		return doc.getInteger("carteira");
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
	
	private Document obterDocumento(String nome) {
		Document doc = new Document("nome",nome);
		FindIterable<Document> pesquisa = bdInter.buscarJogador(doc);
		Iterator<Document> iterator = pesquisa.iterator();
		
		return (iterator.hasNext()) ? (doc = (Document) iterator.next()) : (doc = new Document());
	}

}
