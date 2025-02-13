/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javaswingdev.Notification;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import util.DBconnect;



public class NewSalary extends javax.swing.JFrame {

    Connection conn;
    int xMouse;
    int yMouse;

    
    
    public NewSalary() {
        initComponents();
          conn = DBconnect.connectdb();
          tableload();
        clearform();
        TodayDateLoader();
        TodayTimeLoader();
        year();
    }
    
    
    public void TodayDateLoader() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        lbl_TodayDate.setText(dd);
    }
    
    public void year() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String dd = sdf.format(d);
         year.setText(dd);
    }

    Timer t;
    SimpleDateFormat st;

    public void TodayTimeLoader() {
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                lbl_TodayTime.setText(tt);

            }
        });
        t.start();
    }

    private void loadBSal() {
        try {
            String sql = "SELECT Basic_Sal FROM trainer WHERE Trainer_ID ='" + lbl_NO.getText() + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String sub = rs.getString("Basic_Sal");
                lbl_basic.setText(sub);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void Search_bar() {

        try {

            String sql = "SELECT Trainer_ID,F_Name,L_Name,Birthday FROM trainer WHERE Trainer_ID = '" + txt_Search.getText() + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                lbl_NO.setText(rs.getString("Trainer_ID"));
                lbl_Fname.setText(rs.getString("F_Name"));
                lbl_Lname.setText(rs.getString("L_Name"));
                year.setText(rs.getString("Birthday"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void calFinalSal(){

       int a= Integer.parseInt(lbl_basic.getText());
       int b= Integer.parseInt(txt_bonus.getText());
       int c= Integer.parseInt(txt_deduction.getText());
       
       String amswer = String.valueOf(a+(b-c));
       lbl_finalsal.setText(amswer);

    
    }
    

    private void SalarySave() {
        try {
            String salarySave = "INSERT INTO salary(Trainer_ID,Year, Month, PaidDate, BasicSal, Bonus, Deduction, Final_Salary)"
                    + "VALUES('" + lbl_NO.getText() + "','"+year.getText()+"','" + cmb_months.getSelectedItem() + "','" + lbl_TodayDate.getText() + "',"
                    + "'" + lbl_basic.getText() + "','" + txt_bonus.getText() + "','" + txt_deduction.getText() + "','" + lbl_finalsal.getText()+ "')";

            PreparedStatement stmm = conn.prepareStatement(salarySave);
            stmm.executeUpdate();
            
            

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }

    private void UpadateSalary(){
        try{
        String sql ="Update salary set Year='"+year.getText()+"',Month='"+cmb_months.getSelectedItem()+"',PaidDate='"+lbl_TodayDate.getText()+"',"
                + "BasicSal='" + lbl_basic.getText() + "',Bonus='" + txt_bonus.getText() + "',Deduction='" + txt_deduction.getText() + "',"
                + "Final_Salary='" + lbl_finalsal.getText()+ "' WHERE Trainer_ID='" + lbl_NO.getText() + "'";
        
        PreparedStatement statement = conn.prepareStatement(sql);
                       statement.execute();
              
//            JOptionPane.showMessageDialog(null, "Update Success");
            Notification noti=new Notification(this ,Notification.Type.INFO,Notification.Location.TOP_CENTER,"Update Salary Succuss");
            noti.showNotification();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    private void clearform() {
        txt_Search.setText("");
        lbl_NO.setText("GYM ID");
        lbl_Fname.setText("-");
        lbl_Lname.setText("-");
        year.setText("-");
        lbl_basic.setText("-");
        txt_bonus.setText("");
        txt_deduction.setText("");
        cmb_months.setSelectedItem(null);
        lbl_finalsal.setText("-");
        lbl_alNo.setText("");
    }
    
    
    
       private void btnDelete() {
        int check = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DELETE");

        if (check == 0) {

            String addno = lbl_alNo.getText();

            try {
                String sql = "DELETE FROM salary WHERE Sal_ID='" + addno + "'";
                PreparedStatement sts = conn.prepareStatement(sql);
                sts.execute();

//                JOptionPane.showMessageDialog(null, "Delete Successfull");
                Notification noti = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Delete Salary Succuss");
                noti.showNotification();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
       
      private void tableload(){
        
        try {
            String sql ="SELECT a.Sal_ID, a.Trainer_ID, a.Year, a.Month, a.PaidDate, a.BasicSal, a.Bonus, a.Deduction,"
                    + " a.Final_Salary , b.F_Name, b.L_Name"
                    + " FROM salary as a INNER JOIN trainer b ON a.Trainer_ID = b.Trainer_ID";
            
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
          DefaultTableModel model = (DefaultTableModel) tbl_salary.getModel();
          model.setRowCount(0);
         
           while (rs.next()) {
                String a1 = rs.getString("a.Sal_ID");
                String a = rs.getString("a.Trainer_ID");
                String b = rs.getString("b.F_Name"); 
                String c = rs.getString("b.L_Name");
                String d = rs.getString("a.Year");
                String e = rs.getString("a.Month");
                String f = rs.getString("a.PaidDate");
                String g = rs.getString("a.BasicSal");
                String f1 = rs.getString("a.Bonus");
                String g1 = rs.getString("a.Deduction");
                String g2 = rs.getString("a.Final_Salary");

           
           model.addRow(new Object[]{a,b,c,d,e,f,g,f1,g1,g2,a1});
           
            tbl_salary.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(8).setMaxWidth(0);
           
            tbl_salary.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(9).setMaxWidth(0);
           
            tbl_salary.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(10).setMaxWidth(0);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
       
     private void clickRow() {

          try {
        
           int r = tbl_salary.getSelectedRow();

         String a = tbl_salary.getValueAt(r, 0).toString();
         String b = tbl_salary.getValueAt(r, 1).toString();
         String c = tbl_salary.getValueAt(r, 2).toString();      
         String d = tbl_salary.getValueAt(r, 3).toString();
         String e = tbl_salary.getValueAt(r, 4).toString();  
         String f = tbl_salary.getValueAt(r, 5).toString();
         String g = tbl_salary.getValueAt(r, 6).toString();
        String f1 = tbl_salary.getValueAt(r, 7).toString();
        String g1 = tbl_salary.getValueAt(r, 8).toString();
        String g2 = tbl_salary.getValueAt(r, 9).toString();
       String g3 = tbl_salary.getValueAt(r, 10).toString();

        lbl_NO.setText(a);   
        lbl_Fname.setText(b);
        lbl_Lname.setText(c);
        year.setText(d);
        cmb_months.setSelectedItem(e);
        lbl_paydate.setText(f);
        lbl_basic.setText(g);
        txt_bonus.setText(f1);
        txt_deduction.setText(g1);  
        lbl_alNo.setText(g3);
        lbl_finalsal.setText(g2);
        
          } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
          }
    }
     
    private void search_table(){
        try {
             String sql ="SELECT a.Sal_ID, a.Trainer_ID, a.Year, a.Month, a.PaidDate, a.BasicSal, a.Bonus, a.Deduction,"
                    + " a.Final_Salary , b.F_Name, b.L_Name"
                    + " FROM salary as a INNER JOIN trainer b ON a.Trainer_ID = b.Trainer_ID WHERE a.Trainer_ID = '" + txt_Search.getText() + "'";
            
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
          DefaultTableModel model = (DefaultTableModel) tbl_salary.getModel();
          model.setRowCount(0);
         
           while (rs.next()) {
                String a1 = rs.getString("a.Sal_ID");
                String a = rs.getString("a.Trainer_ID");
                String b = rs.getString("b.F_Name"); 
                String c = rs.getString("b.L_Name");
                String d = rs.getString("a.Year");
                String e = rs.getString("a.Month");
                String f = rs.getString("a.PaidDate");
                String g = rs.getString("a.BasicSal");
                String f1 = rs.getString("a.Bonus");
                String g1 = rs.getString("a.Deduction");
                String g2 = rs.getString("a.Final_Salary");

           
           model.addRow(new Object[]{a,b,c,d,e,f,g,f1,g1,g2,a1});
           
            tbl_salary.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(8).setMaxWidth(0);
           
            tbl_salary.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(9).setMaxWidth(0);
           
            tbl_salary.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_salary.getColumnModel().getColumn(10).setMaxWidth(0);
           }
        } catch (Exception e) {
        }
    } 
     
     
     
     
     
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_Fname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Lname = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_basic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_bonus = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_deduction = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_finalsal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_NO = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmb_months = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_salary = new javax.swing.JTable();
        lbl_paydate = new javax.swing.JLabel();
        lbl_alNo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_Search = new swing.TextFieldAnimation();
        jButton7 = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lbl_TodayDate = new javax.swing.JLabel();
        lbl_TodayTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_minimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Trainer ID / Name");

        jLabel4.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("First Name");

        lbl_Fname.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_Fname.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Fname.setText("-");

        jLabel5.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Last Name");

        lbl_Lname.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_Lname.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Lname.setText("-");

        year.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        year.setForeground(new java.awt.Color(255, 255, 255));
        year.setText("-");

        jLabel13.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Basic Salary");

        lbl_basic.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_basic.setForeground(new java.awt.Color(0, 0, 0));
        lbl_basic.setText("-");

        jLabel14.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Allowance");

        txt_bonus.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        txt_bonus.setForeground(new java.awt.Color(0, 0, 0));
        txt_bonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bonusKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Deduction");

        txt_deduction.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        txt_deduction.setForeground(new java.awt.Color(0, 0, 0));
        txt_deduction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_deductionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_deductionKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Final Salary");

        lbl_finalsal.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_finalsal.setForeground(new java.awt.Color(0, 0, 0));
        lbl_finalsal.setText("-");
        lbl_finalsal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_finalsalMouseClicked(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_24px.png"))); // NOI18N

        lbl_NO.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_NO.setForeground(new java.awt.Color(0, 0, 0));
        lbl_NO.setText("Trainer ID");

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_save_24px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(204, 0, 204));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_24px.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_eraser_24px.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("For");

        cmb_months.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_months.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January ", "February ", "March ", " April ", " May ", " June ", " July ", " August", " September", " October ", " November", " December" }));

        tbl_salary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Trainers ID", "F_Name", "L_Name", "Year", "Month", "Basic Salary", "Paid Date", "Allowance", "Deduction", "Final Salary", "ID"
            }
        ));
        tbl_salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salaryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_salary);

        lbl_paydate.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_paydate.setText("-");

        lbl_alNo.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_alNo.setText("-");

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_update_file_24px_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_bin_24px.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        txt_Search.setForeground(new java.awt.Color(0, 0, 0));
        txt_Search.setAnimationColor(new java.awt.Color(255, 0, 51));
        txt_Search.setCaretColor(new java.awt.Color(0, 0, 0));
        txt_Search.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txt_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_SearchMouseClicked(evt);
            }
        });
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 0, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_process_24px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lbl_paydate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NO)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_Lname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addComponent(year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(15, 15, 15)
                                    .addComponent(lbl_Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(cmb_months, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_basic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbl_finalsal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel14))
                                            .addGap(18, 18, 18)
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_deduction)
                                                .addComponent(txt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_alNo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_alNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_NO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lbl_Fname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lbl_Lname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(year)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(cmb_months, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_basic, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_deduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_finalsal)
                                            .addComponent(jLabel19))
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_paydate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton7))))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(26, 26, 26))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        lbl_TodayDate.setText("---");

        lbl_TodayTime.setText("--");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_TodayDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_TodayTime, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TodayDate)
                    .addComponent(lbl_TodayTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Salary Page");
        jLabel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel12MouseDragged(evt);
            }
        });
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Close)
                    .addComponent(jLabel12)
                    .addComponent(btn_minimize)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        btn_Close.setBackground(new Color(153, 204, 255));
    }//GEN-LAST:event_btn_CloseMouseExited
          
    private void jLabel12MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel12MouseDragged

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel12MousePressed

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
        btn_minimize.setBackground(new Color(153, 204, 255));
    }//GEN-LAST:event_btn_minimizeMouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here   
        SalarySave();
        tableload();
        clearform();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        clearform();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void kGradientPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseClicked
      // TODO add your handling code here:
      calFinalSal();
    }//GEN-LAST:event_kGradientPanel1MouseClicked

    private void lbl_finalsalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_finalsalMouseClicked
        // TODO add your handling code here:
        calFinalSal();
    }//GEN-LAST:event_lbl_finalsalMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        btnDelete();
        tableload();
        clearform();
    }//GEN-LAST:event_jButton1MouseClicked

    private void tbl_salaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salaryMouseClicked
        // TODO add your handling code here:
        clickRow();
    }//GEN-LAST:event_tbl_salaryMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("Sal_ID", lbl_alNo.getText()); // Replace "inv_id" with the correct parameter name in your report

