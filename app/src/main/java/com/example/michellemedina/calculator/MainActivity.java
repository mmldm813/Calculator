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

    int prevValue;
    int currValue;
    boolean clearField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupNumbers();
        setupAddition();
        setupClearButton();
//        setupSubtraction();

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

    }

    private void setupNumbers() {
        numb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(0));
            }
        });

        numb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText() + String.valueOf(1));
            }
        });

        numb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(2));
            }
        });

        numb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(3));
            }
        });

        numb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(4));
            }
        });

        numb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(5));
            }
        });

        numb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(6));
            }
        });

        numb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(7));
            }
        });

        numb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(8));
            }
        });

        numb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearField) {
                    result.setText("");
                    clearField = false;
                }
                result.setText(result.getText()+ String.valueOf(9));
            }
        });

    }

    private void setupAddition() {

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().equals("")) {
                    clearField = true;
                    currValue = 0;
                    result.setText("");
                } else {
                    currValue = Integer.parseInt(result.getText().toString());
                    prevValue = prevValue + currValue;
                    result.setText(Integer.toString(prevValue));
                    clearField = true;
                }
            }
        });

    }

//    private void setupSubtraction() {
//        subtraction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (result.getText().equals("")) {
//                    clearField = true;
//                    currValue = 0;
//                    result.setText("");
//                } else {
//                    currValue = Integer.parseInt(result.getText().toString());
//                    prevValue = prevValue - currValue;
//                    result.setText(Integer.toString(prevValue));
//                    clearField = true;
//                }
//            }
//        });

//    }

    private void setupClearButton() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearField = true;
                prevValue = 0;
                result.setText("");
            }
        });

    }

}



