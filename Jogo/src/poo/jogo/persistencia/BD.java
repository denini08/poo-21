package poo.jogo.persistencia;

import org.bson.Document;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import poo.jogo.persistencia.interf.BDInterface;

public class BD implements BDInterface {
	
	private static BD instancia;
	private MongoClient mongoClient;
	private MongoDatabase Bd;
	private MongoCollection<Document> colJogador;
	//private MongoCollection<Document> colBanca;
		
	private BD() {
		//MongoClientURI uri = new MongoClientURI("mongodb://datapoo21:datapoo21@host:port/db");
		MongoClientURI uri = new MongoClientURI("mongodb://datapoo21:datapoo21@ds241025.mlab.com:41025/jogo21");	
		mongoClient = new MongoClient(uri);
		//mongoClient = new MongoClient();
		Bd = mongoClient.getDatabase("jogo21");
		colJogador = Bd.getCollection("jogo");
	}
		
	//SingleTon
	public static BD getInstance() {
		if(instancia == null) {
			instancia = new BD();
		}
		return instancia;
	}
	
	//funcoes
	public void inserirJogador(Document doc) {
		colJogador.insertOne(doc);
	}
	 
	public FindIterable<Document> buscarJogador(Document doc){
		return colJogador.find(doc);
	}
	
	public FindIterable<Document> listarJogadores(){
		return colJogador.find();
	}
	
	public void deletarJogador(Document doc) {
		colJogador.deleteOne(doc);
	}
	
	public void editarJogador(Document docOld,Document docNew) {
		colJogador.updateOne(docOld, new Document("$set", docNew));
	}
	
	public void fechar() {
		this.mongoClient.close();
	}
	
	//Document documento = new Document("nome","thomás").append("carteira", 1);
		
		
		//FindIterable<Document> res = col.find();
		
		 //for (Document document : res) {
	      //      System.out.println(document.toJson());
	       // }

     
	
}


