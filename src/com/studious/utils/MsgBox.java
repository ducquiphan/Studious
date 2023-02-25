package com.studious.utils;

import java.awt.Component;
import javax.swing.JOptionPane;


/**
 *
 * @author Nguyễn Văn Sĩ
 */

public class MsgBox {
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Studious", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Studious", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Studious", JOptionPane.INFORMATION_MESSAGE);
    }
    
//    public static void balloonTip(Component parent, String message){
//        BalloonTip tip = new BalloonTip();
//    }
}
