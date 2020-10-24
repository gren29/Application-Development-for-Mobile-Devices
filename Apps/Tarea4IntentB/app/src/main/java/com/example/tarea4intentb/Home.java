package com.example.tarea4intentb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;

public class Home extends Activity {

    TextView lblRespuesta;
    Button btnNuevo;
    Bundle bundle;
    int a;
    int b;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lblRespuesta = (TextView)findViewById(R.id.lblRespuesta);
        btnNuevo = (Button)findViewById(R.id.btnNuevo);

        bundle = getIntent().getExtras();
        a = Integer.parseInt(bundle.getString("A"));
        b = Integer.parseInt(bundle.getString("B"));
        c = Integer.parseInt(bundle.getString("C"));

        Ecuacion(a,b,c);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Home.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void  Ecuacion(int a, int b, int c){
        float x1;
        float x2;
        float raiz = (float) Math.pow(b,2) - (4 * a * c);

        if(raiz < 0){
            lblRespuesta.setText("Math ERROR");
        }
        else{
            x1 = (float) (((-(b))+ Math.sqrt(raiz))/(2 * a));
            x2 = (float) (((-(b) )- Math.sqrt(raiz))/(2 * a));
            lblRespuesta.setText("X1 = "+ x1 + "   X2 = "+x2);
        }
    }
}

