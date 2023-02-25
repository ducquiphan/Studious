/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.studious.display;

import com.studious.DAO.ReportDAO;
import com.studious.dao.AccountDAO;
import com.studious.utils.Auth;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phan Qui Duc
 */
public class StatisticTeacher extends javax.swing.JFrame {

    /**
     * Creates new form StatisticTeacher
     */
    JFrame window;

    public StatisticTeacher () {
        initComponents();
        init();
    }

    public StatisticTeacher (JFrame window) {
        initComponents();
        this.window = window;
        init();
    }

    ReportDAO rdao = new ReportDAO();

    private void init () {
        setLocationRelativeTo(null);
        fillToTotalScoreTable("");
        fillToDocumentTable("", "");
        fillToQuestionTable("", "");
        fillToAverageScoreTable("");
        tblAverageScore.setAutoCreateRowSorter(true);
        tblDocument.setAutoCreateRowSorter(true);
        tblQuestions3.setAutoCreateRowSorter(true);
        tblSumScore.setAutoCreateRowSorter(true);
    }

    private void fillToTotalScoreTable (String nameTest) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblSumScore.getModel();
            model.setRowCount(0);
            if (nameTest.equals("")) {
                nameTest = null;
            }
            List<Object[]> list = rdao.getMarkAllStudent(nameTest);
            for (Object[] row : list) {
                model.addRow(new Object[]{row[0], row[1], row[2], row[3], row[4], row[5], row[6]});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillToAverageScoreTable (String nameTest) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblAverageScore.getModel();
            model.setRowCount(0);
            if (nameTest.equals("")) {
                nameTest = null;
            }
            List<Object[]> list = rdao.getMarkAVG(nameTest);
            for (Object[] row : list) {
                model.addRow(new Object[]{row[0], row[1], row[2], row[3]});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillToDocumentTable (String teacherName, String subject) {
        try {
            if (cboForAll.getSelectedIndex() == 0) {
                tblDocument.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null}
                        },
                        new String[]{
                            "STT", "Tên Giáo Viên", "Số Lượng Tài Liệu"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false
                    };

                    public boolean isCellEditable (int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblDocument.getModel();
                model.setRowCount(0);
                if (teacherName.equals("")) {
                    teacherName = null;
                }
                List<Object[]> list = rdao.getDocumentTeacher(teacherName);
                for (Object[] row : list) {
                    model.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }
            if (cboForAll.getSelectedIndex() == 1) {
                tblDocument.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null}
                        },
                        new String[]{
                            "STT", "Tên Môn Học", "Số Lượng Tài Liệu"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false
                    };

                    public boolean isCellEditable (int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblDocument.getModel();
                model.setRowCount(0);
                if (subject.equals("")) {
                    subject = null;
                }
                List<Object[]> list = rdao.getDocumentSubject(subject);
                for (Object[] row : list) {
                    model.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillToQuestionTable (String teacherName, String subject) {
        try {
            if (cboForAll.getSelectedIndex() == 0) {
                tblQuestions3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null}
                        },
                        new String[]{
                            "STT", "Tên Giáo Viên", "Số Lượng Câu Hỏi"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false
                    };

                    public boolean isCellEditable (int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblQuestions3.getModel();
                model.setRowCount(0);
                if (teacherName.equals("")) {
                    teacherName = null;
                }
                List<Object[]> list = rdao.getQuestionOfTeacher(teacherName);
                for (Object[] row : list) {
                    model.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }
            if (cboForAll.getSelectedIndex() == 1) {
                tblQuestions3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null}
                        },
                        new String[]{
                            "STT", "Tên Môn Học", "Số Lượng Câu Hỏi"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false
                    };

                    public boolean isCellEditable (int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblQuestions3.getModel();
                model.setRowCount(0);
                if (subject.equals("")) {
                    subject = null;
                }
                List<Object[]> list = rdao.getQuestionOfSubject(subject);
                for (Object[] row : list) {
                    model.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        cboForAll = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        lblTitle1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnLesson1 = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        javax.swing.JTabbedPane tab4 = new javax.swing.JTabbedPane();
        pnlQuestion6 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblQuestions3 = new javax.swing.JTable();
        pnlDocument2 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblDocument = new javax.swing.JTable();
        pnlAverageScore2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblAverageScore = new javax.swing.JTable();
        pnlSumScore2 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSumScore = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 255, 183));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("THỐNG KÊ ");

        cboForAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboForAll.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Môn học" }));
        cboForAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboForAllActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTitle1.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-search-24.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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
        btnHome.setToolTipText("Màn hình chính");
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

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setToolTipText("Thông tin cá nhân");
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

        btnLesson1.setBackground(new java.awt.Color(232, 255, 183));
        btnLesson1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLesson1.setToolTipText("Bài học");
        btnLesson1.setFocusable(false);
        btnLesson1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLesson1.setMaximumSize(new java.awt.Dimension(45, 45));
        btnLesson1.setMinimumSize(new java.awt.Dimension(45, 45));
        btnLesson1.setPreferredSize(new java.awt.Dimension(45, 45));
        btnLesson1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLesson1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLesson1ActionPerformed(evt);
            }
        });
        jToolBar.add(btnLesson1);

        btnTest.setBackground(new java.awt.Color(232, 255, 183));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTest.setToolTipText("Thi thử");
        btnTest.setFocusable(false);
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest.setMaximumSize(new java.awt.Dimension(45, 45));
        btnTest.setMinimumSize(new java.awt.Dimension(45, 45));
        btnTest.setPreferredSize(new java.awt.Dimension(45, 45));
        btnTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        jToolBar.add(btnTest);

        btnStatistic.setBackground(new java.awt.Color(232, 255, 183));
        btnStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistic.png"))); // NOI18N
        btnStatistic.setToolTipText("Thống kê");
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

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack.setFocusable(false);
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setMaximumSize(new java.awt.Dimension(45, 45));
        btnBack.setMinimumSize(new java.awt.Dimension(45, 45));
        btnBack.setPreferredSize(new java.awt.Dimension(45, 45));
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jToolBar.add(btnBack);

        btnLogout.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout.setToolTipText("Đăng xuất");
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

        tab4.setToolTipText("");
        tab4.setName(""); // NOI18N
        tab4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tab4tab2sStateChanged(evt);
            }
        });

