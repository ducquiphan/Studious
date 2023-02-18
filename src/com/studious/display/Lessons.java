package com.studious.display;

/**
 *
 * @author SsuBii
 */
public class Lessons extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Lessons() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Studious - Bài học");
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
        btnQuestion = new javax.swing.JButton();
        btnDocument = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnLessons = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));
        pnlBackground.setForeground(new java.awt.Color(232, 255, 183));

        btnQuestion.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnQuestion.setForeground(new java.awt.Color(8, 115, 6));
        btnQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Question.png"))); // NOI18N
        btnQuestion.setText("Câu hỏi");
        btnQuestion.setToolTipText("");
        btnQuestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnQuestion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuestion.setIconTextGap(1);
        btnQuestion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestionActionPerformed(evt);
            }
        });

        btnDocument.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        btnDocument.setForeground(new java.awt.Color(8, 115, 6));
        btnDocument.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lambaithi.png"))); // NOI18N
        btnDocument.setText("Tài liệu");
        btnDocument.setToolTipText("");
        btnDocument.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDocument.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDocument.setIconTextGap(1);
        btnDocument.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentActionPerformed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-350x350.png"))); // NOI18N

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(null);
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
        jToolBar.add(btnHome);

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setBorder(null);
        btnPersonalInfo.setFocusable(false);
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnLessons.setBackground(new java.awt.Color(232, 255, 183));
        btnLessons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLessons.setBorder(null);
        btnLessons.setFocusable(false);
        btnLessons.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLessons.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLessons.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLessons);

        btnTest.setBackground(new java.awt.Color(232, 255, 183));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTest.setBorder(null);
        btnTest.setFocusable(false);
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTest);

        btnScore.setBackground(new java.awt.Color(232, 255, 183));
        btnScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/score.png"))); // NOI18N
        btnScore.setBorder(null);
        btnScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnScore);

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
                .addGap(200, 200, 200)
                .addComponent(btnQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(btnDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(lblTitle)
                .addGap(280, 280, 280))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(864, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblTitle)
                .addGap(42, 42, 42)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(190, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestionActionPerformed

    private void btnDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDocumentActionPerformed

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
            java.util.logging.Logger.getLogger(Lessons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lessons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lessons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lessons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lessons().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDocument;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLessons;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnQuestion;
    private javax.swing.JButton btnScore;
    private javax.swing.JButton btnTest;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
