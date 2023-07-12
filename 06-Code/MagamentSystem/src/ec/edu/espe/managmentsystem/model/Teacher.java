
package ec.edu.espe.managmentsystem.model;


import ec.edu.espe.managamentsystem.controller.CreateMenu;
import ec.edu.espe.managamentsystem.controller.HomeStudentController;
import ec.edu.espe.managamentsystem.controller.StudentCourseController;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class Teacher {
   
    private int id;
    private int courseId;
    private String name;
    private int age;
    private String address;
    private String email;
    private int phoneNumber;
    HomeSchoolStudent homeSchoolStudent;

    public Teacher(int id,int courseId, String name, int age, String address, String email, int phoneNumber, HomeSchoolStudent homeSchoolStudent) {
        this.id = id;
        this.courseId= courseId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.homeSchoolStudent = homeSchoolStudent;
    }

    public int getId() {
        return id;
    }
    
      public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public HomeSchoolStudent getHomeSchoolStudent() {
        return homeSchoolStudent;
    }
}
