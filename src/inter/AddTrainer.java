/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javaswingdev.Notification;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import table.TableCustom;
//import net.sf.jasperreports.view.JasperViewer;
//import table.TableCustom;
import util.DBconnect;
//import table.TableCustom;
/**
 *
 * @author DELL-PC
 */
public class AddTrainer extends javax.swing.JFrame {
Connection conn;
    int xMouse;
    int yMouse;
    
     String imgpath = null;
    
    public AddTrainer() {
        initComponents();
          conn = DBconnect.connectdb();
          loadID();
          tableload();   
        
    } 
    
    
    private void loadID(){
 
        try {
             
            // Execute the query
            String sql = "SELECT MAX(Trainer_ID) AS last_id FROM trainer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs.next()) {
                // Get the last ID and display in the text box
                int lastId = rs.getInt("last_id");
                txt_ID.setText(String.valueOf(lastId+1));
            } else {
                txt_ID.setText("No ID found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            txt_ID.setText("Error");
        }
    }
    
    

    public ImageIcon ResizeImage(String imagepath, byte[] pic) {

        ImageIcon MyImage = null;

        if (imagepath != null) {
            MyImage = new ImageIcon(imagepath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Ibl_lmage2.getWidth(), Ibl_lmage2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }    
    public void filechoser() {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            Ibl_lmage2.setIcon(ResizeImage(path, null));

            imgpath = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.print("NO FILE SELECTED");
        }

    }   
    
    
        private void btnSave(){
     
     try {  
         
        String id = txt_ID.getText();
        String Fname = txtFirstName.getText();
        String Lname = txtLastName.getText();
        String pNO = txtPhoneNo.getText();

        String genders = "Male";
        if (rb_Female.isSelected()) {
            genders = "Female";
        }

           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        date = sdf.format(txt_Bday.getDate());
        
        String Adres1 = txt_ad1.getText();
        String Adres2 = txt_ad2.getText();
        
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        String Date;
        Date = stf.format(txt_SrtDate.getDate());

        String bsal = txt_Slry.getText();
        
            String sql = "INSERT INTO trainer(Trainer_ID,F_Name,L_Name,Phone_No,Gender,Birthday,Address1,Address2,Start_Date,Basic_Sal,Photo)"
                    + "VALUES('"+id+"','"+Fname+"','"+Lname+"','"+pNO+"','"+genders+"','"+date+"','"+Adres1+"','"+Adres2+"',"
                    + "'"+Date+"','"+bsal+"',?)";
            
           PreparedStatement statement = conn.prepareStatement(sql);
           InputStream img = new FileInputStream(new File(imgpath));
           statement.setBlob(1, img);
           statement.executeUpdate();
                 
//          JOptionPane.showMessageDialog(null, "Save Trainer Succuss");
            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Save Trainer Succuss");
            noti.showNotification();
            
        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e);
            Notification noti=new Notification(this ,Notification.Type.WARNING,Notification.Location.TOP_CENTER,"Save Trainer Unsuccuss");
            noti.showNotification();
        }
    }
  
    // interface eke thiyena table ekata rs2xml.jar magin, database eke idan data ganna code eka.
   private void tableload() {
        try {
            String sql = "SELECT * FROM trainer ORDER BY Trainer_ID DESC";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
 
            tbl_trainer.setModel(DbUtils.resultSetToTableModel(rs));
    
//            tbl_trainer.getColumnModel().getColumn(1).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(1).setMaxWidth(0);
//            tbl_trainer.getColumnModel().getColumn(4).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(4).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(5).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(6).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(6).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(7).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(7).setMaxWidth(0);
//            tbl_trainer.getColumnModel().getColumn(8).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(8).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(9).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(10).setMaxWidth(0);

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
   private void update(){
       
        
      try {
        //int AddNO = Integer.parseInt(txt.getText());
        String id = txt_ID.getText();
        String Fname = txtFirstName.getText();
        String Lname = txtLastName.getText();
        String pNO = txtPhoneNo.getText();

        String genders = "Male";
        if (rb_Female.isSelected()) {
            genders = "Female";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        date = sdf.format(txt_Bday.getDate());
        
        String Adres1 = txt_ad1.getText();
        String Adres2 = txt_ad2.getText();
        
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        String Date;
        Date = stf.format(txt_SrtDate.getDate());

        String bsal = txt_Slry.getText();
        

            String sql = "UPDATE trainer SET F_Name= '"+Fname+"' , L_Name='"+Lname+"' , Phone_No='"+pNO+"' , Gender='"+genders+"',"
                    + "Birthday='"+Date+"' , Address1='"+Adres1+"' , Address2='"+Adres2+"' , Start_Date='"+date+"',Basic_Sal='"+bsal+"'"
                    + ",Photo=? WHERE  Trainer_ID = '"+id+"' ";
            
           PreparedStatement statement = conn.prepareStatement(sql);
           InputStream img = new FileInputStream(new File(imgpath));
            statement.setBlob(1, img);
           statement.execute();  
           
//           JOptionPane.showMessageDialog(null, "Update Success");
            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Update Trainer Succuss");
            noti.showNotification();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Please Update Image");
        }
        
        
    } 
   
   private void btnDelete() {
        int check = JOptionPane.showConfirmDialog(null, " IF YOU DELETE THIS TRAINER,\n ALL THE SCHEDULES AND SALARIES ASSIGNED TO THIS TRAINER WILL BE DELETED.\n DO YOU WANT TO DELETE");

        if (check == 0) {

            String addno = txt_ID.getText();

            try {
                String sql = "DELETE FROM trainer WHERE Trainer_ID ='" + addno + "'";
                PreparedStatement st = conn.prepareStatement(sql);
                st.execute();

//                JOptionPane.showMessageDialog(null, "Delete Successfull");
            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Delete Trainer Succuss");
            noti.showNotification();
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
   
     private void btnclear(){
        txt_ID.setText("");

        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhoneNo.setText("");
        rb_male.setSelected(false);
        rb_Female.setSelected(false);
     
        txt_Bday.setCalendar(null);
        
        txt_ad1.setText("");
        txt_ad2.setText("");

        txt_SrtDate.setCalendar(null);
        
        txt_Slry.setText("");
        Ibl_lmage2.setIcon(null);
  
    }
  
         private void search() {

        String srch = txt_search.getText();

        try {
            String sql = "SELECT * FROM trainer WHERE F_Name LIKE '%" + srch + "%' OR Trainer_ID LIKE '%" + srch + "%' ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            tbl_trainer.setModel(DbUtils.resultSetToTableModel(rs));
            
            //            tbl_trainer.getColumnModel().getColumn(1).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(1).setMaxWidth(0);
//            tbl_trainer.getColumnModel().getColumn(4).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(4).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(5).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(6).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(6).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(7).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(7).setMaxWidth(0);
//            tbl_trainer.getColumnModel().getColumn(8).setMinWidth(0);
//            tbl_trainer.getColumnModel().getColumn(8).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(9).setMaxWidth(0);
            tbl_trainer.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_trainer.getColumnModel().getColumn(10).setMaxWidth(0);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
         
     private void clickRow() {

        try {
        int r = tbl_trainer.getSelectedRow();

        String id = tbl_trainer.getValueAt(r, 0).toString();
        String fn = tbl_trainer.getValueAt(r, 1).toString();
        String ln = tbl_trainer.getValueAt(r, 2).toString();
        String phone = tbl_trainer.getValueAt(r, 3).toString();
        String Gen = tbl_trainer.getValueAt(r, 4).toString();

        String Ad1 = tbl_trainer.getValueAt(r, 6).toString();
        String Ad2 = tbl_trainer.getValueAt(r, 7).toString();        
        String fee = tbl_trainer.getValueAt(r, 9).toString();
        
        DefaultTableModel model=(DefaultTableModel)tbl_trainer.getModel();
        int selectedRow=tbl_trainer.getSelectedRow();
        Date Bday = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 5).toString()); 
        Date AdDay = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 8).toString());
        

        txt_ID.setText(id);

        txtFirstName.setText(fn);
        txtLastName.setText(ln);
        txtPhoneNo.setText(phone);

        if ("Male".equals(Gen)) {
            rb_male.setSelected(true);
        } else if ("Female".equals(Gen)) {
            rb_Female.setSelected(true);
        }

        txt_Bday.setDate(Bday);
        
        txt_ad1.setText(Ad1);
        txt_ad2.setText(Ad2);

        txt_SrtDate.setDate(AdDay);
        
        txt_Slry.setText(fee);
       
        Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Textbox filled");
            noti.showNotification();
        
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }      

   
     
         private void imageLoader(){
        try {
            int id = Integer.parseInt(txt_ID.getText());

        try {
            String sql = "SELECT * FROM trainer WHERE Trainer_ID='" + id + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Ibl_lmage2.setIcon(ResizeImage(null, rs.getBytes("Photo")));
            } else {
                JOptionPane.showMessageDialog(null, "NO Image Found This ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        } catch (Exception e) {
        }
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_minimize = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lbl_ID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhoneNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rb_male = new javax.swing.JRadioButton();
        rb_Female = new javax.swing.JRadioButton();
        txt_Bday = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_ad1 = new javax.swing.JTextField();
        txt_ad2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_SrtDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_Slry = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_trainer = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txt_ID = new javax.swing.JTextField();
        txt_search = new swing.TextFieldAnimation();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        Ibl_lmage2 = new javax.swing.JLabel();
        btn_choose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        jLabel12.setText("Trainer Page");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addGap(66, 66, 66))
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

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        lbl_ID.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ID.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(0, 0, 0));
        lbl_ID.setText("Trainer ID");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("First Name");

        txtFirstName.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name");

        txtLastName.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Phone NO");

        txtPhoneNo.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Gender");

        rb_male.setBackground(new java.awt.Color(255, 255, 255));
        rb_male.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        rb_male.setForeground(new java.awt.Color(0, 0, 0));
        rb_male.setText("Male");

        rb_Female.setBackground(new java.awt.Color(255, 255, 255));
        rb_Female.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        rb_Female.setForeground(new java.awt.Color(0, 0, 0));
        rb_Female.setText("Female");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Birthday");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Address");

        txt_ad1.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_ad2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Stat Date");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Basic Salary");

        txt_Slry.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        tbl_trainer.setFont(new java.awt.Font("Square721 BT", 0, 14)); // NOI18N
        tbl_trainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Trainer ID", "First Name", "Last Name", "Phone NO", "Gender", "Birthday", "Address Line 1", "Address Line 2", "Start Date", "Salary"
            }
        ));
        tbl_trainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_trainerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_trainer);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_save_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_update_file_24px_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_bin_24px.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_24px.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jButton7.setBackground(new java.awt.Color(102, 0, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_process_24px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txt_ID.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

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
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(lbl_ID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(rb_male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_Female))
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtLastName)
                            .addComponent(txtPhoneNo)
                            .addComponent(txt_ID)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel13)))
                                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGap(18, 18, 18)
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_Slry)
                                                .addComponent(txt_Bday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_ad1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_ad2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_SrtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ID)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(5, 5, 5)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_male)
                            .addComponent(rb_Female)
                            .addComponent(jLabel5)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Bday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel13))
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addComponent(txt_ad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(txt_SrtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Slry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel14))))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3)
                                .addComponent(jButton4))
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 204));

        Ibl_lmage2.setForeground(new java.awt.Color(255, 255, 255));
        Ibl_lmage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_choose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_browse_folder_30px.png"))); // NOI18N
        btn_choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(btn_choose)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(Ibl_lmage2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Ibl_lmage2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_choose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        btn_Close.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btn_CloseMouseExited

    private void jLabel12MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel12MouseDragged

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse= evt.getY();
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
        btn_minimize.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btn_minimizeMouseExited

    private void tbl_trainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_trainerMouseClicked
        // TODO add your handling code here:
        clickRow();
        imageLoader();
    }//GEN-LAST:event_tbl_trainerMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        btnSave();
        //btnclear();
        tableload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update();
        btnclear();
        tableload();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        btnDelete();
        btnclear();
        tableload();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        btnclear();
        tableload();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        btnclear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseActionPerformed
        // TODO add your handling code here:
         try {
            filechoser();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_chooseActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         try {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("Trainer_ID", txt_ID.getText()); // Replace "inv_id" with the correct parameter name in your report

//                Connection conn = db.mycon(); // Assuming db.mycon() returns a valid Connection
                String reportpath = "C:\\Users\\DELL-PC\\Documents\\GYM Project\\GYMsoft\\src\\report\\payment.jrxml";
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
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
    IntelliJTheme.setup(AddTrainer.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ibl_lmage2;
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_choose;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JRadioButton rb_Female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JTable tbl_trainer;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNo;
    private com.toedter.calendar.JDateChooser txt_Bday;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Slry;
    private com.toedter.calendar.JDateChooser txt_SrtDate;
    private javax.swing.JTextField txt_ad1;
    private javax.swing.JTextField txt_ad2;
    private swing.TextFieldAnimation txt_search;
    // End of variables declaration//GEN-END:variables
}
