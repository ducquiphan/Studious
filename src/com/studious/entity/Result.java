package com.studious.entity;

import java.util.Date;

/**
 *
 * @author NGUYEN VAN SI
 */
public class Result {

    private int indexTest;
    private String studentID;
    private String testID;
    private int indexQuestion;
    private String AnsSelected;
    private String AnsCorrect;
    private Date DateTest;

    public Result() {
    }

    public Result(int indexTest, String studentID, String testID, int indexQuestion, String AnsSelected, String AnsCorrect, Date DateTest) {
        this.indexTest = indexTest;
        this.studentID = studentID;
        this.testID = testID;
        this.indexQuestion = indexQuestion;
        this.AnsSelected = AnsSelected;
        this.AnsCorrect = AnsCorrect;
        this.DateTest = DateTest;
    }

    public int getIndexTest() {
        return indexTest;
    }

    public void setIndexTest(int indexTest) {
        this.indexTest = indexTest;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public int getIndexQuestion() {
        return indexQuestion;
    }

    public void setIndexQuestion(int indexQuestion) {
        this.indexQuestion = indexQuestion;
    }

    public String getAnsSelected() {
        return AnsSelected;
    }

    public void setAnsSelected(String AnsSelected) {
        this.AnsSelected = AnsSelected;
    }

    public String getAnsCorrect() {
        return AnsCorrect;
    }

    public void setAnsCorrect(String AnsCorrect) {
        this.AnsCorrect = AnsCorrect;
    }

    public Date getDateTest() {
        return DateTest;
    }

    public void setDateTest(Date DateTest) {
        this.DateTest = DateTest;
    }

}
