/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import util.DBconnect;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import javaswingdev.Notification;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import table.TableCustom;

//clickRaw eka wada na

public class AddMembers extends javax.swing.JFrame {
Connection conn;
int xMouse;
int yMouse;
BufferedImage qrImage;
    /**
     * Creates new form Members
     */
    public AddMembers() {
        initComponents();
        conn = DBconnect.connectdb();
        load_cmb();
        btnclear();  
        tableload();  
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        loadID();
    }
 
    
    public JButton getButton_Msave(){
        return btn_Msave;
    }
    
  
    private void loadID(){
 
        try {
             
            // Execute the query
            String sql = "SELECT MAX(Gym_ID) AS last_id FROM member";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs.next()) {
                // Get the last ID and display in the text box
                int lastId = rs.getInt("last_id");
                txt_gymID.setText(String.valueOf(lastId+1));
            } else {
                txt_gymID.setText("No ID found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            txt_gymID.setText("Error");
        }
    }

    private void generateQRCode(String data) {
        try {
            // Generate QR code image
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
            qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

         // Display QR code in the JLabel
            lbl_qr.setIcon(new ImageIcon(qrImage));
//          lbl_qr.setText("QR Code generated!");

           // Enable save button after generating QR code
           // saveButton.setEnabled(true);
        } catch (WriterException e) {
            e.printStackTrace();
            lbl_qr.setText("Error generating QR Code.");
        }
    }
    
    
     private void saveQRCode() {
    if (qrImage == null) {
        JOptionPane.showMessageDialog(this, "No QR Code to save. Please generate one first.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get the student ID from the text field
    String studentId = txt_gymID.getText().trim();
    if (studentId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Student ID is empty. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Define the save location and filename based on the student ID
    String directoryPath = "C:\\Users\\DELL-PC\\Documents\\GYM Project\\QRs";
    File directory = new File(directoryPath);
    
    // Create the directory if it does not exist
    if (!directory.exists()) {
        if (!directory.mkdirs()) {
            JOptionPane.showMessageDialog(this, "Failed to create directory for saving QR Code.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Define the full path for the QR code image file
    File fileToSave = new File(directory,studentId+"-"+txt_Fname.getText()+ ".png");

    try {
        // Save the QR code image
        ImageIO.write((RenderedImage) qrImage, "PNG", fileToSave);
        lbl_qr.setText("QR Code saved to " + fileToSave.getAbsolutePath());
    } catch (IOException e) {
        e.printStackTrace();
        lbl_qr.setText("Error saving QR Code: " + e.getMessage());
    }
}
    
    
    
        private  void load_cmb() {

        try {
            String sql = "SELECT `Name` FROM package";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String sub = rs.getString("Name");
                cmb_type.addItem(sub);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    
     private void btnSave(){
        //  int AddNO;
       // AddNO = Integer.parseInt(lbl_ID.getText());
        String AddNO = txt_gymID.getText();
        String Fname = txt_Fname.getText();
        String Lname = txt_Lname.getText();

        String pNO = txt_phone.getText();
        
        String genders = cmb_sex.getSelectedItem().toString();
        
        String Adres1 = txt_AdresLine1.getText();

        String Adres2 = txt_AdresLine2.getText();

        String Afee = txt_Fees.getText();

        String time = cmb_timeBox.getSelectedItem().toString();
        

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        date = sdf.format(txt_RsgiDate.getDate());

        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        String Date;
        Date = stf.format(txt_birthday.getDate());

        try {
             String sql1 = "SELECT Package_ID FROM package WHERE name = '"+cmb_type.getSelectedItem()+"'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            
            String ID=null;
            
            if (rs.next()) {
                
                 ID = rs.getString("Package_ID");
   
            } 
            
            String sql = "INSERT INTO member(Gym_ID,F_Name,L_Name,Phone,Gender,Birthday,AddresLine1,AddressLine2,"
                    + "Admission_Date,Admission_Fee,Gym_Time,Package_ID)"
                    + "VALUES('"+AddNO+"','"+Fname+"','"+Lname+"','"+pNO+"','"+genders+"','"+Date+"','"+Adres1+"','"+Adres2+"',"
                    + "'"+date+"','"+Afee+"','"+time+"','"+ID+"')";
            
           PreparedStatement st2 = conn.prepareStatement(sql);
           st2.executeUpdate();
                 
           
            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Save Member Succuss");
            noti.showNotification();
        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
           Notification noti=new Notification(this ,Notification.Type.WARNING,Notification.Location.TOP_CENTER,"Save Unsuccessfull");
            noti.showNotification();
        }
    }

    // interface eke thiyena table ekata rs2xml.jar magin, database eke idan data ganna code eka.
   private void tableload() {
        try {
            String sql = "SELECT * FROM member ORDER BY Gym_ID DESC";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
 
            table1.setModel(DbUtils.resultSetToTableModel(rs));
    
            table1.getColumnModel().getColumn(1).setMinWidth(0);
            table1.getColumnModel().getColumn(1).setMaxWidth(0);
            table1.getColumnModel().getColumn(4).setMinWidth(0);
            table1.getColumnModel().getColumn(4).setMaxWidth(0);
            table1.getColumnModel().getColumn(5).setMinWidth(0);
            table1.getColumnModel().getColumn(5).setMaxWidth(0);
            table1.getColumnModel().getColumn(6).setMinWidth(0);
            table1.getColumnModel().getColumn(6).setMaxWidth(0);
            table1.getColumnModel().getColumn(7).setMinWidth(0);
            table1.getColumnModel().getColumn(7).setMaxWidth(0);
            table1.getColumnModel().getColumn(8).setMinWidth(0);
            table1.getColumnModel().getColumn(8).setMaxWidth(0);
            table1.getColumnModel().getColumn(9).setMinWidth(0);
            table1.getColumnModel().getColumn(9).setMaxWidth(0);
            table1.getColumnModel().getColumn(10).setMinWidth(0);
            table1.getColumnModel().getColumn(10).setMaxWidth(0);
            table1.getColumnModel().getColumn(11).setMinWidth(0);
            table1.getColumnModel().getColumn(11).setMaxWidth(0);
          
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//    private void tableColumCenter(){
//       TableColumn column = table1.getColumnModel().getColumn(0);
//       DefaultTableCellRenderer cellRen = new DefaultTableCellRenderer();
//       cellRen.setHorizontalAlignment(jLabel2.CENTER);
//       column.setCellRenderer(cellRen);
//   }
//   
//    private void tableColumCenter1(){
//       TableColumn column = table1.getColumnModel().getColumn(2);
//       DefaultTableCellRenderer cellRen = new DefaultTableCellRenderer();
//       cellRen.setHorizontalAlignment(jLabel3.CENTER);
//       column.setCellRenderer(cellRen);
//   }
//   
//    private void tableColumCenter2(){
//       TableColumn column = table1.getColumnModel().getColumn(3);
//       DefaultTableCellRenderer cellRen = new DefaultTableCellRenderer();
//       cellRen.setHorizontalAlignment(jLabel4.CENTER);
//       column.setCellRenderer(cellRen);
//   }
 
// waguwe raw ekak click karama a raw eke data textbox wala pirenna code eka
    private void clickRow() {

        try {
        int r = table1.getSelectedRow();

        String id = table1.getValueAt(r, 0).toString();
        String tid = table1.getValueAt(r, 1).toString();
        
         String sql1 = "SELECT name FROM package WHERE Package_ID = '"+tid+"'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            
            String ID=null;
            
            if (rs.next()) {
                
                 ID = rs.getString("name");
   
            } 
        
        String fn = table1.getValueAt(r, 2).toString();
        String ln = table1.getValueAt(r, 3).toString();
        String phone = table1.getValueAt(r, 4).toString();
        String Gen = table1.getValueAt(r, 5).toString();
        
        DefaultTableModel model=(DefaultTableModel)table1.getModel();
        int selectedRow=table1.getSelectedRow();
        Date Bday = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 6).toString()); 
        
        String Ad1 = table1.getValueAt(r, 7).toString();
        String Ad2 = table1.getValueAt(r, 8).toString(); 
        
        Date AdDay = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 9).toString());     
        
        String fee = table1.getValueAt(r, 10).toString();
        String time = table1.getValueAt(r, 11).toString();
        

        txt_gymID.setText(id);

        txt_Fname.setText(fn);
        txt_Lname.setText(ln);
        txt_phone.setText(phone);

        cmb_sex.setSelectedItem(Gen);
        
        txt_birthday.setDate(Bday);
        
        txt_AdresLine1.setText(Ad1);
        txt_AdresLine2.setText(Ad2);

        txt_RsgiDate.setDate(AdDay);
        
        txt_Fees.setText(fee);
        cmb_timeBox.setSelectedItem(time);
        cmb_type.setSelectedItem(ID);
        
        Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Click Raw Succuss");
        noti.showNotification();
        
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


// thiyena data ekak edit karala aay save karana code eka,    
      private void update(){
          
       // int AddNO;
      // AddNO = Integer.parseInt(lbl_ID.getText());
        String AddNO = txt_gymID.getText();
        String Fname = txt_Fname.getText();
        String Lname = txt_Lname.getText();

        String pNO = txt_phone.getText();

        String genders = cmb_sex.getSelectedItem().toString();

        String Adres1 = txt_AdresLine1.getText();

        String Adres2 = txt_AdresLine2.getText();

        String Afee = txt_Fees.getText();

        String time = cmb_timeBox.getSelectedItem().toString();
        
//        String type = cmb_type.getSelectedItem().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        date = sdf.format(txt_RsgiDate.getDate());

        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        String Date;
        Date = stf.format(txt_birthday.getDate());

        try {
            String sql1 = "SELECT Package_ID FROM package WHERE name = '"+cmb_type.getSelectedItem()+"'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            
            String ID=null;
            
            if (rs.next()) {
                
                 ID = rs.getString("Package_ID");
   
            } 
  
            String sql = "UPDATE member SET F_Name='"+Fname+"',L_Name='"+Lname+"',Phone='"+pNO+"',Gender='"+genders+"',"
                    + "Birthday='"+Date+"',AddresLine1='"+Adres1+"',AddressLine2='"+Adres2+"',Admission_Date='"+date+"'"
                    + ",Admission_Fee='"+Afee+"',Gym_Time='"+time+"',Package_ID='"+ID+"' "
                    + "WHERE Gym_ID='"+AddNO+"'";
            
           PreparedStatement statement = conn.prepareStatement(sql);
                       statement.execute();
                         
           
                         
//            JOptionPane.showMessageDialog(null, "Update Success");
            Notification noti=new Notification(this ,Notification.Type.INFO,Notification.Location.TOP_CENTER,"Update Member Succuss");
            noti.showNotification();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
        
    } 
      
     private void btnDelete() {
        int check = JOptionPane.showConfirmDialog(null, " IF YOU DELETE THIS MEMBER,\n ALL THE SCHEDULES AND PAYMENTS ASSIGNED TO THIS MEMBER WILL BE DELETED.\n DO YOU WANT TO DELETE");

        if (check == 0) {

            String addno = txt_gymID.getText();

            try {
                String sql = "DELETE FROM member WHERE Gym_ID ='" + addno + "'";
                PreparedStatement st = conn.prepareStatement(sql);
                st.execute();

            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Delete Member Succuss");
            noti.showNotification();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
      

    private void btnclear(){
        txt_gymID.setText("");

        txt_Fname.setText("");
        txt_Lname.setText("");
        txt_phone.setText("");
        cmb_sex.setSelectedItem(null);
     
        txt_birthday.setCalendar(null);
        
        txt_AdresLine1.setText("");
        txt_AdresLine2.setText("");

        txt_RsgiDate.setCalendar(null);
        
        txt_Fees.setText("");
        cmb_timeBox.setSelectedItem(null);
        cmb_type.setSelectedItem(null);
       
    }
    
    // Search bar ekata liyana code eka
    private void search() {

        String srch = txt_search.getText();

        try {
            String sql = "SELECT * FROM member WHERE F_Name LIKE '%" + srch + "%' OR Gym_ID LIKE '%" + srch + "%' ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            table1.getColumnModel().getColumn(1).setMinWidth(0);
            table1.getColumnModel().getColumn(1).setMaxWidth(0);
            table1.getColumnModel().getColumn(4).setMinWidth(0);
            table1.getColumnModel().getColumn(4).setMaxWidth(0);
            table1.getColumnModel().getColumn(5).setMinWidth(0);
            table1.getColumnModel().getColumn(5).setMaxWidth(0);
            table1.getColumnModel().getColumn(6).setMinWidth(0);
            table1.getColumnModel().getColumn(6).setMaxWidth(0);
            table1.getColumnModel().getColumn(7).setMinWidth(0);
            table1.getColumnModel().getColumn(7).setMaxWidth(0);
            table1.getColumnModel().getColumn(8).setMinWidth(0);
            table1.getColumnModel().getColumn(8).setMaxWidth(0);
            table1.getColumnModel().getColumn(9).setMinWidth(0);
            table1.getColumnModel().getColumn(9).setMaxWidth(0);
            table1.getColumnModel().getColumn(10).setMinWidth(0);
            table1.getColumnModel().getColumn(10).setMaxWidth(0);
            table1.getColumnModel().getColumn(11).setMinWidth(0);
            table1.getColumnModel().getColumn(11).setMaxWidth(0);
            
            
            
        } catch (Exception e) {
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        lbl_ID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Fname = new javax.swing.JTextField();
        txt_Lname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_birthday = new com.toedter.calendar.JDateChooser();
        txt_AdresLine1 = new javax.swing.JTextField();
        txt_AdresLine2 = new javax.swing.JTextField();
        txt_RsgiDate = new com.toedter.calendar.JDateChooser();
        txt_Fees = new javax.swing.JTextField();
        cmb_type = new javax.swing.JComboBox<>();
        cmb_timeBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_gymID = new javax.swing.JTextField();
        cmb_sex = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btn_Msave = new javax.swing.JButton();
        btn_Mupdate = new javax.swing.JButton();
        btn_Mdelete = new javax.swing.JButton();
        btn_Mprint = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_search = new swing.TextFieldAnimation();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_qr = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        btn_minimize = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        lbl_ID.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(0, 0, 0));
        lbl_ID.setText("Gym ID");

        jLabel2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("First Name");

        txt_Fname.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Lname.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Phone NO");

        txt_phone.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Gender");

        jLabel6.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Birthday");

        txt_birthday.setDateFormatString("yyyy-MM-dd");

        txt_AdresLine1.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_AdresLine2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_RsgiDate.setDateFormatString("yyyy-MM-dd");

        txt_Fees.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        cmb_type.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_typeMouseClicked(evt);
            }
        });

        cmb_timeBox.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_timeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Afternoon", "Evening ", "Night" }));

        jLabel8.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Gym Time");

        jLabel10.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Package");

        jLabel7.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Addmission Fee");

        jLabel14.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Addmission Date");

        jLabel13.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Address");

        txt_gymID.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        cmb_sex.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Transgender", "Non-binary", "Genderqueer", "Genderfluid", "Agender", "Bigender", "Demiboy", "Demigirl", "Two-Spirit (Indigenous cultures)", "Pangender", "Androgynous", "Intersex", "Neutrois" }));

        jButton7.setBackground(new java.awt.Color(51, 0, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_process_24px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        table1.setFont(new java.awt.Font("Square721 BT", 0, 14)); // NOI18N
        table1.setForeground(new java.awt.Color(0, 0, 0));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Gym ID", "First Name", "Last Name", "Phone No", "Gender", "Birthday", "Address Line 1", "Address Line 2", "Admission Date", "Admission Fee", "Gym Time", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        btn_Msave.setBackground(new java.awt.Color(255, 0, 0));
        btn_Msave.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        btn_Msave.setForeground(new java.awt.Color(255, 255, 255));
        btn_Msave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_save_24px.png"))); // NOI18N
        btn_Msave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MsaveActionPerformed(evt);
            }
        });

        btn_Mupdate.setBackground(new java.awt.Color(0, 255, 0));
        btn_Mupdate.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        btn_Mupdate.setForeground(new java.awt.Color(255, 255, 255));
        btn_Mupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_update_file_24px_1.png"))); // NOI18N
        btn_Mupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MupdateActionPerformed(evt);
            }
        });

        btn_Mdelete.setBackground(new java.awt.Color(0, 102, 102));
        btn_Mdelete.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        btn_Mdelete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Mdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_bin_24px.png"))); // NOI18N
        btn_Mdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MdeleteActionPerformed(evt);
            }
        });

        btn_Mprint.setBackground(new java.awt.Color(204, 0, 204));
        btn_Mprint.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        btn_Mprint.setForeground(new java.awt.Color(255, 255, 255));
        btn_Mprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_24px.png"))); // NOI18N
        btn_Mprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MprintActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_eraser_24px.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_search.setForeground(new java.awt.Color(0, 0, 0));
        txt_search.setAnimationColor(new java.awt.Color(255, 0, 51));
        txt_search.setCaretColor(new java.awt.Color(0, 0, 0));
        txt_search.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txt_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_searchMouseClicked(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(lbl_ID))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_Fname)
                                            .addComponent(txt_Lname)
                                            .addComponent(txt_phone)
                                            .addComponent(txt_gymID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Fees, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmb_timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel13))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_AdresLine2)
                                                    .addComponent(txt_AdresLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_RsgiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Msave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Mupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Mdelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Mprint)
                        .addGap(57, 57, 57))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ID)
                            .addComponent(txt_gymID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_AdresLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_AdresLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_Lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel14))
                            .addComponent(txt_RsgiDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Fees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cmb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Mprint, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Msave)
                                .addComponent(btn_Mupdate)
                                .addComponent(btn_Mdelete)))
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 204));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        lbl_qr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_qr, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_qr, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_qr_code_16px_1.png"))); // NOI18N
        jButton1.setText("Generate QR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_pin_in_circle_16px.png"))); // NOI18N
        jButton2.setText("Save QR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
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
        jLabel15.setText("Add Member Page");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Close)
                    .addComponent(btn_minimize)
                    .addComponent(jLabel15)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//        tableload();
