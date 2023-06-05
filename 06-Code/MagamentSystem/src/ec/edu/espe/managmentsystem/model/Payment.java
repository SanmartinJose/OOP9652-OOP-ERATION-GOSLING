
package ec.edu.espe.managmentsystem.model;

import ec.edu.espe.managamentsystem.controller.PaymentRecord;
import java.util.Scanner;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Payment {
    public void Payment(){
   PaymentRecord paymentRecord = new PaymentRecord("data/holisticStudents.json", "data/debts.json");
        Scanner scanner = new Scanner(System.in);

        int opcion;
        boolean exit = false;
        while(!exit) {
            System.out.println("MENU");
            System.out.println("1. Agregar Pago Mensual");
            System.out.println("2. Actualizar Pago");
            System.out.println("3. Mostrar Datos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el Nuevo Pago Mensual: ");
                    paymentRecord.monthlyValue();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id = scanner.nextLine();
                    paymentRecord.updatePayment(id);
                    break;
                case 3:
                    paymentRecord.showDebts();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
