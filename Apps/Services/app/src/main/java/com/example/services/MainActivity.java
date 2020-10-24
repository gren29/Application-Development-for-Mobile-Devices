package com.example.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.sql.SQLSyntaxErrorException;

public class MainActivity extends Activity { // ServiceTimerActivity
    private TextView  jtv;
    private TextView lblPause;
    private Button  jbn;
    private Button  btnDetener;
    public boolean  isD = false;
    public boolean isT =  true;
    public double time;
    public double timePause;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jtv = (TextView) findViewById(R.id.xtvT);
        jbn = (Button) findViewById(R.id.xbnI);
        btnDetener = (Button)findViewById(R.id.xbnD);
        lblPause = (TextView)findViewById(R.id.lblPause);
        final Button stopButton = (Button) findViewById(R.id.xbnT);
        btnDetener.setVisibility(View.INVISIBLE);
        stopButton.setVisibility(View.INVISIBLE);

        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initCrono();
                time = 0;
                isT = false;
                timePause = 0;
                btnDetener.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);
            }
        });

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isD){
                    lblPause.setVisibility(View.VISIBLE);
                    btnDetener.setText("Reanudar");
                    timePause = time;
                    stopCrono();
                    isD = true;
                }
                else{
                    btnDetener.setText("Detener");
                    lblPause.setVisibility(View.INVISIBLE);
                    isD = false;
                    initCrono();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopCrono();
                isT = true;
                isD = false;
                btnDetener.setVisibility(View.INVISIBLE);
                lblPause.setVisibility(View.INVISIBLE);
                stopButton.setVisibility(view.INVISIBLE);
            } });

        MiCrono.setUpdateListener(this);
    }
    @Override
    protected void onDestroy() {
        stopCrono();
        super.onDestroy();
    }
    private void initCrono() {
        Intent in = new Intent(this, MiCrono.class);
        startService(in);
    }
    private void stopCrono() {
        Intent in = new Intent(this, MiCrono.class);
        stopService(in);
    }
    public void refreshCrono(double t) {
        time = t + timePause;
        if(isT)jtv.setText("00 : 00 : 00 segs");
        else if(isD){
            jtv.setText(String.format("%.2f", timePause) + " segs");
        }
        else{
            jtv.setText(String.format("%.2f", time) + " segs");
        }

    }
}