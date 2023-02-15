/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studious.entity;

/**
 *
 * @author Phan Qui Duc
 */
public class Account {
    private String userID;
    private String password;
    private String fullname;
    private boolean role;
    private boolean status;

    public Account () {
    }

    public Account (String userID, String password, String fullname, boolean role, boolean status) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }

    
    
    
}
