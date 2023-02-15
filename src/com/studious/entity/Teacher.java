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
public class Teacher {
    private String teacherID;
    private String fullname;
    private boolean gender;
    private Date birthDate;
    private String major;
    private String email;
    private String phone;
    private String avtURL;
    private String accountID;

    public Teacher() {
    }

    public Teacher(String teacherID, String fullname, boolean gender, Date birthDate, String major, String email, String phone, String avtURL, String accountID) {
        this.teacherID = teacherID;
        this.fullname = fullname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.avtURL = avtURL;
        this.accountID = accountID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
