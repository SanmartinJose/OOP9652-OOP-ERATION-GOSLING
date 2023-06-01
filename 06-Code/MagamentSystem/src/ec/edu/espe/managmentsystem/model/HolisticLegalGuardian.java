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
     int age;
    long phoneNumber;
    String name;
    String email;
    
    public HolisticLegalGuardian(int age, long phoneNumber, String name, String email){
        this.age = age;
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
    
    public long getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    public String toString(){
        return "HolisticStudent{" + "age=" + age + "phoneNumber=" + phoneNumber + "name=" + name + "email=" + email + "}";
    }
}
