
package ec.edu.espe.managamentsystem.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
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
    
    public PaymentRecord(String students, String debts){
        this.students = students;
        this.debts = debts;
    }
    public void monthlyValue(String id){
        try{
            String idJsonContent = new String(Files.readAllBytes(Paths.get(getStudents())));
            
            JSONObject idJsonObject = new JSONObject(idJsonContent);
            
            JSONArray debts2 = idJsonObject.optJSONArray(id);
            
            if(debts2 == null){
                debts2 = new JSONArray();
                idJsonObject.put(id, debts2);
            }
            
            FileWriter idFileWriter = new FileWriter(getStudents());
            idFileWriter.write(idJsonObject.toString());
            idFileWriter.close();
            
            String debtJsonContent = new String(Files.readAllBytes(Paths.get(getDebts())));
        JSONObject debtJsonObject = new JSONObject(debtJsonContent);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el valor mensual a pagar: ");
            double monthlyPayment = sc.nextDouble();
            
            for(String existingId : idJsonObject.keySet()){
                JSONArray existingDebts = debtJsonObject.optJSONArray(existingId);
                
                if (existingDebts == null){
                    existingDebts = new JSONArray();
                    debtJsonObject.put(existingId, existingDebts);
                }
                JSONObject debtObject = new JSONObject();
                debtObject.put("value", monthlyPayment);
                debtObject.put("paid", 0.0);
                existingDebts.put(debtObject);
                
            }
            
          FileWriter debtFileWriter = new FileWriter(getDebts());
          debtFileWriter.write(debtJsonObject.toString());
          debtFileWriter.close();
          
            System.out.println("Deudas agragadas con exito");
        }catch (IOException | JSONException e){
            System.out.println("Error al agregar las deudas " + e.getMessage());
        }
    }
        
        public void updatePayment(String id) {
        try {
        String debtJsonContent = new String(Files.readAllBytes(Paths.get(getDebts())));

        JSONObject debtJsonObject = new JSONObject(debtJsonContent);

        JSONArray debtsArray = debtJsonObject.optJSONArray(id);

        if (debtsArray != null && debtsArray.length() > 0) {
            // Suponemos que solo hay una deuda para el ID
            Object debtObject = debtsArray.get(0);

            if (debtObject instanceof JSONObject) {
                JSONObject debtJson = (JSONObject) debtObject;

                double monthlyValue = debtJson.optDouble("value", 0.0);
                double paidValue = debtJson.optDouble("paid", 0.0);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el valor pagado para el ID " + id + ": ");
                double payment = scanner.nextDouble();

                double updatedPaidValue = paidValue + payment;
                double difference = monthlyValue - updatedPaidValue;

                debtJson.put("paid", updatedPaidValue);
                debtJson.put("difference", difference);

                FileWriter debtFileWriter = new FileWriter(getDebts());
                debtFileWriter.write(debtJsonObject.toString());
                debtFileWriter.close();

                System.out.println("Pago registrado con éxito.");
            } else {
                System.out.println("El objeto de deuda no es un JSONObject para el ID " + id);
            }
        } else {
            System.out.println("No se encontró ninguna deuda para el ID " + id);
        }
    } catch (IOException | JSONException e) {
        System.out.println("Error al actualizar el pago: " + e.getMessage());
    }
}

    /**
     * @return the students
     */
    public String getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(String students) {
        this.students = students;
    }

    /**
     * @return the debts
     */
    public String getDebts() {
        return debts;
    }

    /**
     * @param debts the debts to set
     */
    public void setDebts(String debts) {
        this.debts = debts;
    }
}
        
  
