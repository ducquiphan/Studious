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
public class Student {
    private String studentID;
    private String fullname;
    private boolean gender;
    private Date birthDate;
    private int grade;
    private String email;
    private String phone;
    private String avtURL;
    private String accountID;

    public Student() {
    }

    public Student(String studentID, String fullname, boolean gender, Date birthDate, int grade, String email, String phone, String avtURL, String accountID) {
        this.studentID = studentID;
        this.fullname = fullname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return getFullname();
    }
    
    
}
