/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentWrite {
    public void fileWritter(HolisticStudent holisticStudent){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonholisticStudent = gson.toJson(holisticStudent);
        System.out.println(gsonholisticStudent);
        try{              
        String ruta = "data\\holisticStudents.json";
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true)); 
        writer.newLine();  //nueva linea!
        writer.write(gsonholisticStudent); //Escribe palabra
        writer.close();  //Cierra BufferedWriter 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void fileReader() throws FileNotFoundException, IOException{
        
        
        String fileRoute = "data\\holisticStudents.json";

        try {
            
        String holisticStudent = new String(fileRoute);
        JSONObject holisticStudentObject = new JSONObject(holisticStudent);
        //JSONArray debtsArray = JSONObject.getJSONArray(0);
       
        System.out.println("-------Estudiante de holistica:-------");
        System.out.println(holisticStudentObject.getString("id"));
        
    }catch (JSONException e) {
        System.out.println("Error al mostrar los estudiantes " + e.getMessage());
    }
    Scanner sc = new Scanner(System.in);
           System.out.println("Presione Enter para continuar");
    sc.nextLine();
    }
}
