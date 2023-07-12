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

import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentController {
    
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";
     
    public void fileWritter(HolisticStudent holisticStudent){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
                        
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", holisticStudent.getId());
                holisticLegalGuardianDocument.append("name", holisticStudent.getName());
                holisticLegalGuardianDocument.append("age", holisticStudent.getAge());
                holisticLegalGuardianDocument.append("address", holisticStudent.getAddress());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
    public void updateHolisticStudent(int id, HolisticStudent holisticStudent){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
            
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id",id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            
            String oldName = (String) cursor.next().get("name");
            String oldAge = (String) cursor.next().get("age");
            String oldAddress = (String) cursor.next().get("address");
            
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", holisticStudent.getName()));
            collection.updateOne(Filters.eq("age",oldAge), Updates.set("age", holisticStudent.getAge()));
            collection.updateOne(Filters.eq("address",oldAddress), Updates.set("address", holisticStudent.getAddress()));
            
        }catch(MongoException me){

        }
    }
    
    public void deleteHolisticStudent(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
