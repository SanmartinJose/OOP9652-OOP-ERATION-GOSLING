package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class SearchController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void fileWritter(String name) {
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("SearchStudent");

            collection.drop();

            try {
                Document holisticStudentDocument = new Document();
                holisticStudentDocument.append("_id", 1);
                holisticStudentDocument.append("name", name);
                collection.insertOne(holisticStudentDocument);
            } catch (MongoException me) {

            }
        }
    }

    public String getStudent() {

        String name = null;
        Document document = null;

        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("SearchStudent");

            if (collection.countDocuments() != 0) {
                FindIterable<Document> user = null;
                user = collection.find(new Document("_id", 1));
                name = user.first().get("name").toString();
            } else {
                name = "";
            }
        } catch (MongoException me) {

        }
        return name;
    }
}
