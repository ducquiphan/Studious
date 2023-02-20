package com.studious.display;

import com.studious.DAO.AccountDAO;
import com.studious.DAO.StudentDAO;
import com.studious.DAO.TeacherDAO;
import com.studious.entity.Account;
import com.studious.entity.Student;
import com.studious.entity.Teacher;
import com.studious.utils.Auth;
import com.studious.utils.MsgBox;
import java.awt.Frame;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SsuBii
 */
public class ForgotPassword extends javax.swing.JDialog {

    /**
     * Creates new form Login
     */
    AccountDAO aDao = new AccountDAO();
    TeacherDAO tDao = new TeacherDAO();
    StudentDAO sDao = new StudentDAO();
    
    public ForgotPassword(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Studious - Quên mật khẩu");
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
        lblBackGround = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblNameAccount = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/bg-4.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(1, 93, 10));
        lblTitle.setText("QUÊN MẬT KHẨU");

        lblNameAccount.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        lblNameAccount.setText("Tên tài khoản");

        lblPassword.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        lblPassword.setText("Email");

        txtUsername.setBackground(new java.awt.Color(217, 217, 217));
        txtUsername.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txtUsername.setText("GV25579");

        btnConfirm.setBackground(new java.awt.Color(232, 255, 183));
        btnConfirm.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        btnConfirm.setText("Xác nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(232, 255, 183));
        btnBack.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(217, 217, 217));
        txtEmail.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txtEmail.setText("nguyenvansi2l3@gmail.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblNameAccount)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackGround)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblTitle)
                .addGap(55, 55, 55)
                .addComponent(lblNameAccount)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblPassword)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        getPass();
    }//GEN-LAST:event_btnConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ForgotPassword dialog = new ForgotPassword(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblNameAccount;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private String getEmailOfAcc(int index, String key) {
        String email = "";
        if (index == 1) {
            MsgBox.alert(this, "Danh tạo dùm tui cái bảng ADMIN nha");
        } else if (index == 2) {
            Teacher entity = tDao.selectById(key);
            email = entity.getEmail();
        } else {
            Student entity = sDao.selectById(key);
            email = entity.getEmail();
        }
        return email;
    }
    
    private void updateAccount(Account entity) {
        aDao.update(entity);
    }
    
    private int getCode() {
        return (int) (Math.random() * (999999 - 100000 + 1) + 100000);
    }
    
    private void getPass() {
        String username = txtUsername.getText();
        String email = txtEmail.getText().trim();
        final String from = "nguyenvansitqt2k3@gmail.com";
        final String passMail = "caetrjhsiwhygemm";
        Account acc = aDao.selectById(username);
        
        if (acc == null) {
            MsgBox.alert(this, "Tên tài khoản không đúng");
        } else {
            String mailOfAcc = getEmailOfAcc(acc.getRole(), username);
            if (mailOfAcc.equals(email)) {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);
                
                Session session = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, passMail);
                    }
                });
                try {
                    int code = getCode();
                    
                    Message message = new MimeMessage(session);
                    
                    message.setFrom(new InternetAddress(from));
                    
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                    
                    message.setSubject("Studious - Mật khẩu mới");
                    
                    message.setText("Xin chào,\n"
                            + "Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu Studious của bạn.\n"
                            + "Mật khẩu mới sau đây:\n"
                            + code
                            + "\n Bạn nên thay đổi lại mật khẩu cho mình để bảo đảm an toàn cho tài khoản.");
                    Transport.send(message);
                    
                    acc.setPassword(String.valueOf(code));
                    updateAccount(acc);
                    
                    MsgBox.alert(this, "Chúng tôi đã gửi mật khẩu mới đến email của bạn");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
