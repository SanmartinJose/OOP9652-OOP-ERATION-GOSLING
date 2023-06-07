/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managamentsystem.controller;

/**
 *
 * @author Oswaldo Tipan
 */
public class Validator {
    public static boolean validateString(String dataString){
        try {
		Integer.parseInt(dataString);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static boolean validateMinus(Double number){
        if(number > 0){
            return true;
        }else{
            return false;
        }
    }
}
