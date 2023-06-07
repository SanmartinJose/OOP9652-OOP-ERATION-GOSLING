/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticLegalGuardianWrite {
      public void fileWritter(HolisticLegalGuardian holisticLegalGuardian){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonholisticLegalGuardian = gson.toJson(holisticLegalGuardian);
    
        JSONParser parser = new JSONParser();
        
        try{
            String route = "data\\holisticLegalGuardian.json";
            String routeHelp = "data\\help.json";
            
            FileWriter writer2 = new FileWriter(routeHelp, false); 
            writer2.write(gsonholisticLegalGuardian); 
            writer2.close(); 
            
            Object arr = parser.parse(new FileReader(route));
            Object arr2 = parser.parse(new FileReader(routeHelp));
        
            JSONObject si = (JSONObject) arr;
            JSONObject si2 = (JSONObject) arr2;
         
            JSONArray array = (JSONArray) si.get("guardian");
            
            array.add(arr2);
            String newArray =gson.toJson(arr);
        
            BufferedWriter writer = new BufferedWriter(new FileWriter(route, false)); 
            writer.newLine();  //nueva linea!
            writer.write(newArray); //Escribe palabra
            writer.close();  //Cierra BufferedWriter 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
