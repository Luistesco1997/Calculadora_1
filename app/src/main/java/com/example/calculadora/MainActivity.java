package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int num = 0;
    private EditText et1;
    private Button btn_suma, btn_resta, btn_div, btn_mult, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8;
    private Button btn_9, btn_0, btn_dot, btn_equals, btn_clear, btn_drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et_1);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_dot = findViewById(R.id.btn_dot);

        btn_clear = findViewById(R.id.btn_clear);
        btn_drop = findViewById(R.id.btn_drop);

        btn_suma = findViewById(R.id.btn_sum);
        btn_resta = findViewById(R.id.btn_res);
        btn_mult = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);

        btn_equals = findViewById(R.id.btn_equals);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("0"));
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("1"));
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("2"));
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("3"));
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("4"));
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("5"));
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("6"));
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("7"));
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("8"));
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_num("9"));
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().substring(et1.getText().length() - 1, et1.getText().length()).equals("."))
                {
                    et1.setText(et1.getText());
                }else
                {
                    if(num == 0)
                    {
                        et1.setText(et1.getText() + ".");
                    }
                }
                num = 1;
            }
        });

        // btn functions

        btn_drop.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (et1.getText().length() > 1) {
                    et1.setText("" + et1.getText().subSequence(0, et1.getText().length() - 1));
                } else {
                    et1.setText("0");
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("0");
            }
        });

        //btn opera
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_ope("+"));
            }
        });

        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_ope("-"));
            }
        });

        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_ope("*"));
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(eval_ope("/"));
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                et1.setText("" + new convert_post().convert(et1.getText().toString()));
            }
        });

    }

    public String eval_num(String num)
    {
        if (et1.getText().length() == 1 && et1.getText().toString().equals("0"))
        {
            if(num.equals("0") && et1.getText().toString().equals("0"))
            {
                return "0";
            }else
            {
                return num;
            }
        }else
        {
            return et1.getText() + "" + num;
        }
    }

    public String eval_ope(String Signo)
    {
        String signos = "+-*/";
        num = 0;
        if(signos.contains(et1.getText().toString().substring(et1.getText().length()-1, et1.getText().length())))
        {
            return  et1.getText().toString().substring(0, et1.getText().length() - 1) + Signo;
        }else
        {
            return et1.getText() + Signo + "";
        }
    }
}
