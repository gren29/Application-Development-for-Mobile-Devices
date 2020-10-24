package com.example.tarea4intenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Debug;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class Home extends Activity {
    TextView lblNombreApellido;
    Bundle bundle;
    String nombre;
    String apellido;
    Button btnRegresar;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_home);
        lblNombreApellido = (TextView)findViewById(R.id.lblApellidoNombre);
        btnRegresar = (Button)findViewById(R.id.btnRegresar);
        bundle = getIntent().getExtras();
        nombre = bundle.getString("NOMBRE");
        apellido = bundle.getString("APELLIDO");
        lblNombreApellido.setText(nombre +  " " + apellido);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Home.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
