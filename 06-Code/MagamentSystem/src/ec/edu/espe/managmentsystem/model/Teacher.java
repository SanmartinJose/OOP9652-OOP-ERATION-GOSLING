
package ec.edu.espe.managmentsystem.model;

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
        
    }
    
    public void controlTeachersMenu(){
        
        Scanner optionIn = new Scanner(System.in);
        
        int opc =0;
        
        while(opc!=3){
            System.out.println("------- School Managment Software------\n");
            System.out.println("1. Add new Teacher\n");
            System.out.println("2. See Teachers' List\n");
            System.out.println("3. Go Back\n");
            System.out.println("Insert you option: ");
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