//              Connection conn = db.mycon(); // Assuming db.mycon() returns a valid Connection
                String reportpath = "C:\\Users\\DELL-PC\\Documents\\GYM Project\\GYMsoft\\src\\report\\Salary.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportpath);
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
                JasperViewer.viewReport(jp);
//                 JasperPrintManager.printReport(jp, false);
                JasperViewer viewer = new JasperViewer(jp, false); // false prevents EXIT_ON_CLOSE behavior
                viewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE); // Dispose the viewer on close
                viewer.setVisible(true);

            } catch (JRException e) {
               // JOptionPane.showMessageDialog(null, "report loading success");
            }
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txt_bonusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bonusKeyReleased
        // TODO add your handling code here:
                calFinalSal();

    }//GEN-LAST:event_txt_bonusKeyReleased

    private void txt_deductionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deductionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deductionKeyPressed

    private void txt_deductionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deductionKeyReleased
        // TODO add your handling code here:
                calFinalSal();

    }//GEN-LAST:event_txt_deductionKeyReleased

    private void txt_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_SearchMouseClicked

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        // TODO add your handling code here:
        search_table();
        Search_bar();
        loadBSal();
        
    }//GEN-LAST:event_txt_SearchKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        clearform();
        tableload();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UpadateSalary();
        tableload();
        clearform();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(NewSalary.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSalary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JComboBox<String> cmb_months;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_Fname;
    private javax.swing.JLabel lbl_Lname;
    private javax.swing.JLabel lbl_NO;
    private javax.swing.JLabel lbl_TodayDate;
    private javax.swing.JLabel lbl_TodayTime;
    private javax.swing.JLabel lbl_alNo;
    private javax.swing.JLabel lbl_basic;
    private javax.swing.JLabel lbl_finalsal;
    private javax.swing.JLabel lbl_paydate;
    private javax.swing.JTable tbl_salary;
    private swing.TextFieldAnimation txt_Search;
    private javax.swing.JTextField txt_bonus;
    private javax.swing.JTextField txt_deduction;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
