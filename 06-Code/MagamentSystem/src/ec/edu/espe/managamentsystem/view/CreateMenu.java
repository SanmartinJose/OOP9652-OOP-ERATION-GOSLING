/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.view;

import java.util.Scanner;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class CreateMenu {
    int optionMenu;
    public int printMenu(){
        Scanner readOptionMenu = new Scanner(System.in);
        System.out.println("----------MENU----------");
        System.out.println("1. Add Chicken in coop 1");
        System.out.println("2. Add Chicken in coop 2");
        System.out.println("3. Save Data");
        System.out.println("5. Finish");
        optionMenu = readOptionMenu.nextInt();
        return optionMenu;
    }
}
