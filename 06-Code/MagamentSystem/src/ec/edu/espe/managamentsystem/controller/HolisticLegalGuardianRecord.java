/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import java.util.Scanner;
/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticLegalGuardianRecord {
 
    public HolisticLegalGuardian readFile(){
    Scanner readFile = new Scanner(System.in);
        
         
    
        System.out.print("Name: ");
        String name = readFile.next();
        while(Validator.validateString(name)){
            System.out.println("Ingrese un nombre valido por favor");
            System.out.println("Name: ");
            name = readFile.next();
        }
        
        
        System.out.println("Age: ");
        String age = readFile.next();
        while(!Validator.validateString(age)){
            System.out.println("Ingrese un numero por favor");
            System.out.println("Age: ");
            age = readFile.next();
        }
        int ageInt = Integer.parseInt(age);
        
        System.out.println("Phone Number: ");
        String phoneNumber = readFile.next();
        while(!Validator.validateString(phoneNumber)){
            System.out.println("Ingrese un numero por favor");
            System.out.println("Phone Number: ");
            phoneNumber = readFile.next();
        }
        int phoneNumberInt = Integer.parseInt(phoneNumber);
        
        
        System.out.print("Email: ");
        String email = readFile.next();
        
     
        HolisticLegalGuardian holisticLegalGuardian = new HolisticLegalGuardian(ageInt, phoneNumber, name, email);
        return holisticLegalGuardian;
    }
}
