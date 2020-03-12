package com.example.michellemedina.calculator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private CalculationsEngine calculationsEngine = new CalculationsEngine();

    @Test
    public void addTwoNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        assertEquals("5", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractTwoNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(5));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        assertEquals("2", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void multiplyTwoNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        assertEquals("6", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void divideTwoNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(8));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(4));
        assertEquals("2", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void addTwoNegativeNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("-5", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractTwoNegativeNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-5));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("-2", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void multiplyTwoNegativeNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("6", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void divideTwoNegativeNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-6));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("2", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void addOnePositiveAndOneNegativeNumberUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        assertEquals("1", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractOnePositiveAndOneNegativeNumberUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(-2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        assertEquals("-5", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractOnePositiveAndOneNegativeNumberReversedUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("5", calculationsEngine.pressedEqualCalculation());
    }


    @Test
    public void multiplyOnePositiveAndOneNegativeNumberUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("-6", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void divideOnePositiveAndOneNegativeNumberUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(6));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        assertEquals("-2", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void addMultipleNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(1));
        assertEquals("6", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractMultipleNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(8));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(1));
        assertEquals("4", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void multiplyMultipleNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(4));
        assertEquals("24", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void divideMultipleNumbersUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(18));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(2));
        assertEquals("3", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void addMultipleNumbersPositiveAndNegativeUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(1));
        assertEquals("0", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractMultipleNumbersPositiveAndNegativeUsingEqual() {
        calculationsEngine.setCurrValue(new BigDecimal(8));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.SUBTRACTION);
        calculationsEngine.setCurrValue(new BigDecimal(1));
        assertEquals("10", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void multiplyMultipleNumbersPositiveAndNegativeUsingEquals() {
        calculationsEngine.setCurrValue(new BigDecimal(2));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.MULTIPLICATION);
        calculationsEngine.setCurrValue(new BigDecimal(4));
        assertEquals("-24", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void divideMultipleNumbersPositiveAndNegativeUsingEquals() {
        calculationsEngine.setCurrValue(new BigDecimal(18));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(-3));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.DIVISION);
        calculationsEngine.setCurrValue(new BigDecimal(2));
        assertEquals("-3", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void addingNumbersWithDecimalsUsingEquals() {
        calculationsEngine.setCurrValue(new BigDecimal(2.3).setScale(1, RoundingMode.HALF_UP));
        calculationsEngine.pressedOperandButtonPerformsCalculation(CalculationsEngine.OperandType.ADDITION);
        calculationsEngine.setCurrValue(new BigDecimal(3.2).setScale(1, RoundingMode.HALF_UP));
        assertEquals("5.5", calculationsEngine.pressedEqualCalculation());
    }

    @Test
    public void subtractingNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void multiplyNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void divideNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void addingMultipleNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void subtractingMultipleNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void multiplyingMultipleNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void dividingMultipleNumbersWithDecimalsUsingEquals() {

    }

    @Test
    public void addingPositiveAndNegativeDecimalsUsingEquals() {

    }

    @Test
    public void subtractingPositiveAndNegativeDecimalsUsingEquals() {

    }

    @Test
    public void multiplyingPositiveAndNegativeDecimalsUsingEquals() {

    }

    @Test
    public void dividingPositiveAndNegativeDecimalsUsingEquals() {

    }



}