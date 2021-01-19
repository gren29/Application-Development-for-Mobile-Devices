package com.example.examen2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vista vista = new Vista(this);
        setContentView(vista);
    }

    class Vista extends View{
        int x,x1,x2,x3 = 0;
        int y,y1,y2,y3 = 0;
        double anguloRes = 0;
        int statePoint = 1;
        boolean isPress = false;
        public Vista(Context context){
            super(context);
        }

        public void  onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(50);
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLUE);
            canvas.drawText("Dibuje 3 puntos (V0, V1, V2) de un triangulo",40,50,paint);
            canvas.drawRect(0,500,1200,520,paint);
            canvas.drawText("Dibujar en esta zona",20,570,paint);
            if(isPress){
                switch (statePoint){
                    case 1 : {
                        x1 = x;
                        y1 = y;
                        System.out.println("1");
                        canvas.drawText("Puntos faltantes 2",20,150,paint);
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                        break;
                    case 2 :  {
                        canvas.drawText("Puntos faltantes 2",20,150,paint);
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                        break;
                    case 3 :{
                        x2 = x;
                        y2 = y;
                        canvas.drawText("Puntos faltantes 1",20,150,paint);
                        System.out.println("2");
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawText("V1",x2-90,y2,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        canvas.drawCircle(x2,y2,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                    break;
                    case 4 :{
                        canvas.drawText("Puntos faltantes 1",20,150,paint);
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawText("V1",x2-90,y2,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        canvas.drawCircle(x2,y2,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                        break;
                    case 5 :{
                        x3 = x;
                        y3 = y;
                        System.out.println("3");
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawText("V1",x2-90,y2,paint);
                        canvas.drawText("V2",x3+30,y3,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        canvas.drawCircle(x2,y2,20,paint);
                        canvas.drawCircle(x3,y3,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                    break;
                    case 6 : {
                        canvas.drawText("V0",x1-30,y1+60,paint);
                        canvas.drawText("V1",x2-90,y2,paint);
                        canvas.drawText("V2",x3+30,y3,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        canvas.drawCircle(x2,y2,20,paint);
                        canvas.drawCircle(x3,y3,20,paint);
                        statePoint++;
                        isPress = false;
                    }
                        break;
                    case 7 :{
                        System.out.println("4");
                        canvas.drawText("V0",x1-30,y1-60,paint);
                        canvas.drawText("V1",x2-90,y2,paint);
                        canvas.drawText("V2",x3+30,y3,paint);
                        canvas.drawCircle(x1,y1,20,paint);
                        canvas.drawCircle(x2,y2,20,paint);
                        canvas.drawCircle(x3,y3,20,paint);

                        //Trazamos lineas
                        canvas.drawLine(x1,y1,x2,y2,paint);
                        canvas.drawLine(x1,y1,x3,y3,paint);
                        canvas.drawLine(x2,y2,x3,y3,paint);

                        //Caluclamos Angulo
                        Point v0 = new Point(x1,y1);
                        Point v1 = new Point(x2,y2);
                        Point v2 = new Point(x3,y3);
                        anguloRes = angulo(v0,v1,v2);
                        canvas.drawText("Angulo "+anguloRes,20,150,paint);

                        //Calculamos Magnitud de lados
                        float magnitudV0V1 = Magnitud(v0,v1);
                        float magnitudV0V2 = Magnitud(v0,v2);
                        float magnitudV1V2 = Magnitud(v1,v2);
                        System.out.println("X1 :" +x1+"      Y1: "+y1);
                        System.out.println("X2 :" +x2+"      Y2: "+y2);
                        System.out.println("X3 :" +x3+"      Y3: "+y3);
                        canvas.drawText("Magnitudes ",20,230,paint);
                        canvas.drawText("|V0 - V1| : "+magnitudV0V1+" px" ,40,300,paint);
                        canvas.drawText("|V0 - V2| : "+magnitudV0V2+" px",40,360,paint);
                        canvas.drawText("|V1 - V2| : "+magnitudV1V2+" px",40,420,paint);
                        Point pun = PuntoMedio(v0,v1);
                        canvas.drawText("|V0-V1|",pun.x,pun.y,paint);
                        Point pun2 = PuntoMedio(v0,v2);
                        canvas.drawText("|V0-V2|",pun2.x,pun2.y,paint);
                        Point pun3 = PuntoMedio(v1,v2);
                        canvas.drawText("|V1-V2|",pun3.x,pun3.y,paint);

                        isPress = false;
                    }
                    break;
                    default: {

                    }break;
                }
            }
        }

        public  double angulo(Point uno,Point dos,Point tres){
            Point pi = new Point(dos.x-uno.x,dos.y-uno.y);
            Point pj = new Point(tres.x-uno.x,tres.y-uno.y);

            double ang_pi = Math.atan2((double)pi.x,(double)pi.y);
            double ang_pj = Math.atan2((double)pj.x,(double)pj.y);
            double ang = Math.toDegrees(ang_pj-ang_pi);
            //System.out.println("ANGULO ENTRADA : "+ang);
            if(ang < 0)ang *= -1;
            if(ang > 180)ang -= 180;
            //System.out.println("ANGULO SALIDA : "+ang);
            return (ang);
        }

        public float Magnitud(Point v0,Point v1){
            float res = 0;
            res = (float) Math.abs(Math.sqrt((Math.pow((v0.x - v1.x),2))+(Math.pow((v0.y-v1.y),2))));
            return  res;
        }

        public  Point PuntoMedio(Point uno,Point dos){
            float xRes = (uno.x+dos.x)/2;
            float yRes = (uno.y+dos.y)/2;
            Point res = new Point((int)xRes,(int)yRes);
            return res;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int)event.getX();
            y = (int)event.getY();
            isPress = true;
            invalidate();
            return  true;
        }
    }
}