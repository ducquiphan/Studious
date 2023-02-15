/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studious.utils;

import com.studious.entity.Account;

/**
 *
 * @author Phan Qui Duc
 */
public class Auth {
    public static Account user = null;
    public static void clearForm(){
        Auth.user = null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && user.isRole();
    }
}
