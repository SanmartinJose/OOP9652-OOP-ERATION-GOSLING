
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HomeSchoolCourse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class StudentListWrite {
public void studentFileWritter(HomeSchoolCourse homeschoolcourseA, HomeSchoolCourse homeschoolcourseB){
    
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonhomeschoolcourseA = gson.toJson(homeschoolcourseA);
        String gsonhomeschoolcourseB = gson.toJson(homeschoolcourseB);
        System.out.println(gsonhomeschoolcourseA);
        System.out.println(gsonhomeschoolcourseB);
        try{              
        String ruta = "data\\holisticStudents.json";
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true)); 
        writer.newLine();
        writer.write(gsonhomeschoolcourseA);
        writer.write(gsonhomeschoolcourseB);
        writer.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
