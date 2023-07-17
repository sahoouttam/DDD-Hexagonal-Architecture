package com.ddd.hexagonal.architecture.project.domain.model;

import java.math.BigDecimal;

public class Account {

    private Long accountNumber;
    private BigDecimal accountBalance;

    public boolean withdrawAmount(BigDecimal withdrawalAmount) {
        if (accountBalance.compareTo(withdrawalAmount) < 0) {
            return false;
        }
        accountBalance = accountBalance.subtract(withdrawalAmount);
        return true;
    }

    public void depositAmount(BigDecimal depositAmount) {
        accountBalance = accountBalance.add(depositAmount);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
