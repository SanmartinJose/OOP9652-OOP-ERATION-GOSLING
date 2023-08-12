package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticLegalGuardianController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void fileWrite(HolisticLegalGuardian holisticLegalGuardian) {

        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

            try {
                System.out.println("en proceso");
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", holisticLegalGuardian.getId());
                holisticLegalGuardianDocument.append("name", holisticLegalGuardian.getName());
                holisticLegalGuardianDocument.append("age", holisticLegalGuardian.getAge());
                holisticLegalGuardianDocument.append("email", holisticLegalGuardian.getEmail());
                holisticLegalGuardianDocument.append("phoneNumber", holisticLegalGuardian.getPhoneNumber());
                holisticLegalGuardianDocument.append("studentId", holisticLegalGuardian.getStudentId());
                collection.insertOne(holisticLegalGuardianDocument);
            } catch (MongoException me) {
                System.out.println("No se pudo porr: " + me);
            }
        }
    }

    public void deleteHolisticLegalGuardian(int id) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

            Document findDocument = new Document("studentId", id);
            System.out.println(findDocument);
            collection.findOneAndDelete(findDocument);
        } catch (MongoException me) {

        }
    }

    public String getHolisticLegalGuardianList(int id) {
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
        MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

        MongoCursor<Document> cursor = collection.find().iterator();
        String legalGuardianName = "No existente";
        while (cursor.hasNext()) {
            Document name = cursor.next();
            if (name.get("studentId").equals(id)) {
                legalGuardianName = name.get("name").toString();
            }
        }
        return legalGuardianName;
    }

    public FindIterable<Document> getLegalGuardianList() {
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
        MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

        return collection.find();
    }

    public void updateHolisticLeaglGuardian(int id, HolisticLegalGuardian holisticLegalGuardian) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

            MongoCursor<Document> cursor = getLegalGuardianList().iterator();

            String oldName = null;
            int oldAge = 0;
            String oldEmail = null;
            String oldPhoneNumber = null;

            while (cursor.hasNext()) {
                Document document = cursor.next();
                if (document.get("studentId").equals(id)) {
                    oldName = document.get("name").toString();
                    oldAge = (int) document.get("age");
                    oldEmail = document.get("email").toString();
                    oldPhoneNumber = document.get("phoneNumber").toString();
                }
            }

            collection.updateOne(Filters.eq("name", oldName), Updates.set("name", holisticLegalGuardian.getName()));
            collection.updateOne(Filters.eq("age", oldAge), Updates.set("age", holisticLegalGuardian.getAge()));
            collection.updateOne(Filters.eq("email", oldEmail), Updates.set("email", holisticLegalGuardian.getEmail()));
            collection.updateOne(Filters.eq("phoneNumber", oldPhoneNumber), Updates.set("phoneNumber", holisticLegalGuardian.getPhoneNumber()));

        } catch (MongoException me) {

        }
    }

    public MongoCursor<Document> getLegalGuardian(int id) {

        MongoCursor<Document> cursor = null;

        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");

            Document findDocument = new Document("studentId", id);
            cursor = collection.find(findDocument).iterator();

        } catch (MongoException me) {

        }
        return cursor;
    }
}
