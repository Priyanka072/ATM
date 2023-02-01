package com.atm.atm;

import java.io.Serializable;

public class Pin implements Serializable {

    private String userName;
    private int userPin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPin() {
        return userPin;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }
}
