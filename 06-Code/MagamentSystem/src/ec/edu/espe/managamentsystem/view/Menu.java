
package ec.edu.espe.managamentsystem.view;

import ec.edu.espe.managamentsystem.controller.PaymentRecord;
import java.util.Scanner;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Menu {
    public static void main(String[] args) {
        PaymentRecord paymentRecord = new PaymentRecord("data/students.json", "data/debts.json");
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1. Agregar deudas");
            System.out.println("2. Actualizar pago");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id = scanner.nextLine();
                    paymentRecord.monthlyValue(id);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id2 = scanner.nextLine();
                    paymentRecord.updatePayment(id2);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
}