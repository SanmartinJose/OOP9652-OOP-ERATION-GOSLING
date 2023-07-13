
package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
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
    
    public void updatePayment(String uri, int estudianteId, String valorPagado) {
        try (var mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("TestPayment");
            MongoCollection<Document> pagosCollection = database.getCollection("pagos");

            Document existingPago = pagosCollection.find(new Document("id", estudianteId)).first();

            if (existingPago != null) {
                Double valorPagadoActual = existingPago.containsKey("valorPagado") ? existingPago.getDouble("valorPagado") : 0.0;
                Double valorPagadoDouble = Double.parseDouble(valorPagado);
                Double nuevoValorPagado = valorPagadoActual + valorPagadoDouble;

                Document estudiante = database.getCollection("pagos").find(new Document("id", estudianteId)).first();
                Double pagoMensual = estudiante.getDouble("pagoMensual");
                Double valorRestante = pagoMensual - nuevoValorPagado;

                pagosCollection.updateOne(
                        new Document("id", estudianteId),
                        new Document("$set", new Document("valorPagado", nuevoValorPagado)
                                .append("valorRestante", valorRestante))
                );
            } else {
                // Si no existe un registro de pago para el estudiante, se crea uno nuevo
                    Document estudiante = database.getCollection("pagos").find(new Document("id", estudianteId)).first();
                    if (estudiante != null) {
                        String nombre = estudiante.getString("nombre");
                        Double pagoMensual = estudiante.containsKey("pagoMensual") ? estudiante.getDouble("pagoMensual") : 0.0;
                        Double valorPagadoDouble = Double.parseDouble(valorPagado);
                        Double valorRestante = pagoMensual - valorPagadoDouble;

                        Document pagoDocumento = new Document("id", estudianteId)
                        .append("nombre", nombre)
                        .append("pagoMensual", pagoMensual)
                        .append("valorPagado", valorPagadoDouble)
                        .append("valorRestante", valorRestante);

                        pagosCollection.insertOne(pagoDocumento);
                    }
            }
        }
    }
    
    public void deletePaid(String uri, int estudianteId) {
        try (var mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("TestPayment");
            MongoCollection<Document> collection = database.getCollection("pagos");

            Document filter = new Document("id", estudianteId);
            Document update = new Document("$set", new Document("valorPagado", 0).append("valorRestante", 250));

            collection.updateOne(filter, update);
        } catch (MongoException e) {
            System.out.println("Error al realizar la operación en la base de datos: " + e.getMessage());
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