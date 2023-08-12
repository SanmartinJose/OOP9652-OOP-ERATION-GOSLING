package ec.edu.espe.managamentsystem.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.managmentsystem.model.Teacher;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class TeacherController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void fileWritter(Teacher teacher) {
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");

            try {
                Document teacherDocument = new Document();
                teacherDocument.append("_id", teacher.getId());
                teacherDocument.append("courseId", teacher.getCourseId());
                teacherDocument.append("name", teacher.getName());
                teacherDocument.append("age", teacher.getAge());
                teacherDocument.append("address", teacher.getAddress());
                teacherDocument.append("email", teacher.getAddress());
                collection.insertOne(teacherDocument);
            } catch (MongoException me) {

            }
        }
    }

    public void updateTeacher(int id, Teacher teacher) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();

            String oldCourseId = (String) cursor.next().get("courseId");
            String oldName = (String) cursor.next().get("name");
            String oldAge = (String) cursor.next().get("age");
            String oldAddress = (String) cursor.next().get("address");
            String oldEmail = (String) cursor.next().get("email");

            collection.updateOne(Filters.eq("courseId", oldCourseId), Updates.set("courseId", teacher.getCourseId()));
            collection.updateOne(Filters.eq("name", oldName), Updates.set("name", teacher.getName()));
            collection.updateOne(Filters.eq("age", oldAge), Updates.set("age", teacher.getAge()));
            collection.updateOne(Filters.eq("address", oldAddress), Updates.set("address", teacher.getAddress()));
            collection.updateOne(Filters.eq("email", oldEmail), Updates.set("email", teacher.getEmail()));

        } catch (MongoException me) {

        }
    }

    public void deleteTeacher(int id) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");

            Document findDocument = new Document("_id", id);
            collection.findOneAndDelete(findDocument);
        } catch (MongoException me) {

        }
    }
}
