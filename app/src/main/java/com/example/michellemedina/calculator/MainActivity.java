package com.example.michellemedina.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import static com.example.michellemedina.calculator.CalculationsEngine.OperandType.ADDITION;
import static com.example.michellemedina.calculator.CalculationsEngine.OperandType.MULTIPLICATION;
import static com.example.michellemedina.calculator.CalculationsEngine.OperandType.PERCENT;
import static com.example.michellemedina.calculator.CalculationsEngine.OperandType.SUBTRACTION;
import static com.example.michellemedina.calculator.CalculationsEngine.OperandType.DIVISION;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView clear;

    private boolean clearResultField;
    private boolean turnPlusOff;
    private boolean turnMinusOff;
    private boolean turnMultiplicationOff;
    private boolean turnDivisionOff;
    private boolean turnPercentOff;

    private CalculationsEngine calculationsEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationsEngine = new CalculationsEngine();

        findViews();
        onStartSetup();
        clearPressed();
        equalPressed();

    }

    private void onStartSetup() {
        if (calculationsEngine.getCurrValue() == null) {
            result.setText(String.valueOf(BigDecimal.ZERO));
            clearResultField = true;
        }
    }

    private void findViews() {
        enterNumber(R.id.zero, 0);
        enterNumber(R.id.numb1, 1);
        enterNumber(R.id.numb2, 2);
        enterNumber(R.id.numb3, 3);
        enterNumber(R.id.numb4, 4);
        enterNumber(R.id.numb5, 5);
        enterNumber(R.id.numb6, 6);
        enterNumber(R.id.numb7, 7);
        enterNumber(R.id.numb8, 8);
        enterNumber(R.id.numb9, 9);

        pressingOperandButton(R.id.addition, ADDITION);
        pressingOperandButton(R.id.subtraction, SUBTRACTION);
        pressingOperandButton(R.id.multiplication, MULTIPLICATION);
        pressingOperandButton(R.id.division, DIVISION);
        pressingOperandButton(R.id.percent, PERCENT);

        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);

        addDecimal(R.id.decimal);
        addNegative(R.id.negative);
    }

    private void enterNumber(int id, final int number) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearResultField) {
                    result.setText("");
                    clearResultField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                turnMultiplicationOff = false;
                turnDivisionOff = false;
                turnPercentOff = false;
                result.setText(result.getText() + String.valueOf(number));
                calculationsEngine.setCurrValue(result.getText().toString());
            }
        });
    }

    private void addDecimal(int id) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearResultField) {
                    result.setText("");
                    clearResultField = false;
                }
                if (!result.getText().toString().contains(".")) {
                    result.setText(result.getText() + (result.getText().equals("") ? "0." : "."));
                    calculationsEngine.setCurrValue(result.getText().toString());
                }
            }
        });
    }

    private void addNegative(int id) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultStr = result.getText().toString();
                if (clearResultField) {
                    result.setText(String.valueOf(BigDecimal.ZERO));
                    clearResultField = false;
                }
                if (resultStr.length() > 0 && !resultStr.contains("-") && !resultStr.equals(String.valueOf(BigDecimal.ZERO))) {
                    result.setText("-" + result.getText());
                    calculationsEngine.setCurrValue(result.getText().toString());
                }
            }
        });
    }

    void pressingOperandButton(int id, final CalculationsEngine.OperandType operand) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turnPlusOff || !turnMinusOff || !turnMultiplicationOff
                        || !turnDivisionOff || !turnPercentOff) {
                    turnPlusOff = true;
                    turnMinusOff = true;
                    turnMultiplicationOff = true;
                    turnDivisionOff = true;
                    turnPercentOff = true;
                    if (result.getText().equals("")) {
                        clearResultField = true;
                        calculationsEngine.setCurrValue(BigDecimal.ZERO);
                        result.setText("");
                    } else {
                        result.setText(calculationsEngine.pressedOperandButtonPerformsCalculation(operand));
                        clearResultField = true;
                        if (operand == PERCENT) {
                            turnPlusOff = false;
                            turnMinusOff = false;
                            turnMultiplicationOff = false;
                            turnDivisionOff = false;
                            turnPercentOff = false;
                        }
                    }
                }
            }
        });
    }

    void equalPressed() {
        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(calculationsEngine.pressedEqualCalculation());
                clearResultField = true;
            }
        });
    }

    private void clearPressed() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearResultField = true;
                calculationsEngine.clearAllFields();
                result.setText(String.valueOf(BigDecimal.ZERO));
            }
        });
    }
}



