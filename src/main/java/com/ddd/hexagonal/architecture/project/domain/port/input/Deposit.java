package com.ddd.hexagonal.architecture.project.domain.port.input;

import java.math.BigDecimal;

public interface Deposit {

    void deposit(Long accountNumber, BigDecimal depositAmount);
}
