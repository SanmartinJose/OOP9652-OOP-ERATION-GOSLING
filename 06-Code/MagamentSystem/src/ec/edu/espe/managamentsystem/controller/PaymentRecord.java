
package ec.edu.espe.managamentsystem.controller;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.FileWriter;
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


    public void monthlyValue(String uri, String newValue) {
    try (var mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase("TestPayment");
        MongoCollection<Document> estudiantesCollection = database.getCollection("estudiantes");

        MongoCursor<Document> cursor = estudiantesCollection.find().iterator();
        while (cursor.hasNext()) {
            Document estudiante = cursor.next();
            int estudianteId = estudiante.getInteger("id");
            String nombre = estudiante.getString("nombre");

            Double pagoMensual = Double.parseDouble(newValue);

            MongoCollection<Document> pagosCollection = database.getCollection("pagos");
            Document existingPago = pagosCollection.find(new Document("id", estudianteId)).first();

            if (existingPago != null) {
                pagosCollection.updateOne(new Document("id", estudianteId),
                        new Document("$set", new Document("pagoMensual", pagoMensual)));
            } else {
                Document pagoDocumento = new Document("id", estudianteId)
                        .append("nombre", nombre)
                        .append("pagoMensual", pagoMensual);
                pagosCollection.insertOne(pagoDocumento);
            }
        }
        cursor.close();
    }
}
    
    public void updatePayment(String id) {
        try {
            String debtJsonContent = new String(Files.readAllBytes(Paths.get(getDebts())));

            JSONObject debtJsonObject = new JSONObject(debtJsonContent);

            JSONArray studentsArray = debtJsonObject.getJSONArray(id);

            if (studentsArray.length() > 0) {
                JSONObject debtJson = studentsArray.getJSONObject(0);

                double monthlyValue = debtJson.optDouble("value", 0.0);
                double paidValue = debtJson.optDouble("paid", 0.0);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el valor pagado para el ID " + id + ": ");
                String paymentString = scanner.next();
                while(!Validator.validateString(paymentString)){
                    System.out.println("Ingrese un valor numerico por favor");
                    System.out.println("Ingrese el valor pagado para el ID " + id + ": ");
                    paymentString = scanner.next();
                }
                Double payment = Double.parseDouble(paymentString);
                

                double updatedPaidValue = paidValue + payment;
                double difference = monthlyValue - updatedPaidValue;

                debtJson.put("paid", updatedPaidValue);
                debtJson.put("difference", difference);

                FileWriter debtFileWriter = new FileWriter(getDebts());
                debtFileWriter.write(debtJsonObject.toString());
                debtFileWriter.close();

                System.out.println("Pago registrado con éxito.");
            } else {
                System.out.println("No se encontró ninguna deuda para el ID " + id);
            }
        } catch (IOException | JSONException e) {
            System.out.println("Error al actualizar el pago: " + e.getMessage());
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