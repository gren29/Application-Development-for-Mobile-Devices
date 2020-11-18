package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText lblv1A,lblv1B ,lblv1C;
    EditText lblv2A,lblv2B,lblv2C;
    EditText lblv3A,lblv3B,lblv3C;

    float determinante;
    float volumen;
    ArrayList<Float> coordeandaA = new ArrayList<Float>();
    ArrayList<Float> coordeandaB = new ArrayList<Float>();
    ArrayList<Float> coordeandaC = new ArrayList<Float>();
    ArrayList<Float> coordeandaD = new ArrayList<Float>();
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
               determinante = Determinante();
               volumen = determinante / 6;
               Intent myIntent = new Intent(MainActivity.this,FiguraCanvas.class);
               Bundle bn = new Bundle();
               bn.putFloat("VOLUMEN",volumen);
               bn.putSerializable("COORA",coordeandaA);
                bn.putSerializable("COORB",coordeandaB);
                bn.putSerializable("COORC",coordeandaC);
                bn.putSerializable("COORD",coordeandaD);
               myIntent.putExtras(bn);
               startActivity(myIntent);
            }
        });
    }

    public float Determinante(){
        float res = 0;
        float a11 = Float.parseFloat(lblv1A.getText().toString());
        float a12 = Float.parseFloat(lblv1B.getText().toString());
        float a13 = Float.parseFloat(lblv1C.getText().toString());
        float a21 = Float.parseFloat(lblv2A.getText().toString());
        float a22 = Float.parseFloat(lblv2B.getText().toString());
        float a23 = Float.parseFloat(lblv2C.getText().toString());
        float a31 = Float.parseFloat(lblv3A.getText().toString());
        float a32 = Float.parseFloat(lblv3B.getText().toString());
        float a33 = Float.parseFloat(lblv3C.getText().toString());
        coordeandaA.add(0.0F);coordeandaA.add(0.0F);coordeandaA.add(0.0F);
        coordeandaB.add(a11);coordeandaB.add(a12);coordeandaB.add(a13);
        coordeandaC.add(a21);coordeandaC.add(a22);coordeandaC.add(a23);
        coordeandaD.add(a31);coordeandaD.add(a32);coordeandaD.add(a33);
        res =Math.abs ((a11 * a22 * a33) + (a12 * a23 * a31 ) + (a21 * a32 * a13) - (a13 * a22 * a31) - (a12 * a21 *a33) - (a23 *a32 *a11));
        return  res;
    }
}