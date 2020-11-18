package com.example.examen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class FiguraCanvas extends Activity {
    Figura f;
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent().getExtras();
        f = new Figura((Context)this, paramBundle.getString("FIGURA"), paramBundle.getInt("LADOS"));
        setContentView(f);
    }

}
