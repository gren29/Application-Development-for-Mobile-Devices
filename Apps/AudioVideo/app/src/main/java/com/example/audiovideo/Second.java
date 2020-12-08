package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.*;

public class Second extends AppCompatActivity {
    Bundle bdl;
    String res;
    MediaPlayer mp;
    Button jbn;
    VideoView vvw;
    ImageView portada;
    Uri uri;
    MediaController mcr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bdl = getIntent().getExtras();
        res = bdl.getString("ID");
        jbn = (Button)findViewById(R.id.btnRepro);
        portada = (ImageView) findViewById(R.id.imagen);

        if( res.equals("adele_hello")){
            portada.setVisibility(View.VISIBLE);
            portada.setImageResource(R.drawable.muse1);
            reproducir(R.raw.adele_hello);
        }
        if( res.equals("you_got_it")){
            portada.setVisibility(View.VISIBLE);
            portada.setImageResource(R.drawable.muse2);
            reproducir(R.raw.you_got_it);
        }
        if( res.equals("ahhh")){
            portada.setVisibility(View.VISIBLE);
            portada.setImageResource(R.drawable.tdcc1);
            reproducir(R.raw.ahhh);
        }
        if( res.equals("aplauso")){
            portada.setVisibility(View.VISIBLE);
            portada.setImageResource(R.drawable.tdcc2);
            reproducir(R.raw.aplauso);
        }
        if( res.equals("this_is_love")){
            vvw = (VideoView)findViewById(R.id.video);
            vvw.setVisibility(View.VISIBLE);
            jbn.setVisibility(View.VISIBLE);
            uri = Uri.parse("android.resource://com.example.audiovideo/"+ R.raw.this_is_love);
            mcr = new MediaController(this);
            vvw.setMediaController(mcr);
            vvw.setVideoURI(uri);
            vvw.start();
        }
        if( res.equals("this_is_love")){
            jbn.setVisibility(View.VISIBLE);
            vvw = (VideoView)findViewById(R.id.video);
            vvw.setVisibility(View.VISIBLE);
            uri = Uri.parse("android.resource://com.example.audiovideo/"+ R.raw.this_is_love);
            mcr = new MediaController(this);
            vvw.setMediaController(mcr);
            vvw.setVideoURI(uri);
            vvw.start();

        }
    }

    void reproducir(int cancion){
        if(mp != null) mp.release();
        mp = MediaPlayer.create(this, cancion);
        mp.seekTo(0);
        mp.start();
    }
    public void onPause(){
        super.onPause();
        if(mp != null)mp.release();
    }
}