/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package com.studious.display;

import com.studious.entity.Question;

/**
 *
 * @author Admin
 */
public class DoTest extends java.awt.Dialog {

    /**
     * Creates new form DoTest
     */
    public DoTest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDoneQuestion = new javax.swing.JLabel();
        btnEndTest = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlButton = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        pnlShowQuestion = new javax.swing.JPanel();
        lblTitleTest = new javax.swing.JLabel();
        lblQuestionNumber = new javax.swing.JLabel();
        lblShowAnsA = new javax.swing.JLabel();
        lblShowAnsB = new javax.swing.JLabel();
        lblShowAnsC = new javax.swing.JLabel();
        lblShowAnsD = new javax.swing.JLabel();
        pnlChooseAnswer = new javax.swing.JPanel();
        lblChooseAns = new javax.swing.JLabel();
        rdoChooseAnsA = new javax.swing.JRadioButton();
        rdoChooseAnsB = new javax.swing.JRadioButton();
        rdoChooseAnsC = new javax.swing.JRadioButton();
        rdoChooseAnsD = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(232, 255, 183));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(232, 255, 183));

        lblLogo.setBackground(new java.awt.Color(232, 255, 183));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studious/icons/Studious-255x68.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(47, 106, 1));
        lblTitle.setText("LÀM BÀI THI THỬ");

        lblDoneQuestion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDoneQuestion.setText("Số câu đã làm: 5/40");

        btnEndTest.setBackground(new java.awt.Color(215, 215, 215));
        btnEndTest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEndTest.setText("KẾT THÚC BÀI THI");
        btnEndTest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEndTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndTestActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 51));
        lblTime.setText("60:00");

        pnlContent.setBackground(new java.awt.Color(232, 255, 183));

        pnlButton.setBackground(new java.awt.Color(232, 255, 183));
        pnlButton.setLayout(new java.awt.GridLayout(4, 10, 5, 5));

        btn1.setBackground(new java.awt.Color(229, 229, 229));
        btn1.setText("1");
        pnlButton.add(btn1);

        btn2.setBackground(new java.awt.Color(229, 229, 229));
        btn2.setText("2");
        pnlButton.add(btn2);

        btn3.setBackground(new java.awt.Color(229, 229, 229));
        btn3.setText("3");
        pnlButton.add(btn3);

        btn4.setBackground(new java.awt.Color(229, 229, 229));
        btn4.setText("4");
        pnlButton.add(btn4);

        btn5.setBackground(new java.awt.Color(229, 229, 229));
        btn5.setText("5");
        pnlButton.add(btn5);

        btn6.setBackground(new java.awt.Color(229, 229, 229));
        btn6.setText("6");
        pnlButton.add(btn6);

        btn7.setBackground(new java.awt.Color(229, 229, 229));
        btn7.setText("7");
        pnlButton.add(btn7);

        btn8.setBackground(new java.awt.Color(229, 229, 229));
        btn8.setText("8");
        pnlButton.add(btn8);

        btn9.setBackground(new java.awt.Color(229, 229, 229));
        btn9.setText("9");
        pnlButton.add(btn9);

        btn10.setBackground(new java.awt.Color(229, 229, 229));
        btn10.setText("10");
        pnlButton.add(btn10);

        btn11.setBackground(new java.awt.Color(229, 229, 229));
        btn11.setText("11");
        pnlButton.add(btn11);

        btn12.setBackground(new java.awt.Color(229, 229, 229));
        btn12.setText("12");
        pnlButton.add(btn12);

        btn13.setBackground(new java.awt.Color(229, 229, 229));
        btn13.setText("13");
        pnlButton.add(btn13);

        btn14.setBackground(new java.awt.Color(229, 229, 229));
        btn14.setText("14");
        pnlButton.add(btn14);

        btn15.setBackground(new java.awt.Color(229, 229, 229));
        btn15.setText("15");
        pnlButton.add(btn15);

        btn16.setBackground(new java.awt.Color(229, 229, 229));
        btn16.setText("16");
        pnlButton.add(btn16);

        btn17.setBackground(new java.awt.Color(229, 229, 229));
        btn17.setText("17");
        pnlButton.add(btn17);

        btn18.setBackground(new java.awt.Color(229, 229, 229));
        btn18.setText("18");
        pnlButton.add(btn18);

        btn19.setBackground(new java.awt.Color(229, 229, 229));
        btn19.setText("19");
        pnlButton.add(btn19);

        btn20.setBackground(new java.awt.Color(229, 229, 229));
        btn20.setText("20");
        pnlButton.add(btn20);

        btn21.setBackground(new java.awt.Color(229, 229, 229));
        btn21.setText("21");
        pnlButton.add(btn21);

        btn22.setBackground(new java.awt.Color(229, 229, 229));
        btn22.setText("22");
        pnlButton.add(btn22);

        btn23.setBackground(new java.awt.Color(229, 229, 229));
        btn23.setText("23");
        pnlButton.add(btn23);

        btn24.setBackground(new java.awt.Color(229, 229, 229));
        btn24.setText("24");
        pnlButton.add(btn24);

        btn25.setBackground(new java.awt.Color(229, 229, 229));
        btn25.setText("25");
        pnlButton.add(btn25);

        btn26.setBackground(new java.awt.Color(229, 229, 229));
        btn26.setText("26");
        pnlButton.add(btn26);

        btn27.setBackground(new java.awt.Color(229, 229, 229));
        btn27.setText("27");
        pnlButton.add(btn27);

        btn28.setBackground(new java.awt.Color(229, 229, 229));
        btn28.setText("28");
        pnlButton.add(btn28);

        btn29.setBackground(new java.awt.Color(229, 229, 229));
        btn29.setText("29");
        pnlButton.add(btn29);

        btn30.setBackground(new java.awt.Color(229, 229, 229));
        btn30.setText("30");
        pnlButton.add(btn30);

        btn31.setBackground(new java.awt.Color(229, 229, 229));
        btn31.setText("31");
        pnlButton.add(btn31);

        btn32.setBackground(new java.awt.Color(229, 229, 229));
        btn32.setText("32");
        pnlButton.add(btn32);

        btn33.setBackground(new java.awt.Color(229, 229, 229));
        btn33.setText("33");
        pnlButton.add(btn33);

        btn34.setBackground(new java.awt.Color(229, 229, 229));
        btn34.setText("34");
        pnlButton.add(btn34);

        btn35.setBackground(new java.awt.Color(229, 229, 229));
        btn35.setText("35");
        pnlButton.add(btn35);

        btn36.setBackground(new java.awt.Color(229, 229, 229));
        btn36.setText("36");
        pnlButton.add(btn36);

        btn37.setBackground(new java.awt.Color(229, 229, 229));
        btn37.setText("37");
        pnlButton.add(btn37);

        btn38.setBackground(new java.awt.Color(229, 229, 229));
        btn38.setText("38");
        pnlButton.add(btn38);

        btn39.setBackground(new java.awt.Color(229, 229, 229));
        btn39.setText("39");
        pnlButton.add(btn39);

        btn40.setBackground(new java.awt.Color(229, 229, 229));
        btn40.setText("40");
        pnlButton.add(btn40);

        pnlShowQuestion.setBackground(new java.awt.Color(255, 255, 255));

        lblTitleTest.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitleTest.setText("TIÊU ĐỀ BÀI THI");

        lblQuestionNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQuestionNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblQuestionNumber.setText("Câu 1: Nội dung câu hỏi");
        lblQuestionNumber.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblQuestionNumber.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblQuestionNumber.setMaximumSize(new java.awt.Dimension(167, 22));
        lblQuestionNumber.setPreferredSize(new java.awt.Dimension(167, 22));
        lblQuestionNumber.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblShowAnsA.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblShowAnsA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblShowAnsA.setText("A. Đáp án 1");
        lblShowAnsA.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblShowAnsA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblShowAnsA.setMaximumSize(new java.awt.Dimension(167, 22));
        lblShowAnsA.setPreferredSize(new java.awt.Dimension(167, 22));
        lblShowAnsA.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblShowAnsB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblShowAnsB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblShowAnsB.setText("B. Đáp án 2");
        lblShowAnsB.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblShowAnsB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblShowAnsB.setMaximumSize(new java.awt.Dimension(167, 22));
        lblShowAnsB.setPreferredSize(new java.awt.Dimension(167, 22));
        lblShowAnsB.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblShowAnsC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblShowAnsC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblShowAnsC.setText("C. Đáp án 3");
        lblShowAnsC.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblShowAnsC.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblShowAnsC.setMaximumSize(new java.awt.Dimension(167, 22));
        lblShowAnsC.setPreferredSize(new java.awt.Dimension(167, 22));
        lblShowAnsC.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblShowAnsD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblShowAnsD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblShowAnsD.setText("D. Đáp án 4");
        lblShowAnsD.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblShowAnsD.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblShowAnsD.setMaximumSize(new java.awt.Dimension(167, 22));
        lblShowAnsD.setPreferredSize(new java.awt.Dimension(167, 22));
        lblShowAnsD.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlShowQuestionLayout = new javax.swing.GroupLayout(pnlShowQuestion);
        pnlShowQuestion.setLayout(pnlShowQuestionLayout);
        pnlShowQuestionLayout.setHorizontalGroup(
            pnlShowQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShowQuestionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitleTest)
                .addGap(289, 289, 289))
            .addGroup(pnlShowQuestionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlShowQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowAnsD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowAnsC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowAnsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowAnsA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlShowQuestionLayout.setVerticalGroup(
            pnlShowQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShowAnsA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShowAnsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShowAnsC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShowAnsD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlShowQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlShowQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlChooseAnswer.setBackground(new java.awt.Color(229, 229, 229));

        lblChooseAns.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblChooseAns.setText("Chọn đáp án:");

        rdoChooseAnsA.setBackground(new java.awt.Color(229, 229, 229));
        buttonGroup1.add(rdoChooseAnsA);
        rdoChooseAnsA.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoChooseAnsA.setSelected(true);
        rdoChooseAnsA.setText("A");
        rdoChooseAnsA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChooseAnsAActionPerformed(evt);
            }
        });

        rdoChooseAnsB.setBackground(new java.awt.Color(229, 229, 229));
        buttonGroup1.add(rdoChooseAnsB);
        rdoChooseAnsB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoChooseAnsB.setText("B");

        rdoChooseAnsC.setBackground(new java.awt.Color(229, 229, 229));
        buttonGroup1.add(rdoChooseAnsC);
        rdoChooseAnsC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoChooseAnsC.setText("C");

        rdoChooseAnsD.setBackground(new java.awt.Color(229, 229, 229));
        buttonGroup1.add(rdoChooseAnsD);
        rdoChooseAnsD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoChooseAnsD.setText("D");

        javax.swing.GroupLayout pnlChooseAnswerLayout = new javax.swing.GroupLayout(pnlChooseAnswer);
        pnlChooseAnswer.setLayout(pnlChooseAnswerLayout);
        pnlChooseAnswerLayout.setHorizontalGroup(
            pnlChooseAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChooseAnswerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblChooseAns)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChooseAnswerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlChooseAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoChooseAnsC)
                    .addGroup(pnlChooseAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rdoChooseAnsA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoChooseAnsB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdoChooseAnsD))
                .addContainerGap())
        );
        pnlChooseAnswerLayout.setVerticalGroup(
            pnlChooseAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChooseAnswerLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblChooseAns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoChooseAnsA)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsB)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsC)
                .addGap(18, 18, 18)
                .addComponent(rdoChooseAnsD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblDoneQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTime)
                            .addComponent(btnEndTest, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(72, 72, 72)
                        .addComponent(lblTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChooseAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogo)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDoneQuestion))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEndTest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlChooseAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnEndTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEndTestActionPerformed

    private void rdoChooseAnsAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChooseAnsAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChooseAnsAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoTest dialog = new DoTest(new java.awt.Frame(), true);
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
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnEndTest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblChooseAns;
    private javax.swing.JLabel lblDoneQuestion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblQuestionNumber;
    private javax.swing.JLabel lblShowAnsA;
    private javax.swing.JLabel lblShowAnsB;
    private javax.swing.JLabel lblShowAnsC;
    private javax.swing.JLabel lblShowAnsD;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleTest;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlChooseAnswer;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlShowQuestion;
    private javax.swing.JRadioButton rdoChooseAnsA;
    private javax.swing.JRadioButton rdoChooseAnsB;
    private javax.swing.JRadioButton rdoChooseAnsC;
    private javax.swing.JRadioButton rdoChooseAnsD;
    // End of variables declaration//GEN-END:variables

    private void fillQuestion(Question entity, int index) {
        lblQuestionNumber.setText("Câu" + index + ": " + entity.getQuestion());
        lblShowAnsA.setText("A. " + entity.getWrongAns1());
        lblShowAnsB.setText("B. " + entity.getWrongAns2());
        lblShowAnsC.setText("C. " + entity.getWrongAns3());
        lblShowAnsD.setText("D. " + entity.getWrongAns4());
    }
}
