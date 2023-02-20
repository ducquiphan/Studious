package com.studious.display;

/**
 *
 * @author SsuBii
 */
public class MainWindowStudents extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainWindowStudents() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Studious - Màn hình chính");
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
        btnLessons = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnLessonsTab = new javax.swing.JButton();
        btnTestTab = new javax.swing.JButton();
        btnScoreTab = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));
        pnlBackground.setForeground(new java.awt.Color(232, 255, 183));

        lblTitle.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-350x350.png"))); // NOI18N

        btnLessons.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnLessons.setForeground(new java.awt.Color(8, 115, 6));
        btnLessons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/baihoc.png"))); // NOI18N
        btnLessons.setText("Bài học");
        btnLessons.setToolTipText("");
        btnLessons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLessons.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLessons.setIconTextGap(1);
        btnLessons.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLessonsActionPerformed(evt);
            }
        });

        btnScore.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnScore.setForeground(new java.awt.Color(8, 115, 6));
        btnScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/xemdiem.png"))); // NOI18N
        btnScore.setText("Xem điểm");
        btnScore.setToolTipText("");
        btnScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScore.setIconTextGap(1);
        btnScore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });

        btnTest.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnTest.setForeground(new java.awt.Color(8, 115, 6));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lambaithi.png"))); // NOI18N
        btnTest.setText("Làm bài thi");
        btnTest.setToolTipText("");
        btnTest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest.setIconTextGap(1);
        btnTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 255, 183)));
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

        btnHome.setBackground(new java.awt.Color(232, 255, 183));
        btnHome.setForeground(new java.awt.Color(232, 255, 183));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/home.png"))); // NOI18N
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnHome);

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnLessonsTab.setBackground(new java.awt.Color(232, 255, 183));
        btnLessonsTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLessonsTab.setFocusable(false);
        btnLessonsTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLessonsTab.setMaximumSize(new java.awt.Dimension(46, 44));
        btnLessonsTab.setMinimumSize(new java.awt.Dimension(46, 44));
        btnLessonsTab.setPreferredSize(new java.awt.Dimension(46, 44));
        btnLessonsTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLessonsTab);

        btnTestTab.setBackground(new java.awt.Color(232, 255, 183));
        btnTestTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTestTab.setFocusable(false);
        btnTestTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTestTab.setMaximumSize(new java.awt.Dimension(46, 44));
        btnTestTab.setMinimumSize(new java.awt.Dimension(46, 44));
        btnTestTab.setPreferredSize(new java.awt.Dimension(46, 44));
        btnTestTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTestTab);

        btnScoreTab.setBackground(new java.awt.Color(232, 255, 183));
        btnScoreTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/score.png"))); // NOI18N
        btnScoreTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScoreTab.setMaximumSize(new java.awt.Dimension(46, 44));
        btnScoreTab.setMinimumSize(new java.awt.Dimension(46, 44));
        btnScoreTab.setPreferredSize(new java.awt.Dimension(46, 44));
        btnScoreTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnScoreTab);

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnBack);

        btnLogout.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout.setToolTipText("");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLogout);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(257, 257, 257))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnLessons, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(846, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLessons, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(199, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLessonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLessonsActionPerformed

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnScoreActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindowStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindowStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindowStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindowStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindowStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLessons;
    private javax.swing.JButton btnLessonsTab;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnScore;
    private javax.swing.JButton btnScoreTab;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnTestTab;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
