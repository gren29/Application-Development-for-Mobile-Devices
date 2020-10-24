package com.example.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    TextView jtv1 ;
    EditText jet1;
    Button jbn1;

    int x = 5;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jtv1 = (TextView)findViewById(R.id.xtv1);
        jbn1 =(Button) findViewById(R.id.xbn1);
        jtv1.setText("x = "+x);
        //jet1 = (EditText)findViewById(R.id.xet1);
        //fibonacci(x);
    }

    public void fibonacci(int z){
        jet1.setText(x);
        String s = jet1.getText() + "";
        z = Integer.parseInt(s);
    }
}