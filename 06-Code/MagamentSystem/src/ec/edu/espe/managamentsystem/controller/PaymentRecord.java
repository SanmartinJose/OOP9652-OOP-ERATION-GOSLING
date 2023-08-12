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

    public void monthlyValue(Double payment, String studentId) {
        // Para HomeSchoolLegalGuardian
        mdb.setCollection("HomeSchoolLegalGuardian");
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            resetRemainingValue(studentId);
            paymentCollection.updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("monthlyPayment", payment)));
        } else {
            Document paymentDocument = new Document("_id", studentId)
                    .append("name", "")
                    .append("monthlyPayment", payment);
            paymentCollection.insertOne(paymentDocument);
        }

        // Para HolisticLegalGuardian
        mdb.setCollection("HolisticLegalGuardian");
        paymentCollection = mdb.getCollection("Payments");

        existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            resetRemainingValue(studentId);
            paymentCollection.updateOne(new Document("_id", studentId),
                    new Document("$set", new Document("monthlyPayment", payment)));
        } else {
            Document paymentDocument = new Document("_id", studentId)
                    .append("name", "")
                    .append("monthlyPayment", payment);
            paymentCollection.insertOne(paymentDocument);
        }
    }

    public void updatePayment(String studentId, Double valuePaid) {
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document existingPayment = paymentCollection.find(new Document("_id", studentId)).first();

        if (existingPayment != null) {
            Document update = new Document("$set", new Document("valuePaid", valuePaid));
            paymentCollection.updateOne(new Document("_id", studentId), update);

            // Recalculate remaining value
            resetRemainingValue(studentId);
        } else {
            // If there is no payment record for the student, create a new one
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

    private void resetRemainingValue(String studentId) {
        MongoCollection<Document> paymentCollection = mdb.getCollection("Payments");
        Document student = paymentCollection.find(new Document("_id", studentId)).first();

        if (student != null) {
            Number monthlyPaymentNumber = (Number) student.get("monthlyPayment");
            Double monthlyPayment = monthlyPaymentNumber.doubleValue();
            Double valuePaid = student.getDouble("valuePaid");
            Double remainingValue = monthlyPayment - valuePaid;

            Document update = new Document("$set", new Document("remainingValue", remainingValue));

            paymentCollection.updateOne(new Document("_id", studentId), update);
        }
    }
}
