package poo.jogo.persistencia;

import org.bson.Document;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BD {

	public static void main(String[] args) {
		
		
		MongoClient mongoClient = new MongoClient();
		System.out.println("Conexão com o MONGO feita!");
		MongoDatabase DB = mongoClient.getDatabase("jogo21");
		System.out.println("conexão com o BD feita!" + DB.getName());
		
		MongoCollection<Document> col = DB.getCollection("jogo");
		
		Document documento = new Document("nome","thomás").append("carteira", 1);
		//col.insertOne(documento);

		System.out.println("LER");
		
		FindIterable<Document> res = col.find();
		
		 for (Document document : res) {
	            System.out.println(document.toJson());
	        }

   
   
	}
}


