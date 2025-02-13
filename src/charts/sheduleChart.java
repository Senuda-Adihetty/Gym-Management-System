/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package charts;

import inter.Dashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import pos.pro.JpanelLoader;
import util.DBconnect;

/**
 *
 * @author DELL-PC
 */
public class sheduleChart extends javax.swing.JPanel {

    Connection conn;
    JpanelLoader panelLoader = new JpanelLoader();

    /**
     * Creates new form sheduleChart
     */
    public sheduleChart() {
        initComponents();
        //this.dashboard = dashboard;
        conn = DBconnect.connectdb();
        chart();
    }

    private void chart() {

        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        try {
            String sql = "SELECT\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 1 THEN 1 END) AS total_jan,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 2 THEN 1 END) AS total_feb,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 3 THEN 1 END) AS total_march,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 4 THEN 1 END) AS total_april,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 5 THEN 1 END) AS total_may,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 6 THEN 1 END) AS total_june,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 7 THEN 1 END) AS total_july,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 8 THEN 1 END) AS total_august,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 9 THEN 1 END) AS total_september,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 10 THEN 1 END) AS total_october,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 11 THEN 1 END) AS total_november,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 12 THEN 1 END) AS total_december\n"
                    + "FROM \n"
                    + "    gym.sheduledetails WHERE YEAR(IssuedDate)=YEAR(CURDATE())";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int currentYear = Year.now().getValue();
                String curntyear = Integer.toString(currentYear);

                // Current year totals
                barchartdata.setValue(rs.getInt("total_jan"), curntyear, "jan");
                barchartdata.setValue(rs.getInt("total_feb"), curntyear, "feb");
                barchartdata.setValue(rs.getInt("total_march"), curntyear, "mar");
                barchartdata.setValue(rs.getInt("total_april"), curntyear, "apr");
                barchartdata.setValue(rs.getInt("total_may"), curntyear, "may");
                barchartdata.setValue(rs.getInt("total_june"), curntyear, "june");
                barchartdata.setValue(rs.getInt("total_july"), curntyear, "july");
                barchartdata.setValue(rs.getInt("total_august"), curntyear, "aug");
                barchartdata.setValue(rs.getInt("total_september"), curntyear, "sep");
                barchartdata.setValue(rs.getInt("total_october"), curntyear, "oct");
                barchartdata.setValue(rs.getInt("total_november"), curntyear, "nov");
                barchartdata.setValue(rs.getInt("total_december"), curntyear, "dec");
            }

            // Query for previous year data
//        java.sql.ResultSet rsprv = s.executeQuery("SELECT \n"
//                + "  SUM(CASE WHEN MONTH(date) = 1 THEN qty ELSE 0 END) AS prtotal_jan, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 2 THEN qty ELSE 0 END) AS prtotal_feb, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 3 THEN qty ELSE 0 END) AS prtotal_march, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 4 THEN qty ELSE 0 END) AS prtotal_april, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 5 THEN qty ELSE 0 END) AS prtotal_may, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 6 THEN qty ELSE 0 END) AS prtotal_june, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 7 THEN qty ELSE 0 END) AS prtotal_july, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 8 THEN qty ELSE 0 END) AS prtotal_august, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 9 THEN qty ELSE 0 END) AS prtotal_september, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 10 THEN qty ELSE 0 END) AS prtotal_october, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 11 THEN qty ELSE 0 END) AS prtotal_november, \n"
//                + "  SUM(CASE WHEN MONTH(date) = 12 THEN qty ELSE 0 END) AS prtotal_december \n"
//                + "FROM employee_produce_product \n"
//                + "WHERE YEAR(date) = YEAR(CURDATE()) - 1");
//
//        if (rsprv.next()) {
//            int previousYear = Year.now().getValue() - 1;
//            String prvyear = Integer.toString(previousYear);
//
//            // Previous year totals
//            barchartdata.setValue(rsprv.getInt("prtotal_jan"), prvyear, "jan");
//            barchartdata.setValue(rsprv.getInt("prtotal_feb"), prvyear, "feb");
//            barchartdata.setValue(rsprv.getInt("prtotal_march"), prvyear, "mar");
//            barchartdata.setValue(rsprv.getInt("prtotal_april"), prvyear, "apr");
//            barchartdata.setValue(rsprv.getInt("prtotal_may"), prvyear, "may");
//            barchartdata.setValue(rsprv.getInt("prtotal_june"), prvyear, "june");
//            barchartdata.setValue(rsprv.getInt("prtotal_july"), prvyear, "july");
//            barchartdata.setValue(rsprv.getInt("prtotal_august"), prvyear, "aug");
//            barchartdata.setValue(rsprv.getInt("prtotal_september"), prvyear, "sep");
//            barchartdata.setValue(rsprv.getInt("prtotal_october"), prvyear, "oct");
//            barchartdata.setValue(rsprv.getInt("prtotal_november"), prvyear, "nov");
//            barchartdata.setValue(rsprv.getInt("prtotal_december"), prvyear, "dec");
//        }
            String sql2 = "SELECT\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 1 THEN 1 END) AS total_jan,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 2 THEN 1 END) AS total_feb,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 3 THEN 1 END) AS total_march,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 4 THEN 1 END) AS total_april,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 5 THEN 1 END) AS total_may,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 6 THEN 1 END) AS total_june,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 7 THEN 1 END) AS total_july,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 8 THEN 1 END) AS total_august,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 9 THEN 1 END) AS total_september,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 10 THEN 1 END) AS total_october,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 11 THEN 1 END) AS total_november,\n"
                    + "    COUNT(CASE WHEN MONTH(IssuedDate) = 12 THEN 1 END) AS total_december\n"
                    + "FROM \n"
                    + "    gym.sheduledetails WHERE YEAR(IssuedDate) = YEAR(CURDATE()) - 1)";

            PreparedStatement statement2 = conn.prepareStatement(sql2);
            ResultSet rs2 = statement2.executeQuery();

            if (rs2.next()) {
                int previousYear = Year.now().getValue() - 1;
                String prvyear = Integer.toString(previousYear);

                // Current year totals
                barchartdata.setValue(rs.getInt("total_jan"), prvyear, "jan");
                barchartdata.setValue(rs.getInt("total_feb"), prvyear, "feb");
                barchartdata.setValue(rs.getInt("total_march"), prvyear, "mar");
                barchartdata.setValue(rs.getInt("total_april"), prvyear, "apr");
                barchartdata.setValue(rs.getInt("total_may"), prvyear, "may");
                barchartdata.setValue(rs.getInt("total_june"), prvyear, "june");
                barchartdata.setValue(rs.getInt("total_july"), prvyear, "july");
                barchartdata.setValue(rs.getInt("total_august"), prvyear, "aug");
                barchartdata.setValue(rs.getInt("total_september"), prvyear, "sep");
                barchartdata.setValue(rs.getInt("total_october"), prvyear, "oct");
                barchartdata.setValue(rs.getInt("total_november"), prvyear, "nov");
                barchartdata.setValue(rs.getInt("total_december"), prvyear, "dec");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the bar chart
        JFreeChart jchart = ChartFactory.createBarChart("Shedules Chart", "Month", "Total New Shedules", barchartdata, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

// Adjust the maximum width of the bars (the bars will not exceed this width)
        renderer.setMaximumBarWidth(0.05); // Adjust this value to control the bar width
        // Create a new ChartPanel for the chart
        ChartPanel chartPanel = new ChartPanel(jchart);

        // Check if chartload already contains a chart
        if (chartload.getComponentCount() > 0) {
            chartload.removeAll(); // Remove the old chart panel
        }

        // Add the new chart panel to chartload
        chartload.add(chartPanel, BorderLayout.CENTER);
        chartload.validate();  // Revalidate the layout
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
        chartload = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        chartload.setLayout(new java.awt.BorderLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_eye_30px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(chartload, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(chartload, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        Allschedules a = new Allschedules();
//        panelLoader.jPanelLoader(this, a);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartload;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
