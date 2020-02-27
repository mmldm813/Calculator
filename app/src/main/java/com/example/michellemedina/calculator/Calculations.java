package com.example.michellemedina.calculator;


public class Calculations {

    enum OperandType {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION, PERCENT
    }

    private OperandType prevOperand;

    private Double prevValue;
    private Double currValue;
    private Double totalValue;

    public String performMath(final OperandType operand) {
        String result;
        prevValue = currValue;
        currValue = null;
        if (prevOperand == null) {
            totalValue = prevValue;
        } else {
            switch (prevOperand) {
                case ADDITION:
                    if (totalValue == null) {
                        totalValue = (prevValue == null ? 0 : prevValue) + (currValue == null ? 0 : currValue);
                    } else {
                        totalValue = totalValue + (prevValue == null ? 0 : prevValue);
                    }
                    break;
                case SUBTRACTION:
                    if (totalValue == null) {
                        totalValue = (prevValue == null ? 0 : prevValue) - (currValue == null ? 0 : currValue);
                    } else {
                        totalValue = totalValue - (prevValue == null ? 0 : prevValue);
                    }
                    break;
                case MULTIPLICATION:
                    if (totalValue == null) {
                        totalValue = (prevValue == null ? 1 : prevValue) * (currValue == null ? 1 : currValue);
                    } else {
                        totalValue = totalValue * (prevValue == null ? 1 : prevValue);
                    }
                    break;
                case DIVISION:
                    if (totalValue == null) {
                        totalValue = (prevValue == null ? 1 : prevValue) / (currValue == null ? 1 : currValue);
                    } else {
                        totalValue = totalValue / (prevValue == null ? 1 : prevValue);
                    }
                    break;
            }
        }

        if (totalValue.toString().endsWith(".0")) {
            result = String.valueOf(totalValue.intValue());
        } else {
            result = Double.toString(totalValue);
        }
        prevOperand = operand;
        return result;
    }

    public String performEqual() {
        String result;
        double total = totalValue == null ? 0 : totalValue;
        double curr = currValue == null ? 0 : currValue;
        switch (prevOperand) {
            case ADDITION:
                totalValue = total + curr;
                break;
            case SUBTRACTION:
                totalValue = total - curr;
                break;
            case MULTIPLICATION:
                totalValue = total * curr;
                break;
            case DIVISION:
                totalValue = total / curr;
                break;
//                    case PERCENT:
//                        totalValue = total * (prevValue/100);
//                        break;
        }
        if (totalValue.toString().endsWith(".0")) {
            result = String.valueOf(totalValue.intValue());
        } else {
            result = Double.toString(totalValue);
        }
        return result;
    }

    public void clearAllFields() {
        totalValue = null;
        prevValue = null;
        currValue = null;
    }

    public Double getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(Double prevValue) {
        this.prevValue = prevValue;
    }

    public Double getCurrValue() {
        return currValue;
    }

    public void setCurrValue(Double currValue) {
        this.currValue = currValue;
    }

    public void setCurrValue(String value) {
        this.currValue = Double.parseDouble(value);
    }


    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
