/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import table.TableCustom;
import util.DBconnect;

/**
 *
 * @author DELL-PC
 */
public class shedulsearch extends javax.swing.JFrame {
 Connection conn;
 int xMouse;
int yMouse;
    /**
     * Creates new form shedulsearch
     */
    public shedulsearch() {
        initComponents();
        conn = DBconnect.connectdb();
        tableload() ;
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

        private void tableload() {
        try {
            String sql = "SELECT * FROM sheduledetails ORDER BY shedul_ID DESC";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            tbl_Shedule.setModel(DbUtils.resultSetToTableModel(rs));

//            tbl_Shedule.getColumnModel().getColumn(0).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(0).setMaxWidth(0);
//            
//            tbl_Shedule.getColumnModel().getColumn(1).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(1).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(2).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(2).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(3).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(3).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(4).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(4).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(5).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(6).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(6).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(7).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(7).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(8).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(9).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(9).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(10).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(11).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(11).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(12).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(12).setMaxWidth(0);
            
            
            tbl_Shedule.getColumnModel().getColumn(13).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(13).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(14).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(14).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(15).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(15).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(16).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(16).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(17).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(17).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(18).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(18).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(19).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(19).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(20).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(20).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(21).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(21).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(22).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(22).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(23).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(23).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(24).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(24).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(25).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(25).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(26).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(26).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(27).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(27).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(28).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(28).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(29).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(29).setMaxWidth(0);
            
             tbl_Shedule.getColumnModel().getColumn(30).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(30).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(31).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(31).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(32).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(32).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(33).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(33).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(34).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(34).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(35).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(35).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(36).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(36).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(37).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(37).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(38).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(38).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(39).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(39).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(40).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(40).setMaxWidth(0);
             
            tbl_Shedule.getColumnModel().getColumn(41).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(41).setMaxWidth(0);
             
            tbl_Shedule.getColumnModel().getColumn(42).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(42).setMaxWidth(0);
            

           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void tablesearch(){
        try {
            
            String a = txt_search.getText();
            String b = (String) cmb_type.getSelectedItem();
            
            String sql = "SELECT * FROM sheduledetails WHERE shedul_ID='"+a+"' OR Gym_ID='"+a+"' OR Trainer_ID='"+a+"' "
                    + "OR Type='"+b+"'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            tbl_Shedule.setModel(DbUtils.resultSetToTableModel(rs));

//            tbl_Shedule.getColumnModel().getColumn(0).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(0).setMaxWidth(0);
//            
//            tbl_Shedule.getColumnModel().getColumn(1).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(1).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(2).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(2).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(3).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(3).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(4).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(4).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(5).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(6).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(6).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(7).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(7).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(8).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(9).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(9).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(10).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(11).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(11).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(12).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(12).setMaxWidth(0);
            
            
            tbl_Shedule.getColumnModel().getColumn(13).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(13).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(14).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(14).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(15).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(15).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(16).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(16).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(17).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(17).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(18).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(18).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(19).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(19).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(20).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(20).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(21).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(21).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(22).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(22).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(23).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(23).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(24).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(24).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(25).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(25).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(26).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(26).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(27).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(27).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(28).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(28).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(29).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(29).setMaxWidth(0);
            
             tbl_Shedule.getColumnModel().getColumn(30).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(30).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(31).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(31).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(32).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(32).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(33).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(33).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(34).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(34).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(35).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(35).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(36).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(36).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(37).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(37).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(38).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(38).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(39).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(39).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(40).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(40).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(41).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(41).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(42).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(42).setMaxWidth(0);
            

        } catch (Exception e) {
        }
    }
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Shedule = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        cmb_type = new javax.swing.JComboBox<>();
        txt_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        btn_minimize = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Shedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Shedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Shedule);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fat Burn", "Beginer ", "Beginer Level 1", "Chest Day", "Sholder Day", "Back Day", "Legs Day" }));
        cmb_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmb_typeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmb_typeMouseReleased(evt);
            }
        });
        cmb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_typeActionPerformed(evt);
            }
        });

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btn_Close.setBackground(new java.awt.Color(0, 0, 0));
        btn_Close.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btn_Close.setForeground(new java.awt.Color(255, 255, 255));
        btn_Close.setText("X");
        btn_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CloseMouseExited(evt);
            }
        });

        btn_minimize.setBackground(new java.awt.Color(0, 0, 0));
        btn_minimize.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btn_minimize.setForeground(new java.awt.Color(255, 255, 255));
        btn_minimize.setText("--");
        btn_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_minimizeMouseExited(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search Shedule Page");
        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Close)
                    .addComponent(btn_minimize)
                    .addComponent(jLabel15)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SheduleMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tbl_SheduleMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_searchKeyReleased

    private void cmb_typeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_typeMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_typeMouseExited

    private void cmb_typeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_typeMouseReleased
        // TODO add your handling code here:
        tablesearch();
    }//GEN-LAST:event_cmb_typeMouseReleased

    private void cmb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_typeActionPerformed
        // TODO add your handling code here:
         tablesearch();
    }//GEN-LAST:event_cmb_typeActionPerformed

    private void btn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_CloseMouseClicked

    private void btn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseEntered
        // TODO add your handling code here:
        btn_Close.setBackground(Color.red);
    }//GEN-LAST:event_btn_CloseMouseEntered

    private void btn_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseExited
        // TODO add your handling code here:
        btn_Close.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btn_CloseMouseExited

    private void btn_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizeMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btn_minimizeMouseClicked

    private void btn_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizeMouseEntered
        // TODO add your handling code here:
        btn_minimize.setBackground(Color.red);
    }//GEN-LAST:event_btn_minimizeMouseEntered

    private void btn_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizeMouseExited
        // TODO add your handling code here:
        btn_minimize.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btn_minimizeMouseExited

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse= evt.getY();
    }//GEN-LAST:event_jLabel15MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
//            java.util.logging.Logger.getLogger(shedulsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(shedulsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(shedulsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(shedulsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        IntelliJTheme.setup(shedules.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new shedulsearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Shedule;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
