package com.example.examen;

import android.graphics.Canvas;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class Figura extends View {
    Paint p;
    Paint paint = new Paint();
    int centerX,centerY,maxX,maxY,minMaxXY;
    int s = -1;
    double X,Y;
    String figura;
    int n_lados;
    Obj obj;
    float vol;
    ArrayList<Float> coordenadasA =new ArrayList<Float>();
    ArrayList<Float> coordenadasB =new ArrayList<Float>();
    ArrayList<Float> coordenadasC =new ArrayList<Float>();
    ArrayList<Float> coordenadasD =new ArrayList<Float>();

    public Figura(Context c, float volumen, Serializable coorA, Serializable coorB, Serializable coorC, Serializable coorD) {
        super(c);
        coordenadasA = (ArrayList<Float>) coorA;
        coordenadasB = (ArrayList<Float>) coorB;
        coordenadasC = (ArrayList<Float>) coorC;
        coordenadasD = (ArrayList<Float>) coorD;
        this.obj = new Obj(this.figura, this.n_lados,coordenadasA,coordenadasB,coordenadasC,coordenadasD);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(Color.BLACK);
        this.centerX = 550;
        this.centerY = 700;
        vol = volumen;

    }

    int iX(double paramDouble) {
        double d = this.centerX;
        Double.isNaN(d);
        return (int)(d + paramDouble);
    }

    int iY(double paramDouble) {
        double d = this.centerY;
        Double.isNaN(d);
        return (int)(d - paramDouble);
    }

    void line(Canvas c, int i, int j) {
        Point2D p = this.obj.vScr[i];
        Point2D q = this.obj.vScr[j];
        c.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y), this.paint);
    }

    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.drawColor(Color.WHITE);
        p = new Paint();
        int posX = paramCanvas.getWidth();
        int posY = paramCanvas.getHeight();
        p.setColor(Color.BLACK);
        p.setTextSize(50);
        paramCanvas.drawText("Volumen : "+ vol,posX/3,(posY/3)*2,p);
        paramCanvas.drawText("Coordenasa : ",(posX/3),(posY/3)*2+100,p);
        paramCanvas.drawText("A = (0 , 0 , 0 ) ",(posX/3),(posY/3)*2+180,p);
        paramCanvas.drawText("B = ( "+ coordenadasB.get(0) +","+coordenadasB.get(1)+" ,"+coordenadasB.get(2)+" ) ",(posX/3),(posY/3)*2+260,p);
        paramCanvas.drawText("C = ( "+ coordenadasC.get(0) +","+coordenadasC.get(1)+" ,"+coordenadasC.get(2)+" ) ",(posX/3),(posY/3)*2+340,p);
        paramCanvas.drawText("D = ( "+ coordenadasD.get(0) +","+coordenadasD.get(1)+" ,"+coordenadasD.get(2)+" ) ",(posX/3),(posY/3)*2+420,p);
        this.maxX = getWidth() - 1;
        int i = getHeight() - 1;
        this.maxY = i;
        this.minMaxXY = Math.min(this.maxX, i);
        Obj obj = this.obj;
        double d1 = obj.rho;
        double d2 = this.minMaxXY;
        Double.isNaN(d2);
        obj.d = d1 * d2 / this.obj.objSize;
        this.obj.eyeAndScreen();
        line(paramCanvas, 0, 1);line(paramCanvas, 1, 2);line(paramCanvas, 2, 0);line(paramCanvas, 0, 0);
        line(paramCanvas, 4, 4);line(paramCanvas, 4, 4);line(paramCanvas, 4, 4);line(paramCanvas, 4, 4);
        line(paramCanvas, 0, 4);line(paramCanvas, 1, 4);line(paramCanvas, 2, 4);line(paramCanvas, 0, 4);
        return;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 0) {
            this.s = -1;
            this.X = paramMotionEvent.getX();
            this.Y = paramMotionEvent.getY();
            int i;
            for (i = 0; i < 2; i++) {
                double d1 = this.X;
                double d2 = this.centerX;
                Double.isNaN(d2);
                d1 -= d2;
                d2 = this.Y;
                double d3 = this.centerY;
                Double.isNaN(d3);
                d2 -= d3;
                if (Math.sqrt(d1 * d1 + d2 * d2) <= 75.0D) {
                    this.s = i;
                    invalidate();
                }
            }
        }
        if (paramMotionEvent.getAction() == 2 && this.s > -1) {
            this.centerX = (int)paramMotionEvent.getX();
            this.centerY = (int)paramMotionEvent.getY();
            invalidate();
        }
        if (paramMotionEvent.getX() < this.X) {
            Obj obj = this.obj;
            obj.theta -= 0.020943951023931952D;
        }
        if (paramMotionEvent.getX() > this.X) {
            Obj obj = this.obj;
            obj.theta += 0.020943951023931952D;
        }
        if (paramMotionEvent.getY() < this.Y) {
            Obj obj = this.obj;
            obj.phi -= 0.015707963267948967D;
        }
        if (paramMotionEvent.getY() > this.Y) {
            Obj obj = this.obj;
            obj.phi += 0.015707963267948967D;
        }
        invalidate();
        return true;
    }
}