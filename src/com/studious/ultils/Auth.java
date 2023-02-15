package com.studious.ultils;

import com.studious.entity.Account;

/**
 *
 * @author Nguyễn Văn Sĩ
 */
public class Auth {

    public static Account user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.getRole() == 1;
    }

    public static boolean isTeacher() {
        return Auth.isLogin() && user.getRole() == 2;
    }
    
    public static boolean isStudent() {
        return Auth.isLogin() && user.getRole() == 3;
    }
}
