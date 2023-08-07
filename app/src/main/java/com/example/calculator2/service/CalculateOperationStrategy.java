package com.example.calculator2.service;

import android.view.View;
import com.example.calculator2.R;
import java.math.BigDecimal;

public class CalculateOperationStrategy {
    private CalculateOperationService calculateOperationService;

    public BigDecimal calculate(View view, BigDecimal firstNumber, BigDecimal secondNumber) {
        if (view == null) {
            return BigDecimal.ZERO;
        }
        if (view.getId() == R.id.buttonPlus) {
            calculateOperationService = new CalculateOperationSum();
        }
        if (view.getId() == R.id.buttonMinus) {
            calculateOperationService = new CalculateOperationMinus();
        }
        if (view.getId() == R.id.buttonMultiply) {
            calculateOperationService = new CalculateOperationMultiply();
        }
        if (view.getId() == R.id.buttonDivide) {
            calculateOperationService = new CalculateOperationDivide();
        }
        return calculateOperationService.calculate(firstNumber, secondNumber);
    }
}
