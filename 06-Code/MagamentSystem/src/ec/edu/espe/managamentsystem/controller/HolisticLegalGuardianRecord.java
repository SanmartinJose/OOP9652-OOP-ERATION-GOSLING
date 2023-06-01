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
        
        System.out.println("Age: ");
        int age = readFile.nextInt();
        
        System.out.println("Phone Number: ");
        long phoneNumber = readFile.nextLong();
        
        System.out.print("Email: ");
        String email = readFile.next();
        
     
        HolisticLegalGuardian holisticLegalGuardian = new HolisticLegalGuardian(age, phoneNumber, name, email);
        return holisticLegalGuardian;
    }
}
