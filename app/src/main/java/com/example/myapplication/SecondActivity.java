package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView first;
    TextView second;
    TextView result;
    Button zero,one,two,three,four,five,six,seven,eight,nine,Sqrt,Pow,Cosinus,equals,Sinus,clear, next,nextPage, back;
    float res;
    String sing;
    boolean firstNum;
    String[] FirstNumber = new String[10],SecondNumber = new String[10],SingZn= new String[10];
    int stc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        firstNum = true;
        sing = "";
        res =0;
        for (int i =0; i<10;i++){
            FirstNumber[i]="";
            SecondNumber[i]="";
            SingZn[i] = "+";
        }
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
        Sqrt = findViewById(R.id.Sqrt);
        Sinus = findViewById(R.id.Sinus);
        Cosinus = findViewById(R.id.Cosinus);
        equals = findViewById(R.id.equals);
        Pow = findViewById(R.id.Pow);
        clear = findViewById(R.id.clear);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
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
        Sqrt.setOnClickListener(this);
        Pow.setOnClickListener(this);
        Cosinus.setOnClickListener(this);
        equals.setOnClickListener(this);
        Sinus.setOnClickListener(this);
        clear.setOnClickListener(this);
        nextPage.setOnClickListener(this);
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

                if (stc == -1) {
                    stc = 10;
                }
                if (stc == 10) {
                    stc = 0;
                }
                FirstNumber[stc] = first.getText().toString();
                SecondNumber[stc] = second.getText().toString();
                SingZn[stc] = sing;
                stc++;
                if (stc == -1) {
                    stc = 10;
                }
                if (stc == 10) {
                    stc = 0;
                }
                if (res == 0 && first.getText().toString() == "" && second.getText().toString() == "") {
                    result.setText("Введите числа для подсчёта");

                } else {

                    nom1 = Integer.valueOf(first.getText().toString());
                    nom2 = Integer.valueOf(second.getText().toString());
                    switch (sing) {
                        case "POW":
                            res = (float) Math.pow(nom1,nom2);
                            break;
                        case "SQRT":
                            res = (float) Math.pow(nom1,1/nom2);
                            break;
                        case "SIN":
                            res = (float) Math.sin(nom1);
                            break;
                        case "COS":
                            res = (float) Math.cos(nom1);
                            break;
                    }
                    result.setText(String.valueOf(res));
                }

                break;
            case R.id.clear:
                first.setText("");
                second.setText("");
                result.setText("");
                firstNum = true;
                res = 0;
                break;
            case R.id.Pow:
            case R.id.Sqrt:
                res = 0;
                Button getsing = (Button) view;
                if (sing == getsing.getText().toString()) {
                    firstNum = !firstNum;
                } else {
                    firstNum = !firstNum;
                    sing = getsing.getText().toString();
                }
                break;
            case R.id.Sinus:
            case R.id.Cosinus:
                res = 0;
                Button ygl = (Button) view;
                sing = ygl.getText().toString();
                break;
            case R.id.back:
                stc--;
                if (stc == -1) {
                    stc = 10;
                }
                first.setText(FirstNumber[stc]);
                second.setText(SecondNumber[stc]);
                sing = SingZn[stc];
                break;
            case R.id.next:
                stc++;
                if (stc == 10) {
                    stc = 0;
                }
                first.setText(FirstNumber[stc]);
                second.setText(SecondNumber[stc]);
                sing = SingZn[stc];
                break;
            case  R.id.nextPage:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
    }
