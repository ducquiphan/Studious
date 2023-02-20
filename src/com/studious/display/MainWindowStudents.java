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
        btnLessons1 = new javax.swing.JButton();
        btnTest1 = new javax.swing.JButton();
        btnScore1 = new javax.swing.JButton();
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
        btnLessons.setBorderPainted(false);
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
        btnScore.setBorderPainted(false);
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
        btnTest.setBorderPainted(false);
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
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

        btnHome.setBackground(new java.awt.Color(232, 255, 183));
        btnHome.setForeground(new java.awt.Color(232, 255, 183));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/home.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setMaximumSize(new java.awt.Dimension(35, 35));
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jToolBar.add(btnHome);

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setBorder(null);
        btnPersonalInfo.setFocusable(false);
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnLessons1.setBackground(new java.awt.Color(232, 255, 183));
        btnLessons1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLessons1.setBorder(null);
        btnLessons1.setFocusable(false);
        btnLessons1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLessons1.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLessons1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLessons1);

        btnTest1.setBackground(new java.awt.Color(232, 255, 183));
        btnTest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTest1.setBorder(null);
        btnTest1.setFocusable(false);
        btnTest1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest1.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTest1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTest1);

        btnScore1.setBackground(new java.awt.Color(232, 255, 183));
        btnScore1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/score.png"))); // NOI18N
        btnScore1.setBorder(null);
        btnScore1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScore1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnScore1);

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnBack);

        btnLogout.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout.setToolTipText("");
        btnLogout.setBorder(null);
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLogout);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnLessons, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(279, 279, 279))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(856, Short.MAX_VALUE)))
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
                    .addGap(190, 190, 190)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(191, Short.MAX_VALUE)))
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
        new DoTest(this, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

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
    private javax.swing.JButton btnLessons1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnScore;
    private javax.swing.JButton btnScore1;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnTest1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
