/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import net.sf.jasperreports.view.JasperViewer;

import table.TableCustom;
import util.DBconnect;

public class shedules extends javax.swing.JFrame {

    Connection conn;
    int xMouse;
    int yMouse;
    List<String> Exercises = new ArrayList<>();

    String imgpath = null;
    String imgpath2 = null;

    public shedules() {
        initComponents();
        conn = DBconnect.connectdb();
//        Allclear();
        Exercises_arrayLoader();
        Autoload_Exercises1();
        Autoload_Exercises2();
        Autoload_Exercises3();
        Autoload_Exercises4();
        Autoload_Exercises5();
        Autoload_Exercises6();
        Autoload_Exercises7();
        Autoload_Exercises8();
        Autoload_Exercises9();
        Autoload_Exercises10();
        Autoload_Exercises11();
        Autoload_Exercises12();
        Autoload_Exercises13();
        Autoload_Exercises14();
        Autoload_Exercises15();
        trainerLOAD();
        tableload();
        TodayDateLoader();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
       
    }

    public void TodayDateLoader() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        date.setText(dd);
    }

    public ImageIcon ResizeImage(String imagepath, byte[] pic) {

        ImageIcon MyImage = null;

        if (imagepath != null) {
            MyImage = new ImageIcon(imagepath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Ibl_lmage.getWidth(), Ibl_lmage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }

    public ImageIcon ResizeImage2(String imagepath, byte[] pic) {

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
            Ibl_lmage.setIcon(ResizeImage(path, null));

            imgpath = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.print("NO FILE SELECTED");
        }

    }

    public void filechoser2() {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            Ibl_lmage2.setIcon(ResizeImage2(path, null));

            imgpath2 = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.print("NO FILE SELECTED");
        }

    }

    private void Exercises_arrayLoader() {
        try {
            String sql = "SELECT Name FROM supportiveword";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String a = rs.getString("Name");
                Exercises.add(a);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void Autoload_Exercises1() {
        AutoCompleteDecorator.decorate(txt_Exercises01, Exercises, false);
        txt_Exercises01.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises01.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises01.setText(item);
                            txt_Exercises01.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises01.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises2() {
        AutoCompleteDecorator.decorate(txt_Exercises02, Exercises, false);
        txt_Exercises02.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises02.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises02.setText(item);
                            txt_Exercises02.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises02.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises3() {
        AutoCompleteDecorator.decorate(txt_Exercises03, Exercises, false);
        txt_Exercises03.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises03.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises03.setText(item);
                            txt_Exercises03.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises03.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises4() {
        AutoCompleteDecorator.decorate(txt_Exercises04, Exercises, false);
        txt_Exercises04.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises04.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises04.setText(item);
                            txt_Exercises04.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises04.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises5() {
        AutoCompleteDecorator.decorate(txt_Exercises05, Exercises, false);
        txt_Exercises05.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises05.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises05.setText(item);
                            txt_Exercises05.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises05.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises6() {
        AutoCompleteDecorator.decorate(txt_Exercises06, Exercises, false);
        txt_Exercises06.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises06.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises06.setText(item);
                            txt_Exercises06.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises06.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises7() {
        AutoCompleteDecorator.decorate(txt_Exercises07, Exercises, false);
        txt_Exercises07.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises07.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises07.setText(item);
                            txt_Exercises07.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises07.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises8() {
        AutoCompleteDecorator.decorate(txt_Exercises08, Exercises, false);
        txt_Exercises08.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises08.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises08.setText(item);
                            txt_Exercises08.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises08.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises9() {
        AutoCompleteDecorator.decorate(txt_Exercises09, Exercises, false);
        txt_Exercises09.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises09.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises09.setText(item);
                            txt_Exercises09.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises09.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises10() {
        AutoCompleteDecorator.decorate(txt_Exercises10, Exercises, false);
        txt_Exercises10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises10.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises10.setText(item);
                            txt_Exercises10.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises10.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises11() {
        AutoCompleteDecorator.decorate(txt_Exercises11, Exercises, false);
        txt_Exercises11.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises11.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises11.setText(item);
                            txt_Exercises11.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises11.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises12() {
        AutoCompleteDecorator.decorate(txt_Exercises12, Exercises, false);
        txt_Exercises12.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises12.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises12.setText(item);
                            txt_Exercises12.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises12.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises13() {
        AutoCompleteDecorator.decorate(txt_Exercises13, Exercises, false);
        txt_Exercises13.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises13.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises13.setText(item);
                            txt_Exercises13.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises13.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises14() {
        AutoCompleteDecorator.decorate(txt_Exercises14, Exercises, false);
        txt_Exercises14.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises14.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises14.setText(item);
                            txt_Exercises14.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises14.setText("");
                }
            }
        });
    }

    private void Autoload_Exercises15() {
        AutoCompleteDecorator.decorate(txt_Exercises15, Exercises, false);
        txt_Exercises15.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentText = txt_Exercises15.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (String item : Exercises) {
                        if (item.toLowerCase().startsWith(currentText.toLowerCase())) {
                            txt_Exercises15.setText(item);
                            txt_Exercises15.setCaretPosition(item.length());
                            break;
                        }
                    }
                    txt_Exercises15.setText("");
                }
            }
        });
    }

    private void Search_bar() {

        try {

            String sql = "SELECT Gym_ID,F_Name,Package_ID,Gender FROM member WHERE Gym_ID = '" + txt_SerchBar.getText() + "' OR F_Name = '" + txt_SerchBar.getText() + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                lbl_GymId.setText(rs.getString("Gym_ID"));
                lbl_Name.setText(rs.getString("F_Name"));
                lbl_tid.setText(rs.getString("Package_ID"));
                lbl_gender.setText(rs.getString("Gender"));
            }

            String sql1 = "SELECT name FROM package WHERE Package_ID='" + lbl_tid.getText() + "'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            String ID = null;

            if (rs1.next()) {

                ID = rs1.getString("name");
                lbl_Type.setText(ID);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void trainerLOAD() {

        try {
            String sql = "SELECT F_Name FROM trainer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String sub = rs.getString("F_Name");
                cmb_trainers.addItem(sub);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void calBMI() {
        try {
            double weight = Double.parseDouble(txt_w.getText());
            double height = Double.parseDouble(txt_h.getText());
            double bmi = weight / (height * height);
            lbl_BMI.setText(String.format("BMI: %.2f", bmi));

            if (bmi < 18.55) {
                lbl_BT.setText("Underweight");
            } else if (bmi <= 25.00) {
                lbl_BT.setText("Normalweight");
            } else if (bmi <= 35.00) {
                lbl_BT.setText("Overweight");
            } else {
                lbl_BT.setText("Obesity");
            }

        } catch (NumberFormatException ex) {
            lbl_BMI.setText("Invalid input");
        }
    }

    private void btnSave() {

        try {

            String sql1 = "SELECT Trainer_ID FROM trainer WHERE F_Name = '" + cmb_trainers.getSelectedItem() + "'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            String ID = null;

            if (rs1.next()) {

                ID = rs1.getString("Trainer_ID");
            }

            SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
            String ST;
            ST = stf.format(dt_Start.getDate());

            SimpleDateFormat stf2 = new SimpleDateFormat("yyyy-MM-dd");
            String ED;
            ED = stf2.format(dt_End.getDate());

            SimpleDateFormat stf3 = new SimpleDateFormat("yyyy-MM-dd");
            String isd;
            isd = stf3.format(dt_End.getDate());

            String sql = "INSERT INTO gym.sheduledetails"
                    + "(Gym_ID, Trainer_ID, StartDate, EndDate, IssuedDate, Weight, Height, BMI, BodyType, Front, Back, Type, E1, S1, E2, S2, E3, S3, E4, S4, E5, S5, E6, S6, E7, S7, E8, S8, E9, S9, E10, S10, E11, S11, E12, S12, E13, S13, E14, S14, E15, S15)"
                    + "VALUES('" + lbl_GymId.getText() + "','" + ID + "','" + ST + "','" + ED + "','" + isd + "',"
                    + "'" + txt_w.getText() + "','" + txt_h.getText() + "','" + lbl_BMI.getText() + "','" + lbl_BT.getText() + "',?,?,"
                    + "'" + cmb_sdlType.getSelectedItem() + "',"
                    + "'" + txt_Exercises01.getText() + "','" + Set01_txt.getText() + "',"
                    + "'" + txt_Exercises02.getText() + "','" + Set02_txt.getText() + "',"
                    + "'" + txt_Exercises03.getText() + "','" + Set03_txt.getText() + "',"
                    + "'" + txt_Exercises04.getText() + "','" + Set04_txt.getText() + "',"
                    + "'" + txt_Exercises05.getText() + "','" + Set05_txt.getText() + "',"
                    + "'" + txt_Exercises06.getText() + "','" + Set06_txt.getText() + "',"
                    + "'" + txt_Exercises07.getText() + "','" + Set07_txt.getText() + "',"
                    + "'" + txt_Exercises08.getText() + "','" + Set08_txt.getText() + "',"
                    + "'" + txt_Exercises09.getText() + "','" + Set09_txt.getText() + "',"
                    + "'" + txt_Exercises10.getText() + "','" + Set10_txt.getText() + "',"
                    + "'" + txt_Exercises11.getText() + "','" + Set11_txt.getText() + "',"
                    + "'" + txt_Exercises12.getText() + "','" + Set12_txt.getText() + "',"
                    + "'" + txt_Exercises13.getText() + "','" + Set13_txt.getText() + "',"
                    + "'" + txt_Exercises14.getText() + "','" + Set14_txt.getText() + "',"
                    + "'" + txt_Exercises15.getText() + "','" + Set15_txt.getText() + "')";

            PreparedStatement st = conn.prepareStatement(sql);
            InputStream img = new FileInputStream(new File(imgpath));
            InputStream img2 = new FileInputStream(new File(imgpath2));
            st.setBlob(1, img);
            st.setBlob(2, img2);
            st.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Save Shedule Succuss"); 
            Notification noti = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Save Success");
            noti.showNotification();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void btnUpdate() {

        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
        String ST;
        ST = stf.format(dt_Start.getDate());

        SimpleDateFormat stf2 = new SimpleDateFormat("yyyy-MM-dd");
        String ED;
        ED = stf2.format(dt_End.getDate());
        
        SimpleDateFormat stf3 = new SimpleDateFormat("yyyy-MM-dd");
            String isd;
            isd = stf3.format(dt_End.getDate());

        try {

            String sql1 = "SELECT Trainer_ID FROM trainer WHERE F_Name = '" + cmb_trainers.getSelectedItem() + "'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            String ID = null;

            if (rs1.next()) {

                ID = rs1.getString("Trainer_ID");
            }

            String sql = "UPDATE gym.sheduledetails SET Gym_ID='" + lbl_GymId.getText() + "',"
                    + " StartDate='" + ST + "',EndDate='" + ED + "',IssuedDate='" +isd+ "',"
                    + "Weight='" + txt_w.getText() + "',Height='" + txt_h.getText() + "',BMI='" + lbl_BMI.getText() + "',BodyType='" + lbl_BT.getText() + "',"
                    + "Front=?,Back=?,Type='" + cmb_sdlType.getSelectedItem() + "',"
                    + "E1='" + txt_Exercises01.getText() + "',  S1='" + Set01_txt.getText() + "', "
                    + "E2='" + txt_Exercises02.getText() + "', S2='" + Set02_txt.getText() + "', "
                    + "E3='" + txt_Exercises03.getText() + "', S3='" + Set03_txt.getText() + "', "
                    + "E4='" + txt_Exercises04.getText() + "', S4='" + Set04_txt.getText() + "', "
                    + "E5='" + txt_Exercises05.getText() + "', S5='" + Set05_txt.getText() + "', "
                    + "E6='" + txt_Exercises06.getText() + "', S6='" + Set06_txt.getText() + "', "
                    + "E7='" + txt_Exercises07.getText() + "', S7='" + Set07_txt.getText() + "', "
                    + "E8='" + txt_Exercises08.getText() + "', S8='" + Set08_txt.getText() + "', "
                    + "E9='" + txt_Exercises09.getText() + "', S9='" + Set09_txt.getText() + "', "
                    + "E10='" + txt_Exercises10.getText() + "', S10='" + Set10_txt.getText() + "', "
                    + "E11='" + txt_Exercises11.getText() + "', S11='" + Set11_txt.getText() + "', "
                    + "E12='" + txt_Exercises12.getText() + "', S12='" + Set12_txt.getText() + "', "
                    + "E13='" + txt_Exercises13.getText() + "', S13='" + Set13_txt.getText() + "', "
                    + "E14='" + txt_Exercises14.getText() + "', S14='" + Set14_txt.getText() + "', "
                    + "E15='" + txt_Exercises15.getText() + "', S15='" + Set15_txt.getText() + "' "
                    + "WHERE shedul_ID='" + lbl_SDL.getText() + "' and Trainer_ID='" + ID + "'";

            PreparedStatement statement = conn.prepareStatement(sql);
            InputStream img = new FileInputStream(new File(imgpath));
            InputStream img2 = new FileInputStream(new File(imgpath2));
            statement.setBlob(1, img);
            statement.setBlob(2, img2);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pleas Update Images");
        }
    }

    private void tableload() {
        try {
            String sql = "SELECT a.shedul_ID, a.Gym_ID, a.Trainer_ID, a.StartDate, a.EndDate, "
                    + "a.IssuedDate, a.Weight, a.Height, a.BMI, a.BodyType,a.Type, "
                    + "a.E1, a.S1, a.E2, a.S2, a.E3, a.S3, a.E4, a.S4, a.E5, a.S5, a.E6, a.S6, a.E7, a.S7, a.E8, a.S8, "
                    + "a.E9, a.S9, a.E10, a.S10, a.E11, a.S11, a.E12, a.S12, a.E13, a.S13, a.E14, a.S14, a.E15, a.S15,"
                    + "b.F_Name,b.Package_ID,b.Gender"
                    + " FROM sheduledetails AS a INNER JOIN member AS b ON a.Gym_ID=b.Gym_ID ORDER BY shedul_ID DESC";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            tbl_Shedule.setModel(DbUtils.resultSetToTableModel(rs));

//            tbl_Shedule.getColumnModel().getColumn(0).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(0).setMaxWidth(0);
//            
//            tbl_Shedule.getColumnModel().getColumn(1).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(1).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(2).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(2).setMaxWidth(0);
            
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
            
            tbl_Shedule.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(9).setMaxWidth(0);
            
//            tbl_Shedule.getColumnModel().getColumn(10).setMinWidth(0);
//            tbl_Shedule.getColumnModel().getColumn(10).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(11).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(11).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(12).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(12).setMaxWidth(0);
            
            
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
            
//          tbl_Shedule.getColumnModel().getColumn(41).setMinWidth(0);
//          tbl_Shedule.getColumnModel().getColumn(41).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(42).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(42).setMaxWidth(0);
            
            tbl_Shedule.getColumnModel().getColumn(43).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(43).setMaxWidth(0);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clickRow() {

        try {

            int r = tbl_Shedule.getSelectedRow();

            String ss = tbl_Shedule.getValueAt(r, 0).toString();
            String gymid = tbl_Shedule.getValueAt(r, 1).toString();
            String trid = tbl_Shedule.getValueAt(r, 2).toString();
            String sql1 = "SELECT F_Name FROM trainer WHERE Trainer_ID = '" + trid + "'";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            String ID = null;

            if (rs1.next()) {

                ID = rs1.getString("F_Name");
            }

            DefaultTableModel model = (DefaultTableModel) tbl_Shedule.getModel();
            int selectedRow = tbl_Shedule.getSelectedRow();
            Date ST = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(selectedRow, 3).toString());
            Date ED = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(selectedRow, 4).toString());
            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(selectedRow, 5).toString());

            String w = tbl_Shedule.getValueAt(r, 6).toString();
            String h = tbl_Shedule.getValueAt(r, 7).toString();
            String bm = tbl_Shedule.getValueAt(r, 8).toString();
            String bt = tbl_Shedule.getValueAt(r, 9).toString();
            String t = tbl_Shedule.getValueAt(r, 10).toString();

            String E1 = tbl_Shedule.getValueAt(r, 11).toString();
            String S1 = tbl_Shedule.getValueAt(r, 12).toString();

            String E2 = tbl_Shedule.getValueAt(r, 13).toString();
            String S2 = tbl_Shedule.getValueAt(r, 14).toString();

            String E3 = tbl_Shedule.getValueAt(r, 15).toString();
            String S3 = tbl_Shedule.getValueAt(r, 16).toString();

            String E4 = tbl_Shedule.getValueAt(r, 17).toString();
            String S4 = tbl_Shedule.getValueAt(r, 18).toString();

            String E5 = tbl_Shedule.getValueAt(r, 19).toString();
            String S5 = tbl_Shedule.getValueAt(r, 20).toString();

            String E6 = tbl_Shedule.getValueAt(r, 21).toString();
            String S6 = tbl_Shedule.getValueAt(r, 22).toString();

            String E7 = tbl_Shedule.getValueAt(r, 23).toString();
            String S7 = tbl_Shedule.getValueAt(r, 24).toString();

            String E8 = tbl_Shedule.getValueAt(r, 25).toString();
            String S8 = tbl_Shedule.getValueAt(r, 26).toString();

            String E9 = tbl_Shedule.getValueAt(r, 27).toString();
            String S9 = tbl_Shedule.getValueAt(r, 28).toString();

            String E10 = tbl_Shedule.getValueAt(r, 29).toString();
            String S10 = tbl_Shedule.getValueAt(r, 30).toString();

            String E11 = tbl_Shedule.getValueAt(r, 31).toString();
            String S11 = tbl_Shedule.getValueAt(r, 32).toString();

            String E12 = tbl_Shedule.getValueAt(r, 33).toString();
            String S12 = tbl_Shedule.getValueAt(r, 34).toString();

            String E13 = tbl_Shedule.getValueAt(r, 35).toString();
            String S13 = tbl_Shedule.getValueAt(r, 36).toString();

            String E14 = tbl_Shedule.getValueAt(r, 37).toString();
            String S14 = tbl_Shedule.getValueAt(r, 38).toString();

            String E15 = tbl_Shedule.getValueAt(r, 39).toString();
            String S15 = tbl_Shedule.getValueAt(r, 40).toString();
            
            String fn = tbl_Shedule.getValueAt(r, 41).toString();
            
            String pid = tbl_Shedule.getValueAt(r, 42).toString();
            
            String gen = tbl_Shedule.getValueAt(r, 43).toString();

            lbl_Name.setText(fn);
            lbl_tid.setText(pid);
            lbl_gender.setText(gen);
            
            lbl_SDL.setText(ss);
            lbl_GymId.setText(gymid);

            txt_w.setText(w);
            txt_h.setText(h);
            lbl_BMI.setText(bm);
            lbl_BT.setText(bt);
            cmb_trainers.setSelectedItem(ID);
            cmb_sdlType.setSelectedItem(t);
            dt_issu.setDate(dt);

            dt_Start.setDate(ST);
            dt_End.setDate(ED);

            txt_Exercises01.setText(E1);
            Set01_txt.setText(S1);

            txt_Exercises02.setText(E2);
            Set02_txt.setText(S2);

            txt_Exercises03.setText(E3);
            Set03_txt.setText(S3);

            txt_Exercises04.setText(E4);
            Set04_txt.setText(S4);

            txt_Exercises05.setText(E5);
            Set05_txt.setText(S5);

            txt_Exercises06.setText(E6);
            Set06_txt.setText(S6);

            txt_Exercises07.setText(E7);
            Set07_txt.setText(S7);

            txt_Exercises08.setText(E8);
            Set08_txt.setText(S8);

            txt_Exercises09.setText(E9);
            Set09_txt.setText(S9);

            txt_Exercises10.setText(E10);
            Set10_txt.setText(S10);

            txt_Exercises11.setText(E11);
            Set11_txt.setText(S11);

            txt_Exercises12.setText(E12);
            Set12_txt.setText(S12);

            txt_Exercises13.setText(E13);
            Set13_txt.setText(S13);

            txt_Exercises14.setText(E14);
            Set14_txt.setText(S14);

            txt_Exercises15.setText(E15);
            Set15_txt.setText(S15);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     private void btnDelete() {
        int check = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DELETE");

        if (check == 0) {

            String addno = lbl_SDL.getText();

            try {
                String sql = "DELETE FROM gym.sheduledetails WHERE shedul_ID='" + addno + "'";
                PreparedStatement st = conn.prepareStatement(sql);
                st.execute();

            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Delete Member Succuss");
            noti.showNotification();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void TextFieldclear() {
        cmb_sdlType.setSelectedItem(null);

        txt_Exercises01.setText("");
        Set01_txt.setText("");

        txt_Exercises02.setText("");
        Set02_txt.setText("");

        txt_Exercises03.setText("");
        Set03_txt.setText("");

        txt_Exercises04.setText("");
        Set04_txt.setText("");

        txt_Exercises05.setText("");
        Set05_txt.setText("");

        txt_Exercises06.setText("");
        Set06_txt.setText("");

        txt_Exercises07.setText("");
        Set07_txt.setText("");

        txt_Exercises08.setText("");
        Set08_txt.setText("");

        txt_Exercises09.setText("");
        Set09_txt.setText("");

        txt_Exercises10.setText("");
        Set10_txt.setText("");

        txt_Exercises11.setText("");
        Set11_txt.setText("");

        txt_Exercises12.setText("");
        Set12_txt.setText("");

        txt_Exercises13.setText("");
        Set13_txt.setText("");

        txt_Exercises14.setText("");
        Set14_txt.setText("");

        txt_Exercises15.setText("");
        Set15_txt.setText("");

    }

    private void Allclear() {
        lbl_SDL.setText("");
        lbl_GymId.setText("GYM ID");
        lbl_Name.setText("Name");
        lbl_tid.setText("");
        lbl_Type.setText("");
        lbl_gender.setText("");
        
        cmb_trainers.setSelectedItem(null);
        txt_w.setText("");
        txt_h.setText("");
        txt_SerchBar.setText("");
        lbl_BMI.setText("");
        lbl_BT.setText("");
        dt_End.setCalendar(null);
        dt_Start.setCalendar(null);
        dt_End.setCalendar(null);
        dt_issu.setCalendar(null);
        Ibl_lmage.setIcon(null);
        Ibl_lmage2.setIcon(null);
        
        cmb_sdlType.setSelectedItem(null);

        txt_Exercises01.setText("");
        Set01_txt.setText("");

        txt_Exercises02.setText("");
        Set02_txt.setText("");

        txt_Exercises03.setText("");
        Set03_txt.setText("");

        txt_Exercises04.setText("");
        Set04_txt.setText("");

        txt_Exercises05.setText("");
        Set05_txt.setText("");

        txt_Exercises06.setText("");
        Set06_txt.setText("");

        txt_Exercises07.setText("");
        Set07_txt.setText("");

        txt_Exercises08.setText("");
        Set08_txt.setText("");

        txt_Exercises09.setText("");
        Set09_txt.setText("");

        txt_Exercises10.setText("");
        Set10_txt.setText("");

        txt_Exercises11.setText("");
        Set11_txt.setText("");

        txt_Exercises12.setText("");
        Set12_txt.setText("");

        txt_Exercises13.setText("");
        Set13_txt.setText("");

        txt_Exercises14.setText("");
        Set14_txt.setText("");

        txt_Exercises15.setText("");
        Set15_txt.setText("");

    }
 
    private void imageLoader(){
        try {
            int id = Integer.parseInt(lbl_SDL.getText());

        try {
            String sql = "SELECT * FROM sheduledetails WHERE shedul_ID='" + id + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Ibl_lmage.setIcon(ResizeImage(null, rs.getBytes("Front")));
                Ibl_lmage2.setIcon(ResizeImage(null, rs.getBytes("Back")));
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_SerchBar = new javax.swing.JTextField();
        lbl_tid = new javax.swing.JLabel();
        lbl_Type = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmb_trainers = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dt_Start = new com.toedter.calendar.JDateChooser();
        dt_End = new com.toedter.calendar.JDateChooser();
        lbl_GymId = new javax.swing.JLabel();
        lbl_p = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        lbl_sdlID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BodyType = new javax.swing.JLabel();
        txt_w = new javax.swing.JTextField();
        txt_h = new javax.swing.JTextField();
        lbl_BMI = new javax.swing.JLabel();
        lbl_BT = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        lbl_tid1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dt_issu = new com.toedter.calendar.JDateChooser();
        lbl_SDL = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel22 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        txt_Exercises14 = new javax.swing.JTextField();
        txt_Exercises13 = new javax.swing.JTextField();
        txt_Exercises15 = new javax.swing.JTextField();
        txt_Exercises12 = new javax.swing.JTextField();
        Set12_txt = new javax.swing.JTextField();
        Set13_txt = new javax.swing.JTextField();
        Set14_txt = new javax.swing.JTextField();
        Set15_txt = new javax.swing.JTextField();
        txt_Exercises01 = new javax.swing.JTextField();
        Set01_txt = new javax.swing.JTextField();
        txt_Exercises02 = new javax.swing.JTextField();
        Set02_txt = new javax.swing.JTextField();
        txt_Exercises03 = new javax.swing.JTextField();
        Set03_txt = new javax.swing.JTextField();
        txt_Exercises04 = new javax.swing.JTextField();
        Set04_txt = new javax.swing.JTextField();
        txt_Exercises05 = new javax.swing.JTextField();
        Set05_txt = new javax.swing.JTextField();
        txt_Exercises06 = new javax.swing.JTextField();
        Set06_txt = new javax.swing.JTextField();
        txt_Exercises07 = new javax.swing.JTextField();
        Set07_txt = new javax.swing.JTextField();
        txt_Exercises08 = new javax.swing.JTextField();
        Set08_txt = new javax.swing.JTextField();
        txt_Exercises09 = new javax.swing.JTextField();
        Set09_txt = new javax.swing.JTextField();
        txt_Exercises10 = new javax.swing.JTextField();
        Set10_txt = new javax.swing.JTextField();
        txt_Exercises11 = new javax.swing.JTextField();
        Set11_txt = new javax.swing.JTextField();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        Ibl_lmage = new javax.swing.JLabel();
        Ibl_lmage2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Shedule = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        cmb_sdlType = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btn_minimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gym ID / Name");

        txt_SerchBar.setForeground(new java.awt.Color(0, 0, 0));
        txt_SerchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SerchBarKeyReleased(evt);
            }
        });

        lbl_tid.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_tid.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tid.setText("-");

        lbl_Type.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Type.setText("-");

        jLabel6.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gender");

        lbl_gender.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_gender.setForeground(new java.awt.Color(0, 0, 0));
        lbl_gender.setText("-");

        jLabel11.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Trainer");

        cmb_trainers.setForeground(new java.awt.Color(0, 0, 0));
        cmb_trainers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel7.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Start Day");

        jLabel19.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("End Day");

        dt_Start.setForeground(new java.awt.Color(0, 0, 0));

        dt_End.setForeground(new java.awt.Color(0, 0, 0));

        lbl_GymId.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_GymId.setForeground(new java.awt.Color(0, 0, 0));
        lbl_GymId.setText("Gym ID");

        lbl_p.setForeground(new java.awt.Color(255, 255, 0));
        lbl_p.setText("-");

        date.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(0, 0, 0));
        date.setText("jLabel3");

        lbl_sdlID.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_sdlID.setForeground(new java.awt.Color(0, 0, 0));
        lbl_sdlID.setText("Shedule ID");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_26px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel3.setText("Weight");

        jLabel4.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel4.setText("Hight");

        jLabel5.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel5.setText("BMI");

        BodyType.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        BodyType.setText("Body Type");

        txt_w.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_h.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        txt_h.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_hKeyReleased(evt);
            }
        });

        lbl_BMI.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_BMI.setText("-");
        lbl_BMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_BMIMouseEntered(evt);
            }
        });

        lbl_BT.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_BT.setText("-");

        jButton8.setBackground(new java.awt.Color(102, 0, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_process_24px_1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_save_24px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 255, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_update_file_24px_1.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 153, 102));
        jButton11.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_bin_24px.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 0, 255));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_24px.png"))); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel16.setText("kg");

        jLabel17.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel17.setText("m");

        lbl_Name.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_Name.setText("F_Name");

        lbl_tid1.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        lbl_tid1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tid1.setText("Type");

        jLabel8.setText("Issued Date");

        lbl_SDL.setText("-");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(67, 67, 67)
                        .addComponent(lbl_p)
                        .addGap(181, 181, 181))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_sdlID)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel19))
                                        .addGap(18, 18, 18))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_tid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(44, 44, 44)))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_gender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbl_tid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(dt_issu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_BT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_BMI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_h)
                                                    .addComponent(txt_w)
                                                    .addComponent(cmb_trainers, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(dt_Start, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                    .addComponent(dt_End, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel17)))
                                            .addComponent(lbl_SDL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(txt_SerchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_GymId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(BodyType)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SerchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sdlID)
                    .addComponent(lbl_SDL))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_GymId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Name))
                .addGap(6, 6, 6)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Type)
                    .addComponent(lbl_tid)
                    .addComponent(lbl_tid1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmb_trainers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_gender))
                        .addGap(75, 75, 75)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dt_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dt_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_w, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_BMI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BodyType)
                    .addComponent(lbl_BT))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dt_issu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton9)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton6))
                    .addComponent(jButton8))
                .addGap(31, 31, 31))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));

        txt_Exercises14.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises13.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises15.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises12.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set12_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set13_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set14_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set15_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises01.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set01_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises02.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set02_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises03.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set03_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises04.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set04_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises05.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set05_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises06.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set06_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises07.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set07_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises08.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set08_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises09.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set09_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises10.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set10_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        txt_Exercises11.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        Set11_txt.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises01, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set01_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_Exercises05, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises03, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set03_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises02, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set02_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises09, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set09_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises10, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set10_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises11, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set11_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Exercises08, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Exercises04, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Exercises06, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Exercises07, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Set05_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Set04_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Set06_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Set07_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Set08_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises12, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set12_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises14, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set14_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises13, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set13_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises15, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set15_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set01_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set02_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set03_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Exercises04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Exercises05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Exercises06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Exercises07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Exercises08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(Set04_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set05_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set06_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set07_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Set08_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set09_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set10_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set11_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set12_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set13_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Exercises14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set14_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Exercises15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Set15_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(225, 225, 225))
        );

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(255, 255, 255));

        Ibl_lmage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Ibl_lmage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Ibl_lmageMouseEntered(evt);
            }
        });

        Ibl_lmage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Font Photo");

        jLabel15.setText("Back Photo");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_browse_folder_30px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_browse_folder_30px.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ibl_lmage2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Ibl_lmage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Ibl_lmage, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ibl_lmage2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel23.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Shedule Type");

        cmb_sdlType.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_sdlType.setForeground(new java.awt.Color(0, 0, 0));
        cmb_sdlType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Intermediate", "Advanced", "Elite/Athlete-Level" }));
        cmb_sdlType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_sdlTypeMouseEntered(evt);
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

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_sdlType, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(181, 181, 181)))
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(384, 384, 384)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel22))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cmb_sdlType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Shedule Page");
        jLabel18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel18MouseDragged(evt);
            }
        });
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
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
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addGap(452, 452, 452))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Close)
                    .addComponent(jLabel18)
                    .addComponent(btn_minimize)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here
        btnSave();
        tableload();
        Allclear();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        btnUpdate();
        tableload();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        btnDelete();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        TextFieldclear();
    }//GEN-LAST:event_jButton13ActionPerformed

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

    private void jLabel18MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel18MouseDragged

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel18MousePressed

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

    private void cmb_sdlTypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_sdlTypeMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_cmb_sdlTypeMouseEntered

    private void txt_SerchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SerchBarKeyReleased
        // TODO add your handling code here:
        Search_bar();
        //  Loadpackagename();
    }//GEN-LAST:event_txt_SerchBarKeyReleased

    private void tbl_SheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SheduleMouseClicked
        // TODO add your handling code here:
        clickRow();
        imageLoader();
    }//GEN-LAST:event_tbl_SheduleMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here: 
        this.dispose();
        shedules a = new shedules();
        a.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void lbl_BMIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_BMIMouseEntered
        // TODO add your handling code here:
        calBMI();
    }//GEN-LAST:event_lbl_BMIMouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            filechoser();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            filechoser2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Ibl_lmageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ibl_lmageMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Ibl_lmageMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
   
    }//GEN-LAST:event_formMouseEntered

    private void txt_hKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hKeyReleased
       calBMI();
    }//GEN-LAST:event_txt_hKeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
      try {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("shedul_ID", lbl_SDL.getText()); // Replace "inv_id" with the correct parameter name in your report

//                Connection conn = db.mycon(); // Assuming db.mycon() returns a valid Connection
                String reportpath = "C:\\Users\\DELL-PC\\Documents\\GYM Project\\GYMsoft\\src\\report\\schedule.jrxml";
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

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton12MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(shedules.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new shedules().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BodyType;
    private javax.swing.JLabel Ibl_lmage;
    private javax.swing.JLabel Ibl_lmage2;
    private javax.swing.JTextField Set01_txt;
    private javax.swing.JTextField Set02_txt;
    private javax.swing.JTextField Set03_txt;
    private javax.swing.JTextField Set04_txt;
    private javax.swing.JTextField Set05_txt;
    private javax.swing.JTextField Set06_txt;
    private javax.swing.JTextField Set07_txt;
    private javax.swing.JTextField Set08_txt;
    private javax.swing.JTextField Set09_txt;
    private javax.swing.JTextField Set10_txt;
    private javax.swing.JTextField Set11_txt;
    private javax.swing.JTextField Set12_txt;
    private javax.swing.JTextField Set13_txt;
    private javax.swing.JTextField Set14_txt;
    private javax.swing.JTextField Set15_txt;
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JComboBox<String> cmb_sdlType;
    private javax.swing.JComboBox<String> cmb_trainers;
    private javax.swing.JLabel date;
    private com.toedter.calendar.JDateChooser dt_End;
    private com.toedter.calendar.JDateChooser dt_Start;
    private com.toedter.calendar.JDateChooser dt_issu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel5;
    private javax.swing.JLabel lbl_BMI;
    private javax.swing.JLabel lbl_BT;
    private javax.swing.JLabel lbl_GymId;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_SDL;
    private javax.swing.JLabel lbl_Type;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_p;
    private javax.swing.JLabel lbl_sdlID;
    private javax.swing.JLabel lbl_tid;
    private javax.swing.JLabel lbl_tid1;
    private javax.swing.JTable tbl_Shedule;
    private javax.swing.JTextField txt_Exercises01;
    private javax.swing.JTextField txt_Exercises02;
    private javax.swing.JTextField txt_Exercises03;
    private javax.swing.JTextField txt_Exercises04;
    private javax.swing.JTextField txt_Exercises05;
    private javax.swing.JTextField txt_Exercises06;
    private javax.swing.JTextField txt_Exercises07;
    private javax.swing.JTextField txt_Exercises08;
    private javax.swing.JTextField txt_Exercises09;
    private javax.swing.JTextField txt_Exercises10;
    private javax.swing.JTextField txt_Exercises11;
    private javax.swing.JTextField txt_Exercises12;
    private javax.swing.JTextField txt_Exercises13;
    private javax.swing.JTextField txt_Exercises14;
    private javax.swing.JTextField txt_Exercises15;
    private javax.swing.JTextField txt_SerchBar;
    private javax.swing.JTextField txt_h;
    private javax.swing.JTextField txt_w;
    // End of variables declaration//GEN-END:variables
}
