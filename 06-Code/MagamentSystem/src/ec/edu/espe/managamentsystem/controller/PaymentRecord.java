package ec.edu.espe.managamentsystem.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.managmentsystem.util.MongoDBConnectionOptional;
import org.bson.Document;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class PaymentRecord {

    private MongoDBConnectionOptional mdb;

    public PaymentRecord() {
        mdb = MongoDBConnectionOptional.getInstance();
    }

    public void monthlyValue(Double payment, int studentId) {
        mdb.setCollection("Payments");
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            paymentCollection.updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("monthlyPayment", payment)));
        }
        resetRemainingValue(studentId);
    }
    
    public void updatePayment(int studentId, Double valuePaid) {
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            Document update = new Document("$set", new Document("valuePaid", valuePaid));
            paymentCollection.updateOne(new Document("_id", studentId), update);

            resetRemainingValue(studentId);
        } else {
            Document student = paymentCollection.find(new Document("_id", studentId)).first();
            if (student != null) {
                String name = student.getString("name");
                Number monthlyPaymentNumber = (Number) student.get("monthlyPayment");
                Double monthlyPayment = monthlyPaymentNumber.doubleValue();
                Double remainingValue = monthlyPayment - valuePaid;

                Document documentPaid = new Document("_id", studentId)
                        .append("name", name)
                        .append("monthlyPayment", monthlyPayment)
                        .append("valuePaid", valuePaid)
                        .append("remainingValue", remainingValue);

                paymentCollection.insertOne(documentPaid);
            }
        }
    }

    public void deletePaid(String studentId) {
        MongoCollection<Document> PaymentCollection = mdb.getCollection("Payments");
        Document student = PaymentCollection.find(new Document("_id", studentId)).first();
        if (student != null) {
            Number mounthlyPaymentNumber = (Number) student.get("monthlyPayment");
            Double mounthlyPayment = mounthlyPaymentNumber.doubleValue();

            Document filter = new Document("_id", studentId);
            Document update = new Document("$set", new Document("valuePaid", 0.0).append("remainingValue", mounthlyPayment));

            PaymentCollection.updateOne(filter, update);
        }
    }

    private void resetRemainingValue(int studentId) {
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document student = paymentCollection.find(new Document("_id", studentId)).first();

        if (student != null) {
            Number monthlyPaymentNumber = (Number) student.get("monthlyPayment");
            Double monthlyPayment = monthlyPaymentNumber.doubleValue();
            Double valuePaid = student.getDouble("valuePaid");

            if (valuePaid == null) {
                valuePaid = 0.0;
            }
            Double remainingValue = monthlyPayment - valuePaid;
            System.out.println("Remaining Value Before Update: " + remainingValue);

            Document update = new Document("$set", new Document("remainingValue", remainingValue));

            paymentCollection.updateOne(new Document("_id", studentId), update);

            Document updatedStudent = paymentCollection.find(new Document("_id", studentId)).first();
            if (updatedStudent != null) {
                Double updatedRemainingValue = updatedStudent.getDouble("remainingValue");
                System.out.println("Remaining Value After Update: " + updatedRemainingValue);
            }
        }
    }
}
