/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class QnA {
    private String qnaID;
    private String content;
    private Date createDate;
    private String userID;
    private int questionID;

    public QnA() {
    }

    public QnA(String qnaID, String content, Date createDate, String userID, int questionID) {
        this.qnaID = qnaID;
        this.content = content;
        this.createDate = createDate;
        this.userID = userID;
        this.questionID = questionID;
    }

    public String getQnaID() {
        return qnaID;
    }

    public void setQnaID(String qnaID) {
        this.qnaID = qnaID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "QnA{" + "qnaID=" + qnaID + ", content=" + content + ", userID=" + userID + ", questionID=" + questionID + '}';
    }
    
    
}
