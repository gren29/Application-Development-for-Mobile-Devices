package com.example.canvas;

import android.content.*;
import android.graphics.Paint.Align;
import android.graphics.*;
import android.view.View;
public class Lienzo extends View{
    Paint   p;
    int     x, y;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c){
        super.onDraw(c);
        p = new Paint();
        x = c.getWidth();
        y = c.getHeight();
        p.setColor(Color.WHITE);
        c.drawPaint(p);
        p.setColor(Color.BLACK);
        p.setTextSize(40);
        c.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2-20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x/2, 0, x/2, y, p);
        c.drawLine(0, y/2, x, y/2, p);

        p.setTextAlign(Align.LEFT);
        p.setTypeface(Typeface.SERIF);
        c.drawText("Eje X", x-5, y/2-10, p);
        p.setTextAlign(Align.LEFT);
        p.setTypeface(Typeface.SANS_SERIF); c.drawText("Eje Y", x/2+30, 20, p);

        p.setColor(Color.argb(100, 200, 100, 100));
        c.drawCircle(x/2-120, y/2+120, 100, p);
        c.drawOval(100,100,700,400,p);
        c.drawRect(100,500,300,800,p);
        c.drawRoundRect(400,500,600,800,20,20,p);
        c.drawArc( 100,1500,700,2000,0F, -90F, true,p);
    }
}