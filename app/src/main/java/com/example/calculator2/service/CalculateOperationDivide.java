package com.example.calculator2.service;

import java.math.BigDecimal;

public class CalculateOperationDivide implements CalculateOperationService {
    @Override
    public BigDecimal calculate(BigDecimal secondNumber, BigDecimal firstNumber) {
        if (secondNumber == BigDecimal.ZERO || firstNumber == BigDecimal.ZERO) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(String.valueOf(firstNumber.divide(secondNumber)));
    }
}
