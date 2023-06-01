/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentWrite {
    public void fileWritter(HolisticStudent holisticStudent){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonholisticStudent = gson.toJson(holisticStudent);
        System.out.println(gsonholisticStudent);
        try(PrintWriter printWriter = new PrintWriter(new File("holisticStudents.json"))){
            printWriter.write(gsonholisticStudent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
