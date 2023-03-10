package com.studious.display;

/**
 *
 * @author SsuBii
 */
public class FindDocument extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public FindDocument() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Studious - Tìm kiếm tài liệu");
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
        pnlMenuBar = new javax.swing.JPanel();
        lblHomeMenuBar = new javax.swing.JLabel();
        lblLogoutMenuBar = new javax.swing.JLabel();
        lblAccountMenuBar = new javax.swing.JLabel();
        lblLessonMenuBar = new javax.swing.JLabel();
        lblTestMenuBar = new javax.swing.JLabel();
        lblScoreMenuBar = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboSubject1 = new javax.swing.JComboBox<>();
        cboSubject2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        pnlSearch1 = new javax.swing.JPanel();
        lblIconSearch1 = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblScoreStudent = new javax.swing.JTable();
        cboStatisticsBySubject = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));
        pnlBackground.setForeground(new java.awt.Color(232, 255, 183));

        lblTitle.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Studious-255x68.png"))); // NOI18N

        pnlMenuBar.setBackground(new java.awt.Color(232, 255, 183));

        lblHomeMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home-Menubar.png"))); // NOI18N

        lblLogoutMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout-menubar.png"))); // NOI18N

        lblAccountMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/account-Menubar.png"))); // NOI18N

        lblLessonMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/baihoc-menubar.png"))); // NOI18N

        lblTestMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lambaithi-menubar.png"))); // NOI18N

        lblScoreMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xemdiem-menubar.png"))); // NOI18N

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoutMenuBar)
                    .addComponent(lblAccountMenuBar)
                    .addComponent(lblLessonMenuBar)
                    .addComponent(lblHomeMenuBar)
                    .addComponent(lblTestMenuBar)
                    .addComponent(lblScoreMenuBar))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblHomeMenuBar)
                .addGap(18, 18, 18)
                .addComponent(lblAccountMenuBar)
                .addGap(18, 18, 18)
                .addComponent(lblLessonMenuBar)
                .addGap(18, 18, 18)
                .addComponent(lblTestMenuBar)
                .addGap(18, 18, 18)
                .addComponent(lblScoreMenuBar)
                .addGap(18, 18, 18)
                .addComponent(lblLogoutMenuBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle1.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle1.setText("TÌM KIẾM TÀI LIỆU");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel1.setText("Môn:");

        cboSubject.setBackground(new java.awt.Color(233, 233, 233));
        cboSubject.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán", "Vật lý", "Hóa học", "Sinh học" }));
        cboSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel2.setText("Khối:");

        cboSubject1.setBackground(new java.awt.Color(233, 233, 233));
        cboSubject1.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboSubject1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));
        cboSubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubject1ActionPerformed(evt);
            }
        });

        cboSubject2.setBackground(new java.awt.Color(233, 233, 233));
        cboSubject2.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboSubject2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán", "Vật lý", "Hóa học", "Sinh học" }));

        jLabel3.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel3.setText("Bài học:");

        pnlSearch1.setBackground(new java.awt.Color(233, 233, 233));

        lblIconSearch1.setBackground(new java.awt.Color(233, 233, 233));
        lblIconSearch1.setFont(new java.awt.Font("Readex Pro Medium", 0, 14)); // NOI18N
        lblIconSearch1.setForeground(new java.awt.Color(139, 150, 168));
        lblIconSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N

        btnSearch1.setFont(new java.awt.Font("Readex Pro Medium", 0, 14)); // NOI18N
        btnSearch1.setText("Tìm kiếm");

        javax.swing.GroupLayout pnlSearch1Layout = new javax.swing.GroupLayout(pnlSearch1);
        pnlSearch1.setLayout(pnlSearch1Layout);
        pnlSearch1Layout.setHorizontalGroup(
            pnlSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearch1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconSearch1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSearch1Layout.setVerticalGroup(
            pnlSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearch1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconSearch1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblScoreStudent.setFont(new java.awt.Font("Fira Code Light", 0, 12)); // NOI18N
        tblScoreStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã tài liệu", "Tên tài liệu", "Môn học", "Khối", "Người đăng"
            }
        ));
        jScrollPane1.setViewportView(tblScoreStudent);

        cboStatisticsBySubject.setBackground(new java.awt.Color(233, 233, 233));
        cboStatisticsBySubject.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboStatisticsBySubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê theo môn học" }));

        btnView.setBackground(new java.awt.Color(221, 221, 221));
        btnView.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/view2.png"))); // NOI18N
        btnView.setText("Xem");

        btnDelete.setBackground(new java.awt.Color(221, 221, 221));
        btnDelete.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bin.png"))); // NOI18N
        btnDelete.setText("Xóa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboStatisticsBySubject, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboStatisticsBySubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(btnDelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(219, 219, 219)
                        .addComponent(lblTitle1))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblTitle1))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)
                        .addGap(27, 27, 27))))
        );

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubject1ActionPerformed

    private void cboSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubjectActionPerformed

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
            java.util.logging.Logger.getLogger(FindDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FindDocument().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField btnSearch1;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboStatisticsBySubject;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JComboBox<String> cboSubject1;
    private javax.swing.JComboBox<String> cboSubject2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccountMenuBar;
    private javax.swing.JLabel lblHomeMenuBar;
    private javax.swing.JLabel lblIconSearch1;
    private javax.swing.JLabel lblLessonMenuBar;
    private javax.swing.JLabel lblLogoutMenuBar;
    private javax.swing.JLabel lblScoreMenuBar;
    private javax.swing.JLabel lblTestMenuBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlSearch1;
    private javax.swing.JTable tblScoreStudent;
    // End of variables declaration//GEN-END:variables
}
