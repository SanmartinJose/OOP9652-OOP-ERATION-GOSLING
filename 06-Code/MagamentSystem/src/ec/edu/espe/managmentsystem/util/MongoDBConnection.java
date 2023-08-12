package ec.edu.espe.managmentsystem.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class MongoDBConnection {

    public void connection(String collections) {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection(collections);

        }
    }
}
