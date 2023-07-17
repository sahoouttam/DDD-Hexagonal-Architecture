package com.ddd.hexagonal.architecture.project.application.controller;

import com.ddd.hexagonal.architecture.project.domain.port.input.Deposit;
import com.ddd.hexagonal.architecture.project.domain.port.input.Withdraw;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final Deposit depositUseCase;
    private final Withdraw withdrawUseCase;

    public AccountController(Deposit depositUseCase, Withdraw withdrawUseCase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    @PostMapping("/{accountNumber}/deposit/{depositAmount}")
    public void deposit(@PathVariable Long accountNumber, @PathVariable BigDecimal depositAmount) {
        depositUseCase.deposit(accountNumber, depositAmount);
    }

    @PostMapping("/{accountNumber}/withdraw/{withdrawalAmount}")
    public void withdraw(@PathVariable Long accountNumber, @PathVariable BigDecimal withdrawalAmount) {
        withdrawUseCase.withdraw(accountNumber, withdrawalAmount);
    }
}
