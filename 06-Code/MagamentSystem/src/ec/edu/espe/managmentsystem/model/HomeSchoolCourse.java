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
