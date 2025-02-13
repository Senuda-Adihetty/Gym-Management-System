/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import charts.All;
import charts.Allmembers;
import charts.Allschedules;
import charts.Alltrainers;
import charts.liveChartpanel;
import charts.sheduleChart;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;
import keeptoo.KGradientPanel;
import pos.pro.JpanelLoader;
import util.DBconnect;
import java.sql.*;
import java.time.Year;
import javaswingdev.Notification;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class Dashboard extends javax.swing.JFrame {

    JpanelLoader panelLoader = new JpanelLoader();
    Connection conn;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        conn = DBconnect.connectdb();
//        All as = new All();
//        panelLoader.jPanelLoader(main_panel, as);
//          sheduleChart a = new sheduleChart();
//           panelLoader.jPanelLoader(main_panel, a);   
            liveChartpanel lp = new liveChartpanel();
            panelLoader.jPanelLoader(main_panel, lp);
//           Main2 ff = new Main2();
//           panelLoader.jPanelLoader(main_panel, ff);
        dt();
        time();
    }

    public void dt() {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        lbl_Date.setText(dd);
    }

    Timer t;
    SimpleDateFormat st;

    public void time() {
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                lbl_Time.setText(tt);
            }
        });
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_Date = new javax.swing.JLabel();
        lbl_Time = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        user = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        trainer = new javax.swing.JMenuItem();
        members = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        memberPay = new javax.swing.JMenuItem();
        trainerSal = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jButton4.setBackground(new java.awt.Color(255, 255, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(new java.awt.Dimension(0, 0));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));
        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("THE GYM FITNESS CENTER");

        lbl_Date.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbl_Date.setForeground(new java.awt.Color(255, 255, 0));
        lbl_Date.setText("-");

        lbl_Time.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbl_Time.setForeground(new java.awt.Color(255, 255, 0));
        lbl_Time.setText("-");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(239, 239, 239)
                .addComponent(lbl_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_Date)
                        .addComponent(lbl_Time))
                    .addComponent(jLabel3)))
        );

        main_panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N

        jMenu1.setText("MASTER");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_shield_26px.png"))); // NOI18N
        user.setText("User");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jMenu1.add(user);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_shopping_basket_star_24px.png"))); // NOI18N
        jMenuItem2.setText("Packages");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_spinning_30px.png"))); // NOI18N
        jMenuItem1.setText("Exesises");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("PEOPLE");

        trainer.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        trainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_personal_trainer_24px.png"))); // NOI18N
        trainer.setText("Trainer");
        trainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerActionPerformed(evt);
            }
        });
        jMenu4.add(trainer);

        members.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        members.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_24px_1.png"))); // NOI18N
        members.setText("Members");
        members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersActionPerformed(evt);
            }
        });
        jMenu4.add(members);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("PAYMENTS");

        memberPay.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        memberPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_pay_24px.png"))); // NOI18N
        memberPay.setText("Member Payments");
        memberPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberPayActionPerformed(evt);
            }
        });
        jMenu2.add(memberPay);

        trainerSal.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        trainerSal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refund_26px.png"))); // NOI18N
        trainerSal.setText("Trainer Salary");
        trainerSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerSalActionPerformed(evt);
            }
        });
        jMenu2.add(trainerSal);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("SCHEDULE");

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_pen_30px.png"))); // NOI18N
        jMenuItem3.setText("Manage");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_26px.png"))); // NOI18N
        jMenuItem4.setText("Search");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("ATTENDENCE");

        jMenuItem5.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_qr_code_16px.png"))); // NOI18N
        jMenuItem5.setText("Start");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("REPORTS");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(main_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersActionPerformed
        // TODO add your handling code here:
        AddMembers mm = new AddMembers();
        mm.setVisible(true);
       

    }//GEN-LAST:event_membersActionPerformed

    private void trainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerActionPerformed
        // TODO add your handling code here:
        AddTrainer tt = new AddTrainer();
        tt.setVisible(true);
   
    }//GEN-LAST:event_trainerActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
        User uu = new User();
        uu.setVisible(true);
    }//GEN-LAST:event_userActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        packages ff = new packages();
        ff.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void memberPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberPayActionPerformed
        // TODO add your handling code here:
        NewPayment pp = new NewPayment();
        pp.setVisible(true);
   

    }//GEN-LAST:event_memberPayActionPerformed

    private void trainerSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerSalActionPerformed
        // TODO add your handling code here:
        NewSalary ss = new NewSalary();
        ss.setVisible(true);
    }//GEN-LAST:event_trainerSalActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Exercises ee = new Exercises();
        ee.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void kGradientPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseClicked
        // TODO add your handling code here:
//        All as = new All();
//        panelLoader.jPanelLoader(main_panel, as);
    }//GEN-LAST:event_kGradientPanel2MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        shedules sdl = new shedules();
        sdl.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        shedulsearch v = new shedulsearch();
        v.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        AttendenceMark attm = new AttendenceMark();
        attm.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream("/template.theme.json"));

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_Date;
    private javax.swing.JLabel lbl_Time;
    private javax.swing.JPanel main_panel;
    private javax.swing.JMenuItem memberPay;
    private javax.swing.JMenuItem members;
    private javax.swing.JMenuItem trainer;
    private javax.swing.JMenuItem trainerSal;
    private javax.swing.JMenuItem user;
    // End of variables declaration//GEN-END:variables
}
