package com.studious.utils;

import com.toedter.calendar.JDateChooser;
import static java.awt.Color.getHSBColor;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

public class CheckForm {
           
           public static boolean checkTeacherID(JTextField txt) {
                      txt.setBackground(white);
                      String id = txt.getText();
                      String rgx = "[A-Z0-9]{3,6}";
                      if (id.matches(rgx)) {
                                return true;
                      } else {
                                txt.setBackground(getHSBColor(255, 153, 204));
                                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải từ 4 đến 6 kí tự\nchữ hoa và số.");
                                return false;
                     }
           }
           
           public static boolean checkStudentID(JTextField txt) {
                     txt.setBackground(white);
                     String id = txt.getText();
                     String rgx = "[A-Z0-9]{3,6}";
                     if (id.matches(rgx)) {
                                return true;
                     } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải từ 4 đến 6 kí tự\nchữ hoa và số");
                                return false;
                     }
          }
           
            public static boolean checkLessonID(JTextField txt) {
                     txt.setBackground(white);
                     String id = txt.getText();
                     String rgx = "[0-9]{1,3}";
                     if (id.matches(rgx)) {
                                return true;
                     } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải từ 1 đến 3 kí tự số");
                                return false;
                     }
          }
           
           public static boolean isValidDate(String inDate) {
                      if (inDate == null) {
                                System.out.println("flase 1");
                                return false;
                      }
                      
                      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                      System.out.println("Date: "+inDate);
                      if (inDate.trim().length() != dateFormat.toPattern().length()) {
                                System.out.println("flase 2");
                                return false;
                      }

                      dateFormat.setLenient(false);

                      try {
                                dateFormat.parse(inDate.trim());
                      } catch (ParseException pe) {
                                System.out.println("flase 3");
                                return false;
                      }
                      return true;
           }
           
            public static boolean checkDate(JDateChooser txt) {
                     txt.setBackground(white);
                     String id = txt.getDateFormatString();
                     if (isValidDate(id)) {
                                return true;
                     } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), "Ngày không đúng định dạng dd/MM/yyyy");
                                return false;
                     }
           }
            
           public static boolean checkName(JTextField txt) {
                     txt.setBackground(white);
                     String id = txt.getText();
                     String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
                     if (id.matches(rgx)) {
                                return true;
                     } else {
                                txt.setBackground(pink);
                                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
                                return false;
                     }
           }
           
           
           public static boolean checkEmail(JTextField txt) {
                      txt.setBackground(white);
                      String id = txt.getText();
//                      String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
                      String rgx = "^\\w+@\\w+(.\\w+){1,2}";
                      if (id.matches(rgx)) {
                                return true;
                      } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), txt.getText() + " không đúng định dạng");
                                return false;
                      }
           }
           
           public static boolean checkIdentity(JTextField txt) {
                     txt.setBackground(white);
                     String id = txt.getText();
                     String rgx = "[0-9]{12}";
                     if (id.matches(rgx)) {
                                return true;
                     } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), txt.getText()+ " phải đúng 12 số");
                                return false;
                     }
          }
           
           public static boolean checkNullText(JTextField txt) {
                      txt.setBackground(white);
                      if (txt.getText().trim().length() > 0) {
                                return true;
                      } else {
                                txt.setBackground(getHSBColor(299, 21, 96));
                                MsgBox.alert(txt.getRootPane(), "Không được để trống thông tin");
                                return false;
                      }
           }
           
}
