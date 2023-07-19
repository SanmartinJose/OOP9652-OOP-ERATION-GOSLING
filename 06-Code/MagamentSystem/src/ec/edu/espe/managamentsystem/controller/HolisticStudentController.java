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
    
    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
     
    public void fileWritter(HolisticStudent holisticStudent){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
                        
            try {
                Document holisticStudentDocument = new Document();
                holisticStudentDocument.append("_id", holisticStudent.getId());
                holisticStudentDocument.append("name", holisticStudent.getName());
                holisticStudentDocument.append("age", holisticStudent.getAge());
                holisticStudentDocument.append("address", holisticStudent.getAddress());
                collection.insertOne(holisticStudentDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
    public void updateHolisticStudent(String name, HolisticStudent holisticStudent){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
            
            MongoCursor<Document> cursor = getStudentList().iterator();
        
            String oldName = null;
            int oldAge = 0;
            String oldAddress = null;
            
            while(cursor.hasNext()){
                Document document = cursor.next();
                if(document.get("name").equals(name)){   
                    oldName = document.get("name").toString();
                    oldAge = (int) document.get("age");
                    oldAddress = document.get("address").toString();
                }
            }
            
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", holisticStudent.getName()));
            collection.updateOne(Filters.eq("age",oldAge), Updates.set("age", holisticStudent.getAge()));
            collection.updateOne(Filters.eq("address",oldAddress), Updates.set("address", holisticStudent.getAddress()));
            
        }catch(MongoException me){

        }
    }
    
    public void deleteHolisticStudent(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
    
    public MongoCursor<Document> getStudent(String name){
        
        MongoCursor<Document> cursor = null;
       
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");
            
            Document findDocument = new Document ("name",name);
            cursor = collection.find(findDocument).iterator();
            
        }catch(MongoException me){
            
        }
        return cursor;
    }    
    
    public int getStudentId(){
        SearchController searchController = new SearchController();
         
        MongoCursor<Document> cursor = getStudent(searchController.getStudent());
                   
           int id = 0;
           
           while(cursor.hasNext()){
                Document document = cursor.next();
                id = (int) document.get("_id");
           }
        return id;
    }
    
    public FindIterable<Document> getStudentList(){
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
        MongoCollection<Document> collection = database.getCollection("HolisticStudents");

        return collection.find();
    }
    
    public boolean validateStudentData(String name){
            
        MongoCursor<Document> cursor = getStudentList().iterator();
         
        boolean isFound = false;
        
        while(cursor.hasNext()){
            Document document = cursor.next();
            if(name.equals("")){
               isFound = false; 
            }else{
                isFound = document.get("name").equals(name); 
            }    
        }
        return isFound;
    }
}
