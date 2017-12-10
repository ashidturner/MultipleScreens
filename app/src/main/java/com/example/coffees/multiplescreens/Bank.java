package com.example.coffees.multiplescreens;

import java.io.Serializable;

/**
 * Created by Coffees on 12/8/2017.
 */

public class Bank implements Serializable {
    private String bankName;
    private int bankAccNo;
    private int cvv;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank(int bankAccNo, int cvv) {
        this.bankAccNo = bankAccNo;
        this.cvv = cvv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(int bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
