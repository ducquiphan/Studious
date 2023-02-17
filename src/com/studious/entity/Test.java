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
    private String questionsList;

    public Test() {
    }

    public Test(String testID, String testTitle, String lesson, int grade, Date createDate, String teacherID, String questionsList) {
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

    public String getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(String questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public String toString() {
        return getTestTitle();
    }

}
