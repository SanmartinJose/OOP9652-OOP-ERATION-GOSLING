
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
        int option = 0;
        
        do{
            System.out.println("MENU");
            System.out.println("1. Agregar Pago Mensual");
            System.out.println("2. Actualizar Pago");
            System.out.println("3. Mostrar Datos");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opcion: ");
            
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese una opcion valida. Intentelo nuevamente.");
                continue;
            }
                
            switch(option) {
                case 1:
                    paymentRecord.monthlyValue();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id = scanner.nextLine();

                    try {
                        int numericId = Integer.parseInt(id);
                        paymentRecord.updatePayment(String.valueOf(numericId));
                    } catch (NumberFormatException e) {
                        System.out.println("El ID ingresado no es un valor valido. Intentelo nuevamente");
                    }
                    break;
                case 3:
                    paymentRecord.showDebts();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    option = 4;
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }while(option!=4);
           
    }
}
