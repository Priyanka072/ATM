package com.atm.user.NewVolume;

import com.atm.user.Model.User;

public class ResponseTemplate {
    private User users;
    private Details details;

    public ResponseTemplate(User users, Details details) {
        this.users = users;
        this.details = details;
    }
    public ResponseTemplate() {
        super();
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
