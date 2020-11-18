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

    int determinante;
    float volumen;
    ArrayList<Integer> coordeandaA = new ArrayList<Integer>();
    ArrayList<Integer> coordeandaB = new ArrayList<Integer>();
    ArrayList<Integer> coordeandaC = new ArrayList<Integer>();
    ArrayList<Integer> coordeandaD = new ArrayList<Integer>();
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
               //System.out.println("VOL : " +volumen);
            }
        });
    }

    public int Determinante(){
        int res = 0;
        int a11 = Integer.parseInt(lblv1A.getText().toString());
        int a12 = Integer.parseInt(lblv1B.getText().toString());
        int a13 = Integer.parseInt(lblv1C.getText().toString());
        int a21 = Integer.parseInt(lblv2A.getText().toString());
        int a22 = Integer.parseInt(lblv2B.getText().toString());
        int a23 = Integer.parseInt(lblv2C.getText().toString());
        int a31 = Integer.parseInt(lblv3A.getText().toString());
        int a32 = Integer.parseInt(lblv3B.getText().toString());
        int a33 = Integer.parseInt(lblv3C.getText().toString());
        coordeandaA.add(0);coordeandaA.add(0);coordeandaA.add(0);
        coordeandaB.add(a11);coordeandaB.add(a12);coordeandaB.add(a13);
        coordeandaC.add(a21);coordeandaC.add(a22);coordeandaC.add(a23);
        coordeandaD.add(a31);coordeandaD.add(a32);coordeandaD.add(a33);
        res =Math.abs ((a11 * a22 * a33) + (a12 * a23 * a31 ) + (a21 * a32 * a13) - (a13 * a22 * a31) - (a12 * a21 *a33) - (a23 *a32 *a11));
        return  res;
    }
}