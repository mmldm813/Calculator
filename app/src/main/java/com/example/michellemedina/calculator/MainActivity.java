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
    TextView addition;
    TextView clear;
    TextView subtraction;
    TextView equals;

    Integer prevValue = null;
    Integer currValue = null;
    Integer totalValue = null;
    boolean clearField = false;
    boolean turnPlusOff = false;
    boolean turnMinusOff = false;

    OperandType lastOperand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        onStartSetup();
        setupAddition();
        setupClearButton();
        setupEqualButton();
        setupSubtraction();
    }

    private void onStartSetup() {
        if (currValue == null) {
            result.setText(String.valueOf(0));
            clearField = true;
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

        result = findViewById(R.id.result);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);

        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
    }

    private void setupNumberListener(int id, final int number) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                result.setText(result.getText() + String.valueOf(number));
                currValue = Integer.parseInt(result.getText().toString());
            }
        });
    }


    private void setupAddition() {
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turnPlusOff == false) {
                    turnPlusOff = true;
                    prevValue = currValue;
                    currValue = null;
                    if (result.getText().equals("")) {
                        clearField = true;
                        currValue = 0;
                        result.setText("");
                    } else {
                        lastOperand = OperandType.ADDITION;
                        if (totalValue == null) {
                            totalValue =  (prevValue == null ? 0 : prevValue) + (currValue == null ? 0 : currValue);
                        } else {
                            totalValue = totalValue + (prevValue == null ? 0 : prevValue) + (currValue == null ? 0 : currValue);
                        }
                        result.setText(Integer.toString(totalValue));
                        clearField = true;
                    }
                }
            }
        });

    }

    private void setupSubtraction() {
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turnMinusOff == false) {
                    turnMinusOff = true;
                    prevValue = currValue;
                    currValue = null;
                    if (result.getText().equals("")) {
                        clearField = true;
                        currValue = 0;
                        result.setText("");
                    } else {
                        lastOperand = OperandType.SUBTRACTION;
                        if (totalValue == null) {
                            totalValue =  (prevValue == null ? 0 : prevValue) - (currValue == null ? 0 : currValue);
                        } else {
                            totalValue = totalValue - (prevValue == null ? 0 : prevValue) - (currValue == null ? 0 : currValue);
                        }
                        result.setText(Integer.toString(totalValue));
                        clearField = true;
                    }
                }
            }
        });
    }

    private void setupEqualButton() {
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = totalValue == null ? 0 : totalValue;
                int curr = currValue == null ? 0 : currValue;
                switch (lastOperand) {
                    case ADDITION:
                        totalValue = total + curr;
                        break;
                    case SUBTRACTION:
                        totalValue = total - curr;
                        break;
                }
                result.setText(Integer.toString(totalValue));
                clearField = true;
            }
        });
    }

    private void setupClearButton() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearField = true;
                totalValue = null;
                prevValue = null;
                currValue = null;
                result.setText(String.valueOf(0));
            }
        });
    }
}



