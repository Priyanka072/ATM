package com.atm.details.Entity;

import javax.persistence.*;

@Entity
@Table(name = "details_table")
public class Details {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long detailsId;
    @Id
    private String userName;

    private Long accountNo;
    private Long phoneNo;
    private int amount;
    private Long cardNo;

    public Details() {
        super();
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

}
