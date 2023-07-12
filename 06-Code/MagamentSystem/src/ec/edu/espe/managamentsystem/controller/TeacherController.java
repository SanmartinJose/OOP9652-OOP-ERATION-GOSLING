/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import com.mongodb.client.result.InsertOneResult;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import ec.edu.espe.managmentsystem.model.Teacher;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class TeacherController {
    
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";
     
    public void fileWritter(Teacher teacher){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");
                        
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", teacher.getId());
                holisticLegalGuardianDocument.append("courseId", teacher.getCourseId());
                holisticLegalGuardianDocument.append("name", teacher.getName());
                holisticLegalGuardianDocument.append("age", teacher.getAge());
                holisticLegalGuardianDocument.append("address", teacher.getAddress());
                holisticLegalGuardianDocument.append("email", teacher.getAddress());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
    public void updateHolisticStudent(int id, Teacher teacher){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");
            
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id",id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            
            String oldCourseId = (String) cursor.next().get("courseId");
            String oldName = (String) cursor.next().get("name");
            String oldAge = (String) cursor.next().get("age");
            String oldAddress = (String) cursor.next().get("address");
            String oldEmail = (String) cursor.next().get("email");
            
            collection.updateOne(Filters.eq("courseId",oldCourseId), Updates.set("courseId", teacher.getCourseId()));
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", teacher.getName()));
            collection.updateOne(Filters.eq("age",oldAge), Updates.set("age", teacher.getAge()));
            collection.updateOne(Filters.eq("address",oldAddress), Updates.set("address", teacher.getAddress()));
            collection.updateOne(Filters.eq("email",oldEmail), Updates.set("email", teacher.getEmail()));
            
        }catch(MongoException me){

        }
    }
    
    public void deleteHolisticStudent(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Teacher");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
