package com.example.michellemedina.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.michellemedina.calculator.Calculations.OperandType.ADDITION;
import static com.example.michellemedina.calculator.Calculations.OperandType.MULTIPLICATION;
import static com.example.michellemedina.calculator.Calculations.OperandType.SUBTRACTION;
import static com.example.michellemedina.calculator.Calculations.OperandType.DIVISION;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView clear;

    private boolean clearResultField;
    private boolean turnPlusOff;
    private boolean turnMinusOff;
    private boolean turnMultiplicationOff;
    private boolean turnDivisionOff;
    private boolean turnPercentOff;

    private Calculations calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculations = new Calculations();

        findViews();
        onStartSetup();
        setupClearButton();
        setupEqualButton();

    }

    private void onStartSetup() {
        if (calculations.getCurrValue() == null) {
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

        executeOperation(R.id.addition, ADDITION);
        executeOperation(R.id.subtraction, SUBTRACTION);
        executeOperation(R.id.multiplication, MULTIPLICATION);
        executeOperation(R.id.division, DIVISION);
//        executeOperation(R.id.percent, OperandType.PERCENT);

        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);

        addingDecimal(R.id.decimal);
        addingNegative(R.id.negative);
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
                calculations.setCurrValue(result.getText().toString());
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
                    calculations.setCurrValue(result.getText().toString());
                }
            }
        });
    }

    private void addingNegative(int id) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearResultField) {
                    result.setText("");
                    clearResultField = false;
                }
                if (!result.getText().toString().contains("-")) {
                    result.setText("-" + result.getText());
                    calculations.setCurrValue(result.getText().toString());
                }
            }
        });
    }

    void executeOperation(int id, final Calculations.OperandType operand) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turnPlusOff || !turnMinusOff || !turnMultiplicationOff
                        || !turnDivisionOff || !turnPercentOff) {
                    turnPlusOff = true;
                    turnMinusOff = true;
                    turnMultiplicationOff = true;
                    turnDivisionOff = true;
//                    turnPercentOff = true;
                    if (result.getText().equals("")) {
                        clearResultField = true;
                        calculations.setCurrValue(0.0);
                        result.setText("");
                    } else {
                        result.setText(calculations.performMath(operand));
                        clearResultField = true;
                    }
                }
            }
        });
    }

    void setupEqualButton() {
        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(calculations.performEqual());
                clearResultField = true;
            }
        });
    }

    private void setupClearButton() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearResultField = true;
                calculations.clearAllFields();
                result.setText(String.valueOf(0));
            }
        });
    }
}



