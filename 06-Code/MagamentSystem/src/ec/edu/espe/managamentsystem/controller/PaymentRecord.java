
package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managmentsystem.model.Payment;
import java.util.Scanner;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class PaymentRecord {
    public Payment readFile(){
    Scanner readFile = new Scanner(System.in);
        System.out.print("Tipo de Transaccion: ");
        String wayToPay = readFile.next();
        System.out.print("Valor Total por Mes: ");
        int totalValuePerMonth = readFile.nextInt();
        Payment payment = new Payment(wayToPay, totalValuePerMonth);
        return payment;
    }
}
