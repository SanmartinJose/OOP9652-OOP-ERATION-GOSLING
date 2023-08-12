package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managmentsystem.model.HolisticStudent;
import java.util.Scanner;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentRecord {

    public HolisticStudent readFile() {
        Scanner readFile = new Scanner(System.in);

        System.out.println("Id:");
        String id = readFile.next();
        while (!Validator.validateString(id)) {
            System.out.println("Ingrese un id valido por favor");
            System.out.println("Id: ");
            id = readFile.next();
        }
        int idInt = Integer.parseInt(id);

        System.out.println("Name:");
        String name = readFile.next();
        while (Validator.validateString(name)) {
            System.out.println("Ingrese un nombre valido por favor");
            System.out.println("Name: ");
            name = readFile.next();
        }

        System.out.println("Age:");
        String age = readFile.next();
        while (!Validator.validateString(age)) {
            System.out.println("Ingrese un numero valido por favor");
            System.out.println("Age: ");
            age = readFile.next();
        }
        int ageInt = Integer.parseInt(age);

        System.out.println("Address:");
        String address = readFile.next();

        HolisticStudent holisticStudent = new HolisticStudent(idInt, ageInt, name, address);
        return holisticStudent;
    }
}
