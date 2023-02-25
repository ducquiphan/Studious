/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.studious.display;

import com.studious.dao.AccountDAO;
import com.studious.dao.LessonDAO;
import com.studious.dao.QuestionDAO;
import com.studious.dao.QuestionOfTestDAO;
import com.studious.dao.StudentDAO;
import com.studious.entity.Lesson;
import com.studious.entity.Question;
import com.studious.entity.Student;
import com.studious.utils.Auth;
import com.studious.utils.MsgBox;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuestionsManagement extends javax.swing.JFrame {

    /**
     * Creates new form QuestionsManagement
     */
    
    JFrame window;
    
    public QuestionsManagement() {
        initComponents();
        init();
    }
    
    public QuestionsManagement(JFrame window) {
        initComponents();
        this.window = window;
        init();
    }

    QuestionDAO qdao = new QuestionDAO();
    LessonDAO ldao = new LessonDAO();
    QuestionOfTestDAO qotdao = new QuestionOfTestDAO();
    int row = -1;
    Question quest = null;
    List<Lesson> lList;

    private void init() {
        this.setLocationRelativeTo(null);
        this.fillCboSubjectList();
        this.fillCboSubject();
        tblQuestions.setAutoCreateRowSorter(true);
        //setIconImage(XImage.getAppIcon());
        setResizable(false);
        doTest(false);
        Auth.user = adao.selectById("GV1");
    }

    private void insert() {
        Question qt = getForm();
        if (isValidated()) {
            try {
                qdao.insert(qt);
                this.fillTableQuestions();
                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại");
            }
        }
    }

    private void update() {
        if (isValidated()) {
            try {
                Question qt = getForm();
                qdao.update(qt);
                this.fillTableQuestions();
                this.clearForm();
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    private void delete() {
        Integer questionID = (Integer) tblQuestions.getValueAt(this.row, 1);
        Question question = qdao.selectById(questionID);
        if (question.getTeacherID().equals(Auth.user.getUserID())) {
            if (qotdao.selectByQuestionID(questionID) == null) {
                try {
                    qdao.delete(question.getQuestionID());
                    fillTableQuestions();
                    this.clearForm();
                    MsgBox.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại!");
                }
            } else {
                MsgBox.alert(this, "Xóa thất bại! Câu hỏi này đang được sử dụng cho bài thi!");
            }
        } else {
            MsgBox.alert(this, "Bạn không có quyền xóa!");
        }
    }

    private void fillToForm() {
        int index = (int) tblQuestions.getValueAt(this.row, 1);
        Question question = qdao.selectById(index);
        this.setForm(question);
        btnEdit.setEnabled(true);
        tabs.setSelectedIndex(0);
    }

    private void clearForm() {
        Question qt = new Question();
        this.setForm(qt);
        this.row = -1;
        btnEdit.setEnabled(false);
        btnInsert.setEnabled(true);
    }

    private void setForm(Question qt) {
        cboSubject.setSelectedIndex(cboSubjectList.getSelectedIndex());
        cboGrade.setSelectedIndex(cboGradeList.getSelectedIndex());
        cboLesson.setSelectedIndex(cboLessonList.getSelectedIndex());
        txtTitleQuestion.setText(qt.getQuestion());
        txtAnswer1.setText(qt.getAns1());
        txtAnswer2.setText(qt.getAns2());
        txtAnswer3.setText(qt.getAns3());
        txtAnswer4.setText(qt.getAns4());
        cboRightAns.setSelectedItem(qt.getAns());
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(false);
    }

    private Question getForm() {
        Question qt = new Question();
        qt.setQuestion(txtTitleQuestion.getText());
        qt.setAns1(txtAnswer1.getText());
        qt.setAns2(txtAnswer2.getText());
        qt.setAns3(txtAnswer3.getText());
        qt.setAns4(txtAnswer4.getText());
        qt.setAns((String) cboRightAns.getSelectedItem());
        int indexLesson = cboLesson.getSelectedIndex();
        Lesson lessonEntity = lList.get(indexLesson);
        qt.setLessonID(lessonEntity.getLessonID());
        qt.setTeacherID(Auth.user.getUserID());
        return qt;
    }

    private void edit() {
        if (Auth.user.getUserID().equals(tblQuestions.getValueAt(this.row, 4))) {
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnInsert.setEnabled(false);
        } else {
            MsgBox.alert(this, "Bạn không có quyền được chỉnh sửa tài liệu này!");
        }
    }

    private void first() {
        this.row = 0;
        this.fillToForm();
    }

    private void prev() {
        if (this.row > 0) {
            this.row--;
            this.fillToForm();
        }
    }

    private void next() {
        if (this.row < tblQuestions.getRowCount() - 1) {
            this.row++;
            this.fillToForm();
        }
    }

    private void last() {
        this.row = tblQuestions.getRowCount() - 1;
        this.fillToForm();
    }

    private void fillCboSubjectList() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboSubjectList.getModel();
            model.removeAllElements();
            List<Object> list = ldao.selectSubject();
            if (list != null) {
                for (Object subject : list) {
                    model.addElement(subject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCboGradeList() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboGradeList.getModel();
            model.removeAllElements();
            String subject = (String) cboSubjectList.getSelectedItem();
            List<Object> list = ldao.selectGradeBySubject(subject);
            if (list != null) {
                for (Object grade : list) {
                    model.addElement(grade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCboLessonList() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboLessonList.getModel();
            model.removeAllElements();
            String subject = String.valueOf(cboSubjectList.getSelectedItem());
            Integer grade = (Integer) cboGradeList.getSelectedItem();
            if (subject != null && grade != null) {
                List<Lesson> list = ldao.selectBySubjectAndGrade(subject, grade);
                if (list != null) {
                    for (Lesson lesson : list) {
                        model.addElement(lesson);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCboSubject() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboSubject.getModel();
            model.removeAllElements();
            List<Object> list = ldao.selectSubject();
            if (list != null) {
                for (Object subject : list) {
                    model.addElement(subject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCboGrade() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboGrade.getModel();
            model.removeAllElements();
            String subject = (String) cboSubject.getSelectedItem();
            List<Object> list = ldao.selectGradeBySubject(subject);
            if (list != null) {
                for (Object grade : list) {
                    model.addElement(grade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCboLesson() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboLesson.getModel();
            model.removeAllElements();
            String subject = String.valueOf(cboSubject.getSelectedItem());
            Integer grade = (Integer) cboGrade.getSelectedItem();
            if (subject != null && grade != null) {
                lList = ldao.selectBySubjectAndGrade(subject, grade);
                if (lList != null) {
                    for (Lesson lesson : lList) {
                        model.addElement(lesson);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTableQuestions() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblQuestions.getModel();
            model.setRowCount(0);
            Lesson lesson = (Lesson) cboLessonList.getSelectedItem();
            if (lesson != null) {
                List<Question> list = qdao.selectByLessonID(lesson.getLessonID());
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Question question = list.get(i);
                        model.addRow(new Object[]{i + 1, question.getQuestionID(), question.getQuestion(), question.getAns(), question.getAns1(), question.getAns2(), question.getAns3(), question.getAns4()});
                    }
                }

            }
        } catch (Exception e) {
            MsgBox.alert(this, e.toString());
        }
    }

    private void doTest(boolean check) {
        if (check) {
            grpButtonAns.clearSelection();
            pnlQnA.setVisible(false);
            pnlQuest.setVisible(check);
            Integer questionID = (Integer) tblQuestions.getValueAt(this.row, 1);
            quest = qdao.selectById(questionID);
            lblShowQuestionDoTest.setText(quest.getQuestion());
            lblResult.setVisible(!check);
            rdoChooseAnsA.setText(quest.getAns1());
            rdoChooseAnsB.setText(quest.getAns2());
            rdoChooseAnsC.setText(quest.getAns3());
            rdoChooseAnsD.setText(quest.getAns4());

        } else {
            pnlQnA.setVisible(false);
            pnlQuest.setVisible(check);
        }
    }

    private boolean isValidated() {
        if (txtTitleQuestion.getText().isEmpty()) {
            MsgBox.alert(this, "Tiêu đề không được đề trống!");
            return false;
        }

        if (txtAnswer1.getText().isEmpty()) {
            MsgBox.alert(this, "Đáp án 1 không được đề trống!");
            return false;
        }

        if (txtAnswer2.getText().isEmpty()) {
            MsgBox.alert(this, "Đáp án 2 không được đề trống!");
            return false;
        }

        if (txtAnswer3.getText().isEmpty()) {
            MsgBox.alert(this, "Đáp án 3 không được đề trống!");
            return false;
        }

        if (txtAnswer4.getText().isEmpty()) {
            MsgBox.alert(this, "Đáp án 4 không được đề trống!");
            return false;
        }
        return true;
    }

    AccountDAO adao = new AccountDAO();

    private void send() {
        Auth.user = adao.selectById("HS1");
        String cmt = txtReply.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpButtonAns = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlManage = new javax.swing.JPanel();
        lblSubject = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        lblGrade = new javax.swing.JLabel();
        cboGrade = new javax.swing.JComboBox<>();
        lblLesson = new javax.swing.JLabel();
        cboLesson = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTitleQuestion = new javax.swing.JLabel();
        lblCorrectAns = new javax.swing.JLabel();
        lblAnswer1 = new javax.swing.JLabel();
        lblAnswer2 = new javax.swing.JLabel();
        lblAnswer3 = new javax.swing.JLabel();
        lblAnswer4 = new javax.swing.JLabel();
        txtTitleQuestion = new javax.swing.JTextField();
        txtAnswer1 = new javax.swing.JTextField();
        txtAnswer2 = new javax.swing.JTextField();
        txtAnswer3 = new javax.swing.JTextField();
        txtAnswer4 = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        cboRightAns = new javax.swing.JComboBox<>();
        pnlDoTest = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlQuest = new javax.swing.JPanel();
        lblTitleDoTest = new javax.swing.JLabel();
        lblShowQuestionDoTest = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        rdoChooseAnsA = new javax.swing.JRadioButton();
        rdoChooseAnsB = new javax.swing.JRadioButton();
        rdoChooseAnsD = new javax.swing.JRadioButton();
        rdoChooseAnsC = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnRemake = new javax.swing.JButton();
        pnlQnA = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        txtReply = new javax.swing.JTextField();
        pnlAns1 = new javax.swing.JPanel();
        lblQnAID1 = new javax.swing.JLabel();
        lblAvatar1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblID1 = new javax.swing.JLabel();
        lblComment1 = new javax.swing.JLabel();
        btnReport1 = new javax.swing.JButton();
        btnDeleteComment1 = new javax.swing.JButton();
        pnlList = new javax.swing.JPanel();
        lblSubjectList = new javax.swing.JLabel();
        cboSubjectList = new javax.swing.JComboBox<>();
        lblGradeList = new javax.swing.JLabel();
        cboGradeList = new javax.swing.JComboBox<>();
        btnSearchList = new javax.swing.JButton();
        txtSearchList = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQuestions = new javax.swing.JTable();
        cboArrange = new javax.swing.JComboBox<>();
        lblLessonList = new javax.swing.JLabel();
        cboLessonList = new javax.swing.JComboBox<>();
        btnDo = new javax.swing.JButton();
        jToolBar = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnPersonalInfo = new javax.swing.JButton();
        btnLesson1 = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));

        lblLogo.setBackground(new java.awt.Color(232, 255, 183));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("QUẢN LÝ CÂU HỎI");

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        pnlManage.setBackground(new java.awt.Color(255, 255, 255));

        lblSubject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubject.setText("Môn:");
        lblSubject.setToolTipText("");

        cboSubject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán ", "Vật lí", "Hóa học", "Tiếng anh" }));
        cboSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectActionPerformed(evt);
            }
        });

        lblGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGrade.setText("Khối:");
        lblGrade.setToolTipText("");

        cboGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));
        cboGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGradeActionPerformed(evt);
            }
        });

        lblLesson.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLesson.setText("Bài học:");
        lblLesson.setToolTipText("");

        cboLesson.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLesson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hàm số mũ, Hàm Logarit" }));

        btnNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-reset-24.png"))); // NOI18N
        btnNew.setText("Tạo mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-new-copy-24.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.setMaximumSize(new java.awt.Dimension(87, 26));
        btnInsert.setMinimumSize(new java.awt.Dimension(87, 26));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-pencil-24 (1).png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-available-updates-24.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-bin-24.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblTitleQuestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitleQuestion.setText("Tiêu đề:");
        lblTitleQuestion.setToolTipText("");

        lblCorrectAns.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAns.setText("Đáp án đúng:");
        lblCorrectAns.setToolTipText("");

        lblAnswer1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnswer1.setText("Đáp án 1:");
        lblAnswer1.setToolTipText("");

        lblAnswer2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnswer2.setText("Đáp án 2:");
        lblAnswer2.setToolTipText("");

        lblAnswer3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnswer3.setText("Đáp án 3:");
        lblAnswer3.setToolTipText("");

        lblAnswer4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnswer4.setText("Đáp án 4:");
        lblAnswer4.setToolTipText("");

        txtTitleQuestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitleQuestion.setText("1 + 1 = ?");
        txtTitleQuestion.setToolTipText("");
        txtTitleQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleQuestionActionPerformed(evt);
            }
        });

        txtAnswer1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnswer1.setText("1");
        txtAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer1ActionPerformed(evt);
            }
        });

        txtAnswer2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnswer2.setText("0");
        txtAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer2ActionPerformed(evt);
            }
        });

        txtAnswer3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnswer3.setText("8");
        txtAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer3ActionPerformed(evt);
            }
        });

        txtAnswer4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnswer4.setText("3");
        txtAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer4ActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("<<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        cboRightAns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c", "d" }));

        javax.swing.GroupLayout pnlManageLayout = new javax.swing.GroupLayout(pnlManage);
        pnlManage.setLayout(pnlManageLayout);
        pnlManageLayout.setHorizontalGroup(
            pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(pnlManageLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLesson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitleQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCorrectAns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnswer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnswer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnswer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnswer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManageLayout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageLayout.createSequentialGroup()
                        .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboRightAns, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlManageLayout.createSequentialGroup()
                                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboLesson, 0, 254, Short.MAX_VALUE)
                                    .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 197, Short.MAX_VALUE))
                            .addComponent(txtTitleQuestion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(111, 111, 111))))
        );
        pnlManageLayout.setVerticalGroup(
            pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubject)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrade)
                    .addComponent(cboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLesson)
                    .addComponent(cboLesson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleQuestion)
                    .addComponent(txtTitleQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorrectAns)
                    .addComponent(cboRightAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer1)
                    .addComponent(txtAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer2)
                    .addComponent(txtAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer3)
                    .addComponent(txtAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer4)
                    .addComponent(txtAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        tabs.addTab("Quản lí", pnlManage);

        pnlDoTest.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlQuest.setBackground(new java.awt.Color(255, 255, 255));

        lblTitleDoTest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitleDoTest.setText("Tiêu đề:");
        lblTitleDoTest.setToolTipText("");

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
        grpButtonAns.add(rdoChooseAnsA);
        rdoChooseAnsA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsA.setSelected(true);
        rdoChooseAnsA.setText("A. 2");
        rdoChooseAnsA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChooseAnsAActionPerformed(evt);
            }
        });

        rdoChooseAnsB.setBackground(new java.awt.Color(255, 255, 255));
        grpButtonAns.add(rdoChooseAnsB);
        rdoChooseAnsB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsB.setText("B. 1");

        rdoChooseAnsD.setBackground(new java.awt.Color(255, 255, 255));
        grpButtonAns.add(rdoChooseAnsD);
        rdoChooseAnsD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsD.setText("D. 9");

        rdoChooseAnsC.setBackground(new java.awt.Color(255, 255, 255));
        grpButtonAns.add(rdoChooseAnsC);
        rdoChooseAnsC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsC.setText("C. 0");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCheck.setText("Kiểm tra");
        btnCheck.setMaximumSize(new java.awt.Dimension(87, 26));
        btnCheck.setMinimumSize(new java.awt.Dimension(87, 26));
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnRemake.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemake.setText("Làm lại");
        btnRemake.setMaximumSize(new java.awt.Dimension(87, 26));
        btnRemake.setMinimumSize(new java.awt.Dimension(87, 26));
        btnRemake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlQuestLayout = new javax.swing.GroupLayout(pnlQuest);
        pnlQuest.setLayout(pnlQuestLayout);
        pnlQuestLayout.setHorizontalGroup(
            pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuestLayout.createSequentialGroup()
                        .addComponent(lblTitleDoTest)
                        .addGap(18, 18, 18)
                        .addComponent(lblShowQuestionDoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rdoChooseAnsC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlQuestLayout.createSequentialGroup()
                        .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnswer)
                            .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlQuestLayout.setVerticalGroup(
            pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleDoTest)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlQnA.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-right-arrow-35.png"))); // NOI18N
        btnSend.setBorder(null);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtReply.setText("jTextField1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtReply, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtReply)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAns1.setBackground(new java.awt.Color(255, 255, 255));

        lblQnAID1.setText("QNA1");

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName1.setText("Nguyễn Gia Phúc");

        lblID1.setBackground(new java.awt.Color(255, 255, 255));
        lblID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID1.setForeground(new java.awt.Color(153, 153, 153));
        lblID1.setText("@PS12345");

        lblComment1.setBackground(new java.awt.Color(255, 255, 255));
        lblComment1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblComment1.setForeground(new java.awt.Color(153, 153, 153));
        lblComment1.setText("Đáp án B là sai nhé!");
        lblComment1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReport1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReport1.setText("Báo cáo");
        btnReport1.setBorder(null);

        btnDeleteComment1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteComment1.setText("Xóa");
        btnDeleteComment1.setBorder(null);
        btnDeleteComment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteComment1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAns1Layout = new javax.swing.GroupLayout(pnlAns1);
        pnlAns1.setLayout(pnlAns1Layout);
        pnlAns1Layout.setHorizontalGroup(
            pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAns1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAns1Layout.createSequentialGroup()
                        .addComponent(lblID1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(lblQnAID1))
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComment1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAns1Layout.createSequentialGroup()
                        .addComponent(btnReport1)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteComment1)))
                .addContainerGap())
        );
        pnlAns1Layout.setVerticalGroup(
            pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAns1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAns1Layout.createSequentialGroup()
                        .addComponent(lblName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID1)
                            .addComponent(lblQnAID1)))
                    .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblComment1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAns1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReport1)
                    .addComponent(btnDeleteComment1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlQnALayout = new javax.swing.GroupLayout(pnlQnA);
        pnlQnA.setLayout(pnlQnALayout);
        pnlQnALayout.setHorizontalGroup(
            pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQnALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQnALayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlAns1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlQnALayout.setVerticalGroup(
            pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQnALayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlAns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlQuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlQnA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlQnA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout pnlDoTestLayout = new javax.swing.GroupLayout(pnlDoTest);
        pnlDoTest.setLayout(pnlDoTestLayout);
        pnlDoTestLayout.setHorizontalGroup(
            pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDoTestLayout.setVerticalGroup(
            pnlDoTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Làm câu hỏi", pnlDoTest);

        pnlList.setBackground(new java.awt.Color(255, 255, 255));

        lblSubjectList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubjectList.setText("Môn:");
        lblSubjectList.setToolTipText("");

        cboSubjectList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSubjectList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán" }));
        cboSubjectList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectListActionPerformed(evt);
            }
        });

        lblGradeList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGradeList.setText("Khối:");
        lblGradeList.setToolTipText("");

        cboGradeList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboGradeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));
        cboGradeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGradeListActionPerformed(evt);
            }
        });

        btnSearchList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-search-24.png"))); // NOI18N
        btnSearchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchListActionPerformed(evt);
            }
        });

        txtSearchList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblQuestions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã câu hỏi", "Câu hỏi", "Đáp án đúng", "Đáp án 1", "Đáp án 2", "Đáp án 3", "Đáp án 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuestions.getTableHeader().setReorderingAllowed(false);
        tblQuestions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuestionsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblQuestions);

        cboArrange.setBackground(new java.awt.Color(233, 233, 233));
        cboArrange.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboArrange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê theo môn học" }));

        lblLessonList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLessonList.setText("Bài học:");
        lblLessonList.setToolTipText("");

        cboLessonList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLessonList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hàm Logarit" }));
        cboLessonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLessonListActionPerformed(evt);
            }
        });

        btnDo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-pencil-24 (1).png"))); // NOI18N
        btnDo.setText("Làm");
        btnDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addComponent(cboArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblGradeList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLessonList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSubjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlListLayout.createSequentialGroup()
                                        .addComponent(cboLessonList, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                        .addComponent(btnSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlListLayout.createSequentialGroup()
                                        .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboSubjectList, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboGradeList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubjectList)
                    .addComponent(cboSubjectList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGradeList, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGradeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSearchList, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(btnSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLessonList, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboLessonList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDo)
                .addGap(50, 50, 50)
                .addComponent(cboArrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        tabs.addTab("Danh sách", pnlList);

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

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tabs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtTitleQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleQuestionActionPerformed

    private void txtAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer1ActionPerformed

    private void txtAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer2ActionPerformed

    private void txtAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer3ActionPerformed

    private void txtAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer4ActionPerformed

    private void rdoChooseAnsAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChooseAnsAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChooseAnsAActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        switch (quest.getAns()) {
            case "a" -> {
                if (rdoChooseAnsA.isSelected()) {
                    lblResult.setText("Bạn đã trả lời đúng!");
                    lblResult.setVisible(true);
                } else {
                    lblResult.setText("Bạn đã trả lời sai! Câu trả lời đúng là: " + quest.getAns());
                    lblResult.setVisible(true);
                    lblResult.setForeground(Color.red);
                }
            }
            case "b" -> {
                if (rdoChooseAnsB.isSelected()) {
                    lblResult.setText("Bạn đã trả lời đúng!");
                    lblResult.setVisible(true);
                } else {
                    lblResult.setText("Bạn đã trả lời sai! Câu trả lời đúng là: " + quest.getAns());
                    lblResult.setVisible(true);
                    lblResult.setForeground(Color.red);
                }
            }
            case "c" -> {
                if (rdoChooseAnsD.isSelected()) {
                    lblResult.setText("Bạn đã trả lời đúng!");
                    lblResult.setVisible(true);
                } else {
                    lblResult.setText("Bạn đã trả lời sai! Câu trả lời đúng là: " + quest.getAns());
                    lblResult.setVisible(true);
                    lblResult.setForeground(Color.red);
                }
            }
            case "d" -> {
                if (rdoChooseAnsD.isSelected()) {
                    lblResult.setText("Bạn đã trả lời đúng!");
                    lblResult.setVisible(true);
                } else {
                    lblResult.setText("Bạn đã trả lời sai! Câu trả lời đúng là: " + quest.getAns());
                    lblResult.setVisible(true);
                    lblResult.setForeground(Color.red);
                }
            }
            default ->
                throw new AssertionError();

        }
        btnCheck.setEnabled(false);
        btnRemake.setEnabled(true);
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnRemakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemakeActionPerformed
        // TODO add your handling code here:
        lblResult.setForeground(Color.black);
        lblResult.setVisible(false);
        grpButtonAns.clearSelection();
        btnCheck.setEnabled(true);
        btnRemake.setEnabled(false);
    }//GEN-LAST:event_btnRemakeActionPerformed

    private void btnDeleteComment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteComment1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteComment1ActionPerformed

    private void cboSubjectListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectListActionPerformed
        // TODO add your handling code here:
        fillCboGradeList();
    }//GEN-LAST:event_cboSubjectListActionPerformed

    private void cboGradeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGradeListActionPerformed
        // TODO add your handling code here:
        fillCboLessonList();
    }//GEN-LAST:event_cboGradeListActionPerformed

    private void btnSearchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchListActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) tblQuestions.getModel();
            model.setRowCount(0);
            List<Question> list = qdao.selectByQuestion(txtSearchList.getText());
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Question question = list.get(i);
                    model.addRow(new Object[]{i + 1, question.getQuestionID(), question.getQuestion(), question.getAns(), question.getAns1(), question.getAns2(), question.getAns3(), question.getAns4()});
                }
            }
        } catch (Exception e) {
            e.toString();
        }
    }//GEN-LAST:event_btnSearchListActionPerformed

    private void tblQuestionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuestionsMouseClicked
        // TODO add your handling code here:
        this.row = tblQuestions.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 1) {
            this.row = tblQuestions.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            Question question = qdao.selectById((Integer) tblQuestions.getValueAt(row, 1));
            Lesson lesson = ldao.selectById((Integer) question.getLessonID());
            cboSubjectList.setSelectedItem(lesson.getSubject());
        }
        if (evt.getClickCount() == 2) {
            this.row = tblQuestions.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.row >= 0) {
                //this.edit();
                tabs.setSelectedIndex(0);
                this.fillToForm();
            }
        }
        
    }//GEN-LAST:event_tblQuestionsMouseClicked

    private void cboLessonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLessonListActionPerformed
        // TODO add your handling code here:
        fillTableQuestions();
    }//GEN-LAST:event_cboLessonListActionPerformed

    private void btnDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoActionPerformed
        // TODO add your handling code here:
        if (this.row >= 0) {
            //this.edit();
            tabs.setSelectedIndex(1);
            doTest(true);
            btnRemake.setEnabled(false);

        }
    }//GEN-LAST:event_btnDoActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void cboGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGradeActionPerformed
        // TODO add your handling code here:
        fillCboLesson();
    }//GEN-LAST:event_cboGradeActionPerformed

    private void cboSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectActionPerformed
        // TODO add your handling code here:
        fillCboGrade();
    }//GEN-LAST:event_cboSubjectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        send();
    }//GEN-LAST:event_btnSendActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        // TODO add your handling code here:
        if (tabs.getSelectedIndex() == 0) {
//            if (cboSubjectList.) {
//                cboSubject.setSelectedIndex(cboSubjectList.getSelectedIndex());
//                cboGrade.setSelectedIndex(cboGradeList.getSelectedIndex());
//                cboLesson.setSelectedIndex(cboLessonList.getSelectedIndex());
//                reset();
//            }
//            else{
            cboSubject.setSelectedIndex(cboSubjectList.getSelectedIndex());
            cboGrade.setSelectedIndex(cboGradeList.getSelectedIndex());
            cboLesson.setSelectedIndex(cboLessonList.getSelectedIndex());
//            }
        }
        if (tabs.getSelectedIndex() == 2) {
            cboSubjectList.setSelectedIndex(cboSubject.getSelectedIndex());
            cboGradeList.setSelectedIndex(cboGrade.getSelectedIndex());
            cboLessonList.setSelectedIndex(cboLesson.getSelectedIndex());
        }
    }//GEN-LAST:event_tabsStateChanged

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
            java.util.logging.Logger.getLogger(QuestionsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionsManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteComment1;
    private javax.swing.JButton btnDo;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLesson1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnRemake;
    private javax.swing.JButton btnReport1;
    private javax.swing.JButton btnSearchList;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboArrange;
    private javax.swing.JComboBox<String> cboGrade;
    private javax.swing.JComboBox<String> cboGradeList;
    private javax.swing.JComboBox<String> cboLesson;
    private javax.swing.JComboBox<String> cboLessonList;
    private javax.swing.JComboBox<String> cboRightAns;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JComboBox<String> cboSubjectList;
    private javax.swing.ButtonGroup grpButtonAns;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblAnswer1;
    private javax.swing.JLabel lblAnswer2;
    private javax.swing.JLabel lblAnswer3;
    private javax.swing.JLabel lblAnswer4;
    private javax.swing.JLabel lblAvatar1;
    private javax.swing.JLabel lblComment1;
    private javax.swing.JLabel lblCorrectAns;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblGradeList;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblLesson;
    private javax.swing.JLabel lblLessonList;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblQnAID1;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblShowQuestionDoTest;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblSubjectList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleDoTest;
    private javax.swing.JLabel lblTitleQuestion;
    private javax.swing.JPanel pnlAns1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlDoTest;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlManage;
    private javax.swing.JPanel pnlQnA;
    private javax.swing.JPanel pnlQuest;
    private javax.swing.JRadioButton rdoChooseAnsA;
    private javax.swing.JRadioButton rdoChooseAnsB;
    private javax.swing.JRadioButton rdoChooseAnsC;
    private javax.swing.JRadioButton rdoChooseAnsD;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblQuestions;
    private javax.swing.JTextField txtAnswer1;
    private javax.swing.JTextField txtAnswer2;
    private javax.swing.JTextField txtAnswer3;
    private javax.swing.JTextField txtAnswer4;
    private javax.swing.JTextField txtReply;
    private javax.swing.JTextField txtSearchList;
    private javax.swing.JTextField txtTitleQuestion;
    // End of variables declaration//GEN-END:variables
}
