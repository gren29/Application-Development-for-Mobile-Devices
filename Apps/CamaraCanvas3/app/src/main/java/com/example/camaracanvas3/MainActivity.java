package com.example.camaracanvas3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String CARPETA_PRINCIPAL = "misImagenesApp/";
    private static final String CARPETA_IMAGBN = "imagenes";
    private static final String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGBN;
    private  String path;
    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
    File fileImagen;
    Bitmap bitmap;

    private Button jbn;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbn = (Button) findViewById(R.id.xbn);
        imageView = (ImageView)findViewById(R.id.imgFoto);

        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto();
            }
        });
    }

    private  void tomarFoto(){
        File miFile = new File(Environment.getExternalStorageDirectory(),DIRECTORIO_IMAGEN);//RUTA_IMAGEN
        boolean isCreado = miFile.exists();

        if(isCreado == false){
            isCreado = miFile.mkdir();
        }
        if(isCreado){
            Long consecutivo = System.currentTimeMillis()/1000;
            String nombre = consecutivo.toString()+".jpg";

            path = Environment.getExternalStorageDirectory()+File.separator+DIRECTORIO_IMAGEN+File.separator+nombre;
            fileImagen = new File(path);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fileImagen));
            startActivityForResult(intent,COD_FOTO);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case COD_SELECCIONA:
                Uri miPath = data.getData();
                imageView.setImageURI(miPath);
                break;

            case COD_FOTO:
                MediaScannerConnection.scanFile(this, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String s, Uri uri) {
                        Log.i("Path :",""+path);
                    }
                });
                bitmap = BitmapFactory.decodeFile(path);
                imageView.setImageBitmap(bitmap);
                break;
        }
    }

    private String getCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        String n = "pic_" + sdf.format(new Date());;
        return n;
    }
}