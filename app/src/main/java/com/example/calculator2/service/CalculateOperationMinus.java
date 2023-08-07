package com.example.calculator2.service;

import java.math.BigDecimal;

public class CalculateOperationMinus implements CalculateOperationService {
    @Override
    public BigDecimal calculate(BigDecimal secondNumber, BigDecimal firstNumber) {
        return new BigDecimal(String.valueOf(firstNumber.subtract(secondNumber)));
    }
}
