package com.example.calculator2.service;

import java.math.BigDecimal;

public class CalculateOperationSum implements CalculateOperationService {
    @Override
    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new BigDecimal(String.valueOf(firstNumber.add(secondNumber)));
    }
}
