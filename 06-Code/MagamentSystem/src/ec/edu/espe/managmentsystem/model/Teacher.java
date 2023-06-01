
package ec.edu.espe.managmentsystem.model;

import ec.edu.espe.managamentsystem.controller.RegisterStudent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class Teacher {
    private int id;
    private String name;
    private int age;
    private String address;
    private String email;
    private int phoneNumber;
    
    private void checkTheListOfStudents(){
        ArrayList<HomeSchoolStudent> chickens = new ArrayList<>();
        ArrayList<HomeSchoolStudent> chickens2 = new ArrayList<>();              
        CreateMenu createMenu = new CreateMenu();
        RegisterStudent fileRead = new FileReader();
        FileWritter fileWritte = new FileWritter();
        
        boolean finish = true;
        while(finish == true){
            int optionMenu = createMenu.createMenu();
            switch (optionMenu){
                case 1:
                    chicken = fileRead.readFile();
                    chickens.add(chicken);
                    break;
                case 2:
                    chicken = fileRead.readFile();
                    chickens2.add(chicken);
                    break;
                case 3:
                    Coop coop1 = new Coop(1, chickens);
                    Coop coop2 = new Coop(2, chickens2);
                    fileWritte.fileWritter(coop1, coop2);
                    break;
                default:
                    finish = false;
                    break;
            }
        }
    }
    
   
}
