/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.managmentsystem.model.HolisticStudent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONArray;
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
        try(PrintWriter printWriter = new PrintWriter(new File("holisticStudents.json"))){
            printWriter.write(gsonholisticStudent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void fileReader() throws FileNotFoundException, IOException{
        
        
        String rutaArchivo = "C:\\Users\\oswal\\Desktop\\MagamentSystem\\data\\holisticStudents.json";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        StringBuilder jsonStr = new StringBuilder();
        String linea;
        while ((linea = br.readLine()) != null) {
            jsonStr.append(linea);
        }
        String contenidoJSON = jsonStr.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contenidoJSON = "...";

        JSONObject jsonObject = new JSONObject(contenidoJSON);

        String valorString = jsonObject.getString("claveString");
        int valorInt = jsonObject.getInt("claveInt");
        boolean valorBoolean = jsonObject.getBoolean("claveBoolean");
        JSONObject objetoAnidado = jsonObject.getJSONObject("claveObjeto");

        JSONArray jsonArray = jsonObject.getJSONArray("claveArray");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject elementoArray = jsonArray.getJSONObject(i);
        }
    }
}
