package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        //Given
        Account myAccount = new Account(100);

        //Action
        myAccount.depositMoney(50);

        //Assert
        assertEquals(myAccount.showBalance(), 150);
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        //Given
        Account myAccount = new Account(100);

        //Action
        myAccount.withdrawMoney(50);

        //Assert
        assertEquals(myAccount.showBalance(), 50);
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        //Given
        Account myAccount = new Account(50);

        //Action
        myAccount.withdrawMoney(100);

        //Assert
        assertEquals(myAccount.showBalance(), 50);
    }
}
