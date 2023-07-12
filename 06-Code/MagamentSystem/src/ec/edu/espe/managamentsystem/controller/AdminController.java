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
import ec.edu.espe.managmentsystem.model.Admin;
import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class AdminController {
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";
     
    public void fileWritter(Admin admin){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Admin");
                        
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", admin.getId());
                holisticLegalGuardianDocument.append("name", admin.getName());
                holisticLegalGuardianDocument.append("phoneNumber", admin.getPhoneNumber());
                holisticLegalGuardianDocument.append("email", admin.getEmail());
                holisticLegalGuardianDocument.append("charge", admin.getCharge());
                holisticLegalGuardianDocument.append("userName", admin.getUserName());
                holisticLegalGuardianDocument.append("password", admin.getPassword());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
    public void updateHolisticStudent(int id, Admin admin){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Admin");
            
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id",id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            
            String oldName = (String) cursor.next().get("name");
            String oldPhoneNumber = (String) cursor.next().get("phoneNumber");
            String oldEmail = (String) cursor.next().get("email");
            String oldCharge = (String) cursor.next().get("charge");
            String oldUserName = (String) cursor.next().get("userName");
            String oldPassword = (String) cursor.next().get("password");
            
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", admin.getName()));
            collection.updateOne(Filters.eq("phoneNumber",oldPhoneNumber), Updates.set("phoneNumber", admin.getPhoneNumber()));
            collection.updateOne(Filters.eq("email",oldEmail), Updates.set("email", admin.getEmail()));
            collection.updateOne(Filters.eq("charge",oldCharge), Updates.set("charge", admin.getCharge()));
            collection.updateOne(Filters.eq("userName",oldUserName), Updates.set("userName", admin.getUserName()));
            collection.updateOne(Filters.eq("password",oldPassword), Updates.set("password", admin.getPassword()));
            
        }catch(MongoException me){

        }
    }
    
    public void deleteHolisticStudent(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("Admin");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
