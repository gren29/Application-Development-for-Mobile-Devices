package com.example.afinador;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private static final String tocando = "Reproduciendo: ";
    private MediaPlayer player;
    private Button bnE, bnB, bnG, bnD, bnA, bnE2, salir; TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnE = (Button)this.findViewById(R.id.cuerdaE1);
        bnB = (Button)this.findViewById(R.id.cuerdaB);
        bnG = (Button)this.findViewById(R.id.cuerdaG);
        bnD = (Button)this.findViewById(R.id.cuerdaD);
        bnA = (Button)this.findViewById(R.id.cuerdaA);
        bnE2 = (Button)this.findViewById(R.id.cuerdaE2);
        salir = (Button)this.findViewById(R.id.salir);
        tv = (TextView)this.findViewById(R.id.tv);

        bnE.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(1);
            }
        });
        bnB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(2);
            }
        });
        bnG.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(3);
            }
        });

        bnD.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(4);
            }
        });

        bnA.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(5);
            }
        });

        bnE2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(6);
            }
        });
    }

    @Override
    public void onPause(){
        try {
            super.onPause();
            player.pause();
        }catch (Exception e){}
    }

    public void onStop(){
        super.onStop();
        player.stop();
    }

    private void playSound(int arg){
        try {
            if(player.isPlaying()){
                player.stop();
                player.release();
            }
        }catch (Exception e){
            //Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
        if(arg == 1){
            player = MediaPlayer.create(this,R.raw.e6);
            tv.setText("Tocando CUERDA e");
        }
        else if(arg == 2){
            player = MediaPlayer.create(this,R.raw.b2);
            tv.setText("Tocando CUERDA B");
        }
        else if(arg == 3){
            player = MediaPlayer.create(this,R.raw.g3);
            tv.setText("Tocando CUERDA G");
        }
        else if(arg ==4){
            player = MediaPlayer.create(this,R.raw.d4);
            tv.setText("Tocando CUERDA D");
        }
        else if(arg == 5){
            player = MediaPlayer.create(this,R.raw.a5);
            tv.setText("Tocando CUERDA A");
        }
        else if(arg == 6){
            player = MediaPlayer.create(this,R.raw.e1);
            tv.setText("Tocando CUERDA e");
        }
        player.setLooping(true);
        player.start();
    }
}