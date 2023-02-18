
package com.studious.entity;

/**
 *
 * @author Phan Qui Duc
 */
public class QuestionOfTest {
    private int questionOfTestID;
    private int questionID;
    private String testID;

    public QuestionOfTest() {
    }

    public QuestionOfTest(int questionOfTestID, int questionID, String testID) {
        this.questionOfTestID = questionOfTestID;
        this.questionID = questionID;
        this.testID = testID;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public int getQuestionOfTestID() {
        return questionOfTestID;
    }

    public void setQuestionOfTestID(int questionOfTestID) {
        this.questionOfTestID = questionOfTestID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    
    
}
