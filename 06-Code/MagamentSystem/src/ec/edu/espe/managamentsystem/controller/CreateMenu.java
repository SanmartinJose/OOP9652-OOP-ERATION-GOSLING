/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import java.util.Scanner;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
class CreateMenu {
    
     int optionMenu;
    public int createMenu(){
        Scanner readOptionMenu = new Scanner(System.in);
        System.out.println("----------Welcome to your Manage System----------");
        System.out.println("1. Agrega a Curso A "+"\n2. Agregar a curso B"+"\n3.Revisar Listas"+"\n4.Exit");       
        optionMenu = readOptionMenu.nextInt();
        return optionMenu;
    }
}
