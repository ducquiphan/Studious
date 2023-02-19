package com.studious.entity;

/**
 *
 * @author Phan Qui Duc
 */
public class Question {
    private int questionID;
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans;
    private int lessonID;
    private String teacherID;

    public Question() {
    }

    public Question(int questionID, String question, String ans1, String ans2, String ans3, String ans4, String ans, int lessonID, String teacherID) {
        this.questionID = questionID;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans = ans;
        this.lessonID = lessonID;
        this.teacherID = teacherID;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
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
