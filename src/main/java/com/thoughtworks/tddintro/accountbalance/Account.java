package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by James on 5/8/2016.
 */
public class Account {
    private int moneyInMyAccount;

    public Account(int i) {
        this.moneyInMyAccount = i;
    }

    public void depositMoney(int moneyDepositing) {
        moneyInMyAccount += moneyDepositing;
    }

    public int showBalance() {
        return moneyInMyAccount;
    }

    public void withdrawMoney(int moneyWithdrawing) {
        if (moneyInMyAccount > moneyWithdrawing) {
            moneyInMyAccount -= moneyWithdrawing;
        }
    }
}
