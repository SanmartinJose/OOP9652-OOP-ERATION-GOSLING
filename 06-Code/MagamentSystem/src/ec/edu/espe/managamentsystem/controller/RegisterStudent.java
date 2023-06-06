
package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managmentsystem.model.HomeSchoolStudent;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class RegisterStudent {
    public HomeSchoolStudent readFile(){
    Scanner readFile = new Scanner(System.in);
        System.out.print("Id: ");
        String id = readFile.next();
        while(!Validator.validateString(id)){
            System.out.println("Ingrese un id valido por favor");
            System.out.println("Id: ");
            id = readFile.next();
        }
        int idInt = Integer.parseInt(id);
        
        
        System.out.print("Name: ");
        String name = readFile.next();
        while(Validator.validateString(name)){
            System.out.println("Ingrese un nombre valido por favor");
            System.out.println("Name: ");
            name = readFile.next();
        }
        
        System.out.print("Addres: ");
        String address = readFile.next();   
        
        System.out.print("Type of Student: ");
        String typeOfStudy = readFile.next();
        while(Validator.validateString(typeOfStudy)){
            System.out.println("Ingrese un valor valido por favor");
            System.out.println("Type of Student: ");
            typeOfStudy = readFile.next();
        }
        
        System.out.print("Year Born: ");
        String yearBorn = readFile.next();
        while(!Validator.validateString(yearBorn)){
            System.out.println("Ingrese un año por favor");
            System.out.println("Year Born: ");
            yearBorn = readFile.next();
        }
        int yearBornInt = Integer.parseInt(yearBorn);
        
        System.out.print("Month Born: ");
        String monthBorn = readFile.next();
        while(!Validator.validateString(monthBorn)){
            System.out.println("Ingrese un mes por favor");
            System.out.println("Month Born: ");
            monthBorn = readFile.next();
        }
        int monthBornInt = Integer.parseInt(monthBorn);
        
        System.out.print("Day Born: ");
        String dayBorn = readFile.next();
        while(!Validator.validateString(dayBorn)){
            System.out.println("Ingrese un dia por favor");
            System.out.println("Day Born: ");
            dayBorn = readFile.next();
        }
        int dayBornInt = Integer.parseInt(dayBorn);
        
        
        HomeSchoolStudent homeSchoolStudent = new HomeSchoolStudent(idInt,name,typeOfStudy,address,new Date(yearBornInt, monthBornInt, dayBornInt));
        return homeSchoolStudent;
}}
