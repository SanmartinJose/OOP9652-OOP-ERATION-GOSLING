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
import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticLegalGuardianController {
    
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";

    public void fileWrite(HolisticLegalGuardian holisticLegalGuardian){
        
         try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");
                        
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("name", holisticLegalGuardian.getName());
                holisticLegalGuardianDocument.append("age", holisticLegalGuardian.getAge());
                holisticLegalGuardianDocument.append("email", holisticLegalGuardian.getEmail());
                holisticLegalGuardianDocument.append("phoneNumber", holisticLegalGuardian.getPhoneNumber());
                holisticLegalGuardianDocument.append("studentId", holisticLegalGuardian.getStudentId());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {
                
            }
        }
    }
    
    public void deleteHolisticLegalGuardian(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticLegalGuardian");
            
            Document findDocument = new Document ("studentId",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
