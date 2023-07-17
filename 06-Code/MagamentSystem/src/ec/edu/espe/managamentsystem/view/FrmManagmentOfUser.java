
package ec.edu.espe.managamentsystem.view;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class FrmManagmentOfUser extends javax.swing.JFrame {

    
    /**
     * Creates new form FrmRecoverUser
     */
    public FrmManagmentOfUser() {           
        
        initComponents();
        tbeManagmentOfUser.setModel(addTableData());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeManagmentOfUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btmBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("C.I.");

        jLabel2.setText("Nombre de Usuario");

        jLabel3.setText("Correo");

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefono");

        btnCreate.setText("Crear");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID)
                            .addComponent(txtUserName)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tbeManagmentOfUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbeManagmentOfUser);
        tbeManagmentOfUser.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\user (3).png")); // NOI18N

        btmBack.setText("Volver");
        btmBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btmBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btmBack))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String userName = txtUserName.getText();
    String email = txtEmail.getText(); 
    String phone = txtPhone.getText();
    String Id = txtID.getText();

    DefaultTableModel tableModel = (DefaultTableModel) tbeManagmentOfUser.getModel();
    tableModel.setRowCount(0); // Limpiar el contenido actual de la tabla

    String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
    String db = "SchoolManagmentSystem";

    try (final MongoClient mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase(db);
        MongoCollection<Document> collection = database.getCollection("Users");

        // Construir el filtro de búsqueda
        Bson filter = null;
        if (!userName.isEmpty()) {
            filter = Filters.eq("username", userName);
        } else if (!email.isEmpty()) {
            filter = Filters.eq("email", email);
        } else if (!phone.isEmpty()) {
            filter = Filters.eq("cellphone", phone);
        }else if (!Id.isEmpty()) {
            filter = Filters.eq("id", Id);
        }

        // Buscar los documentos que coincidan con el filtro
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

            // Desencriptar la contraseña
            String descifrada = "";
            int desplazar = 2;
            for (int i = 0; i < password.length(); i++) {
                int codigoLetra = password.codePointAt(i);
                char letraDesplazada = (char) (codigoLetra - desplazar);
                descifrada += letraDesplazada;
            }

            // Agregar la fila al modelo de la tabla
            tableModel.addRow(new Object[]{id, fullName, cellphone, userEmail, username, descifrada, typeOfUser});
        }
    } catch (MongoException e) {
        e.printStackTrace();
    }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btmBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBackActionPerformed
        FrmManagmentSystem frmManagmentSystem = new FrmManagmentSystem();
        frmManagmentSystem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btmBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
       FrmCreateUser frmCreateUser = new FrmCreateUser();
       frmCreateUser.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     int selectedRow = tbeManagmentOfUser.getSelectedRow();
    
    if (selectedRow != -1) {
        String id = tbeManagmentOfUser.getValueAt(selectedRow, 0).toString();
        String userName = tbeManagmentOfUser.getValueAt(selectedRow, 4).toString();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        
        tbeManagmentOfUser.setValueAt(email, selectedRow, 3);
        tbeManagmentOfUser.setValueAt(phone, selectedRow, 2);
        
        boolean success = updateDataBase(id, userName, email, phone);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Los datos se actualizaron correctamente en la base de datos.");
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al actualizar los datos en la base de datos.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para editar.");
    }        
            
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    
    int selectedRow = tbeManagmentOfUser.getSelectedRow();

    if (selectedRow != -1) {
        String fullName = tbeManagmentOfUser.getValueAt(selectedRow, 1).toString();
        String id = tbeManagmentOfUser.getValueAt(selectedRow, 0).toString();

        // Mostrar el cuadro de diálogo de confirmación
        int choice = JOptionPane.showOptionDialog(
            this,
            "¿Estás seguro de que deseas eliminar a este usuario?\n: " + fullName,
            "Confirmar eliminación",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Sí", "No", "Cancelar"},
            null
        );

        if (choice == JOptionPane.YES_OPTION) {
           
            DefaultTableModel tableModel = (DefaultTableModel) tbeManagmentOfUser.getModel();
            tableModel.removeRow(selectedRow);

            
            boolean success = deleteInDataBase(id);

            if (success) {
                JOptionPane.showMessageDialog(this, "El usuario se eliminó correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el usuario.");
            }
        } else if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "La eliminación del usuario ha sido cancelada.");
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            // No hacer nada, simplemente cerrar el cuadro de diálogo
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
    }

    }//GEN-LAST:event_btnDeleteActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmManagmentOfUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmManagmentOfUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmManagmentOfUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmManagmentOfUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmManagmentOfUser().setVisible(true);
            }
        });
    }
    private DefaultTableModel addTableData() {
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
   
    private boolean updateDataBase(String id, String userName, String email, String phone) {
        String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
        String db = "SchoolManagmentSystem";

        try (final MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            MongoCollection<Document> collection = database.getCollection("Users");

            
            Bson filter = Filters.eq("id", id);

           
            Bson updateFields = Updates.combine(
                Updates.set("email", email),
                Updates.set("cellphone", phone)
            );

           
            UpdateResult result = collection.updateOne(filter, updateFields);

            // Verificar si la actualización fue exitosa
            if (result.getModifiedCount() > 0) {
                return true;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return false; // La actualización no fue exitosa
    }

    private boolean deleteInDataBase(String id) {
    String uri = "mongodb+srv://jmsanmartin:12345@managmentsystem.kklzuz1.mongodb.net/?retryWrites=true&w=majority";
    String db = "SchoolManagmentSystem";

    try (final MongoClient mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase(db);
        MongoCollection<Document> collection = database.getCollection("Users");

        // Construir el filtro para encontrar el documento a eliminar
        Bson filter = Filters.eq("id", id);

        // Eliminar el documento de la base de datos
        DeleteResult result = collection.deleteOne(filter);

        // Verificar si la eliminación fue exitosa
        if (result.getDeletedCount() > 0) {
            return true;
        }
    } catch (MongoException e) {
        e.printStackTrace();
    }

    return false; // La eliminación no fue exitosa
}

    
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbeManagmentOfUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}