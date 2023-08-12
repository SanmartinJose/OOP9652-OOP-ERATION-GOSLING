package ec.edu.espe.managamentsystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.managamentsystem.view.FrmManagmentSystem;
import ec.edu.espe.managamentsystem.view.FrmManagmentSystemInstructor;
import ec.edu.espe.managamentsystem.view.FrmPrincipalLogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class LoginController {

    private boolean succesfulLogin = false;
    private FrmPrincipalLogin frmPrincipalLogin;

    public LoginController(FrmPrincipalLogin frmPrincipalLogin) {
        this.frmPrincipalLogin = frmPrincipalLogin;
    }

    public void principalLogin(JTextField txtUsername, JTextField txtCode, JLabel lblAlert, JLabel lblAlert1, FrmPrincipalLogin frmPrincipalLogin) {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            if (txtUsername.getText().isEmpty() || txtCode.getText().isEmpty()) {
                lblAlert.setVisible(true);
                lblAlert1.setVisible(true);
            } else {
                lblAlert.setVisible(false);
                lblAlert1.setVisible(false);
                stayInLogin();
            }

            if (login(txtUsername, txtCode, "Admin") == true) {
                enterToTheProgramAdmin();
            } else if (login(txtUsername, txtCode, "Instructor") == true) {
                enterToTheProgramInstructor();
            } else {
                stayInLogin();
                JOptionPane.showMessageDialog(frmPrincipalLogin, "Intenta de nuevo", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void enterToTheProgramAdmin() {

        FrmManagmentSystem frmMagamentSystem = new FrmManagmentSystem();
        frmMagamentSystem.setVisible(true);
        frmPrincipalLogin.dispose();

    }

    private void enterToTheProgramInstructor() {

        FrmManagmentSystemInstructor frmMagamentSystemInstructor = new FrmManagmentSystemInstructor();
        frmMagamentSystemInstructor.setVisible(true);
        frmPrincipalLogin.dispose();
    }

    private void stayInLogin() {
        FrmManagmentSystem frmMagamentSystem = new FrmManagmentSystem();
        frmMagamentSystem.setVisible(false);
    }

    public boolean login(JTextField usernameField, JTextField passwordField, String typeOfUser) {

        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            String username = usernameField.getText();
            String password = passwordField.getText();
            String cifrada = "";

            int desplazar = 2;
            for (int i = 0; i < password.length(); i++) {
                int codigoLetra = password.codePointAt(i);
                char letraDesplazada = (char) (codigoLetra + desplazar);
                cifrada = cifrada + letraDesplazada;
            }

            Bson filter = Filters.and(
                    Filters.eq("username", username),
                    Filters.eq("password", cifrada),
                    Filters.eq("typeOfUser", typeOfUser)
            );

            Document user = collection.find(filter).first();

            if (user != null && user.getString("username").equals(username) && user.getString("password").equals(cifrada)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
