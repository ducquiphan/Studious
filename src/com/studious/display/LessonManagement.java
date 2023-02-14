/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package com.studious.display;

/**
 *
 * @author Admin
 */
public class LessonManagement extends java.awt.Dialog {

    /**
     * Creates new form LesspnManagement
     */
    public LessonManagement(java.awt.Frame parent, boolean modal) {
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
        tabs = new javax.swing.JTabbedPane();
        pnlManage = new javax.swing.JPanel();
        lblLessonID = new javax.swing.JLabel();
        txtLessonID = new javax.swing.JTextField();
        lblSubject = new javax.swing.JLabel();
        lblLessonTitle = new javax.swing.JLabel();
        txtLessonTitle = new javax.swing.JTextField();
        lblGrade = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        cboGrade = new javax.swing.JComboBox<>();
        btnNew1 = new javax.swing.JButton();
        btnInsert1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        pnlList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        btnDeleteRow = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnHome1 = new javax.swing.JButton();
        btnPersonalInfo1 = new javax.swing.JButton();
        btnTeacher1 = new javax.swing.JButton();
        btnStudent1 = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 255, 183));
        setTitle("QUẢN LÝ BÀI HỌC");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("QUẢN LÝ BÀI HỌC");

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabs.setName(""); // NOI18N

        pnlManage.setBackground(new java.awt.Color(255, 255, 255));
        pnlManage.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblLessonID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLessonID.setText("Mã bài học:");
        lblLessonID.setToolTipText("");

        txtLessonID.setBackground(new java.awt.Color(204, 204, 204));
        txtLessonID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSubject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubject.setText("Môn:");
        lblSubject.setToolTipText("");

        lblLessonTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLessonTitle.setText("Tiêu đề bài học:");
        lblLessonTitle.setToolTipText("");

        txtLessonTitle.setBackground(new java.awt.Color(204, 204, 204));
        txtLessonTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGrade.setText("Khối:");
        lblGrade.setToolTipText("");

        cboSubject.setBackground(new java.awt.Color(204, 204, 204));
        cboSubject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán", "Vật Lí", "Hóa Học", "Tiếng Anh" }));

        cboGrade.setBackground(new java.awt.Color(204, 204, 204));
        cboGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        btnNew1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-reset-24.png"))); // NOI18N
        btnNew1.setText("Tạo mới");

        btnInsert1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInsert1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-new-copy-24.png"))); // NOI18N
        btnInsert1.setText("Thêm");
        btnInsert1.setMaximumSize(new java.awt.Dimension(87, 26));
        btnInsert1.setMinimumSize(new java.awt.Dimension(87, 26));

        btnEdit1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-pencil-24 (1).png"))); // NOI18N
        btnEdit1.setText("Sửa");

        btnUpdate1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-available-updates-24.png"))); // NOI18N
        btnUpdate1.setText("Cập nhật");

        btnDelete1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-bin-24.png"))); // NOI18N
        btnDelete1.setText("Xóa");

        javax.swing.GroupLayout pnlManageLayout = new javax.swing.GroupLayout(pnlManage);
        pnlManage.setLayout(pnlManageLayout);
        pnlManageLayout.setHorizontalGroup(
            pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLessonID)
                    .addComponent(lblSubject)
                    .addComponent(lblLessonTitle)
                    .addComponent(lblGrade))
                .addGap(34, 34, 34)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLessonID)
                    .addComponent(txtLessonTitle)
                    .addGroup(pnlManageLayout.createSequentialGroup()
                        .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addGap(216, 216, 216))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNew1)
                .addGap(18, 18, 18)
                .addComponent(btnInsert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate1)
                .addGap(18, 18, 18)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlManageLayout.setVerticalGroup(
            pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLessonID)
                    .addComponent(txtLessonID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubject)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLessonTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLessonTitle))
                .addGap(22, 22, 22)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrade)
                    .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew1)
                    .addComponent(btnInsert1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit1)
                    .addComponent(btnUpdate1)
                    .addComponent(btnDelete1))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        tabs.addTab("Quản lí", pnlManage);

        pnlList.setBackground(new java.awt.Color(255, 255, 255));
        pnlList.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã bài học", "Tên bài học", "Ngày tạo", "Người tạo"
            }
        ));
        jScrollPane1.setViewportView(tblGridView);

        btnDeleteRow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-bin-24.png"))); // NOI18N
        btnDeleteRow.setText("Xóa");

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteRow)
                .addGap(86, 86, 86))
        );

        tabs.addTab("Danh sách", pnlList);

        lblTitle1.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 255, 183)));
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

        btnHome1.setBackground(new java.awt.Color(232, 255, 183));
        btnHome1.setForeground(new java.awt.Color(232, 255, 183));
        btnHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/home.png"))); // NOI18N
        btnHome1.setFocusable(false);
        btnHome1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnHome1);

        btnPersonalInfo1.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo1.setFocusable(false);
        btnPersonalInfo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo1);

        btnTeacher1.setBackground(new java.awt.Color(232, 255, 183));
        btnTeacher1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnTeacher1.setFocusable(false);
        btnTeacher1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacher1.setMaximumSize(new java.awt.Dimension(46, 44));
        btnTeacher1.setMinimumSize(new java.awt.Dimension(46, 44));
        btnTeacher1.setPreferredSize(new java.awt.Dimension(46, 44));
        btnTeacher1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTeacher1);

        btnStudent1.setBackground(new java.awt.Color(232, 255, 183));
        btnStudent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnStudent1.setFocusable(false);
        btnStudent1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStudent1.setMaximumSize(new java.awt.Dimension(46, 44));
        btnStudent1.setMinimumSize(new java.awt.Dimension(46, 44));
        btnStudent1.setPreferredSize(new java.awt.Dimension(46, 44));
        btnStudent1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnStudent1);

        btnStatistic.setBackground(new java.awt.Color(232, 255, 183));
        btnStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistic.png"))); // NOI18N
        btnStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatistic.setMaximumSize(new java.awt.Dimension(46, 44));
        btnStatistic.setMinimumSize(new java.awt.Dimension(46, 44));
        btnStatistic.setPreferredSize(new java.awt.Dimension(46, 44));
        btnStatistic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnStatistic);

        btnBack1.setBackground(new java.awt.Color(232, 255, 183));
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnBack1);

        btnLogout1.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout1.setToolTipText("");
        btnLogout1.setFocusable(false);
        btnLogout1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLogout1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle))
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LessonManagement dialog = new LessonManagement(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnHome1;
    private javax.swing.JButton btnInsert1;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnPersonalInfo1;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnStudent1;
    private javax.swing.JButton btnTeacher1;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cboGrade;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblLessonID;
    private javax.swing.JLabel lblLessonTitle;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlManage;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtLessonID;
    private javax.swing.JTextField txtLessonTitle;
    // End of variables declaration//GEN-END:variables
}
