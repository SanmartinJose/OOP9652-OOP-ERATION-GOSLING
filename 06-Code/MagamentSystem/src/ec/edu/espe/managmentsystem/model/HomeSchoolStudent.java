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
    private int courseId;
    private String name;
    private String typeOfStudy;
    private String address;

    public HomeSchoolStudent(int id, int courseId, String name, String typeOfStudy, String address) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.typeOfStudy = typeOfStudy;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
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

    @Override
    public String toString() {
        return "HomeSchoolStudent{" + "id=" + id + ", age=" + age + ", name=" + name + ", typeOfStudy=" + typeOfStudy + ", address=" + address + '}';
    }

}
