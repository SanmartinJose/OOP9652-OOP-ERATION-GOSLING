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
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Oswaldo Tipan
 */
public class HolisticLegalGuardianWrite {
      public void fileWritter(HolisticLegalGuardian holisticLegalGuardian){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonholisticLegalGuardian = gson.toJson(holisticLegalGuardian);
        System.out.println(gsonholisticLegalGuardian);
        try{
            String ruta = "C:\\Users\\oswal\\Desktop\\Personal\\IngSoftware\\OOP\\projectFolder\\OOP9652-OOP-ERATION-GOSLING\\06-Code\\MagamentSystem\\data\\holisticLegalGuardian.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true)); 
            writer.newLine();  //nueva linea!
            writer.write(gsonholisticLegalGuardian); //Escribe palabra
            writer.close();  //Cierra BufferedWriter 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
