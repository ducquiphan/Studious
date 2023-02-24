
package com.studious.display;
import com.studious.dao.LessonDAO;
import com.studious.dao.QuestionDAO;
import com.studious.dao.QuestionOfTestDAO;
import com.studious.entity.Lesson;
import com.studious.entity.Question;
import com.studious.utils.Auth;
import com.studious.utils.MsgBox;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class QuestionsManagement extends javax.swing.JFrame {

    /**
     * Creates new form QuestionsManagement
     */
    public QuestionsManagement() {
        initComponents();
        init();
    }

    QuestionDAO qdao = new QuestionDAO();
    LessonDAO ldao = new LessonDAO();
    QuestionOfTestDAO qotdao = new QuestionOfTestDAO();
    int row = -1;
    Question quest = null;
    List<Lesson> lList;

    private void init() {
        this.setLocationRelativeTo(this);
        this.fillCboSubjectList();
        this.fillCboSubject();
        //setIconImage(XImage.getAppIcon());
        setResizable(false);
        doTest(false);
//        rdoChooseAnsA.setName("a");
//        rdoChooseAnsB.setName("b");
//        rdoChooseAnsC.setName("c");
//        rdoChooseAnsD.setName("d");
    }

    
    private void insert() {
        if (isValidated()) {
            Question qt = getForm();
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
                int questionID = (int) tblQuestions.getValueAt(this.row, 1);
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
                qt.setQuestionID(questionID);
                qdao.update(qt);
                this.fillTableQuestions();
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    private void delete() {
        Integer questionID = (Integer) tblQuestions.getValueAt(this.row, 1);
        Question qList = qdao.selectById(questionID);
        if (qList.getTeacherID().equals(Auth.user.getUserID())) {
            if (qotdao.selectByQuestionID(questionID) == null) {
                try {
                    Question qt = qdao.selectById(questionID);
                    qdao.delete(qt.getQuestionID());
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

    private void clearForm() {
        Question qt = new Question();
        this.setForm(qt);
        this.row = -1;
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
        int index = (int) tblQuestions.getValueAt(this.row, 1);
        Question qt = qdao.selectById(index);
        this.setForm(qt);
        tabs.setSelectedIndex(0);
    }

    private void first() {
        this.row = 0;
        this.edit();
    }

    private void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    private void next() {
        if (this.row < tblQuestions.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    private void last() {
        this.row = tblQuestions.getRowCount() - 1;
        this.edit();
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
            pnlQnA.setVisible(check);
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
            pnlQnA.setVisible(check);
            pnlQuest.setVisible(check);
        }
    }
    
    private boolean isValidated(){
        if(txtTitleQuestion.getText().isEmpty()){
            MsgBox.alert(this, "Tiêu đề không được đề trống!");
            return false;
        }
        
        if(txtAnswer1.getText().isEmpty()){
            MsgBox.alert(this, "Đáp án 1 không được đề trống!");
            return false;
        }
        
        if(txtAnswer2.getText().isEmpty()){
            MsgBox.alert(this, "Đáp án 2 không được đề trống!");
            return false;
        }
        
        if(txtAnswer3.getText().isEmpty()){
            MsgBox.alert(this, "Đáp án 3 không được đề trống!");
            return false;
        }
        
        if(txtAnswer4.getText().isEmpty()){
            MsgBox.alert(this, "Đáp án 4 không được đề trống!");
            return false;
        }
        return true;
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
        btnCheck = new javax.swing.JButton();
        btnRemake = new javax.swing.JButton();
        rdoChooseAnsC = new javax.swing.JRadioButton();
        pnlQnA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblComment = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        btnDeleteComment = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblReply = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
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
        btnLesson = new javax.swing.JButton();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
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

        rdoChooseAnsC.setBackground(new java.awt.Color(255, 255, 255));
        rdoChooseAnsC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChooseAnsC.setText("C. 0");

        javax.swing.GroupLayout pnlQuestLayout = new javax.swing.GroupLayout(pnlQuest);
        pnlQuest.setLayout(pnlQuestLayout);
        pnlQuestLayout.setHorizontalGroup(
            pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuestLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(pnlQuestLayout.createSequentialGroup()
                        .addComponent(lblTitleDoTest)
                        .addGap(18, 18, 18)
                        .addComponent(lblShowQuestionDoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rdoChooseAnsC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoChooseAnsD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlQuestLayout.createSequentialGroup()
                        .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAnswer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(25, 25, 25)
                .addGroup(pnlQuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlQnA.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("Nguyễn Gia Phúc");

        lblID.setBackground(new java.awt.Color(255, 255, 255));
        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(153, 153, 153));
        lblID.setText("@PS12345");

        lblComment.setBackground(new java.awt.Color(255, 255, 255));
        lblComment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblComment.setForeground(new java.awt.Color(153, 153, 153));
        lblComment.setText("Đáp án B là sai nhé!");
        lblComment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReport.setText("Báo cáo");
        btnReport.setBorder(null);

        btnDeleteComment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteComment.setText("Xóa");
        btnDeleteComment.setBorder(null);
        btnDeleteComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCommentActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReply.setBackground(new java.awt.Color(255, 255, 255));
        lblReply.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblReply.setForeground(new java.awt.Color(153, 153, 153));
        lblReply.setText("TRẢ LỜI");

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/icons8-right-arrow-35.png"))); // NOI18N
        btnSend.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReply, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblReply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlQnALayout = new javax.swing.GroupLayout(pnlQnA);
        pnlQnA.setLayout(pnlQnALayout);
        pnlQnALayout.setHorizontalGroup(
            pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQnALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlQnALayout.createSequentialGroup()
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlQnALayout.createSequentialGroup()
                                .addComponent(btnReport)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteComment))))
                    .addComponent(jLabel1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlQnALayout.setVerticalGroup(
            pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQnALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlQnALayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID))
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQnALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReport)
                    .addComponent(btnDeleteComment))
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã câu hỏi", "Câu hỏi", "Đáp án đúng", "Đáp án 1", "Đáp án 2", "Đáp án 3", "Đáp án 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnHome.setBackground(new java.awt.Color(232, 255, 183));
        btnHome.setForeground(new java.awt.Color(232, 255, 183));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/home.png"))); // NOI18N
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setMaximumSize(new java.awt.Dimension(35, 35));
        btnHome.setPreferredSize(new java.awt.Dimension(40, 40));
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnHome);

        btnPersonalInfo.setBackground(new java.awt.Color(232, 255, 183));
        btnPersonalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/account.png"))); // NOI18N
        btnPersonalInfo.setFocusable(false);
        btnPersonalInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonalInfo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPersonalInfo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnPersonalInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnPersonalInfo);

        btnLesson.setBackground(new java.awt.Color(232, 255, 183));
        btnLesson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/lessons.png"))); // NOI18N
        btnLesson.setFocusable(false);
        btnLesson.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLesson.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLesson.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLesson.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLesson);

        btnTest.setBackground(new java.awt.Color(232, 255, 183));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/mockExam.png"))); // NOI18N
        btnTest.setFocusable(false);
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTest.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTest.setPreferredSize(new java.awt.Dimension(40, 40));
        btnTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnTest);

        btnStatistic.setBackground(new java.awt.Color(232, 255, 183));
        btnStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/statistic.png"))); // NOI18N
        btnStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatistic.setPreferredSize(new java.awt.Dimension(40, 40));
        btnStatistic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnStatistic);

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/back.png"))); // NOI18N
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setPreferredSize(new java.awt.Dimension(40, 40));
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnBack);

        btnLogout.setBackground(new java.awt.Color(232, 255, 183));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/logout.png"))); // NOI18N
        btnLogout.setToolTipText("");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLogout.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(btnLogout);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
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
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnDeleteCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteCommentActionPerformed

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
        if (evt.getClickCount() == 2) {
            this.row = tblQuestions.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.row >= 0) {
                //this.edit();
                tabs.setSelectedIndex(0);
            }
        }
        this.row = tblQuestions.rowAtPoint(evt.getPoint());
        this.edit();
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
        insert();
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
    private javax.swing.JButton btnDeleteComment;
    private javax.swing.JButton btnDo;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLesson;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPersonalInfo;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnRemake;
    private javax.swing.JButton btnReport;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblAnswer1;
    private javax.swing.JLabel lblAnswer2;
    private javax.swing.JLabel lblAnswer3;
    private javax.swing.JLabel lblAnswer4;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblCorrectAns;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblGradeList;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLesson;
    private javax.swing.JLabel lblLessonList;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblReply;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblShowQuestionDoTest;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblSubjectList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleDoTest;
    private javax.swing.JLabel lblTitleQuestion;
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
    private javax.swing.JTextField txtSearchList;
    private javax.swing.JTextField txtTitleQuestion;
    // End of variables declaration//GEN-END:variables
}
