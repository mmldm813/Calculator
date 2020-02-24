package com.example.michellemedina.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum OperandType {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION
    }

    TextView result;
    TextView clear;
    TextView equals;

    Double prevValue = null;
    Double currValue = null;
    Double totalValue = null;

    boolean clearResultField = false;
    boolean turnPlusOff = false;
    boolean turnMinusOff = false;
    boolean turnMultiplicationOff = false;
    boolean turnDivisionOff = false;

    OperandType lastOperand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        onStartSetup();
        setupClearButton();
        setupEqualButton();
    }

    private void onStartSetup() {
        if (currValue == null) {
            result.setText(String.valueOf(0));
            clearResultField = true;
        }
    }

    private void findViews() {
        setupNumberListener(R.id.zero, 0);
        setupNumberListener(R.id.numb1, 1);
        setupNumberListener(R.id.numb2, 2);
        setupNumberListener(R.id.numb3, 3);
        setupNumberListener(R.id.numb4, 4);
        setupNumberListener(R.id.numb5, 5);
        setupNumberListener(R.id.numb6, 6);
        setupNumberListener(R.id.numb7, 7);
        setupNumberListener(R.id.numb8, 8);
        setupNumberListener(R.id.numb9, 9);

        setLastOperand(R.id.addition, OperandType.ADDITION);
        setLastOperand(R.id.subtraction, OperandType.SUBTRACTION);
        setLastOperand(R.id.multiplication, OperandType.MULTIPLICATION);
        setLastOperand(R.id.division, OperandType.DIVISION);

        result = findViewById(R.id.result);

        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        addingDecimal(R.id.decimal);
    }

    private void setupNumberListener(int id, final int number) {
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
                result.setText(result.getText() + String.valueOf(number));
                currValue = Double.parseDouble(result.getText().toString());
            }
        });
    }

    private void addingDecimal(int id) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearResultField) {
                    result.setText("");
                    clearResultField = false;
                }
                if (!result.getText().toString().contains(".")) {
                    result.setText(result.getText() + (result.getText().equals("") ? "0." : "."));
                    currValue = Double.parseDouble(result.getText().toString());
                }
            }
        });
    }

    private void setLastOperand(int id, final OperandType lastOperandType) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turnPlusOff == false || turnMinusOff == false || turnMultiplicationOff == false
                        || turnDivisionOff == false) {
                    turnPlusOff = true;
                    turnMinusOff = true;
                    turnMultiplicationOff = true;
                    turnDivisionOff = true;
                    prevValue = currValue;
                    currValue = null;
                    if (result.getText().equals("")) {
                        clearResultField = true;
                        currValue = 0.0;
                        result.setText("");
                    } else {
                        lastOperand = lastOperandType;
                        switch (lastOperand) {
                            case ADDITION:
                                if (totalValue == null) {
                                    totalValue = (prevValue == null ? 0 : prevValue) + (currValue == null ? 0 : currValue);
                                } else {
                                    prevValue = null;
                                    totalValue = totalValue + (currValue == null ? 0 : currValue);
                                }
                                break;
                            case SUBTRACTION:
                                if (totalValue == null) {
                                    totalValue = (prevValue == null ? 0 : prevValue) - (currValue == null ? 0 : currValue);
                                } else {
                                    prevValue = null;
                                    totalValue = totalValue - (currValue == null ? 0 : currValue);
                                }
                                break;
                            case MULTIPLICATION:
                                if (totalValue == null) {
                                    totalValue = (prevValue == null ? 1 : prevValue) * (currValue == null ? 1 : currValue);
                                } else {
                                    prevValue = null;
                                    totalValue = totalValue * (currValue == null ? 1 : currValue);
                                }
                                break;
                            case DIVISION:
                                if (totalValue == null) {
                                    totalValue = (prevValue == null ? 1 : prevValue) / (currValue == null ? 1 : currValue);
                                } else {
                                    prevValue = null;
                                    totalValue = totalValue / (currValue == null ? 1 : currValue);
                                }
                                break;

                        }
                        if (totalValue.toString().endsWith(".0")) {
                            result.setText(String.valueOf(totalValue.intValue()));
                        } else {
                            result.setText(Double.toString(totalValue));
                        }
                        clearResultField = true;
                    }
                }
            }
        });
    }

    private void setupEqualButton() {
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = totalValue == null ? 0 : totalValue;
                double curr = currValue == null ? 0 : currValue;
                switch (lastOperand) {
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
                }
                if (totalValue.toString().endsWith(".0")) {
                    result.setText(String.valueOf(totalValue.intValue()));
                } else {
                    result.setText(Double.toString(totalValue));
                }
                clearResultField = true;
            }
        });
    }

    private void setupClearButton() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearResultField = true;
                totalValue = null;
                prevValue = null;
                currValue = null;
                result.setText(String.valueOf(0));
            }
        });
    }
}



