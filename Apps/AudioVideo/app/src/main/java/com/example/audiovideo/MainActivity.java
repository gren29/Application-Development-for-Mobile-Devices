package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity  {
    ImageButton jbn1, jbn2, jbn3, jbn4,jbn5,jbn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbn1 = (ImageButton) findViewById(R.id.xbn1);
        jbn2 = (ImageButton) findViewById(R.id.xbn2);
        jbn3 = (ImageButton) findViewById(R.id.xbn3);
        jbn4 = (ImageButton) findViewById(R.id.xbn4);
        jbn5 = (ImageButton) findViewById(R.id.xbn5);
        jbn6 = (ImageButton) findViewById(R.id.xbn6);


      jbn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myInten = new Intent(MainActivity.this,Second.class);
              Bundle bdl = new Bundle();
              bdl.putString("ID", "adele_hello");
              myInten.putExtras(bdl);
              startActivity(myInten);
          }
      });

        jbn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInten = new Intent(MainActivity.this,Second.class);
                Bundle bdl = new Bundle();
                bdl.putString("ID", "you_got_it");
                myInten.putExtras(bdl);
                startActivity(myInten);
            }
        });

        jbn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInten = new Intent(MainActivity.this,Second.class);
                Bundle bdl = new Bundle();
                bdl.putString("ID", "ahhh");
                myInten.putExtras(bdl);
                startActivity(myInten);
            }
        });

        jbn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInten = new Intent(MainActivity.this,Second.class);
                Bundle bdl = new Bundle();
                bdl.putString("ID", "aplauso");
                myInten.putExtras(bdl);
                startActivity(myInten);
            }
        });
        jbn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInten = new Intent(MainActivity.this,Second.class);
                Bundle bdl = new Bundle();
                bdl.putString("ID", "this_is_love");
                myInten.putExtras(bdl);
                startActivity(myInten);
            }
        });
        jbn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInten = new Intent(MainActivity.this,Second.class);
                Bundle bdl = new Bundle();
                bdl.putString("ID", "this_is_love");
                myInten.putExtras(bdl);
                startActivity(myInten);
            }
        });
    }


}