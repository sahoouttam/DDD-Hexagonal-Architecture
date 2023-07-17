package com.ddd.hexagonal.architecture.project.domain.port.input;

import java.math.BigDecimal;

public interface Withdraw {

    boolean withdraw(Long accountNumber, BigDecimal withdrawalAmount);
}
