/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package com.studious.display;

/**
 *
 * @author Admin
 */
public class PersonalInfoTeacher extends java.awt.Dialog {

    /**
     * Creates new form PersonalInfoTeacher
     */
    public PersonalInfoTeacher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlInformation = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAddAvatar = new javax.swing.JButton();
        lblBirthday = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        txtBirthday = new javax.swing.JTextField();
        lblIdentifier = new javax.swing.JLabel();
        txtIdentifier = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        txtID = new javax.swing.JTextField();
        rdoFemale = new javax.swing.JRadioButton();
        lblSpeciality = new javax.swing.JLabel();
        txtSpeciality = new javax.swing.JTextField();
        lblTitle1 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 255, 183));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("THÔNG TIN CÁ NHÂN");

        pnlInformation.setBackground(new java.awt.Color(255, 255, 255));
        pnlInformation.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Họ và tên:");
        lblName.setToolTipText("");

        lblAvatar.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtName.setBackground(new java.awt.Color(204, 204, 204));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAddAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-new-copy-24.png"))); // NOI18N
        btnAddAvatar.setText("Thêm ảnh");

        lblBirthday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBirthday.setText("Ngày sinh:");
        lblBirthday.setToolTipText("");

        btnChangePass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-available-updates-24 (1).png"))); // NOI18N
        btnChangePass.setText("Đổi mật khẩu");

        txtBirthday.setBackground(new java.awt.Color(204, 204, 204));
        txtBirthday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblIdentifier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdentifier.setText("Mã định danh:");
        lblIdentifier.setToolTipText("");

        txtIdentifier.setBackground(new java.awt.Color(204, 204, 204));
        txtIdentifier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGender.setText("Giới tính:");
        lblGender.setToolTipText("");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email:");
        lblEmail.setToolTipText("");

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setText("Mã giáo viên:");
        lblID.setToolTipText("");

        rdoMale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoMale.setText("Nam");

        txtID.setBackground(new java.awt.Color(204, 204, 204));
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rdoFemale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoFemale.setText("Nữ");

        lblSpeciality.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSpeciality.setText("Chuyên môn:");
        lblSpeciality.setToolTipText("");

        txtSpeciality.setBackground(new java.awt.Color(204, 204, 204));
        txtSpeciality.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlInformationLayout = new javax.swing.GroupLayout(pnlInformation);
        pnlInformation.setLayout(pnlInformationLayout);
        pnlInformationLayout.setHorizontalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblName)
                    .addComponent(lblBirthday)
                    .addComponent(lblIdentifier)
                    .addComponent(lblSpeciality)
                    .addComponent(lblEmail)
                    .addComponent(lblGender))
                .addGap(34, 34, 34)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChangePass)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformationLayout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInformationLayout.createSequentialGroup()
                                .addComponent(txtSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInformationLayout.createSequentialGroup()
                                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))))
        );
        pnlInformationLayout.setVerticalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBirthday))
                        .addGap(19, 19, 19)
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdentifier)))
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAvatar)
                    .addComponent(lblSpeciality)
                    .addComponent(txtSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoFemale)
                        .addComponent(rdoMale))
                    .addComponent(lblGender))
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(27, 27, 27)
                .addComponent(btnChangePass)
                .addGap(33, 33, 33))
        );

        lblTitle1.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

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
        btnPersonalInfo.setFocusable(false);
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnTeacher.setBackground(new java.awt.Color(232, 255, 183));
        btnTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnTeacher.setFocusable(false);
        btnTeacher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacher.setMaximumSize(new java.awt.Dimension(46, 44));
        btnTeacher.setMinimumSize(new java.awt.Dimension(46, 44));
        btnTeacher.setPreferredSize(new java.awt.Dimension(46, 44));
        btnTeacher.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });
        jToolBar.add(btnTeacher);

        btnStudent.setBackground(new java.awt.Color(232, 255, 183));
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnStudent.setFocusable(false);
        btnStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStudent.setMaximumSize(new java.awt.Dimension(46, 44));
        btnStudent.setMinimumSize(new java.awt.Dimension(46, 44));
        btnStudent.setPreferredSize(new java.awt.Dimension(46, 44));
        btnStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnStudent);

        btnStatistic.setBackground(new java.awt.Color(232, 255, 183));
        btnStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistic.png"))); // NOI18N
        btnStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatistic.setMaximumSize(new java.awt.Dimension(46, 44));
        btnStatistic.setMinimumSize(new java.awt.Dimension(46, 44));
        btnStatistic.setPreferredSize(new java.awt.Dimension(46, 44));
        btnStatistic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnStatistic);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlInformation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)))
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(726, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(141, Short.MAX_VALUE)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTeacherActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PersonalInfoTeacher dialog = new PersonalInfoTeacher(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAvatar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdentifier;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSpeciality;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdentifier;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSpeciality;
    // End of variables declaration//GEN-END:variables
}
