package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.managamentsystem.view.holistic.FrmEditHolisticStudent;
import ec.edu.espe.managamentsystem.view.holistic.FrmHolisticStudent;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import ec.edu.espe.managmentsystem.util.Validation;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentController {

    public String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";

    public void fileWritter(HolisticStudent holisticStudent) {
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
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

    public void updateHolisticStudent(String name, HolisticStudent holisticStudent) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");

            MongoCursor<Document> cursor = getStudentList().iterator();

            String oldName = null;
            int oldAge = 0;
            String oldAddress = null;

            while (cursor.hasNext()) {
                Document document = cursor.next();
                if (document.get("name").equals(name)) {
                    oldName = document.get("name").toString();
                    oldAge = (int) document.get("age");
                    oldAddress = document.get("address").toString();
                }
            }

            collection.updateOne(Filters.eq("name", oldName), Updates.set("name", holisticStudent.getName()));
            collection.updateOne(Filters.eq("age", oldAge), Updates.set("age", holisticStudent.getAge()));
            collection.updateOne(Filters.eq("address", oldAddress), Updates.set("address", holisticStudent.getAddress()));

        } catch (MongoException me) {

        }
    }

    public void deleteHolisticStudent(int id) {
        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");

            Document findDocument = new Document("_id", id);
            collection.findOneAndDelete(findDocument);
        } catch (MongoException me) {

        }
    }

    public MongoCursor<Document> getStudent(String name) {

        MongoCursor<Document> cursor = null;

        try ( MongoClient mongo = MongoClients.create(uri)) {
            MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection("HolisticStudents");

            Document findDocument = new Document("name", name);
            cursor = collection.find(findDocument).iterator();

        } catch (MongoException me) {

        }
        return cursor;
    }

    public int getStudentId() {
        SearchController searchController = new SearchController();

        MongoCursor<Document> cursor = getStudent(searchController.getStudent());

        int id = 0;

        while (cursor.hasNext()) {
            Document document = cursor.next();
            id = (int) document.get("_id");
        }
        return id;
    }

    public FindIterable<Document> getStudentList() {
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase database = mongo.getDatabase("SchoolManagmentSystem");
        MongoCollection<Document> collection = database.getCollection("HolisticStudents");

        return collection.find();
    }

    public boolean validateStudentData(String name) {

        MongoCursor<Document> cursor = getStudentList().iterator();

        boolean isFound = false;

        while (cursor.hasNext()) {
            Document document = cursor.next();
            if (document.get("name").equals(name)) {
                isFound = true;
                return isFound;
            } else {
                isFound = document.get("name").equals(name);
            }
        }
        return isFound;
    }

    public void addTableData(JTable tbeHolisticStudents) {
        DefaultTableModel dtm = new DefaultTableModel();

        String[] title = new String[]{"N", "Name", "Age", "Legal Guardian"};
        dtm.setColumnIdentifiers(title);
        tbeHolisticStudents.setModel(dtm);

        HolisticStudentController holisticStudentController;
        holisticStudentController = new HolisticStudentController();

        HolisticLegalGuardianController holisticLegalGuardianController;
        holisticLegalGuardianController = new HolisticLegalGuardianController();

        MongoCursor<Document> cursor = holisticStudentController.getStudentList().iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            int id = (int) document.get("_id");
            dtm.addRow(new Object[]{
                document.get("_id"),
                document.get("name"),
                document.get("age"),
                holisticLegalGuardianController.getHolisticLegalGuardianList(id)
            });
        }
    }

    public boolean getData(JTextField txtStudentName, JLabel lblFound) {
        Validation validation = new Validation();
        String name;

        if (txtStudentName.getText().isEmpty()) {
            lblFound.setText("*Campo Obligatorio");
            lblFound.setVisible(true);
            return false;
        } else {

            lblFound.setText("*estudiante no encontrado");
            lblFound.setVisible(false);

            name = validation.validateName(txtStudentName);

            HolisticStudentController holisticStudentController = new HolisticStudentController();
            boolean isFound = holisticStudentController.validateStudentData(name);

            SearchController searchController = new SearchController();
            searchController.fileWritter(name);

            if (isFound) {
                lblFound.setVisible(false);
                FrmEditHolisticStudent frmEditHolisticStudent = new FrmEditHolisticStudent();
                frmEditHolisticStudent.setVisible(true);

                FrmHolisticStudent frmHolisticStudent = new FrmHolisticStudent();
                frmHolisticStudent.setVisible(false);
            } else {
                lblFound.setVisible(true);
            }
            return isFound;
        }
    }
}
