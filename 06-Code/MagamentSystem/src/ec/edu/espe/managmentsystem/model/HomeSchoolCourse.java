package ec.edu.espe.managmentsystem.model;

import java.util.ArrayList;

/**
 *
 * @author PabloEZurita
 */
public class HomeSchoolCourse {

    private int id;
    private String name;

    public HomeSchoolCourse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HomeSchoolCourse{" + "id=" + id + ", name=" + name + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
