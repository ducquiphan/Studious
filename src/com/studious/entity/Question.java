package com.studious.entity;

/**
 *
 * @author Phan Qui Duc
 */
public class Question {
    private int questionID;
    private String question;
    private String wrongAns1;
    private String wrongAns2;
    private String wrongAns3;
    private String wrongAns4;
    private String ans;
    private int lessonID;
    private String teacherID;

    public Question() {
    }

    public Question(int questionID, String question, String wrongAns1, String wrongAns2, String wrongAns3, String wrongAns4, String ans, int lessonID, String teacherID) {
        this.questionID = questionID;
        this.question = question;
        this.wrongAns1 = wrongAns1;
        this.wrongAns2 = wrongAns2;
        this.wrongAns3 = wrongAns3;
        this.wrongAns4 = wrongAns4;
        this.ans = ans;
        this.lessonID = lessonID;
        this.teacherID = teacherID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getWrongAns1() {
        return wrongAns1;
    }

    public void setWrongAns1(String wrongAns1) {
        this.wrongAns1 = wrongAns1;
    }

    public String getWrongAns2() {
        return wrongAns2;
    }

    public void setWrongAns2(String wrongAns2) {
        this.wrongAns2 = wrongAns2;
    }

    public String getWrongAns3() {
        return wrongAns3;
    }

    public void setWrongAns3(String wrongAns3) {
        this.wrongAns3 = wrongAns3;
    }

    public String getWrongAns4() {
        return wrongAns4;
    }

    public void setWrongAns4(String wrongAns4) {
        this.wrongAns4 = wrongAns4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return getQuestion();
    }
    
    
}
