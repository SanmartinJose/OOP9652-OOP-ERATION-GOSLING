
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
        
        Scanner optionIn = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("--------Sistema de administración de horarios-------");
            System.out.println("1. Administrar cursos del HomeSchool");
            System.out.println("2. Administrar estudiantes de Holística");
            System.out.println("3. Administrar pagos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = optionIn.nextInt();

            switch (option) {
                case 1:
                    optionIn.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id = optionIn.nextLine();
                    paymentRecord.monthlyValue(id);
                    break;
                case 2:
                    optionIn.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id2 = optionIn.nextLine();
                    paymentRecord.updatePayment(id2);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (option != 3);
    }
    
    public void controlHomeSchoolMenu(){
        
        int option = 0;
        Scanner optionIn = new Scanner(System.in);

        do{
            System.out.println("-------Administración del HomeSchool-----");
            System.out.println("1. Administrar Estudiantes");
            System.out.println("2. Administrar Profesores");
            System.out.println("3. Aministar horarios");
            System.out.println("4. Regresar");
        }while(option!=3);
    }
    
    public void controlHolisticStudentsMenu(){
        
    }
    
    public void controlPaymentsMenu(){
        
    }
    
}