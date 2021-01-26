package com.example.camaracanvas;

import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import android.graphics.Bitmap;
import android.os.*;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CARPETA_PRINCIPAL = "misImagenesApp/";
    private static final String CARPETA_IMAGBN = "imagenes";
    private static final String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGBN;
    private  String ruta;
    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
    File fileImagen;
    Bitmap bitmap;

    private Button jbn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbn = (Button) findViewById(R.id.xbn);

        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private String getCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        String n = "pic_" + sdf.format(new Date());;
        return n;
    }
}