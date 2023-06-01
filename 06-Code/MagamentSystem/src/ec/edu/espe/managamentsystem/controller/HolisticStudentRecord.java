/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import ec.edu.espe.managmentsystem.model.HolisticStudent;
import java.util.Scanner;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentRecord {
    public HolisticStudent readFile(){
        Scanner readFile = new Scanner(System.in);
        
        System.out.println("Id:");
        int id = readFile.nextInt();
        
        System.out.println("Age:");
        int age = readFile.nextInt();
        
        System.out.println("Name:");
        String name = readFile.nextLine();
        
        System.out.println("Address:");
        String address = readFile.nextLine();
        
        HolisticStudent holisticStudent = new HolisticStudent(id, age, name, address);
        return holisticStudent;
    }
}
