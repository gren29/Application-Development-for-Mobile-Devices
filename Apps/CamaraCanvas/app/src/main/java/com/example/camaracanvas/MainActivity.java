package com.example.camaracanvas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public Button btnTomarFoto;

    private static final int REQUEST_PERMISSION_CAMERA = 100;
    private static final int TAKE_PICTURE = 101;
    private  static final int REQUEST_PERMISSION_WRITE_STORAGE = 200;
    public Bitmap bitmap;
    public ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTomarFoto = (Button)findViewById(R.id.btnTomarFoto);

        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermisosCamara();
            }
        });
    }

    public void tomarFoto(){
        //System.out.print("TOMAR FOTO");
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i,TAKE_PICTURE);
        }

    }

    public void guardarFoto(){
        OutputStream outputStream = null;
        File file;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ContentValues values = new ContentValues();
            ContentResolver contentResolver = getContentResolver();
            String fileName = System.currentTimeMillis() + "pic";
            values.put(MediaStore.Images.Media.DISPLAY_NAME);
        }
        else{

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == TAKE_PICTURE){
            if(resultCode == Activity.RESULT_OK && data != null ){
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                tomarFoto();
            }
            else if(requestCode == REQUEST_PERMISSION_WRITE_STORAGE){
                if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    guardarFoto();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void PermisosCamara(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                tomarFoto();
            }
            else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
            }
        }else{
            tomarFoto();
        }
    }

    public void PermisoStorage(){
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.P){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    guardarFoto();
                }
                else{
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_PERMISSION_WRITE_STORAGE);
                }
            }
            else{
                guardarFoto();
            }
        }else{
            guardarFoto();
        }
    }
}