
package com.studious.entity;

import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class Student {
    private String studentID;
    private String fullname;
    private boolean gender;
    private Date birthDate;
    private String identity ;
    private int grade;
    private String email;
    private String avtURL;
    private String accountID;

    public Student() {
    }

    public Student(String studentID, String fullname, boolean gender, Date birthDate, String identity, int grade, String email, String avtURL, String accountID) {
        this.studentID = studentID;
        this.fullname = fullname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.identity = identity;
        this.grade = grade;
        this.email = email;
        this.avtURL = avtURL;
        this.accountID = accountID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

        public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvtURL() {
        return avtURL;
    }

    public void setAvtURL(String avtURL) {
        this.avtURL = avtURL;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
    
    
}
