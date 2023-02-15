
package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class TestReport {
    private String testReportID;
    private String testID;
    private String studentID;
    private String testTitle;
    private double testScore;
    private int completeTime;
    private int correctAnswers;
    private Date finishedDate;

    public TestReport() {
    }

    public TestReport(String testReportID, String testID, String studentID, String testTitle, double testScore, int completeTime, int correctAnswers, Date finishedDate) {
        this.testReportID = testReportID;
        this.testID = testID;
        this.studentID = studentID;
        this.testTitle = testTitle;
        this.testScore = testScore;
        this.completeTime = completeTime;
        this.correctAnswers = correctAnswers;
        this.finishedDate = finishedDate;
    }

    public String getTestReportID() {
        return testReportID;
    }

    public void setTestReportID(String testReportID) {
        this.testReportID = testReportID;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public int getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int completeTime) {
        this.completeTime = completeTime;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }
    
    @Override
    public String toString(){
        return "Kết quả bài thi: "+getTestTitle();
    }
}
