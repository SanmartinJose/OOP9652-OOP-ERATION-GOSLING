/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author PabloEZurita
 */
public class HomeSchoolLegalGuardian {
    int age ;
    int studentId;
    String phoneNumber;
    String name;
    String email;

    public HomeSchoolLegalGuardian(int age, int studentId, String phoneNumber, String name, String email) {
        this.age = age;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    
}
