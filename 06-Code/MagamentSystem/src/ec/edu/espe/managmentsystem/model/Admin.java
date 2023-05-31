/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managmentsystem.model;

import java.util.Scanner;

/**
 *
 * @author Oswaldo Tipan
 */
public class Admin {
    private String name;
    
    public void controlMainMenu(){
        
        Scanner optionIn = new Scanner(System.in);
        
        int opc=0;
        
        while(opc!=3){
            System.out.println("------- School Managment Software------\n");
            System.out.println("1. Manage Student system\n");
            System.out.println("2. Manage Techer system\n");
            System.out.println("3. Leave the system\n");
            System.out.println("Insert your option: ");
            opc = optionIn.nextInt();
            
            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Insert a valid option");
                    break;
            }
        }
    }
}
