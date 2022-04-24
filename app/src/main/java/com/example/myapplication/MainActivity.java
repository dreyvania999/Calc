package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView first;
    TextView second;
    TextView result;
    Spinner spinner;
    Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multiply, equals, devide, clear, nextPage;
    double res;
    String sing;
    boolean firstNum;
    String[]  str = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = true;
        sing = "";
        res = 0.0;
        for (int i = 0; i < 10; i++) {
            str[i] = "";
        }
        spinner = findViewById(R.id.spinner);

        nextPage = findViewById(R.id.nextPage);
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
        devide = findViewById(R.id.divide);
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
        nextPage.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
        spinner.setPrompt("Title");

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

                String[] s =new String[10];
                int i;
                for (i =0;i<10;i++) {
                    s[i] =str[i] ;
                }
                for (i =0;i<9;i++) {
                    str[i+1] = s[i];
                }

                if (res == 0 && first.getText().toString().equals("") && second.getText().toString().equals("")) {
                    result.setText("Введите числа для подсчёта");

                } else {

                    nom1 = Integer.valueOf(first.getText().toString());
                    nom2 = Integer.valueOf(second.getText().toString());
                    switch (sing) {
                        case "+":
                            res = nom1 + nom2;
                            break;
                        case "-":
                            res = nom1 - nom2;
                            break;
                        case "*":
                            res = nom1 * nom2;
                            break;
                        case "/":
                            res = (double) nom1/nom2;
                            break;
                    }
                    result.setText(" " +res);
                    str[0] = first.getText().toString() + " " + sing + " " + second.getText().toString() + " = "+ res;
                    ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, str);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);

                }

                break;
            case R.id.clear:
                first.setText("");
                second.setText("");
                result.setText("");
                firstNum = true;
                res = 0;
                break;
            case R.id.multiply:
            case R.id.plus:
            case R.id.minus:
            case R.id.divide:
                res = 0;
                Button getsing = (Button) view;
                if (sing.equals(getsing.getText().toString())) {
                    firstNum = !firstNum;
                } else {
                    firstNum = !firstNum;
                    sing = getsing.getText().toString();
                }
                break;

            case R.id.nextPage:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        String item = (String) parent.getSelectedItem();
        String[] s = item.split(" ");
        first.setText(s[0]);
        second.setText(s[2]);
        sing = s[1];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}