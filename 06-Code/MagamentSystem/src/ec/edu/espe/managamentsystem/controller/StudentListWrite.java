
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HomeSchoolCourse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.json.JSONObject;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class StudentListWrite {
public void studentFileWritter(HomeSchoolCourse homeschoolcourseA, HomeSchoolCourse homeschoolcourseB){
    
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonhomeschoolcourseA = gson.toJson(homeschoolcourseA);
        String gsonhomeschoolcourseB = gson.toJson(homeschoolcourseB);
        
        System.out.println("-----------------Estudiante de HomeSchool:---------------\n\n");
        printStudentList(gsonhomeschoolcourseA, "A");
        printStudentList(gsonhomeschoolcourseB, "B");
        
        try{              
        String ruta = "data\\studentList.json";
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true)); 
        writer.newLine();
        writer.write(gsonhomeschoolcourseA);
        writer.write(gsonhomeschoolcourseB);
        writer.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void printStudentList(String gsonhomeschoolcourse, String course){
        org.json.JSONObject homeSchoolObject = new org.json.JSONObject(gsonhomeschoolcourse);
        org.json.JSONArray homeSchoolArray = homeSchoolObject.getJSONArray("homeschoolstudent");
  
        System.out.println("--------------------Curso "+course+"--------------------\n\n");
        System.out.println("\tId\tName\t\tAge\t\tAddress\t\tBornOnDate\n");
            
        for(int i =0; i < homeSchoolArray.length() ;i++){
            JSONObject singleStudent = (JSONObject) homeSchoolArray.get(i);
            System.out.println("\t"+singleStudent.get("id")+"\t"+singleStudent.get("name")+"\t\t"+singleStudent.get("age")+"\t\t"+singleStudent.get("address")+"\t\t"+ singleStudent.get("bornDate") + "\n");
        }
    }
}
