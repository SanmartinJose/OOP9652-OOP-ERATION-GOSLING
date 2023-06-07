
package ec.edu.espe.managamentsystem.view;

import ec.edu.espe.managamentsystem.controller.GradesMenu;
import ec.edu.espe.managamentsystem.controller.HolisticLegalGuardianRecord;
import ec.edu.espe.managamentsystem.controller.HolisticLegalGuardianWrite;
import ec.edu.espe.managamentsystem.controller.HolisticStudentRecord;
import ec.edu.espe.managamentsystem.controller.HolisticStudentWrite;
import ec.edu.espe.managamentsystem.controller.PaymentRecord;
import ec.edu.espe.managamentsystem.controller.RegisterStudent;
import ec.edu.espe.managamentsystem.controller.StudentListWrite;
import ec.edu.espe.managmentsystem.model.Payment;
import ec.edu.espe.managmentsystem.model.Teacher;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Menu {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
        
        PaymentRecord paymentRecord = new PaymentRecord("data/holisticStudents.json", "data/debts.json");
        
        Scanner optionIn = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("--------Sistema de administración de horarios-------\n");
            System.out.println("1. Administrar cursos del HomeSchool\n");
            System.out.println("2. Administrar estudiantes de Holística\n");
            System.out.println("3. Administrar pagos\n");
            System.out.println("4. Salir\n");
            System.out.print("Seleccione una opción: ");
            option = optionIn.nextInt();

            switch (option) {
                case 1:
                    controlHomeSchoolMenu();
                    break;
                case 2:
                    controlHolisticStudentsMenu();
                    break;
                case 3:
                    Payment payment = new Payment();
                    payment.Payment();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    option =3;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (option != 3);
    }
    
    public static void controlHomeSchoolMenu(){
        
        int option = 0;
        Scanner optionIn = new Scanner(System.in);
        Teacher teacher = new Teacher();
        do{
            System.out.println("-------Administración del HomeSchool-----\n");
            System.out.println("1. Administrar Estudiantes\n");
            System.out.println("2. Aministar horarios\n");
            System.out.println("3. Administrar notas\n");
            System.out.println("4. Regresar\n");
            System.out.println("Selecciones una opción: ");
            option = optionIn.nextInt();
            
            switch(option){
                case 1:
                    teacher.adminStudents();
                    break;
                case 2:
                    break;
                case 3:
                    GradesMenu.main();
                    break;  
                case 4:
                    System.out.println("Disponible solo para modo gráfico");
                    option=4;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }while(option!=4);
    }
    
    public static void controlHolisticStudentsMenu() throws IOException, FileNotFoundException, ParseException, org.json.simple.parser.ParseException{
        int option = 0;
        Scanner optionIn = new Scanner(System.in);
        do{
            System.out.println("-------Administración de educación Holística-----\n");
            System.out.println("1. Añadir nuevo estudiante\n");
            System.out.println("2. Visualizar estudiantes\n");
            System.out.println("3. Regresar\n");
            System.out.println("Selecciones una opción: ");
            option = optionIn.nextInt();
            
            switch(option){
                case 1:
                    addNewHolisticStudent();
                    break;
                case 2:
                    readHolisticStudents();
                    break;
                case 3:
                    option = 3;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            
        }while(option!=3);
    }
    
    public static void addNewHolisticStudent(){
        System.out.println("-------Administración de educación Holística-----\n");
        System.out.println("Ingrese los datos del estudiante\n");
        
        HolisticStudentRecord holisticStudentRecord = new HolisticStudentRecord();
        HolisticStudentWrite holisticStudentWrite = new HolisticStudentWrite();      
        holisticStudentWrite.fileWritter(holisticStudentRecord.readFile());
        
        System.out.println("Ingrese los datos del representante\n");
        
        HolisticLegalGuardianRecord holisticLegalGuardianRecord = new HolisticLegalGuardianRecord();
        HolisticLegalGuardianWrite holisticLegalGuardianWrite = new HolisticLegalGuardianWrite();
        holisticLegalGuardianWrite.fileWritter(holisticLegalGuardianRecord.readFile());
    }
    
    public static void readHolisticStudents() throws IOException, FileNotFoundException, ParseException, org.json.simple.parser.ParseException{
        HolisticStudentWrite holisticStudentWrite = new HolisticStudentWrite();
        
        holisticStudentWrite.fileReader();
    }
    
    public void addNewHomeShoolStudent(){
        RegisterStudent registerStudent = new RegisterStudent();
        StudentListWrite studentListWrite = new StudentListWrite();
        
        //studentListWrite.fileWritter(registerStudent.readFile(), registerStudent.readFile());
    }
    public static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}