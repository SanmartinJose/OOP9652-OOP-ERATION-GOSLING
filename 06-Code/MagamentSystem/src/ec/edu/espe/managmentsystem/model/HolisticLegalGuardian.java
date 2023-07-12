/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class HolisticLegalGuardian {
    int age ;
    int studentId;
    String phoneNumber;
    String name;
    String email;
    
    public HolisticLegalGuardian(int age, String phoneNumber, String name, String email){
        this.age = age;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.name= name;
        this.email = email;
    }
    
     public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getStudentId(){
        return studentId;
    }
    
    public void setStudentId(){
        this.studentId = studentId;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
