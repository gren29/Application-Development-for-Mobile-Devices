package com.example.tarea4intenta;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends Activity {
    EditText lblNombre;
    EditText lblApellido;
    Button btnAceptar;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblNombre = (EditText)findViewById(R.id.lblNombre);
        lblApellido = (EditText)findViewById(R.id.lblApellido);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Home.class);
                bundle = new Bundle();
                bundle.putString("NOMBRE",lblNombre.getText().toString());
                bundle.putString("APELLIDO",lblApellido.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);;
            }
        });
    }
}