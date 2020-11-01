//SQLite
import android.os.Bundle;
import android.app.Activity; 
import android.content.ContentValues;
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.*;

public class MainActivity extends Activity {
    EditText    jetI, jetN;
    Button      jbnA, jbnL;
    TextView    jtvL;
    SQLiteDatabase sqld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);
        jetI = (EditText)findViewByID(R.id.xetI);
        jetN = (EditText)findViewByID(R.id.xetN);
        jbnA = (Button)findViewByID(R.id.xbnA);
        jbnL = (Button)findViewByID(R.id.xbnL);
        jtvL = (TextView)findViewByID(R.id.xtvL);
        sqld = dsqlh.getWritableDatabase();

        jbnA.setOnClickListener(new OnClickListener() { 
            public void onClick(View v) {
                String id = jetI.getText().toString();
                String nombre = jetN.getText().toString(); 
                ContentValues cv = new ContentValues();
                cv.put("id", id);
                cv.put("nombre", nombre); 
                sqld.insert("Contactos", null, cv);
                jetI.setText(""); jetN.setText(""); 
            }
        });

        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null); 
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0); 
                        nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n"); 
                    }while(c.moveToNext());
                }
            } 
        });
    }
}

//DbmsSQLiteHelper.java

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
public class DbmsSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Contactos (id INTEGER, nombre TEXT)";
    public DbmsSQLiteHelper(Context c, String s, CursorFactory cf, int v){
        super(c, s, cf, v); 
    }
    @Override
    public void onCreate(SQLiteDatabase db){ 
        db.execSQL(sqlCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqld, int ov, int nv) { 
        sqld.execSQL("DROP TABLE IF EXISTS Contactos"); 
        sqld.execSQL(sqlCreate);
    }
}