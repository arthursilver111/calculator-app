package com.example.calculator2.service;

import java.math.BigDecimal;

public class CalculateOperationMultiply implements CalculateOperationService {
    @Override
    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {
        return new BigDecimal(String.valueOf(firstNumber.multiply(secondNumber)));
    }
}
