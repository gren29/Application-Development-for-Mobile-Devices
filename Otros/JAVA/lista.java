//paso 1
import android.app.ListActivity; 
import android.os.Bundle;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle b) { 
        super.onCreate(b);
        ListAdapter la = crearAdapter(); 
        setListAdapter(la);
    }

    protected ListAdapter crearAdapter(){
      return null;
    }
}

//paso 2
protected ListAdapter crearAdapter(){ 
    String[] s = new String[] {
        "Elemento1",
        "Elemento2",
        "Elemento3"
    };
    ListAdapter la2 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, s);
    return la2;
}


//PARTE II
import android.app.Activity;
import android.os.Bundle;
import java.util.*;
import android.widget.ListView;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        final ListView lv = (ListView) findViewById(R.id.xlv1);
        final NuevaEntradaAdapter nea = new NuevaEntradaAdapter(this,R.layout.nueva_entrada_lista); lv.setAdapter(nea);
        for(final NuevaEntrada i : getEntradas()) { 
            nea.add(i);
        } 
    }

    private List<NuevaEntrada> getEntradas() {
        final List<NuevaEntrada> datos = new ArrayList<NuevaEntrada>(); 
        for(int i = 1; i < 31; i++) {
            datos.add(  new NuevaEntrada("Datos de Entrada " + i, "Alejandro ESCOM " + i, new GregorianCalendar(2016, 12, i).getTime(),i % 2 == 0 ? R.drawable.icon_1 : R.drawable.icon_2)
            );
        }
        return datos;
    }
}


//paso 4
import java.util.Date;
    public final class NuevaEntrada {
    private final String titulo;
    private final String autor;
    private final Date fecha;
    private final int icono;
    public NuevaEntrada(final String t, final String a, final Date f, final int i) { 
        this.titulo = t;
        this.autor = a;
        this.fecha = f;
        this.icono = i;
    }
    public String getTitulo() { 
        return titulo;
    }
    public String getAutor() {
        return autor; 
    }
    public Date getFecha() { 
        return fecha;
    }
    public int getIcono() {
        return icono; 
    }
}

//Paso 6

import java.text.DateFormat;
import android.content.Context; 
import android.view.*;
import android.widget.*;
public final class NuevaEntradaAdapter extends ArrayAdapter<NuevaEntrada> {
    private final int entradaLayoutRecurso;
    public NuevaEntradaAdapter(final Context c, final int entLayRec) {
        super(c, 0);
        this.entradaLayoutRecurso = entLayRec; 
    }

    @Override
    public View getView(final int i, final View v, final ViewGroup vg) { 
        final View v2 = getWorkingView(v);
        final ViewHolder vh = getViewHolder(v2); 
        final NuevaEntrada ne = getItem(i);
        vh.tituloView.setText(ne.getTitulo());
        final String s = String.format("Por %s on %s", ne.getAutor(),DateFormat.getDateInstance(DateFormat.SHORT).format(ne.getFecha()) );
        vh.subTituloView.setText(s);
        vh.imagenView.setImageResource(ne.getIcono());
        return v2; 
    }
    private View getWorkingView(final View v3) { 
        View workingView = null;
        if(null == v3) {
            final Context c2 = getContext();
            final LayoutInflater inflater = (LayoutInflater)c2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            workingView = inflater.inflate(entradaLayoutRecurso, null);
        } else {
            workingView = v3;
        }
        return workingView; 
    }

    private ViewHolder getViewHolder(final View workingView) {
        final Object tag = workingView.getTag(); 
        ViewHolder vh = null;
        if(null == tag || !(tag instanceof ViewHolder)) {
            vh = new ViewHolder();
            vh.tituloView = (TextView) workingView.findViewById(R.id.xtvtitulo);
            vh.subTituloView = (TextView) workingView.findViewById(R.id.xtvsubtitulo); 
            vh.imagenView = (ImageView) workingView.findViewById(R.id.xivicono); 
            workingView.setTag(vh);
        } else {
            vh = (ViewHolder) tag; 
        }
        return vh; 
    }
    private static class ViewHolder { 
        public TextView tituloView; 
        public TextView subTituloView; 
        public ImageView imagenView;
    }
}
