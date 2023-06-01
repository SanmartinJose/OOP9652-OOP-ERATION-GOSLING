
package ec.edu.espe.managmentsystem.model;


import ec.edu.espe.managamentsystem.controller.RegisterStudent;
import ec.edu.espe.managamentsystem.controller.StudentListWrite;
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
    HomeSchoolStudent homeSchoolStudent;
    
    private void checkTheListOfStudents(){
        ArrayList<HomeSchoolStudent> homeSchoolStudentsA = new ArrayList<>();
        ArrayList<HomeSchoolStudent> homeSchoolStudentsB = new ArrayList<>();              
        CreateMenu createMenu = new CreateMenu();
        RegisterStudent fileRead = new RegisterStudent();
        StudentListWrite fileWritte = new StudentListWrite();
        
        boolean finish = true;
        while(finish == true){
            int optionMenu = createMenu.createMenu();
            switch (optionMenu){
                case 1:
                    homeSchoolStudent = fileRead.readFile();
                    homeSchoolStudentsA.add(homeSchoolStudent);
                    break;
                case 2:
                    homeSchoolStudent = fileRead.readFile();
                    homeSchoolStudentsB.add(homeSchoolStudent);
                    break;
                case 3:
                    HomeSchoolCourse homeSchoolCourseA = new HomeSchoolCourse(1,"A", homeSchoolStudentsA);
                    HomeSchoolCourse homeSchoolCourseB = new HomeSchoolCourse(2, "B", homeSchoolStudentsB);
                    fileWritte.studentFileWritter(homeSchoolCourseA , homeSchoolCourseB);
                    break;
                default:
                    finish = false;
                    break;
            }
        }
    }
    
   
}
