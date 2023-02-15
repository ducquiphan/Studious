
package com.studious.entity;

/**
 *
 * @author Phan Qui Duc
 */
public class Account {
    private String userID;
    private String password;
    private String fullname;
    private int role;
    private boolean status;

    public Account () {
    }

    public Account (String userID, String password, String fullname, int role, boolean status) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account{");
        sb.append("fullname=").append(fullname);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    
}
