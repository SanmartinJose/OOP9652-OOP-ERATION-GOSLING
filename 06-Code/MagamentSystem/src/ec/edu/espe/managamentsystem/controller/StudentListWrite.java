
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HomeSchoolCourse;
import java.io.File;
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
        try(PrintWriter printWriter = new PrintWriter(new File("C:\\Users\\USER\\Documents\\ESPE\\Semestre 2023 1\\OOP\\OOP9652-OOP-ERATION-GOSLING\\06-Code\\MagamentSystem\\data\\studentList.json"))){
            printWriter.write(gsonhomeschoolcourseA);
            printWriter.write(gsonhomeschoolcourseB);
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
