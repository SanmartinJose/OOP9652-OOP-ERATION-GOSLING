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
import ec.edu.espe.managmentsystem.model.HomeSchoolLegalGuardian;
import org.bson.Document;


/**
 *
 * @author Oswaldo Tipan
 */
public class HomeSchoolLegalGuardianController {
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";

    public void fileWrite(HomeSchoolLegalGuardian homeSchoolLegalGuardian){
        
         try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolLegalGuardian");
                        
            try {
                Document homeSchoolLegalGuardianDocument = new Document();
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
    
    public void deleteHolisticLegalGuardian(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolLegalGuardian");
            
            Document findDocument = new Document ("studentId",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
