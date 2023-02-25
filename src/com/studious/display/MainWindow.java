package com.studious.display;

import com.studious.utils.Auth;
import com.studious.utils.MsgBox;
import com.studious.utils.XImage;
import javax.swing.JFrame;

/**
 *
 * @author SsuBii
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    JFrame window;
    
    public MainWindow () {
        initComponents();
        init();
        
    }
    
    public MainWindow (JFrame window) {
        initComponents();
        init();
        this.window = window;
    }

    private void init(){
        setLocationRelativeTo(null);
        setTitle("Studious - Màn hình chính");
        this.setIconImage(XImage.getAppIcon());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnTeacherMain = new javax.swing.JButton();
        btnStatisticMain = new javax.swing.JButton();
        btnStudentMain = new javax.swing.JButton();
        btnQnaMain = new javax.swing.JButton();
        jToolBar = new javax.swing.JToolBar();
        btnPersonalInfo = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnQna = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));
        pnlBackground.setForeground(new java.awt.Color(232, 255, 183));

        lblTitle.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-350x350.png"))); // NOI18N

        btnTeacherMain.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnTeacherMain.setForeground(new java.awt.Color(8, 115, 6));
        btnTeacherMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/teacher 1.png"))); // NOI18N
        btnTeacherMain.setText("Giáo viên");
        btnTeacherMain.setToolTipText("");
        btnTeacherMain.setBorder(null);
        btnTeacherMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacherMain.setIconTextGap(1);
        btnTeacherMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacherMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherMainActionPerformed(evt);
            }
        });

        btnStatisticMain.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnStatisticMain.setForeground(new java.awt.Color(8, 115, 6));
        btnStatisticMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistics 1.png"))); // NOI18N
        btnStatisticMain.setText("Thống kê");
        btnStatisticMain.setToolTipText("");
        btnStatisticMain.setBorder(null);
        btnStatisticMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatisticMain.setIconTextGap(1);
        btnStatisticMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStatisticMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticMainActionPerformed(evt);
            }
        });

        btnStudentMain.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnStudentMain.setForeground(new java.awt.Color(8, 115, 6));
        btnStudentMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Student1.png"))); // NOI18N
        btnStudentMain.setText("Học sinh");
        btnStudentMain.setToolTipText("");
        btnStudentMain.setBorder(null);
        btnStudentMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStudentMain.setIconTextGap(1);
        btnStudentMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStudentMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentMainActionPerformed(evt);
            }
        });

        btnQnaMain.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnQnaMain.setForeground(new java.awt.Color(8, 115, 6));
        btnQnaMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/QnA 1.png"))); // NOI18N
        btnQnaMain.setText("Hỏi đáp");
        btnQnaMain.setToolTipText("");
        btnQnaMain.setBorder(null);
        btnQnaMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQnaMain.setIconTextGap(1);
        btnQnaMain.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQnaMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQnaMainActionPerformed(evt);
            }
        });

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 255, 183)));
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setToolTipText("Thông tin cá nhân");
        btnPersonalInfo.setBorder(null);
        btnPersonalInfo.setFocusable(false);
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setMaximumSize(new java.awt.Dimension(45, 45));
        btnPersonalInfo.setMinimumSize(new java.awt.Dimension(45, 45));
        btnPersonalInfo.setPreferredSize(new java.awt.Dimension(45, 45));
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalInfoActionPerformed(evt);
            }
        });
        jToolBar.add(btnPersonalInfo);

        btnHome.setBackground(new java.awt.Color(232, 255, 183));
        btnHome.setForeground(new java.awt.Color(232, 255, 183));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/home.png"))); // NOI18N
        btnHome.setToolTipText("Màn hình chính");
        btnHome.setBorder(null);
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setMaximumSize(new java.awt.Dimension(45, 45));
        btnHome.setMinimumSize(new java.awt.Dimension(45, 45));
        btnHome.setPreferredSize(new java.awt.Dimension(45, 45));
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jToolBar.add(btnHome);

        btnTeacher.setBackground(new java.awt.Color(232, 255, 183));
        btnTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/teacher.png"))); // NOI18N
        btnTeacher.setToolTipText("Quản lý giáo viên");
        btnTeacher.setBorder(null);
        btnTeacher.setFocusable(false);
        btnTeacher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacher.setMaximumSize(new java.awt.Dimension(45, 45));
        btnTeacher.setMinimumSize(new java.awt.Dimension(45, 45));
        btnTeacher.setPreferredSize(new java.awt.Dimension(45, 45));
        btnTeacher.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTeacherMouseEntered(evt);
            }
        });
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });
        jToolBar.add(btnTeacher);

        btnStudent.setBackground(new java.awt.Color(232, 255, 183));
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/student.png"))); // NOI18N
        btnStudent.setToolTipText("Quản lý học sinh");
        btnStudent.setBorder(null);
        btnStudent.setFocusable(false);
        btnStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStudent.setMaximumSize(new java.awt.Dimension(45, 45));
        btnStudent.setMinimumSize(new java.awt.Dimension(45, 45));
        btnStudent.setPreferredSize(new java.awt.Dimension(45, 45));
        btnStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        jToolBar.add(btnStudent);

        btnStatistic.setBackground(new java.awt.Color(232, 255, 183));
        btnStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistic.png"))); // NOI18N
        btnStatistic.setToolTipText("Thống kê");
        btnStatistic.setBorder(null);
        btnStatistic.setFocusable(false);
        btnStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatistic.setMaximumSize(new java.awt.Dimension(45, 45));
        btnStatistic.setMinimumSize(new java.awt.Dimension(45, 45));
        btnStatistic.setPreferredSize(new java.awt.Dimension(45, 45));
        btnStatistic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticActionPerformed(evt);
            }
        });
        jToolBar.add(btnStatistic);

        btnQna.setBackground(new java.awt.Color(232, 255, 183));
        btnQna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/QnA.png"))); // NOI18N
        btnQna.setBorder(null);
        btnQna.setFocusable(false);
        btnQna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQna.setMaximumSize(new java.awt.Dimension(45, 45));
        btnQna.setMinimumSize(new java.awt.Dimension(45, 45));
        btnQna.setPreferredSize(new java.awt.Dimension(45, 45));
        btnQna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQnaActionPerformed(evt);
            }
        });
        jToolBar.add(btnQna);

        btnLogout.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout.setToolTipText("Đăng xuất");
        btnLogout.setBorder(null);
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMaximumSize(new java.awt.Dimension(45, 45));
        btnLogout.setMinimumSize(new java.awt.Dimension(45, 45));
        btnLogout.setPreferredSize(new java.awt.Dimension(45, 45));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jToolBar.add(btnLogout);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnTeacherMain, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStudentMain, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQnaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStatisticMain, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(257, 257, 257))))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTeacherMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStatisticMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQnaMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTeacherMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherMainActionPerformed
        TeacherManagement window = new TeacherManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnTeacherMainActionPerformed

    private void btnStatisticMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticMainActionPerformed
        StatisticAdmin window = new StatisticAdmin(this);
        this.dispose();
        window.setVisible(true);
    }//GEN-LAST:event_btnStatisticMainActionPerformed

    private void btnStudentMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentMainActionPerformed
        StudentManagement window = new StudentManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnStudentMainActionPerformed

    private void btnQnaMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQnaMainActionPerformed
        MsgBox.alert(this, "Chức năng đang trong quá trình phát triển");
        QuestAndAns window = new QuestAndAns(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnQnaMainActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalInfoActionPerformed
        PersonalInforAdmin window = new PersonalInforAdmin(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnPersonalInfoActionPerformed

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        TeacherManagement window = new TeacherManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        StudentManagement window = new StudentManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticActionPerformed
        StatisticAdmin window = new StatisticAdmin(this);
        this.dispose();
        window.setVisible(true);
    }//GEN-LAST:event_btnStatisticActionPerformed

    private void btnQnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQnaActionPerformed
        MsgBox.alert(this, "Chức năng đang trong quá trình phát triển");
        QuestAndAns window = new QuestAndAns(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnQnaActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Auth.user = null;
        Login window = new Login();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (MsgBox.confirm(this, "Bạn muốn đóng ứng dụng ?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnTeacherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTeacherMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main (String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run () {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnQna;
    private javax.swing.JButton btnQnaMain;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnStatisticMain;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnStudentMain;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JButton btnTeacherMain;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables

}
