
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
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import ec.edu.espe.managmentsystem.model.HomeSchoolCourse;
import org.bson.Document;


/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class StudentCourseController {
    
    public String uri = "mongodb+srv://ojtipan:trabatrix2@farm.am6duog.mongodb.net/?retryWrites=true&w=majority";
    
    public void writeStudentCourse(HomeSchoolCourse homeschoolcourse){
    
         try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");
            try {
                Document holisticLegalGuardianDocument = new Document();
                holisticLegalGuardianDocument.append("_id", homeschoolcourse.getId());
                holisticLegalGuardianDocument.append("name", homeschoolcourse.getName());
                collection.insertOne(holisticLegalGuardianDocument);    
            } catch (MongoException me) {

            }
        }
    }
    
    public void updateStudentCoure(int id, HolisticStudent holisticStudent){
          try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");
            
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id",id);
            MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
            
            String oldName = (String) cursor.next().get("name");
            
            collection.updateOne(Filters.eq("name",oldName), Updates.set("name", holisticStudent.getName()));
        }catch(MongoException me){

        }
    }
    
    public void deleteStudentCourse(int id){
        try (MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("ManagementSystem");
            MongoCollection<Document> collection = database.getCollection("HomeSchoolCourse");
            
            Document findDocument = new Document ("_id",id);
            collection.findOneAndDelete(findDocument);
        }catch(MongoException me){
            
        }
    }
}
