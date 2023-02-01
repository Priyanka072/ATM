package com.atm.changePin.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pin_table")
public class Pin implements Serializable {
    @Id
    private String userName;
    private int userPin;

    public Pin() {
        super();
    }

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
