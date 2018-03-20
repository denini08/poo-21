package poo.jogo.persistencia.interf;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public interface BDInterface {
	
	public void inserirJogador(Document doc);
	 
	public FindIterable<Document> buscarJogador(Document doc);
	
	public FindIterable<Document> listarJogadores();
	
	public void deletarJogador(Document doc);
	
	public void editarJogador(Document docOld, Document docNew);

}