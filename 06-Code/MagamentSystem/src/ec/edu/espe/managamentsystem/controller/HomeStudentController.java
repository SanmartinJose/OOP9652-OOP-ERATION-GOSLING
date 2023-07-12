
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
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import ec.edu.espe.managmentsystem.model.HomeSchoolStudent;
import java.util.Date;
import java.util.Scanner;
import org.bson.Document;
/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class HomeStudentController {
    
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";
    
    public void writeHomeStudent(HomeSchoolStudent homeSchoolStudent){
          try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolStudent");
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", homeSchoolStudent.getId());
                holisticLegalGuardianDocument.append("courseId", homeSchoolStudent.getCourseId());
                holisticLegalGuardianDocument.append("age", homeSchoolStudent.getAge());
                holisticLegalGuardianDocument.append("name", homeSchoolStudent.getName());
                holisticLegalGuardianDocument.append("typeOfStudy", homeSchoolStudent.getTypeOfStudy());
                holisticLegalGuardianDocument.append("address", homeSchoolStudent.getAddress());
                holisticLegalGuardianDocument.append("bornDate", homeSchoolStudent.getBorndate());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
     public void updateHomeSchoolStudent(int id, HomeSchoolStudent homeSchoolStudent){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolStudent");
            
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id",id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            
            String oldCourseId = (String) cursor.next().get("courseId");
            String oldAge = (String) cursor.next().get("age");
            String oldName = (String) cursor.next().get("name");
            String oldTypeOfStudy = (String) cursor.next().get("typeOfStudy");
            String oldAddress = (String) cursor.next().get("address");
            String oldBornDate = (String) cursor.next().get("bornDate");
             
            
            collection.updateOne(Filters.eq("courseId",oldCourseId), Updates.set("courseId", homeSchoolStudent.getCourseId()));
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", homeSchoolStudent.getName()));
            collection.updateOne(Filters.eq("age",oldAge), Updates.set("age", homeSchoolStudent.getAge()));
            collection.updateOne(Filters.eq("typeOfStudy",oldTypeOfStudy), Updates.set("typeOfStudy", homeSchoolStudent.getTypeOfStudy()));
            collection.updateOne(Filters.eq("address",oldAddress), Updates.set("address", homeSchoolStudent.getAddress()));
            collection.updateOne(Filters.eq("bornDate",oldBornDate), Updates.set("bornDate", homeSchoolStudent.getBorndate()));
            
        }catch(MongoException me){

        }
    }
    
    public void deleteHolisticStudent(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolStudent");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
