package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView first;
    TextView second;
    TextView result;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button multiply;
    Button equals;
    Button devide;
    Button clear;
    float res;
    String sing;
    boolean firstNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = true;
        sing = "";
        res =0;
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        result = findViewById(R.id.result);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        equals = findViewById(R.id.equals);
        devide = findViewById(R.id.devide);
        clear = findViewById(R.id.clear);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        devide.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        equals.setOnClickListener(this);
        multiply.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (firstNum) {
                    numText = first.getText().toString();
                    numText += button.getText().toString();
                    first.setText(numText);
                } else {
                    numText = second.getText().toString();
                    numText += button.getText().toString();
                    second.setText(numText);
                }
                break;
            case R.id.equals:
                int nom1;
                int nom2;


                if (res == 0 && first.getText().toString() =="" && second.getText().toString() ==""){
                    result.setText("Введите числа для подсчёта");

                }
                else{
                    nom1 = Integer.valueOf(first.getText().toString());
                    nom2 = Integer.valueOf(second.getText().toString());
                    switch (sing) {
                        case "+":
                            res = nom1 +nom2;
                            break;
                        case "-":
                            res = nom1 - nom2;
                            break;
                        case "x":
                            res = nom1 * nom2;
                            break;
                        case "/":
                            res = nom1 / nom2;
                            break;
                    }
                    result.setText(String.valueOf(res));
                }

                break;
            case R.id.clear:
                first.setText("");
                second.setText("");
                firstNum = true;
                res =0;
                break;
            case R.id.multiply:
            case R.id.plus:
            case R.id.minus:
            case R.id.devide:
                res =0;
                Button getsing = (Button) view;
                if (sing == getsing.getText().toString()) {
                    firstNum = !firstNum;
                } else {
                    firstNum = !firstNum;
                    sing = getsing.getText().toString();
                }
                break;
        }
    }
}