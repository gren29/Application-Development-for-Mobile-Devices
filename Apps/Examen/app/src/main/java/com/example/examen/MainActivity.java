package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText lblv1A;
    EditText lblv1B;
    EditText lblv1C;
    EditText lblv2A;
    EditText lblv2B;
    EditText lblv2C;
    EditText lblv3A;
    EditText lblv3B;
    EditText lblv3C;

    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblv1A = (EditText)findViewById(R.id.v1A);
        lblv1B = (EditText)findViewById(R.id.v1B);
        lblv1C = (EditText)findViewById(R.id.v1C);
        lblv2A = (EditText)findViewById(R.id.v2A);
        lblv2B = (EditText)findViewById(R.id.v2B);
        lblv2C = (EditText)findViewById(R.id.v2C);
        lblv3A = (EditText)findViewById(R.id.v3A);
        lblv3B = (EditText)findViewById(R.id.v3B);
        lblv3C = (EditText)findViewById(R.id.v3C);
        btnAceptar = (Button)findViewById(R.id.btnACeptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent(MainActivity.this,Home.class);
                Bundle bundle =  new Bundle();
                //bundle.putString("A",lblA.getText().toString());
               // bundle.putString("B",lblB.getText().toString());
                //bundle.putString("C",lblC.getText().toString());
                //myIntent.putExtras(bundle);
                // startActivity(myIntent);
            }
        });
    }
}