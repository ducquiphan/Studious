package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class Test {

    private String testID;
    private String testTitle;
    private int timeTest;
    private String lesson;
    private int grade;
    private Date createDate;
    private String teacherID;
    private String questionsList;

    public Test() {
    }

    public Test(String testID, String testTitle, int timeTest, String lesson, int grade, String teacherID) {
        this.testID = testID;
        this.testTitle = testTitle;
        this.timeTest = timeTest;
        this.lesson = lesson;
        this.grade = grade;
        this.teacherID = teacherID;
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

    public int getTimeTest() {
        return timeTest;
    }

    public void setTimeTest(int timeTest) {
        this.timeTest = timeTest;
    }

}
