package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.util.Log;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
/*
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        //EditText campo1 = (EditText) findViewById(R.id.xet1);
       // Log.d("Obteniendo cursor...", String.valueOf(campo1.getSelectionEnd()));
        //EditText jet1 = (EditText) findViewById(R.id.xet1); jet1.setSelection(3);
        //if (findViewById(R.id.xet1).isFocusable()) {
          //  findViewById(R.id.xet2).requestFocus(); }

       // View view = this.getCurrentFocus();
        //if (view!=null){
          //  InputMethodManager imm =
            //        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            //imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    //}
    }
}

/*
import android.app.*;
import android.os.*;
import android.text.Editable;
import android.widget.EditText;
public class MainActivity extends Activity {
    EditText jet1;
    Editable jet2;
    int ini = 0, fin = 0;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b); setContentView(R.layout.activity_main);
        /*jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = jet1.getText();
        for (int i = ini; i < jet1.length(); i++)
            if (jet2.charAt(i) == ' ') fin = i;
        jet1.setSelection(ini, fin);

}
}

import android.app.Activity;
import android.os.Bundle;
import android.text.*;
import android.widget.*;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText jet1 = (EditText) findViewById(R.id.xet1); jet1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){} @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {} @Override
            public void afterTextChanged(Editable e) {
                TextView tv = (TextView) findViewById(R.id.xtv1); String t = String.valueOf(e.length()); tv.setText(t);
            } });
    }
}




import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.*;
import android.widget.*;
public class MainActivity extends Activity {
    EditText jet1;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1); jet1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            private Object InputMethodManager;

            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent ke) {
                boolean b = false;
                if(id == EditorInfo.IME_ACTION_SEARCH){
                    Toast.makeText(MainActivity.this,        "búsqueda..." + v.getText().toString(), Toast.LENGTH_LONG).show();
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    b = true;
                }
                return b;
            }
        });
    }
}

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText jet1 = (EditText) findViewById(R.id.xet1);
        jet1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ImageView iconoDescuento = (ImageView) findViewById(R.id.xiv1);
                    Drawable d = iconoDescuento.getDrawable();
                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d,ContextCompat.getColor(MainActivity.this, R.color.micolor));
                }// micolor es un archivo xml en la carpeta color.xml.
            }
        });

    }
}*/


        import android.widget.*;
        import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    public static String[] MI_LISTA = {"Android", "Arriba", "Africa", "Asia", "América", "A", "AGUILA"};
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView jactv1 = (AutoCompleteTextView) findViewById(R.id.xactv1);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, MI_LISTA);
        jactv1.setAdapter(aa);
    }
}