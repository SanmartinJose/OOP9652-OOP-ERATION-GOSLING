package ec.edu.espe.managamentsystem.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import ec.edu.espe.managmentsystem.model.HomeSchoolCourse;
import org.bson.Document;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class StudentCourseController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void writeStudentCourse(HomeSchoolCourse homeschoolcourse) {

        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");
            try {
                Document homeschoolcourseDocument = new Document();
                homeschoolcourseDocument.append("_id", homeschoolcourse.getId());
                homeschoolcourseDocument.append("name", homeschoolcourse.getName());
                collection.insertOne(homeschoolcourseDocument);
            } catch (MongoException me) {

            }
        }
    }

    public void updateStudentCoure(int id, HolisticStudent holisticStudent) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();

            String oldName = (String) cursor.next().get("name");

            collection.updateOne(Filters.eq("name", oldName), Updates.set("name", holisticStudent.getName()));
        } catch (MongoException me) {

        }
    }

    public void deleteStudentCourse(int id) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");

            Document findDocument = new Document("_id", id);
            collection.findOneAndDelete(findDocument);
        } catch (MongoException me) {

        }
    }

    public FindIterable<Document> getStudentCourse() {
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
        MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");
        return collection.find();
    }
}
