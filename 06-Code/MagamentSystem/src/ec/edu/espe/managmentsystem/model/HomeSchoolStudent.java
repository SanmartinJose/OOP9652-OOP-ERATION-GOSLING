
package ec.edu.espe.managmentsystem.model;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Oswaldo Tipan
 */
public class HomeSchoolStudent {
    private int id;
    private int age;
    private String name;
    private String typeOfStudy;
    private String address; 
    private Date bornDate;
    
    public void controlStudentsMenu(){
        
        Scanner optionIn = new Scanner(System.in);
        
        int opc =0;
        
        while(opc!=3){
            System.out.println("------- School Managment Software------\n");
            System.out.println("1. Add new Student\n");
            System.out.println("2. See Students' List\n");
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
    
    public HomeSchoolStudent(int id, String name, String typeOfStudy, String address, Date bornDate) {
        this.id = id;
        this.name = name;
        this.typeOfStudy = typeOfStudy;
        this.address = address;
        this.bornDate = bornDate;
        bornDate.setYear(bornDate.getYear()-1900);
        this.age=computeAge().getYear();
    }
    private Date computeAge(){
        // TODO code, compute agein years using the bornOnDate
        long timeDiff = new Date().getTime() - bornDate.getTime();
        Date ageDate = new Date();
        ageDate.setTime(timeDiff);
        ageDate.setYear(ageDate.getYear()-70);
        return ageDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfStudy() {
        return typeOfStudy;
    }

    public void setTypeOfStudy(String typeOfStudy) {
        this.typeOfStudy = typeOfStudy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBorndate() {
        return bornDate;
    }

    public void setBorndate(Date borndate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "HomeSchoolStudent{" + "id=" + id + ", age=" + age + ", name=" + name + ", typeOfStudy=" + typeOfStudy + ", address=" + address + ", borndate=" + bornDate + '}';
    }
    
}
