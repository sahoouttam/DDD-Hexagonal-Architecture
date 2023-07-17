package com.ddd.hexagonal.architecture.project.domain.port.output;

import com.ddd.hexagonal.architecture.project.domain.model.Account;

public interface CreateAccount {

    void save(Account account);
}
