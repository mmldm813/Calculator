package com.example.michellemedina.calculator;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations {

    enum OperandType {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION, PERCENT
    }

    private OperandType prevOperand;

    private BigDecimal prevValue;
    private BigDecimal currValue;
    private BigDecimal totalValue;

    private BigDecimal one = new BigDecimal(1);
    private BigDecimal zero = new BigDecimal(0);
    private BigDecimal oneHundred = new BigDecimal(100);

    public String performMath(final OperandType operand) {
        String result;
        prevValue = currValue;
        currValue = null;

        if (operand == OperandType.PERCENT) {
            if (totalValue == null) {
                totalValue = (prevValue == null ? one : prevValue)
                        .multiply((currValue == null ? one : currValue).divide(oneHundred));
            } else {
                totalValue = totalValue
                        .multiply((prevValue == null ? one : prevValue).divide(oneHundred));
            }
        } else {
            if (prevOperand == null) {
                totalValue = prevValue;
            } else {
                switch (prevOperand) {
                    case ADDITION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? zero : prevValue)
                                    .add(currValue == null ? zero : currValue);
                        } else {
                            totalValue = totalValue.add(prevValue == null ? zero : prevValue);
                        }
                        break;
                    case SUBTRACTION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? zero : prevValue)
                                    .subtract(currValue == null ? zero : currValue);
                        } else {
                            totalValue = totalValue.subtract(prevValue == null ? zero : prevValue);
                        }
                        break;
                    case MULTIPLICATION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? one : prevValue)
                                    .multiply(currValue == null ? one : currValue);
                        } else {
                            totalValue = totalValue.multiply(prevValue == null ? one : prevValue);
                        }
                        break;
                    case DIVISION:
                        if (totalValue == null) {
                            totalValue = (prevValue == null ? one : prevValue)
                                    .divide(currValue == null ? one : currValue);
                        } else {
                            totalValue = totalValue.divide(prevValue == null ? one : prevValue , RoundingMode.HALF_UP);
                        }
                        break;
                }
            }
        }

        if (totalValue.toString().endsWith(".0")) {
            result = String.valueOf(totalValue.intValue());
        } else {
            result = String.valueOf(totalValue);
        }
        prevOperand = operand;
        return result;
    }

    public String performEqual() {
        String result;
        BigDecimal total = totalValue == null ? zero : totalValue;
        BigDecimal curr = currValue == null ? zero : currValue;
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
                totalValue = total.multiply(prevValue.divide(oneHundred));
                break;
        }
        if (totalValue.toString().endsWith(".0")) {
            result = String.valueOf(totalValue.intValue());
        } else {
            result = String.valueOf(totalValue);        }
        return result;
    }

    public void clearAllFields() {
        totalValue = null;
        prevValue = null;
        currValue = null;
    }

    public BigDecimal getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(BigDecimal prevValue) {
        this.prevValue = prevValue;
    }

    public BigDecimal getCurrValue() {
        return currValue;
    }

    public void setCurrValue(BigDecimal currValue) {
        this.currValue = currValue;
    }

    public void setCurrValue(String value) {
         this.currValue = BigDecimal.valueOf(Double.parseDouble(value));
    }


    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
