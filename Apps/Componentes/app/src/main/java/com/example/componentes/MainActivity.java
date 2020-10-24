package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent itn;
    Bundle bd1;
    EditText jet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.xed);
         Button jbn7 = (Button) findViewById(R.id.xbn7);
         Button jbn8 = (Button) findViewById(R.id.xbn8);
         Button jbn9 = (Button) findViewById(R.id.xbn9);
         Button jbn4 = (Button) findViewById(R.id.xbn4);
         Button jbn5 = (Button) findViewById(R.id.xbn5);
         Button jbn6 = (Button) findViewById(R.id.xbn6);
         Button jbn1 = (Button) findViewById(R.id.xbn1);
         Button jbn2 = (Button) findViewById(R.id.xbn2);
         Button jbn3 = (Button) findViewById(R.id.xbn3);
         Button jbn0 = (Button) findViewById(R.id.xbn0);
         Button clr = (Button) findViewById(R.id.xbnClear);
         Button res = (Button) findViewById(R.id.xbnRes);

         jbn0.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 jet.append("0");
             }
         });
        jbn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("1");
            }
        });
        jbn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("2");
            }
        });
        jbn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("3");
            }
        });
        jbn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("4");
            }
        });
        jbn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("5");
            }
        });
        jbn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("6");
            }
        });
        jbn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("7");
            }
        });
        jbn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("8");
            }
        });
        jbn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.append("9");
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jet.setText("");
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = jet.getText().toString();
                itn = new Intent(MainActivity.this, Home.class);
                bd1 = new Bundle();
                bd1.putString("NUMERO", num);
                itn.putExtras(bd1);
                startActivity(itn);
            }
        });
    }
}