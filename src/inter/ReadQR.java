/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import table.TableCustom;
import util.DBconnect;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL-PC
 */
public class ReadQR extends javax.swing.JFrame implements Runnable ,ThreadFactory{
    Connection conn;
private Webcam webcam = null;
    private WebcamPanel panel=null;
   private Executor executor = Executors.newSingleThreadExecutor(this);
    /**
     * Creates new form ReadQR
     */
    public ReadQR() {
        initComponents();
        conn = DBconnect.connectdb();
        TableLoad();
        iniwebcam();
       
       
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    private void TableLoad(){

        try {
             String sql = "SELET ID, Gym_ID, Status, Date, Time FROM attendance";
            
           PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
                      DefaultTableModel model = (DefaultTableModel) table1.getModel();
          model.setRowCount(0);

           while (rs.next()) {
                String a = rs.getString("ID");
                String k = rs.getString("Gym_ID");
                String m = rs.getString("Status");
                String c = rs.getString("Date");
                String b = rs.getString("Time");
 
           model.addRow(new Object[]{a,k,m,c,b}); 
            
           } 
           
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_result = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 330));

        jLabel1.setText("Result");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 60, -1));

        txt_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_resultActionPerformed(evt);
            }
        });
        getContentPane().add(txt_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 380, 40));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_resultActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ReadQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReadQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReadQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReadQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
     IntelliJTheme.setup(AddMembers.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadQR().setVisible(true);
            }
        });
    }
    
     private void iniwebcam(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel .setFPSDisplayed(true);
        
        
        jPanel2.add(panel,new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0,400,300));
        
        executor.execute(this);
        
        
    }
    @Override
    public  void run(){
        do {            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Result result = null ;
            BufferedImage image = null ;
            
            if (webcam.isOpen()){
                if ((image = webcam.getImage())== null){
                    continue;
                }
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap( new HybridBinarizer(source));
            
            try {
                result =new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(result != null){
                txt_result.setText(result.getText());
            }
            
        } while (true);
        
    }
    
    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread(r,"My Thread");
        t.setDaemon(true);
        return t;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txt_result;
    // End of variables declaration//GEN-END:variables
}