//        
//        btnclear();
        this.dispose();
        
        AddMembers adm = new AddMembers();
        adm.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        clickRow();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        clickRow();
    }//GEN-LAST:event_table1KeyReleased

    private void btn_MsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MsaveActionPerformed
        // TODO add your handling code here
        btnSave();
        tableload();
        
        btnclear();

        
        
    }//GEN-LAST:event_btn_MsaveActionPerformed

    private void btn_MupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MupdateActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
        
        btnclear();
    }//GEN-LAST:event_btn_MupdateActionPerformed

    private void btn_MdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MdeleteActionPerformed
        // TODO add your handling code here:
        btnDelete();
        tableload(); 
        btnclear();  
    }//GEN-LAST:event_btn_MdeleteActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
                String data =txt_gymID.getText();
        generateQRCode(data);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
        saveQRCode(); 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_typeMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmb_typeMouseClicked

    private void btn_MprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MprintActionPerformed
        // TODO add your handling code here:
        
//        try {
//   
////            Connection conn = db.mycon(); // Assuming db.mycon() returns a valid Connection
//            String reportpath = "";
//            JasperReport jr=JasperCompileManager.compileReport(reportpath);
//            JasperPrint jp =JasperFillManager.fillReport(jr, null, conn);
//            JasperViewer.viewReport(jp);
//
//        } catch (JRException e) {
//            JOptionPane.showMessageDialog(null, "report loading success");
//        }
//        
    
               try {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("Gym_ID", txt_gymID.getText()); // Replace "inv_id" with the correct parameter name in your report

//                Connection conn = db.mycon(); // Assuming db.mycon() returns a valid Connection
                String reportpath = "C:\\Users\\DELL-PC\\Documents\\GYM Project\\GYMsoft\\src\\report\\Payment_Receipt.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportpath);
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
//                JasperViewer.viewReport(jp);
                 JasperPrintManager.printReport(jp, false);
//                JasperViewer viewer = new JasperViewer(jp, false); // false prevents EXIT_ON_CLOSE behavior
//                viewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE); // Dispose the viewer on close
//                viewer.setVisible(true);

            } catch (JRException e) {
               // JOptionPane.showMessageDialog(null, "report loading success");
            }

    }//GEN-LAST:event_btn_MprintActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        btnclear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_searchMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_searchMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    IntelliJTheme.setup(AddMembers.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMembers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_Mdelete;
    private javax.swing.JButton btn_Mprint;
    private javax.swing.JButton btn_Msave;
    private javax.swing.JButton btn_Mupdate;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JComboBox<String> cmb_sex;
    private javax.swing.JComboBox<String> cmb_timeBox;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_qr;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txt_AdresLine1;
    private javax.swing.JTextField txt_AdresLine2;
    private javax.swing.JTextField txt_Fees;
    private javax.swing.JTextField txt_Fname;
    private javax.swing.JTextField txt_Lname;
    private com.toedter.calendar.JDateChooser txt_RsgiDate;
    private com.toedter.calendar.JDateChooser txt_birthday;
    private javax.swing.JTextField txt_gymID;
    private javax.swing.JTextField txt_phone;
    private swing.TextFieldAnimation txt_search;
    // End of variables declaration//GEN-END:variables
}
