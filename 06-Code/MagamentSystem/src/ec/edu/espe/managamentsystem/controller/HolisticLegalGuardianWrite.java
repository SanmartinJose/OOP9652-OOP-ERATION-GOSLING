/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HolisticLegalGuardian;
import java.io.File;
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
        try(PrintWriter printWriter = new PrintWriter(new File("C:\\Users\\oswal\\Desktop\\MagamentSystem\\data\\holisticLegalGuardian.json"))){
            printWriter.write(gsonholisticLegalGuardian);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
