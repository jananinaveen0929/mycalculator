package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyCalcBrain calculator;  //declare object for my brain class
    Button btnAdd, btnSub, btnMul, btnDiv;
    EditText edt1, edt2;
    TextView txtResult;
    double num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calculator = new MyCalcBrain();//initialize object for my brain class

        edt1 = findViewById(R.id.number1);
        edt2 = findViewById(R.id.number2);

        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        btnMul = findViewById(R.id.multiply);
        btnDiv = findViewById(R.id.divide);

        txtResult = findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }) ;
    }

    public double getNumbers(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter number 1", Toast.LENGTH_SHORT).show();
            return Double.NaN;
        } else {
            return Double.parseDouble(editText.getText().toString());
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        num1 = getNumbers(edt1);
        num2 = getNumbers(edt2);

        if (num1 == 0 || num2 == 0) {
            return;
        }
        double result = 0;
        try {
            int viewId = v.getId();
            if (viewId == R.id.add) {
                result = calculator.add(num1, num2);
            } else if (viewId == R.id.sub) {
                result = calculator.subtract(num1, num2);
            } else if (viewId == R.id.multiply) {
                result = calculator.multiply(num1, num2);
            } else if (viewId == R.id.divide) {
                result = calculator.divide(num1, num2);
            }
             txtResult.setText(String.format("Result: %.2f", result));

            }
        catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            txtResult.setText("Error: Divide by Zero");


        }
    }
}