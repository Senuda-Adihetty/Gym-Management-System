/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inter;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.Notification;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import table.TableCustom;
import util.DBconnect;

/**
 *
 * @author DELL-PC
 */
public class presets extends javax.swing.JFrame {

    Connection conn;
    int xMouse;
    int yMouse;
    List<String> Exercises = new ArrayList<>();

    public presets() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        conn = DBconnect.connectdb();
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
        TodayDateLoader();
        tableload();
        
    }

    public void TodayDateLoader() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        date.setText(dd);
        date.setVisible(false);
        
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

    private void btnSave() {

        try {

            String sql = "INSERT INTO presets(Type, IssueDate, E1, S1, E2, S2, E3, S3, E4, S4,"
                    + " E5, S5, E6, S6, E7, S7, E8, S8, E9, S9, E10, S10, E11, S11, E12, S12, E13, S13, "
                    + "E14, S14, E15, S15)"
                    + "VALUES('" + cmb_sdlType.getSelectedItem() + "','" + date.getText() + "',"
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

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Save Shedule Succuss"); 
            Notification noti = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Save Member Succuss");
            noti.showNotification();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void tableload() {
        try {
            String sql = "SELECT * FROM presets";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

//            tbl_pre.setModel(DbUtils.resultSetToTableModel(rs));

            
             DefaultTableModel model = (DefaultTableModel) tbl_Shedule.getModel();
             model.setRowCount(0);
         
           while (rs.next()) {
                String a = rs.getString("ID");
                String b = rs.getString("Type");
                String c = rs.getString("IssueDate");
                
                String aa = rs.getString("E1"); 
                String bb = rs.getString("S1");
                
                String cc = rs.getString("E2");
                String dd = rs.getString("S2");
                
                String ee = rs.getString("E3");
                String ff = rs.getString("S3");
                
                String gg = rs.getString("E4");
                String hh = rs.getString("S4");
                
                String ii = rs.getString("E5");
                String jj = rs.getString("S5");
                
                String kk = rs.getString("E6");
                String ll = rs.getString("S6");
                
                String mm = rs.getString("E7");
                String nn = rs.getString("S7");
                
                String oo = rs.getString("E8");
                String pp = rs.getString("S8");
                
                String qq = rs.getString("E9");
                String rr = rs.getString("S9");
                
                String ss = rs.getString("E10");
                String tt = rs.getString("S10");
                
                String uu = rs.getString("E11");
                String vv = rs.getString("S11");
                        
                String ww = rs.getString("E12");
                String xx = rs.getString("S12");
                
                String yy = rs.getString("E13");
                String zz = rs.getString("S13");
                
                String aaa = rs.getString("E14");
                String bbb = rs.getString("S14");
                
                String ccc = rs.getString("E15");
                String ddd = rs.getString("S15");
                
           model.addRow(new Object[]{a,b,c,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss,tt,uu,vv,ww,xx,yy,zz,aaa,bbb,ccc,ddd});
           }
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
            tbl_Shedule.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(10).setMaxWidth(0);
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
            
    
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void updateTable(){
        try {
            String sql = "UPDATE gym.presets SET Type='" + cmb_sdlType.getSelectedItem() + "',"
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
                    + "WHERE ID='" + lbl_ID.getText() + "'";
            
             PreparedStatement statement = conn.prepareStatement(sql);
                       statement.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clickRaw(){
        try {

            int r = tbl_Shedule.getSelectedRow();
            
            String id = tbl_Shedule.getValueAt(r, 0).toString();
            String t = tbl_Shedule.getValueAt(r, 1).toString();
    
            String E1 = tbl_Shedule.getValueAt(r, 3).toString();
            String S1 = tbl_Shedule.getValueAt(r, 4).toString();

            String E2 = tbl_Shedule.getValueAt(r, 5).toString();
            String S2 = tbl_Shedule.getValueAt(r, 6).toString();

            String E3 = tbl_Shedule.getValueAt(r, 7).toString();
            String S3 = tbl_Shedule.getValueAt(r, 8).toString();

            String E4 = tbl_Shedule.getValueAt(r, 9).toString();
            String S4 = tbl_Shedule.getValueAt(r, 10).toString();

            String E5 = tbl_Shedule.getValueAt(r, 11).toString();
            String S5 = tbl_Shedule.getValueAt(r, 12).toString();

            String E6 = tbl_Shedule.getValueAt(r, 13).toString();
            String S6 = tbl_Shedule.getValueAt(r, 14).toString();

            String E7 = tbl_Shedule.getValueAt(r, 15).toString();
            String S7 = tbl_Shedule.getValueAt(r, 16).toString();

            String E8 = tbl_Shedule.getValueAt(r, 17).toString();
            String S8 = tbl_Shedule.getValueAt(r, 18).toString();

            String E9 = tbl_Shedule.getValueAt(r, 19).toString();
            String S9 = tbl_Shedule.getValueAt(r, 20).toString();

            String E10 = tbl_Shedule.getValueAt(r, 21).toString();
            String S10 = tbl_Shedule.getValueAt(r, 22).toString();

            String E11 = tbl_Shedule.getValueAt(r, 23).toString();
            String S11 = tbl_Shedule.getValueAt(r, 24).toString();

            String E12 = tbl_Shedule.getValueAt(r, 25).toString();
            String S12 = tbl_Shedule.getValueAt(r, 26).toString();

            String E13 = tbl_Shedule.getValueAt(r, 27).toString();
            String S13 = tbl_Shedule.getValueAt(r, 28).toString();

            String E14 = tbl_Shedule.getValueAt(r, 29).toString();
            String S14 = tbl_Shedule.getValueAt(r, 30).toString();

            String E15 = tbl_Shedule.getValueAt(r, 31).toString();
            String S15 = tbl_Shedule.getValueAt(r, 21).toString();
    
            
            lbl_ID.setText(id);

            cmb_sdlType.setSelectedItem(t); 
            
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

    
private void search() {

     String srch = txt_search.getText();

        try {
            String sql = "SELECT * FROM gym.presets WHERE Type LIKE '%" + srch + "%' OR ID LIKE '%" + srch + "%' ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            tbl_Shedule.setModel(DbUtils.resultSetToTableModel(rs));
            
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
            tbl_Shedule.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_Shedule.getColumnModel().getColumn(10).setMaxWidth(0);
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
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     private void btnDelete() {
        int check = JOptionPane.showConfirmDialog(null, "Do YOU WANT TO DELETE");

        if (check == 0) {

            String addno = lbl_ID.getText();

            try {
                String sql = "DELETE FROM gym.presets WHERE ID ='" + addno + "'";
                PreparedStatement st = conn.prepareStatement(sql);
                st.execute();

            Notification noti=new Notification(this ,Notification.Type.SUCCESS,Notification.Location.TOP_CENTER,"Delete Member Succuss");
            noti.showNotification();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Close = new javax.swing.JButton();
        btn_minimize = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
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
        cmb_sdlType = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Shedule = new javax.swing.JTable();
        date = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        lbl_ID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel15.setText("  My Shedules Presets Page");
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
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(260, 260, 260))
        );

        cmb_sdlType.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        cmb_sdlType.setForeground(new java.awt.Color(0, 0, 0));
        cmb_sdlType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fat Burn", "Beginer ", "Beginer Level 1", "Chest Day", "Sholder Day", "Back Day", "Legs Day" }));
        cmb_sdlType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_sdlTypeMouseEntered(evt);
            }
        });

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

        jButton13.setBackground(new java.awt.Color(0, 0, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_eraser_24px.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        tbl_Shedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25", "Title 26", "Title 27", "Title 28", "Title 29", "Title 30", "Title 31", "Title 32", "Title 33"
            }
        ));
        tbl_Shedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Shedule);

        date.setText("jLabel1");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_26px.png"))); // NOI18N

        txt_search.setFont(new java.awt.Font("Square721 BT", 0, 16)); // NOI18N
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        lbl_ID.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(cmb_sdlType, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addGap(46, 46, 46)
                        .addComponent(jButton13)
                        .addGap(87, 87, 87)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_sdlType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton9)
                                .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6))
                            .addComponent(jButton8))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_ID)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel15MousePressed

    private void cmb_sdlTypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_sdlTypeMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_cmb_sdlTypeMouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here
        btnSave();
        tableload();
        TextFieldclear();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         updateTable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        btnDelete();
        TextFieldclear();
        tableload();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        TextFieldclear();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tbl_SheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SheduleMouseClicked
        // TODO add your handling code here:
        clickRaw();
    }//GEN-LAST:event_tbl_SheduleMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        presets a = new presets();
        a.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        search();
       
    }//GEN-LAST:event_txt_searchKeyReleased

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
//            java.util.logging.Logger.getLogger(presets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(presets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(presets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(presets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
        IntelliJTheme.setup(presets.class.getResourceAsStream("/template.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new presets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lbl_ID;
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
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
