package com.studious.display;

import com.studious.DAO.ReportDAO;
import com.studious.utils.Auth;
import com.studious.utils.MsgBox;
import com.studious.utils.XImage;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phan Qui Duc
 */
public class StatisticAdmin extends javax.swing.JFrame {

    /**
     * Creates new form StatisticAdmin
     */
    
    JFrame window;
    public StatisticAdmin() {
        initComponents();
        init();
    }

    public StatisticAdmin(JFrame window) {
        this.window = window;
        initComponents();
        init();
    }

    ReportDAO rdao = new ReportDAO();

    private void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        fillToTotalScoreTable("");
        fillToDocumentTable("", "");
        fillToQuestionTable("", "");
        fillToAverageScoreTable("");
        tblAverageScore.setAutoCreateRowSorter(true);
        tblDocument.setAutoCreateRowSorter(true);
        tblQuestions.setAutoCreateRowSorter(true);
        tblSumScore.setAutoCreateRowSorter(true);
        setTitle("Studious - Thống kê");
    }

    private void fillToTotalScoreTable(String nameTest) {
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

    private void fillToAverageScoreTable(String nameTest) {
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

    private void fillToDocumentTable(String teacherName, String subject) {
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

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
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

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
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

    private void fillToQuestionTable(String teacherName, String subject) {
        try {
            if (cboForAll.getSelectedIndex() == 0) {
                tblQuestions.setModel(new javax.swing.table.DefaultTableModel(
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

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblQuestions.getModel();
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
                tblQuestions.setModel(new javax.swing.table.DefaultTableModel(
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

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tblQuestions.getModel();
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
        lblTitle1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        cboForAll = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        tab = new javax.swing.JTabbedPane();
        pnlQuestion2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQuestions = new javax.swing.JTable();
        pnlDocument = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDocument = new javax.swing.JTable();
        pnlAverageScore = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAverageScore = new javax.swing.JTable();
        pnlSumScore = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSumScore = new javax.swing.JTable();
        jToolBar = new javax.swing.JToolBar();
        btnPersonalInfo = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnQna = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(232, 255, 183));

        lblTitle1.setBackground(new java.awt.Color(232, 255, 183));
        lblTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

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

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-search-24.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pnlQuestion2.setToolTipText("");
        pnlQuestion2.setName(""); // NOI18N

        tblQuestions.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblQuestions);

        javax.swing.GroupLayout pnlQuestion2Layout = new javax.swing.GroupLayout(pnlQuestion2);
        pnlQuestion2.setLayout(pnlQuestion2Layout);
        pnlQuestion2Layout.setHorizontalGroup(
            pnlQuestion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuestion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlQuestion2Layout.setVerticalGroup(
            pnlQuestion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Câu hỏi", pnlQuestion2);

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
        jScrollPane6.setViewportView(tblDocument);

        javax.swing.GroupLayout pnlDocumentLayout = new javax.swing.GroupLayout(pnlDocument);
        pnlDocument.setLayout(pnlDocumentLayout);
        pnlDocumentLayout.setHorizontalGroup(
            pnlDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocumentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDocumentLayout.setVerticalGroup(
            pnlDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocumentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab.addTab("Tài liệu", pnlDocument);

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
        jScrollPane7.setViewportView(tblAverageScore);

        javax.swing.GroupLayout pnlAverageScoreLayout = new javax.swing.GroupLayout(pnlAverageScore);
        pnlAverageScore.setLayout(pnlAverageScoreLayout);
        pnlAverageScoreLayout.setHorizontalGroup(
            pnlAverageScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAverageScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAverageScoreLayout.setVerticalGroup(
            pnlAverageScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAverageScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab.addTab("Điểm trung bình", pnlAverageScore);

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
        jScrollPane8.setViewportView(tblSumScore);

        javax.swing.GroupLayout pnlSumScoreLayout = new javax.swing.GroupLayout(pnlSumScore);
        pnlSumScore.setLayout(pnlSumScoreLayout);
        pnlSumScoreLayout.setHorizontalGroup(
            pnlSumScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSumScoreLayout.setVerticalGroup(
            pnlSumScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        tab.addTab("Điểm tổng", pnlSumScore);

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 255, 183)));
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

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

        btnTeacher.setBackground(new java.awt.Color(232, 255, 183));
        btnTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/teacher.png"))); // NOI18N
        btnTeacher.setToolTipText("Quản lý giáo viên");
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

        btnQna.setBackground(new java.awt.Color(232, 255, 183));
        btnQna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/QnA.png"))); // NOI18N
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

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack.setToolTipText("Quay lại");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTitle1)
                            .addGap(579, 579, 579)
                            .addComponent(lblTitle))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(cboForAll, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalInfoActionPerformed
        PersonalInforAdmin window = new PersonalInforAdmin(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnPersonalInfoActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MainWindow window = new MainWindow();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnTeacherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTeacherMouseEntered

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        TeacherManagement window = new TeacherManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        StudentManagement window = new StudentManagement(this, true);
        window.setVisible(true);
    }//GEN-LAST:event_btnStudentActionPerformed

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
        // TODO add your handling code here:
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(StatisticAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnQna;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JComboBox<String> cboForAll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlAverageScore;
    private javax.swing.JPanel pnlDocument;
    private javax.swing.JPanel pnlQuestion2;
    private javax.swing.JPanel pnlSumScore;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tblAverageScore;
    private javax.swing.JTable tblDocument;
    private javax.swing.JTable tblQuestions;
    private javax.swing.JTable tblSumScore;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
