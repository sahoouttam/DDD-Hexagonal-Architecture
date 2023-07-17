package com.ddd.hexagonal.architecture.project.domain.service;

import com.ddd.hexagonal.architecture.project.domain.model.Account;
import com.ddd.hexagonal.architecture.project.domain.port.input.Deposit;
import com.ddd.hexagonal.architecture.project.domain.port.input.Withdraw;
import com.ddd.hexagonal.architecture.project.domain.port.output.CreateAccount;
import com.ddd.hexagonal.architecture.project.domain.port.output.RetrieveAccount;

import java.math.BigDecimal;

public class AccountService implements Deposit, Withdraw {

    private final CreateAccount createAccount;
    private final RetrieveAccount retrieveAccount;

    public AccountService(CreateAccount createAccount, RetrieveAccount retrieveAccount) {
        this.createAccount = createAccount;
        this.retrieveAccount = retrieveAccount;
    }

    @Override
    public void deposit(Long accountNumber, BigDecimal depositAmount) {
        Account account = retrieveAccount.load(accountNumber);
        account.depositAmount(depositAmount);
        createAccount.save(account);
    }

    @Override
    public boolean withdraw(Long accountNumber, BigDecimal withdrawalAmount) {
        Account account = retrieveAccount.load(accountNumber);
        boolean withdrawalSuccess = account.withdrawAmount(withdrawalAmount);
        if (withdrawalSuccess) createAccount.save(account);
        return withdrawalSuccess;
    }
}
