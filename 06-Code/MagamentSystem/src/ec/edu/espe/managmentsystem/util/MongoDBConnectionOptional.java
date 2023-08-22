package ec.edu.espe.managmentsystem.util;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class MongoDBConnectionOptional {

    private static MongoDBConnectionOptional instance;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private MongoDBConnectionOptional() {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String dbName = "SchoolManagmentSystem";
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(dbName);
    }

    public static synchronized MongoDBConnectionOptional getInstance() {
        if (instance == null) {
            instance = new MongoDBConnectionOptional();
        }
        return instance;
    }

    public void setCollection(String collectionName) {
        collection = database.getCollection(collectionName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);

    }

    public void addStudentToPaymentsIfValid() {
        MongoCollection<Document> paymentsCollection = database.getCollection("Payments");
        MongoCollection<Document> holisticLegalGuardianCollection = database.getCollection("HolisticLegalGuardian");
        MongoCollection<Document> homeSchoolLegalGuardianCollection = database.getCollection("HomeSchoolLegalGuardian");

        try (MongoCursor<Document> cursor = holisticLegalGuardianCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document holisticDocument = cursor.next();
                int studentId = holisticDocument.getInteger("_id");

                Document query = new Document("_id", studentId);
                boolean existsInPayments = paymentsCollection.countDocuments(query) > 0;

                if (!existsInPayments) {
                    Document homeSchoolDocument = homeSchoolLegalGuardianCollection.find(query).first();

                    String name = (holisticDocument != null) ? holisticDocument.getString("name") : homeSchoolDocument.getString("name");

                    System.out.println("Adding student to Payments: " + name);

                    Document newPayment = new Document("_id", studentId)
                            .append("name", name)
                            .append("monthlyPayment", 0.0)
                            .append("valuePaid", 0.0)
                            .append("remainingValue", 0.0);
                    paymentsCollection.insertOne(newPayment);
                    System.out.println("Student added to Payments successfully.");
                }
            }
        }
    }

    public static Object[][] generateTableData(String collectionName, String[] fields) {
        List<Object[]> dataList = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("SchoolManagmentSystem");
            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> result = collection.find();

            for (Document document : result) {
                Object[] rowData = new Object[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    rowData[i] = document.get(fields[i]);
                }
                dataList.add(rowData);
            }
        }
        Object[][] data = new Object[dataList.size()][fields.length];

        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    public static void adjustColumnWidth(JTable table, int columnIndex) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        int maxWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            Object value = table.getValueAt(row, columnIndex);
            TableCellRenderer renderer = table.getCellRenderer(row, columnIndex);
            Component component = renderer.getTableCellRendererComponent(table, value, false, false, row, columnIndex);
            int width = component.getPreferredSize().width;
            maxWidth = Math.max(maxWidth, width);
        }
        column.setPreferredWidth(maxWidth);
    }

    public static void updateTable(JTable table, String collectionName, String[] fieldsToDisplay) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        Object[][] tableData = MongoDBConnectionOptional.generateTableData(collectionName, fieldsToDisplay);
        for (Object[] rowData : tableData) {
            model.addRow(rowData);
        }
    }
}
