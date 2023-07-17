package com.ddd.hexagonal.architecture.project.infrastructure.adapter;

import com.ddd.hexagonal.architecture.project.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNumber(Long accountNumber);
}
