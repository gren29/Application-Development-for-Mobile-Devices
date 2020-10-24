package com.example.tarea4intentb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText lblA;
    EditText lblB;
    EditText lblC;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblA = (EditText)findViewById(R.id.lblA);
        lblB = (EditText)findViewById(R.id.lblB);
        lblC = (EditText)findViewById(R.id.lblC);
        btnAceptar = (Button)findViewById(R.id.btnACeptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,Home.class);
                Bundle bundle =  new Bundle();
                bundle.putString("A",lblA.getText().toString());
                bundle.putString("B",lblB.getText().toString());
                bundle.putString("C",lblC.getText().toString());
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
    }
}