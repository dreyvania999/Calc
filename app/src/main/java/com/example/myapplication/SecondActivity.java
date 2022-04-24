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

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView first;
    TextView second;
    TextView result;
    Spinner spinner;
    Button zero, one, two, three, four, five, six, seven, eight, nine, Sqrt, Pow, Cosinus, equals, Sinus, clear, nextPage;
    double res;
    String sing;
    boolean firstNum;
    String[] stc = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstNum = true;
        sing = "";
        res = 0;
        for (int i = 0; i < 10; i++) {
            stc[i]=" ";
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
        Sqrt = findViewById(R.id.Sqrt);
        Sinus = findViewById(R.id.Sinus);
        Cosinus = findViewById(R.id.Cosinus);
        equals = findViewById(R.id.equals);
        Pow = findViewById(R.id.Pow);
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
        Sqrt.setOnClickListener(this);
        Pow.setOnClickListener(this);
        Cosinus.setOnClickListener(this);
        equals.setOnClickListener(this);
        Sinus.setOnClickListener(this);
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


                String[] s = new String[10];
                int i;
                for (i = 0; i < 10; i++) {
                    s[i] = stc[i];
                }
                for (i = 0; i < 9; i++) {
                    stc[i + 1] = s[i];
                }


                if (res == 0 && first.getText().toString().equals("") && second.getText().toString().equals("")) {
                    result.setText("Введите числа для подсчёта");

                } else {

                    nom1 = Integer.parseInt(first.getText().toString());

                    switch (sing) {
                        case "POW":
                            nom2 = Integer.parseInt(second.getText().toString());
                            res = Math.pow(nom1, nom2);
                            break;
                        case "SQRT":
                            nom2 = Integer.parseInt(second.getText().toString());
                            res = Math.pow(nom1, 1 / nom2);
                            break;
                        case "SIN":
                            res = Math.sin(nom1);
                            break;
                        case "COS":
                            res = Math.cos(nom1);
                            break;
                    }
                    result.setText(" " +res);
                    stc[0] = first.getText().toString() + " " + sing + " " + second.getText().toString() + " = "+ res;
                    ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, stc);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);                }

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
                if (sing.equals(getsing.getText().toString())) {
                    firstNum = !firstNum;
                } else {
                    firstNum = !firstNum;
                    sing = getsing.getText().toString();
                }
                break;
            case R.id.Sinus:
            case R.id.Cosinus:
                res = 0;
                Button getsings = (Button) view;
                sing = getsings.getText().toString();
                break;

            case R.id.nextPage:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        String item = (String) parent.getSelectedItem();
        String[] s = item.split(" ");
        first.setText(s[0]);
        if (s.length>=5) {
            second.setText(s[2]);
        }
        else {
            second.setText(" ");
        }
        sing = s[1];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}