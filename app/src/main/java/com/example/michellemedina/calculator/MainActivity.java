package com.example.michellemedina.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numb0;
    TextView numb1;
    TextView numb2;
    TextView numb3;
    TextView numb4;
    TextView numb5;
    TextView numb6;
    TextView numb7;
    TextView numb8;
    TextView numb9;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        onStartSetup();
        setupNumbers();
        setupAddition();
        setupClearButton();
//        setupEqualButton();
//        setupSubtraction();

    }

    private void onStartSetup() {
        if (currValue == null) {
            result.setText(String.valueOf(0));
            clearField = true;
        }
    }

    private void findViews() {
        numb0 = findViewById(R.id.zero);
        numb1 = findViewById(R.id.numb1);
        numb2 = findViewById(R.id.numb2);
        numb3 = findViewById(R.id.numb3);
        numb4 = findViewById(R.id.numb4);
        numb5 = findViewById(R.id.numb5);
        numb6 = findViewById(R.id.numb6);
        numb7 = findViewById(R.id.numb7);
        numb8 = findViewById(R.id.numb8);
        numb9 = findViewById(R.id.numb9);

        result = findViewById(R.id.result);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);

        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);

    }

    private void setupNumbers() {
        numb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 0;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 1;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 2;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 3;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 4;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 5;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 6;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 7;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 8;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

        numb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                turnPlusOff = false;
                turnMinusOff = false;
                currValue = 9;
                result.setText(result.getText() + String.valueOf(currValue));
            }
        });

    }

    private void setupAddition() {
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turnPlusOff == false) {
                    turnPlusOff = true;
                    prevValue = totalValue;
                    if (result.getText().equals("")) {
                        clearField = true;
                        currValue = 0;
                        result.setText("");
                    } else {
                        totalValue = (prevValue == null ? 0 : prevValue)  + (currValue == null ? 0 : currValue);
                        result.setText(Integer.toString(totalValue));
                        clearField = true;

                    }
                }
            }
        });

    }

//    private void setupSubtraction() {
//        subtraction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (turnMinusOff == false) {
//                    turnMinusOff = true;
//                    prevValue = totalValue;
//                    if (result.getText().equals("")) {
//                        clearField = true;
//                        currValue = 0;
//                        result.setText("");
//                    } else {
//                        currValue = Integer.parseInt(result.getText().toString());
//                        totalValue = Math.abs(prevValue) - currValue;
//                        result.setText(Integer.toString(totalValue));
//                        clearField = true;
//                    }
//                }
//
//            }
//        });
//
//    }

//    private void setupEqualButton() {
//        equals.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currValue = Integer.parseInt(result.getText().toString());
//                totalValue = prevValue + currValue;
//                result.setText(Integer.toString(totalValue));
//            }
//        });
//    }

    private void setupClearButton() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearField = true;
                totalValue = 0;
                result.setText(String.valueOf(0));
            }
        });

    }

}



