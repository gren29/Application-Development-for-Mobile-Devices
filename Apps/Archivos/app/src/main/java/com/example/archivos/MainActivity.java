package com.example.archivos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String		s;
    InputStream	is;
    InputStreamReader isr;
    BufferedReader  br;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        tv	= (TextView) findViewById(R.id.xtv);
        tv.append("\nAbriendo: res/raw/misdatos.txt"); // NOTA: este es su archivo.
        is	= getResources().openRawResource(R.raw.misdatos);
        isr	= new InputStreamReader(is);
        br	= new BufferedReader(isr, 8192);
        try{
            while( null != (s=br.readLine()) )
                tv.append("\n" + s);
            is.close();
            isr.close();
            br.close();
        } catch(Exception e){
            tv.append("\n " + e);
        }
        tv.append("\nEnd of file.");
    }
}