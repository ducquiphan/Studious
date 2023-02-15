/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studious.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Phan Qui Duc
 */
public class Test {
    private String testID;
    private String testTitle;
    private String lesson;
    private int grade;
    private Date createDate;
    private String teacherID;
    private List<String> questionsList;

    public Test() {
    }

    public Test(String testID, String testTitle, String lesson, int grade, Date createDate, String teacherID, List<String> questionsList) {
        this.testID = testID;
        this.testTitle = testTitle;
        this.lesson = lesson;
        this.grade = grade;
        this.createDate = createDate;
        this.teacherID = teacherID;
        this.questionsList = questionsList;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public List<String> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<String> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public String toString() {
        return getTestTitle();
    }
    
    
}