        pnlQuestion6.setToolTipText("");
        pnlQuestion6.setName(""); // NOI18N

        tblQuestions3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Môn Học", "Số Lượng Câu Hỏi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tblQuestions3);

        javax.swing.GroupLayout pnlQuestion6Layout = new javax.swing.GroupLayout(pnlQuestion6);
        pnlQuestion6.setLayout(pnlQuestion6Layout);
        pnlQuestion6Layout.setHorizontalGroup(
            pnlQuestion6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuestion6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlQuestion6Layout.setVerticalGroup(
            pnlQuestion6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestion6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tab4.addTab("Câu hỏi", pnlQuestion6);

        tblDocument.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Môn Học", "Số Lượng Tài Liệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(tblDocument);

        javax.swing.GroupLayout pnlDocument2Layout = new javax.swing.GroupLayout(pnlDocument2);
        pnlDocument2.setLayout(pnlDocument2Layout);
        pnlDocument2Layout.setHorizontalGroup(
            pnlDocument2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocument2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDocument2Layout.setVerticalGroup(
            pnlDocument2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocument2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab4.addTab("Tài liệu", pnlDocument2);

        tblAverageScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã bài thi", "Điểm trung bình tổng", "Số lượt thi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(tblAverageScore);

        javax.swing.GroupLayout pnlAverageScore2Layout = new javax.swing.GroupLayout(pnlAverageScore2);
        pnlAverageScore2.setLayout(pnlAverageScore2Layout);
        pnlAverageScore2Layout.setHorizontalGroup(
            pnlAverageScore2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAverageScore2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAverageScore2Layout.setVerticalGroup(
            pnlAverageScore2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAverageScore2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab4.addTab("Điểm trung bình", pnlAverageScore2);

        tblSumScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HS", "Họ Tên", "Khối", "Mã Bài Thi", "Bài Thi", "Điểm", "Ngày Làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane18.setViewportView(tblSumScore);

        javax.swing.GroupLayout pnlSumScore2Layout = new javax.swing.GroupLayout(pnlSumScore2);
        pnlSumScore2.setLayout(pnlSumScore2Layout);
        pnlSumScore2Layout.setHorizontalGroup(
            pnlSumScore2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumScore2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSumScore2Layout.setVerticalGroup(
            pnlSumScore2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumScore2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab4.addTab("Điểm tổng", pnlSumScore2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitle1)
                                .addGap(579, 579, 579)
                                .addComponent(lblTitle))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboForAll, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboForAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (tab.getSelectedIndex() == 3) {
            fillToTotalScoreTable(txtSearch.getText());
        }
        if (tab.getSelectedIndex() == 2) {
            fillToAverageScoreTable(txtSearch.getText());
        }
        if (tab.getSelectedIndex() == 1) {
            fillToDocumentTable(txtSearch.getText(), txtSearch.getText());
        }
        if (tab.getSelectedIndex() == 0) {
            fillToQuestionTable(txtSearch.getText(), txtSearch.getText());
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void cboForAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboForAllActionPerformed
        // TODO add your handling code here:
        if (tab.getSelectedIndex() == 1) {
            txtSearch.setText("");
            fillToDocumentTable("", "");
        }
        if (tab.getSelectedIndex() == 0) {
            txtSearch.setText("");
            fillToQuestionTable("", "");
        }
    }//GEN-LAST:event_cboForAllActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Login.main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalInfoActionPerformed
        PersonalInfoTeacher window = new PersonalInfoTeacher(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnPersonalInfoActionPerformed

    private void btnLesson1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLesson1ActionPerformed
        LessonsTeacher window = new LessonsTeacher(this);
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLesson1ActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        TestManagement window = new TestManagement(this);
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticActionPerformed
        StatisticTeacher window = new StatisticTeacher(this);
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStatisticActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Auth.user = null;
        Login window = new Login();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tab4tab2sStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tab4tab2sStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tab4tab2sStateChanged

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
            java.util.logging.Logger.getLogger(StatisticTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run () {
                new StatisticTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLesson1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnTest;
    private javax.swing.JComboBox<String> cboForAll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlAverageScore2;
    private javax.swing.JPanel pnlDocument2;
    private javax.swing.JPanel pnlQuestion2;
    private javax.swing.JPanel pnlQuestion3;
    private javax.swing.JPanel pnlQuestion6;
    private javax.swing.JPanel pnlSumScore2;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTabbedPane tab1;
    private javax.swing.JTable tblAverageScore;
    private javax.swing.JTable tblDocument;
    private javax.swing.JTable tblQuestions;
    private javax.swing.JTable tblQuestions1;
    private javax.swing.JTable tblQuestions3;
    private javax.swing.JTable tblSumScore;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
