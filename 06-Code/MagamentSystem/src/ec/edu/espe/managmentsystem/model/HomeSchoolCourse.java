/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managmentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author PabloEZurita
 */
public class HomeSchoolCourse {
    private int id;
    private String name;
    private ArrayList<HomeSchoolStudent>homeschoolstudent;

    public HomeSchoolCourse(int id, String name, ArrayList<HomeSchoolStudent> homeschoolstudent) {
        this.id = id;
        this.name = name;
        this.homeschoolstudent = homeschoolstudent;
    }

    @Override
    public String toString() {
        return "HomeSchoolCourse{" + "id=" + id + ", name=" + name + ", homeschoolstudent=" + homeschoolstudent + '}';
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public ArrayList<HomeSchoolStudent> getHomeschoolstudent() {
        return homeschoolstudent;
    }

    public void setHomeschoolstudent(ArrayList<HomeSchoolStudent> homeschoolstudent) {
        this.homeschoolstudent = homeschoolstudent;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
