/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ec.edu.espe.managamentsystem.view.holistic;

import com.mongodb.client.MongoCursor;
import ec.edu.espe.managamentsystem.controller.HolisticLegalGuardianController;
import ec.edu.espe.managamentsystem.controller.HolisticStudentController;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Oswaldo Tipan
 */
public class Impresión extends javax.swing.JPanel implements Printable {
    DefaultTableModel dtm = new DefaultTableModel();
    public Impresión() {
        initComponents();
        String[] title = new String[]{"N", "Name","Age","Legal Guardian"};
        dtm.setColumnIdentifiers(title);
        tbeHolisticStudents.setModel(dtm);
        addTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeHolisticStudents = new javax.swing.JTable();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estudiantes de Holística");

        tbeHolisticStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Name", "Age", "Legal Guardian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeHolisticStudents.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tbeHolisticStudents.setShowGrid(false);
        tbeHolisticStudents.setShowHorizontalLines(true);
        tbeHolisticStudents.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tbeHolisticStudents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbeHolisticStudents;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex==0){
            Graphics2D graphcis2d = (Graphics2D) graphics;
            graphcis2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            printAll(graphcis2d);
            return PAGE_EXISTS;
        }else{
            return NO_SUCH_PAGE;
        }
    }
    
     private void addTableData(){
        
       HolisticStudentController holisticStudentController;
       holisticStudentController = new HolisticStudentController();
       
       HolisticLegalGuardianController holisticLegalGuardianController;
       holisticLegalGuardianController = new HolisticLegalGuardianController();
       
       MongoCursor<Document> cursor = holisticStudentController.getStudentList().iterator();
       
       
       while(cursor.hasNext()){
            Document document = cursor.next();
            
            int id = (int) document.get("_id");
            
            dtm.addRow(new Object[]{
               document.get("_id"),
                document.get("name"),
                document.get("age"), 
            });
       }
    }
}
