package ec.edu.espe.managamentsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.managamentsystem.view.FrmManagmentOfUser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class UserManagment {

    public DefaultTableModel addTableData() {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Full Name");
        tableModel.addColumn("Cellphone");
        tableModel.addColumn("Email");
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Type of User");

        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                String id = document.getString("id");
                String fullName = document.getString("fullName");
                String cellphone = document.getString("cellphone");
                String email = document.getString("email");
                String username = document.getString("username");
                String password = document.getString("password");
                String typeOfUser = document.getString("typeOfUser");

                // Desencriptar la contraseña
                String descifrada = "";
                int desplazar = 2;
                for (int i = 0; i < password.length(); i++) {
                    int codigoLetra = password.codePointAt(i);
                    char letraDesplazada = (char) (codigoLetra - desplazar);
                    descifrada += letraDesplazada;
                }

                tableModel.addRow(new Object[]{id, fullName, cellphone, email, username, descifrada, typeOfUser});
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return tableModel;
    }

    public static void SearchInDataBase(String userName, String email, String phone, String Id, JTable newTable) {

        DefaultTableModel tableModel = (DefaultTableModel) newTable.getModel();
        tableModel.setRowCount(0); // Limpiar el contenido actual de la tabla

        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";
        String collec = "Users";
        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection(collec);

            Bson filter = null;
            if (!userName.isEmpty()) {
                filter = Filters.eq("username", userName);
            } else if (!email.isEmpty()) {
                filter = Filters.eq("email", email);
            } else if (!phone.isEmpty()) {
                filter = Filters.eq("cellphone", phone);
            } else if (!Id.isEmpty()) {
                filter = Filters.eq("id", Id);
            }

            FindIterable<Document> documents;
            if (filter != null) {
                documents = collection.find(filter);
            } else {
                documents = collection.find();
            }

            for (Document document : documents) {
                String id = document.getString("id");
                String fullName = document.getString("fullName");
                String cellphone = document.getString("cellphone");
                String userEmail = document.getString("email");
                String username = document.getString("username");
                String password = document.getString("password");
                String typeOfUser = document.getString("typeOfUser");

                String descifrada = "";
                int desplazar = 2;
                for (int i = 0; i < password.length(); i++) {
                    int codigoLetra = password.codePointAt(i);
                    char letraDesplazada = (char) (codigoLetra - desplazar);
                    descifrada += letraDesplazada;
                }

                tableModel.addRow(new Object[]{id, fullName, cellphone, userEmail, username, descifrada, typeOfUser});
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public static void editDataBase(int selectedRowIndex, JTable table, JTextField txtId, JTextField txtUsername, JTextField txtMail, JTextField txtCellphone) {

        if (selectedRowIndex >= 0) {
            String id = (String) table.getValueAt(selectedRowIndex, 0);
            String username = (String) table.getValueAt(selectedRowIndex, 4);
            String email = (String) table.getValueAt(selectedRowIndex, 3);
            String cellphone = (String) table.getValueAt(selectedRowIndex, 2);

            txtId.setText(id);
            txtUsername.setText(username);
            txtMail.setText(email);
            txtCellphone.setText(cellphone);

            txtUsername.setEnabled(false);
            txtId.setEnabled(false);

            txtMail.setEnabled(true);
            txtCellphone.setEnabled(true);
        } else {

            JOptionPane.showMessageDialog(table, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean deleteInDataBase(String id) {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";

        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                return true;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return false; // La eliminación no fue exitosa
    }

    public void deleteDataBase(int selectedRow, JTable table) {
        FrmManagmentOfUser frmManagmentOfUser = new FrmManagmentOfUser();

        if (selectedRow != -1) {
            String fullName = table.getValueAt(selectedRow, 1).toString();
            String id = table.getValueAt(selectedRow, 0).toString();

            int choice = JOptionPane.showOptionDialog(
                    table,
                    "¿Estás seguro de que deseas eliminar a este usuario?\n: " + fullName,
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No", "Cancelar"},
                    null
            );

            if (choice == JOptionPane.YES_OPTION) {

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.removeRow(selectedRow);

                boolean success = deleteInDataBase(id);

                if (success) {
                    JOptionPane.showMessageDialog(frmManagmentOfUser, "El usuario se eliminó correctamente.");
                } else {
                    JOptionPane.showMessageDialog(frmManagmentOfUser, "Hubo un error al eliminar el usuario.");
                }
            } else if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(frmManagmentOfUser, "La eliminación del usuario ha sido cancelada.");
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                // No hacer nada, simplemente cerrar el cuadro de diálogo
            }
        } else {
            JOptionPane.showMessageDialog(table, "Por favor, selecciona un usuario para eliminar.");
        }
    }

    public void newDataSave(String id, String email, String cellphone, JTextField txtId, JTextField txtUsername, JTextField txtMail, JTextField txtCellphone) {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";
        FrmManagmentOfUser frmManagmentOfUser = new FrmManagmentOfUser();

        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            Bson filter = Filters.eq("id", id);

            Bson update = Updates.combine(
                    Updates.set("email", email),
                    Updates.set("cellphone", cellphone)
            );

            UpdateResult updateResult = collection.updateOne(filter, update);

            if (updateResult.getModifiedCount() > 0) {

                JOptionPane.showMessageDialog(frmManagmentOfUser, "Usuario Modificado con exito");

                txtId.setEnabled(true);
                txtUsername.setEnabled(true);

                txtId.setText("");
                txtUsername.setText("");
                txtMail.setText("");
                txtCellphone.setText("");
            } else {
                JOptionPane.showMessageDialog(frmManagmentOfUser, "Failed to save data");
            }
        } catch (MongoException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmManagmentOfUser, "An error occurred while saving the data");
        }
    }
}
