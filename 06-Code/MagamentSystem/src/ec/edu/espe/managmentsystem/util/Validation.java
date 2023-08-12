package ec.edu.espe.managmentsystem.util;

import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class Validation {

    public String validateName(JTextField textField) {
        String text = textField.getText();

        if (isValidText(text)) {
            return text;
        } else {
            textField.setText("");

            JLabel invalidLabel = new JLabel("Cadena inválida");
            textField.add(invalidLabel);

            return validateName(textField);
        }
    }

    private boolean isValidText(String text) {
        return text.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$");
    }

    public static String validId(String cedula) {
        cedula = cedula.trim();
        if (cedula.length() != 10) {
            return "Cadena inválida";
        }
        // Verificar que sean solo dígitos
        if (!cedula.matches("\\d+")) {
            return "La cédula debe contener solo dígitos";
        }
        return cedula;
    }

    public static Double validValue(String valorPagadoStr) {
        if (valorPagadoStr.isEmpty()) {
            return null;
        }
        try {
            double valor = Double.parseDouble(valorPagadoStr);

            if (valor <= 0 || valor > 9999.99) {
                return null;
            }

            return valor;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String validateNumber(JTextField textField) {
        String text = textField.getText();

        if (isValidNumber(text)) {

            return text;
        } else {
            JLabel invalidLabel = new JLabel("Cadena incorrecta");
            textField.add(invalidLabel);
            return validateName(textField);
        }
    }

    private boolean isValidNumber(String text) {
        return text.matches("\\d{10}");
    }

    public String validateEmail(JTextField textField) {
        String text = textField.getText();

        if (isValidEmail(text)) {
            return text;
        } else {
            JLabel invalidLabel = new JLabel("no");
            textField.add(invalidLabel);
            return validateName(textField);
        }
    }

    private boolean isValidEmail(String text) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(text).matches();
    }

    public String validatePassword(JTextField textField) {
        String cadena = textField.getText();

        if (cadena.matches("^[a-zA-Z0-9]{6,12}$")) {
            return cadena;
        } else {
            textField.setText("");
            return null;
        }

    }
}
