package com.example.examen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class FiguraCanvas extends Activity {
    Figura f;
    public void onCreate(Bundle bn) {
        super.onCreate(bn);
        bn = getIntent().getExtras();
        f = new Figura((Context)this,bn.getFloat("VOLUMEN"),bn.getSerializable("COORA"), bn.getSerializable("COORB"),bn.getSerializable("COORC"),bn.getSerializable("COORD") );
        setContentView(f);
    }

}
