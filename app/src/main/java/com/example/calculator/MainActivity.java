package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, clear_btn, power_btn, percent_btn, division_btn, multiply_btn, substraction_btn, addition_btn, equal_btn, point_btn;
    TextView angkaMasuk, angkaKeluar;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        addition_btn = findViewById(R.id.addition_btn);
        substraction_btn = findViewById(R.id.substraction_btn);
        division_btn = findViewById(R.id.division_btn);
        multiply_btn = findViewById(R.id.multiply_btn);

        equal_btn = findViewById((R.id.equal_btn);

        clear_btn = findViewById(R.id.clear_btn);
        point_btn = findViewById(R.id.point_btn);
        percent_btn = findViewById(R.id.percent_btn);
        power_btn = findViewById(R.id.power_btn);

        angkaMasuk = findViewById(R.id.angkaMasuk);
        angkaKeluar = findViewById(R.id.angkaKeluar);

        power_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                angkaMasuk.setText("");
                angkaKeluar.setText("");
            }
        });

        btn0.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"0");
            }
        });

        btn1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"1");
            }
        });

        btn2.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"2");
            }
        });

        btn3.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"3");
            }
        });

        btn4.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"4");
            }
        });

        btn5.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"5");
            }
        });

        btn6.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"6");
            }
        });

        btn7.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"7");
            }
        });

        btn8.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"8");
            }
        });

        btn9.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"9");
            }
        });

        addition_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "+");
            }
        });

        substraction_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"-");
            }
        });

        multiply_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"x");
            }
        });

        division_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"/");
            }
        });

        point_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +",");
            }
        });

        percent_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process +"%");
            }
        });

        power_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               String word = angkaMasuk.getText().toString();
               int input = word.length();
               if (input > 0) {
                   angkaMasuk.setText(word.substring(0 input - 1));
                }
            }
        });



        equal_btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("/", "/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process, "javascript", 1, null).toString();
                }catch (Exception e){
                    finalResult="0";
                }
                angkaKeluar.setText(finalResult);
            }
        });




    }
}