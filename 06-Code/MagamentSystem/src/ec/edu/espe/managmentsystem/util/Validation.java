
package ec.edu.espe.managmentsystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class Validation {
    public String validateName(JTextField textField) {
        String inputString = textField.getText();
        
        if (inputString.matches("[a-zA-ZñÑ, ]+")) {
            return inputString;
        } else {
            return null;
        }
    }
    public  String validateNumber(JTextField textField) {
        String inputString = textField.getText();
        
        // Check if the string consists of only numeric characters and has a length of up to 10
        if (inputString.matches("[0-9]{1,10}")) {
            return inputString;
        } else {
            return null;
        }
    }
    public  String validateString(JTextField textField) {
        String inputString = textField.getText();
        
        // Regular expression that allows only letters of the alphabet (including "ñ")
        // and verifies it has an email format
        String pattern = "^[a-zA-ZñÑ]+@[a-zA-ZñÑ]+\\.[a-zA-ZñÑ]+$";

        // Create a Pattern object
        Pattern regexPattern = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regexPattern.matcher(inputString);

        // Check if the string matches the pattern
        if (matcher.matches()) {
            return inputString;
        } else {
            return null;
        }
    }
}
