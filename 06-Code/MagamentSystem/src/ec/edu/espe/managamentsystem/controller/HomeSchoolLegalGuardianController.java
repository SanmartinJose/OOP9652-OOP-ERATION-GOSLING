package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.managmentsystem.model.HomeSchoolLegalGuardian;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class HomeSchoolLegalGuardianController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void fileWrite(HomeSchoolLegalGuardian homeSchoolLegalGuardian) {

        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolLegalGuardian");

            try {
                Document homeSchoolLegalGuardianDocument = new Document();
                homeSchoolLegalGuardianDocument.append("_id", homeSchoolLegalGuardian.getId());
                homeSchoolLegalGuardianDocument.append("name", homeSchoolLegalGuardian.getName());
                homeSchoolLegalGuardianDocument.append("age", homeSchoolLegalGuardian.getAge());
                homeSchoolLegalGuardianDocument.append("email", homeSchoolLegalGuardian.getEmail());
                homeSchoolLegalGuardianDocument.append("phoneNumber", homeSchoolLegalGuardian.getPhoneNumber());
                homeSchoolLegalGuardianDocument.append("studentId", homeSchoolLegalGuardian.getStudentId());
                collection.insertOne(homeSchoolLegalGuardianDocument);
            } catch (MongoException me) {

            }
        }
    }

    public void deleteHolisticLegalGuardian(int id) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolLegalGuardian");

            Document findDocument = new Document("studentId", id);
            collection.findOneAndDelete(findDocument);
        } catch (MongoException me) {

        }
    }
}
