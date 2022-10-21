package app.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ConnectDB {
	private static ConnectDB instance = null;
	private MongoClient mongoClient;
	
	private ConnectDB() {
		/* Atlas
			String uri = "mongodb+srv://admin:admin@letuan19431791.je4adoh.mongodb.net/?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(uri);
		*/
		
		//localhost
		mongoClient = MongoClients.create();
	}
	
	public static ConnectDB getInstance() {
		if(instance == null)
			instance = new ConnectDB();
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}
}
