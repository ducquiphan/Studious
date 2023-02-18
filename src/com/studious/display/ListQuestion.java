package com.studious.display;

/**
 *
 * @author SsuBii
 */
public class ListQuestion extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public ListQuestion() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Studious - Câu hỏi");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        lblSubject = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        lblGrade = new javax.swing.JLabel();
        cboGrade = new javax.swing.JComboBox<>();
        cboLesson = new javax.swing.JComboBox<>();
        lblLesson = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblScoreStudent = new javax.swing.JTable();
        cboArrange = new javax.swing.JComboBox<>();
        btnDo = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JTextField();
        btnSearch3 = new javax.swing.JButton();
        pnlDoTest = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTitileDoTest = new javax.swing.JLabel();
        lblShowQuestionDoTest = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        rdoChooseAnsA = new javax.swing.JRadioButton();
        rdoChooseAnsB = new javax.swing.JRadioButton();
        rdoChooseAnsD = new javax.swing.JRadioButton();
        btnCheck = new javax.swing.JButton();
        btnRemake = new javax.swing.JButton();
        rdoChooseAnsC = new javax.swing.JRadioButton();
        lblLogo = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnLesson = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));
        pnlBackground.setForeground(new java.awt.Color(232, 255, 183));

        lblTitle.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("CÂU HỎI");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N

        pnlList.setBackground(new java.awt.Color(255, 255, 255));

        lblSubject.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblSubject.setText("Môn:");

        cboSubject.setBackground(new java.awt.Color(233, 233, 233));
        cboSubject.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán", "Vật lý", "Hóa học", "Sinh học" }));
        cboSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectActionPerformed(evt);
            }
        });

        lblGrade.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblGrade.setText("Khối:");

        cboGrade.setBackground(new java.awt.Color(233, 233, 233));
        cboGrade.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));
        cboGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGradeActionPerformed(evt);
            }
        });

        cboLesson.setBackground(new java.awt.Color(233, 233, 233));
        cboLesson.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboLesson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán", "Vật lý", "Hóa học", "Sinh học" }));

        lblLesson.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblLesson.setText("Bài học:");

        tblScoreStudent.setFont(new java.awt.Font("Fira Code Light", 0, 12)); // NOI18N
        tblScoreStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã câu hỏi", "Câu hỏi", "Môn"
            }
        ));
        jScrollPane1.setViewportView(tblScoreStudent);
        if (tblScoreStudent.getColumnModel().getColumnCount() > 0) {
            tblScoreStudent.getColumnModel().getColumn(0).setMinWidth(50);
            tblScoreStudent.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblScoreStudent.getColumnModel().getColumn(0).setMaxWidth(50);
            tblScoreStudent.getColumnModel().getColumn(1).setMinWidth(200);
            tblScoreStudent.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblScoreStudent.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        cboArrange.setBackground(new java.awt.Color(233, 233, 233));
        cboArrange.setFont(new java.awt.Font("Montserrat Thin", 1, 16)); // NOI18N
        cboArrange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp" }));

        btnDo.setBackground(new java.awt.Color(221, 221, 221));
        btnDo.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnDo.setText("Làm");

        btnSearch1.setFont(new java.awt.Font("Readex Pro Medium", 0, 14)); // NOI18N
        btnSearch1.setText("Tìm kiếm");

        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-search-24.png"))); // NOI18N
        btnSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlListLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLesson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListLayout.createSequentialGroup()
                                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboSubject, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboLesson, javax.swing.GroupLayout.Alignment.LEADING, 0, 220, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                                .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDo)))
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubject)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrade)
                    .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLesson)
                                .addComponent(cboLesson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboArrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDo))
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Danh sách", pnlList);

        pnlDoTest.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblTitileDoTest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitileDoTest.setText("Tiêu đề:");
        lblTitileDoTest.setToolTipText("");

        lblShowQuestionDoTest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblShowQuestionDoTest.setText("1+1 = ?");
        lblShowQuestionDoTest.setToolTipText("");

        lblAnswer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnswer.setText("Đáp án:");
        lblAnswer.setToolTipText("");

        lblResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResult.setText("Bạn đã chọn sai. Đáp án đúng là:");
        lblResult.setToolTipText("");

        rdoChooseAnsA.setBackground(new java.awt.Color(255, 255, 255));
        rdoChooseAnsA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsA.setSelected(true);
        rdoChooseAnsA.setText("A. 2");
        rdoChooseAnsA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChooseAnsAActionPerformed(evt);
            }
        });

        rdoChooseAnsB.setBackground(new java.awt.Color(255, 255, 255));
        rdoChooseAnsB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsB.setText("B. 1");

        rdoChooseAnsD.setBackground(new java.awt.Color(255, 255, 255));
        rdoChooseAnsD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsD.setText("D. 9");

        btnCheck.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCheck.setText("Kiểm tra");
        btnCheck.setMaximumSize(new java.awt.Dimension(87, 26));
        btnCheck.setMinimumSize(new java.awt.Dimension(87, 26));

        btnRemake.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnRemake.setText("Làm lại");
        btnRemake.setMaximumSize(new java.awt.Dimension(87, 26));
        btnRemake.setMinimumSize(new java.awt.Dimension(87, 26));

        rdoChooseAnsC.setBackground(new java.awt.Color(255, 255, 255));
        rdoChooseAnsC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsC.setText("C. 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTitileDoTest)
                        .addGap(18, 18, 18)
                        .addComponent(lblShowQuestionDoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdoChooseAnsC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblAnswer)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(rdoChooseAnsA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoChooseAnsB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoChooseAnsD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(470, 470, 470)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitileDoTest)
                    .addComponent(lblShowQuestionDoTest))
                .addGap(18, 18, 18)
                .addComponent(lblAnswer)
                .addGap(18, 18, 18)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoChooseAnsA)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsB)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsC)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsD)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDoTestLayout = new javax.swing.GroupLayout(pnlDoTest);
        pnlDoTest.setLayout(pnlDoTestLayout);
        pnlDoTestLayout.setHorizontalGroup(
            pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
            .addGroup(pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDoTestLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(36, 36, 36)))
        );
        pnlDoTestLayout.setVerticalGroup(
            pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDoTestLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Làm câu hỏi", pnlDoTest);

        lblLogo.setBackground(new java.awt.Color(232, 255, 183));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

        jToolBar.setBackground(new java.awt.Color(232, 255, 183));
        jToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 255, 183)));
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
        btnPersonalInfo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnLesson.setBackground(new java.awt.Color(232, 255, 183));
        btnLesson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLesson.setBorder(null);
        btnLesson.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLesson.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLesson.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLesson);

        btnTest.setBackground(new java.awt.Color(232, 255, 183));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTest.setBorder(null);
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTest.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTest);

        btnScore.setBackground(new java.awt.Color(232, 255, 183));
        btnScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/score.png"))); // NOI18N
        btnScore.setBorder(null);
        btnScore.setFocusable(false);
        btnScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScore.setMaximumSize(new java.awt.Dimension(35, 35));
        btnScore.setPreferredSize(new java.awt.Dimension(35, 35));
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
        btnLogout.setPreferredSize(new java.awt.Dimension(35, 35));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLogout);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(864, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(29, 29, 29)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGradeActionPerformed

    private void cboSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubjectActionPerformed

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch3ActionPerformed

    private void rdoChooseAnsAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChooseAnsAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChooseAnsAActionPerformed

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDo;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLesson;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnRemake;
    private javax.swing.JButton btnScore;
    private javax.swing.JTextField btnSearch1;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnTest;
    private javax.swing.JComboBox<String> cboArrange;
    private javax.swing.JComboBox<String> cboGrade;
    private javax.swing.JComboBox<String> cboLesson;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblLesson;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblShowQuestionDoTest;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTitileDoTest;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlDoTest;
    private javax.swing.JPanel pnlList;
    private javax.swing.JRadioButton rdoChooseAnsA;
    private javax.swing.JRadioButton rdoChooseAnsB;
    private javax.swing.JRadioButton rdoChooseAnsC;
    private javax.swing.JRadioButton rdoChooseAnsD;
    private javax.swing.JTable tblScoreStudent;
    // End of variables declaration//GEN-END:variables
}
