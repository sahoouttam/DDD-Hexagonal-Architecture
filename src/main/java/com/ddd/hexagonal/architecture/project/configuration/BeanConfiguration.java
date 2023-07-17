package com.ddd.hexagonal.architecture.project.configuration;

import com.ddd.hexagonal.architecture.project.DddHexagonalArchitectureApplication;
import com.ddd.hexagonal.architecture.project.domain.service.AccountService;
import com.ddd.hexagonal.architecture.project.infrastructure.adapter.AccountRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DddHexagonalArchitectureApplication.class)
public class BeanConfiguration {

    public AccountService accountService(AccountRepository accountRepository) {
        return new AccountService(accountRepository, accountRepository);
    }
}
