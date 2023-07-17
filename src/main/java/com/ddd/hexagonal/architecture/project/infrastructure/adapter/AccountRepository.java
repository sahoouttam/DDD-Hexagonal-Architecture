package com.ddd.hexagonal.architecture.project.infrastructure.adapter;

import com.ddd.hexagonal.architecture.project.domain.model.Account;
import com.ddd.hexagonal.architecture.project.domain.port.output.CreateAccount;
import com.ddd.hexagonal.architecture.project.domain.port.output.RetrieveAccount;

public class AccountRepository implements RetrieveAccount, CreateAccount {

    private final JpaAccountRepository jpaAccountRepository;

    public AccountRepository(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public void save(Account account) {
        jpaAccountRepository.save(account);
    }

    @Override
    public Account load(Long accountNumber) {
        return jpaAccountRepository.findByAccountNumber(accountNumber);
    }
}
