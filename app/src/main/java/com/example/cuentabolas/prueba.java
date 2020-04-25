package com.example.cuentabolas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiVista(this));
    }

    public class MiVista extends View {

        public  Paint p, p2;

        private static final int RADIO = 30 ;

        private int centroX;
        private int centroY;
        private int velocidadX = 55 ;
        private int velocidadY = 55 ;

        public MiVista(Context context){
            super(context);
            p = new Paint();
            p.setColor(Color.RED);

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldW, int oldH) {
            centroX = w / 2;
            centroY = h / 2;
        }

        protected void onDraw(Canvas c){
            // Anchura
            int w = getWidth();
            // Altura
            int h = getHeight();

            centroX += velocidadX ;
            centroY += velocidadY ;

            // Límites de pantalla
            int limiteDerecha = w - RADIO ;
            int limiteInferior = h - RADIO ;

            // Comprobar si invertir si llegamos al límite
            if (centroX >= limiteDerecha) {
                centroX = limiteDerecha ;
                velocidadX *= -1 ;
            }
            if (centroX <= RADIO) {
                centroX = RADIO ;
                velocidadX *= -1 ;
            }
            if (centroY >= limiteInferior) {
                centroY = limiteInferior ;
                velocidadY *= -1 ;
            }
            if (centroY <= RADIO) {
                centroY = RADIO ;
                velocidadY *= -1 ;
            }

            // Dibujar el círculo
            c.drawCircle(centroX, centroY, RADIO, p);
            postInvalidateDelayed(100);
        }


    }
}
