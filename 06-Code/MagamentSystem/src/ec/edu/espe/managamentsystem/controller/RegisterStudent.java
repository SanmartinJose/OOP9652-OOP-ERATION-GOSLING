
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
        int id = readFile.nextInt();
        System.out.print("Name: ");
        String name = readFile.next();
        System.out.print("Addres: ");
        String address = readFile.next();   
        System.out.print("Type of Student: ");
        String typeOfStudy = readFile.next(); 
        System.out.print("Year Born: ");
        int yearBorn = readFile.nextInt();
        System.out.print("Month Born: ");
        int monthBorn = readFile.nextInt();
        System.out.print("Day Born: ");
        int dayBorn = readFile.nextInt();
        HomeSchoolStudent homeSchoolStudent = new HomeSchoolStudent(id,name,typeOfStudy,address,new Date(yearBorn, monthBorn, dayBorn));
        return homeSchoolStudent;
}}
