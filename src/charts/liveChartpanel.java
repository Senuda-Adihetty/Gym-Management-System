/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package charts;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import raven.chart.ModelChart;
import util.DBconnect;
import util.ModelData;
/**
 *
 * @author DELL-PC
 */
public class liveChartpanel extends javax.swing.JPanel {
Connection conn;
    
    /**
     * Creates new form liveChartpanel
     */
    public liveChartpanel() {
        initComponents();
            conn = DBconnect.connectdb();
        chart.setTitle("Chart Data");
        chart.addLegend("Schedule", Color.decode("#7b4397"), Color.decode("#dc2430"));
//        chart.addLegend("WetWeight", Color.decode("#e65c00"), Color.decode("#F9D423"));
//        chart.addLegend("SackWeight", Color.decode("#0099F7"), Color.decode("#F11712"));
//        test();
        setdata();
    }

      private void test() {
        chart.clear();
        chart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        chart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        chart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        chart.start();
    }
    
    
    private void setdata() {
    try {
        List<ModelData> lists = new ArrayList<>();
        
// String sql="select date as Month,sum(totalqty) as quantity,sum(wet_weight) as wetweight,sum(sackweight)as sackweight from supplier_payment group by date order by date ASC";
        String sql="SELECT DATE_FORMAT(IssuedDate, '%M') AS month, "
                + "COUNT(shedul_ID) AS total FROM sheduledetails GROUP BY DATE_FORMAT(IssuedDate, '%M') "
                + "ORDER BY MAX(IssuedDate)DESC";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            
            String month=rs.getString("Month");
            double Total=rs.getDouble("total");
//            double Wet_weight=rs.getDouble("wet_weight");
//            double sack_weight=rs.getDouble("Sack_Weight");
            lists.add(new ModelData(month, Total));
        }
        rs.close();
        statement.close();
        for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getTotal()}));

            }
        chart.start();

    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new raven.panel.PanelShadow();
        chart = new raven.chart.CurveLineChart();

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.chart.CurveLineChart chart;
    private raven.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
