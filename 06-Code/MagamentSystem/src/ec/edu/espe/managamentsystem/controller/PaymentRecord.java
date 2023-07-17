
package ec.edu.espe.managamentsystem.controller;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.managmentsystem.model.Payment;
import ec.edu.espe.managmentsystem.util.MongoDBConnectionOptional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class PaymentRecord {
    private String students;
    private String debts;
    private MongoDBConnectionOptional mdb;

    public PaymentRecord() {
        mdb = new MongoDBConnectionOptional();
        mdb.connection("Payments");
    }
    
    public void monthlyValue(Payment payment) {
        MongoDBConnectionOptional db = new MongoDBConnectionOptional();
        db.connection("HomeSchoolLegalGuardian");

        MongoCursor<Document> cursor = db.getCollection().find().iterator();
        while (cursor.hasNext()) {
            Document student = cursor.next();
            int studentChangeType = student.getInteger("studentId");
            String studentId = String.valueOf(studentChangeType);
            String name = student.getString("name");

            Double mounthlyPayment = payment.getPagoMensual();

            MongoCollection<Document> paymentCollection = db.getDatabase().getCollection("Payments");
            Document existingPayment = paymentCollection.find(new Document("studentId", studentId)).first();

            if (existingPayment != null) {
                paymentCollection.updateOne(new Document("studentId", studentId),
                        new Document("$set", new Document("monthlyPayment", mounthlyPayment)));
            } else {
                Document pagoDocumento = new Document("studentId", studentId)
                        .append("name", name)
                        .append("monthlyPayment", mounthlyPayment);
                paymentCollection.insertOne(pagoDocumento);
            }
        }
        cursor.close();
        
         db.connection("HolisticLegalGuardian");

        cursor = db.getCollection().find().iterator();
        while (cursor.hasNext()) {
            Document student = cursor.next();
            int studentChangeType = student.getInteger("studentId");
            String studentId = String.valueOf(studentChangeType);
            String name = student.getString("name");

            Double monthlyPayment = payment.getPagoMensual();

            MongoCollection<Document> paymentCollection = db.getDatabase().getCollection("Payments");
            Document existingPayment = paymentCollection.find(new Document("studentId", studentId)).first();

            if (existingPayment != null) {
                paymentCollection.updateOne(new Document("studentId", studentId),
                        new Document("$set", new Document("monthlyPayment", monthlyPayment)));
            } else {
                Document paymentDocument = new Document("studentId", studentId)
                        .append("name", name)
                        .append("monthlyPayment", monthlyPayment);
                paymentCollection.insertOne(paymentDocument);
            }
        }
        cursor.close();
        
    }

    public void updatePayment(String studentId, Double valuePaid) {
        Document existingPayment = mdb.getCollection().find(new Document("studentId", studentId)).first();

        if (existingPayment != null) {
            Double currerntPaidValue = existingPayment.containsKey("valuePaid") ? existingPayment.getDouble("valuePaid") : 0.0;
            Double newPaidValue = currerntPaidValue + valuePaid;

            Document estudiante = mdb.getCollection().find(new Document("studentId", studentId)).first();
            Number mounthlyPaymentNumber = (Number) estudiante.get("monthlyPayment");
            Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();
            Double remainingValue = mounthlyPayment - newPaidValue;

            mdb.getCollection().updateOne(new Document("studentId", studentId),
                    new Document("$set", new Document("valuePaid", newPaidValue)
                            .append("remainingValue", remainingValue))
            );
        } else {
            // If there is no payment record for the student, create a new one
            Document student = mdb.getCollection().find(new Document("studentId", studentId)).first();
            if (student != null) {
                String name = student.getString("name");
                Number mounthlyPaymentNumber = (Number) student.get("monthlyPayment");
                Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();
                Double remainingValue = mounthlyPayment - valuePaid;

                Document documentPaid = new Document("studentId", studentId)
                        .append("name", name)
                        .append("monthlyPayment", mounthlyPayment)
                        .append("valuePaid", valuePaid)
                        .append("remainingValue", remainingValue);

                mdb.getCollection().insertOne(documentPaid);
            }
        }
    }

    public void deletePaid(String studentId) {
        MongoCollection<Document> PaymentCollection = mdb.getCollection();
        Document student = PaymentCollection.find(new Document("studentId", studentId)).first();
        if (student != null) {
            Number mounthlyPaymentNumber = (Number) student.get("monthlyPayment");
            Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();

            Document filter = new Document("studentId", studentId);
            Document update = new Document("$set", new Document("valuePaid", 0.0).append("remainingValue", mounthlyPayment));

            PaymentCollection.updateOne(filter, update);
        }
    }

public void showDebts() {
    try {
        String debtJsonContent = new String(Files.readAllBytes(Paths.get(getDebts())));
        JSONObject debtJsonObject = new JSONObject(debtJsonContent);

        System.out.println("Deudas registradas:");

        for (String id : debtJsonObject.keySet()) {
            JSONArray debtsArray = debtJsonObject.getJSONArray(id);

            System.out.println("ID: " + id);
            System.out.println("Deudas:");

            for (int i = 0; i < debtsArray.length(); i++) {
                JSONObject debtObject = debtsArray.getJSONObject(i);
                double value = debtObject.getDouble("value");
                double paid = debtObject.getDouble("paid");
                double difference = value - paid;
                System.out.println("  - Valor Mensual: " + value);
                System.out.println("    Pagado: " + paid);
                System.out.println("    Diferencia: " + difference);
            }
        }
    } catch (IOException | JSONException e) {
        System.out.println("Error al mostrar las deudas: " + e.getMessage());
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("Presione Enter para continuar");
    sc.nextLine();
}
    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getDebts() {
        return debts;
    }

    public void setDebts(String debts) {
        this.debts = debts;
    }
}