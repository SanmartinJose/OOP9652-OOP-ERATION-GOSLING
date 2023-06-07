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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticStudentWrite {
    public void fileWritter(HolisticStudent holisticStudent){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonholisticStudent = gson.toJson(holisticStudent);
        
        
        JSONParser parser = new JSONParser();
        
        try{              
        String route = "data\\holisticStudents.json";
        String routeHelp = "data\\help.json";
        
        FileWriter writer2 = new FileWriter(routeHelp, false); 
        writer2.write(gsonholisticStudent); 
        writer2.close(); 
        
        Object arr = parser.parse(new FileReader(route));
        Object arr2 = parser.parse(new FileReader(routeHelp));
        
        JSONObject si = (JSONObject) arr;
        JSONObject si2 = (JSONObject) arr2;
         
        JSONArray array = (JSONArray) si.get("students");
        
        
        array.add(arr2);
        String newArray =gson.toJson(arr);
        
        
        FileWriter writer = new FileWriter(route, false); 
        writer.write(newArray); 
        writer.close();  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void fileReader() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException{
        
        
        String fileRoute = "data\\holisticStudents.json";
 
        JSONParser parser = new JSONParser();
        
        try {
            
            Object holisticStudentsObject = parser.parse(new FileReader(fileRoute));
            JSONObject holisticStudentsJSONObject = (JSONObject) holisticStudentsObject;
            JSONArray holisticStudentArray = (JSONArray) holisticStudentsJSONObject.get("students");
            
            printHolisticStudents(holisticStudentArray);
        
        }catch (JSONException e) {
            System.out.println("Error al mostrar los estudiantes: " + e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
               System.out.println("Presione Enter para continuar");
        sc.nextLine();
    }
    
    public void printHolisticStudents(ArrayList holisticStudentArray ){
        System.out.println("-------Estudiante de holistica:-------\n");
            System.out.println("Id\tName\t\tAge\t\tAddress\n");
            
            for(int i =0; i < holisticStudentArray.size() ;i++){
                JSONObject singleStudent = (JSONObject) holisticStudentArray.get(i);
                System.out.println(singleStudent.get("id")+"\t"+singleStudent.get("name")+"\t\t"+singleStudent.get("age")+"\t\t"+singleStudent.get("address")+"\n");
            }
    }
}
