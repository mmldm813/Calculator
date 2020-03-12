package com.example.michellemedina.calculator;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationsEngine {

    enum OperandType {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION, PERCENT
    }

    private static final BigDecimal ONE = new BigDecimal(1);
    private static final BigDecimal ZERO = new BigDecimal(0);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Nullable
    private OperandType prevOperand;
    @Nullable
    private BigDecimal prevValue;
    @Nullable
    private BigDecimal currValue;
    @Nullable
    private BigDecimal totalValue;


    public @NonNull String pressedOperandButtonPerformsCalculation(@NonNull final OperandType operand) {
        String result = "";
        prevValue = currValue;
        currValue = null;

        if (operand == OperandType.PERCENT) {
            if (totalValue == null) {
                totalValue = (prevValue == null ? ONE : prevValue)
                        .multiply((currValue == null ? ONE : currValue).divide(ONE_HUNDRED));
            } else {
                totalValue = totalValue
                        .multiply((prevValue == null ? ONE : prevValue).divide(ONE_HUNDRED));
            }
        } else {
            if (prevOperand == null) {
                totalValue = prevValue;
            } else {
                switch (prevOperand) {
                    case ADDITION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? ZERO : prevValue)
                                    .add(currValue == null ? ZERO : currValue);
                        } else {
                            totalValue = totalValue.add(prevValue == null ? ZERO : prevValue);
                        }
                        break;
                    case SUBTRACTION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? ZERO : prevValue)
                                    .subtract(currValue == null ? ZERO : currValue);
                        } else {
                            totalValue = totalValue.subtract(prevValue == null ? ZERO : prevValue);
                        }
                        break;
                    case MULTIPLICATION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? ONE : prevValue)
                                    .multiply(currValue == null ? ONE : currValue);
                        } else {
                            totalValue = totalValue.multiply(prevValue == null ? ONE : prevValue);
                        }
                        break;
                    case DIVISION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? ONE : prevValue)
                                    .divide(currValue == null ? ONE : currValue);
                        } else {
                            totalValue = totalValue.divide(prevValue == null ? ONE : prevValue, RoundingMode.HALF_UP);
                        }
                        break;
                }
            }
        }


        if (totalValue != null) {
            result = String.valueOf(totalValue);
        }
        prevOperand = operand;
        return result;
    }

    public @NonNull String pressedEqualCalculation() {
        String result = "";
        BigDecimal total = totalValue == null ? ZERO : totalValue;
        BigDecimal curr = currValue == null ? ZERO : currValue;
        switch (prevOperand) {
            case ADDITION:
                totalValue = total.add(curr);
                break;
            case SUBTRACTION:
                totalValue = total.subtract(curr);
                break;
            case MULTIPLICATION:
                totalValue = total.multiply(curr);
                break;
            case DIVISION:
                totalValue = total.divide(curr);
                break;
            case PERCENT:
                totalValue = total.multiply(prevValue.divide(ONE_HUNDRED));
                break;
        }
        if (totalValue != null) {
            result = String.valueOf(totalValue);
        }
        return result;
    }

    public void clearAllFields() {
        totalValue = null;
        prevValue = null;
        currValue = null;
    }

    public @Nullable BigDecimal getCurrValue() {
        return currValue;
    }

    public void setCurrValue(@NonNull BigDecimal currValue) {
        this.currValue = currValue;
    }

    public void setCurrValue(@NonNull String value) {
        this.currValue = new BigDecimal(value);
    }

}
