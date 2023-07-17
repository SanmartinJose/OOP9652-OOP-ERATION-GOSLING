
package ec.edu.espe.managamentsystem.controller;


import com.mongodb.client.MongoCollection;
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
    
    public void monthlyValue(Double payment, String studentId) {
        MongoDBConnectionOptional db = new MongoDBConnectionOptional();
        db.connection("HomeSchoolLegalGuardian");

        MongoCollection<Document> paymentCollection = db.getDatabase().getCollection("Payments");

        // Buscar el estudiante por su ID
        Document existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            // Actualizar el pago mensual existente
            paymentCollection.updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("monthlyPayment", payment)));
        } else {
            // Insertar un nuevo documento de pago mensual
            Document paymentDocument = new Document("_id", studentId)
                    .append("name", "") // Asegúrate de proporcionar el nombre correcto aquí
                    .append("monthlyPayment", payment);
            paymentCollection.insertOne(paymentDocument);
        }

        db.connection("HolisticLegalGuardian");

        // Realizar el mismo procedimiento para la otra colección de estudiantes
        paymentCollection = db.getDatabase().getCollection("Payments");

        existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            paymentCollection.updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("monthlyPayment", payment)));
        } else {
            Document paymentDocument = new Document("_id", studentId)
                    .append("name", "") // Asegúrate de proporcionar el nombre correcto aquí
                    .append("monthlyPayment", payment);
            paymentCollection.insertOne(paymentDocument);
    }
}

    public void updatePayment(String studentId, Double valuePaid) {
        Document existingPayment = mdb.getCollection().find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            Double currerntPaidValue = existingPayment.containsKey("valuePaid") ? existingPayment.getDouble("valuePaid") : 0.0;
            Double newPaidValue = currerntPaidValue + valuePaid;

            Document estudiante = mdb.getCollection().find(new Document("_id", studentId)).first();
            Number mounthlyPaymentNumber = (Number) estudiante.get("monthlyPayment");
            Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();
            Double remainingValue = mounthlyPayment - newPaidValue;

            mdb.getCollection().updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("valuePaid", newPaidValue)
                            .append("remainingValue", remainingValue))
            );
        } else {
            // If there is no payment record for the student, create a new one
            Document student = mdb.getCollection().find(new Document("_id", studentId)).first();
            if (student != null) {
                String name = student.getString("name");
                Number mounthlyPaymentNumber = (Number) student.get("monthlyPayment");
                Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();
                Double remainingValue = mounthlyPayment - valuePaid;

                Document documentPaid = new Document("_id", studentId)
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
        Document student = PaymentCollection.find(new Document("_id", studentId)).first();
        if (student != null) {
            Number mounthlyPaymentNumber = (Number) student.get("monthlyPayment");
            Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();

            Document filter = new Document("_id", studentId);
            Document update = new Document("$set", new Document("valuePaid", 0.0).append("remainingValue", mounthlyPayment));

            PaymentCollection.updateOne(filter, update);
        }
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