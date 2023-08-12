package ec.edu.espe.managamentsystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.managamentsystem.view.FrmCreateUser;
import ec.edu.espe.managmentsystem.model.User;
import ec.edu.espe.managmentsystem.util.Validation;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.bson.Document;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class UserCreation {

    public static boolean registerAnUser(JTextField identification, JTextField name, JTextField code, JTextField mail, JTextField userName, JTextField phone, JComboBox typeUser, JLabel alertId, JLabel alertName, JLabel alertEmail, JLabel alertPassword, JLabel alertPhone, JLabel alertUser) {
        FrmCreateUser frmCreateUser = new FrmCreateUser();

        Validation v = new Validation();
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";

        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");
            User user;
            String id;
            String fullName;
            String cellphone;
            String email;
            String typeOfUser;
            String username;
            String password = null;
            String cadena;

            if (identification.getText().isEmpty() || name.getText().isEmpty()
                    || code.getText().isEmpty() || mail.getText().isEmpty()
                    || userName.getText().isEmpty() || phone.getText().isEmpty()) {
                alertId.setVisible(true);
                alertName.setVisible(true);
                alertEmail.setVisible(true);
                alertPassword.setVisible(true);
                alertPhone.setVisible(true);
                alertUser.setVisible(true);
                return false;
            } else {
                alertId.setVisible(false);
                alertName.setVisible(false);
                alertEmail.setVisible(false);
                alertPassword.setVisible(false);
                alertPhone.setVisible(false);
                alertUser.setVisible(false);
            }

            id = v.validateNumber(identification);
            fullName = v.validateName(name);
            cellphone = v.validateNumber(phone);
            email = v.validateEmail(mail);
            typeOfUser = typeUser.getSelectedItem().toString();
            username = userName.getText();

            Document existingUser = collection.find(eq("username", username)).first();
            if (existingUser != null) {
                JOptionPane.showMessageDialog(frmCreateUser, "El nombre de usuario ya existe");
                return true;
            }

            cadena = v.validatePassword(code);
            if (cadena == null) {
                JOptionPane.showMessageDialog(frmCreateUser, "La contraseña no es válida \n "
                        + "recuerda que solo puede contener letra o numeros" + "\n y debe tener de 6 a 12 caracteres");
                return true;
            }

            String cifrada = "";
            int desplazar = 2;
            for (int i = 0; i < cadena.length(); i++) {
                int codigoLetra = cadena.codePointAt(i);
                char letraDesplazada = (char) (codigoLetra + desplazar);
                cifrada = cifrada + letraDesplazada;
            }

            Document document = new Document("id", id)
                    .append("fullName", fullName)
                    .append("cellphone", cellphone)
                    .append("email", email)
                    .append("typeOfUser", typeOfUser)
                    .append("username", username)
                    .append("password", cifrada);

            collection.insertOne(document);
            mongoClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(frmCreateUser, "Usuario Guardado con Exito");
        frmCreateUser.emptyField();
        return false;

    }
}
