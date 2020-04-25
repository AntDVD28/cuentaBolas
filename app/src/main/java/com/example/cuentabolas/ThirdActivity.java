package com.example.cuentabolas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiPropiaVista(this));
    }

    //Debemos de crear nuestra propia vista
    public class MiPropiaVista extends View {

        private Paint pincel1, pincel2, pincel3, pincel4, pincel5, pincel6, pincel7, pincel8, pincel9, pincel10;
        private Bola bola1, bola2, bola3, bola4, bola5, bola6, bola7, bola8, bola9, bola10;
        private int numVerdes, numAzules, numRojas, numAmarillas, numColor;

        private static final int RADIO = 30 ;
        private int centroX, centroX2, centroX3, centroX4, centroX5, centroX6, centroX7, centroX8, centroX9, centroX10;
        private int centroY, centroY2, centroY3, centroY4, centroY5, centroY6, centroY7, centroY8, centroY9, centroY10;
        private int velocidadX, velocidadX2, velocidadX3, velocidadX4, velocidadX5, velocidadX6, velocidadX7, velocidadX8, velocidadX9, velocidadX10;
        private int velocidadY, velocidadY2, velocidadY3, velocidadY4, velocidadY5, velocidadY6, velocidadY7, velocidadY8, velocidadY9, velocidadY10;

        //Utilizaremos un array para guardar el número de bolas generado de cada color
        //posición 0 -> verdes
        //posición 1 -> azules
        //posición 2 -> rojas
        //posición 3 -> amarillas
        private int num_bolas[] = {0, 0, 0, 0};

        //Paint pincel_auxiliar = new Paint();

        public MiPropiaVista(Context context){
            super(context);
            //Obtengo las dimensiones de la pantalla
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int anchoPantalla = size.x;
            int altoPantalla = size.y;

            //IMPORTANTE:::::Los objetos debemos de crearlos fuera del método onDraw, crearlos dentro reduce considerablemente el rendimiento

            //Creo la primera bola
            bola1 = new Bola(anchoPantalla, altoPantalla);
            pincel1 = bola1.getPincel();
            centroX = bola1.getPosXInicial();
            centroY = bola1.getPosYInicial();
            velocidadX = bola1.getVelocidadX();
            velocidadY = bola1.getVelocidadY();
            numColor = bola1.getNumColor();
            contabilizaColor(numColor);

            //Segunda bola
            bola2 = new Bola(anchoPantalla, altoPantalla);
            pincel2 = bola2.getPincel();
            centroX2 = bola2.getPosXInicial();
            centroY2 = bola2.getPosYInicial();
            velocidadX2 = bola2.getVelocidadX();
            velocidadY2 = bola2.getVelocidadY();
            numColor = bola2.getNumColor();
            contabilizaColor(numColor);

            //Tercera bola
            bola3 = new Bola(anchoPantalla, altoPantalla);
            pincel3 = bola3.getPincel();
            centroX3 = bola3.getPosXInicial();
            centroY3 = bola3.getPosYInicial();
            velocidadX3 = bola3.getVelocidadX();
            velocidadY3 = bola3.getVelocidadY();
            numColor = bola3.getNumColor();
            contabilizaColor(numColor);

            //Cuarta bola
            bola4 = new Bola(anchoPantalla, altoPantalla);
            pincel4 = bola4.getPincel();
            centroX4 = bola4.getPosXInicial();
            centroY4 = bola4.getPosYInicial();
            velocidadX4 = bola4.getVelocidadX();
            velocidadY4 = bola4.getVelocidadY();
            numColor = bola4.getNumColor();
            contabilizaColor(numColor);

            //Quinta bola
            bola5 = new Bola(anchoPantalla, altoPantalla);
            pincel5 = bola5.getPincel();
            centroX5 = bola5.getPosXInicial();
            centroY5 = bola5.getPosYInicial();
            velocidadX5 = bola5.getVelocidadX();
            velocidadY5 = bola5.getVelocidadY();
            numColor = bola5.getNumColor();
            contabilizaColor(numColor);

            //Sexta bola
            bola6 = new Bola(anchoPantalla, altoPantalla);
            pincel6 = bola6.getPincel();
            centroX6 = bola6.getPosXInicial();
            centroY6 = bola6.getPosYInicial();
            velocidadX6 = bola6.getVelocidadX();
            velocidadY6 = bola6.getVelocidadY();
            numColor = bola6.getNumColor();
            contabilizaColor(numColor);

            //Séptima bola
            bola7 = new Bola(anchoPantalla, altoPantalla);
            pincel7 = bola7.getPincel();
            centroX7 = bola7.getPosXInicial();
            centroY7 = bola7.getPosYInicial();
            velocidadX7 = bola7.getVelocidadX();
            velocidadY7 = bola7.getVelocidadY();
            numColor = bola7.getNumColor();
            contabilizaColor(numColor);

            //Octava bola
            bola8 = new Bola(anchoPantalla, altoPantalla);
            pincel8 = bola8.getPincel();
            centroX8 = bola8.getPosXInicial();
            centroY8 = bola8.getPosYInicial();
            velocidadX8 = bola8.getVelocidadX();
            velocidadY8 = bola8.getVelocidadY();
            numColor = bola8.getNumColor();
            contabilizaColor(numColor);

            //Novena bola
            bola9 = new Bola(anchoPantalla, altoPantalla);
            pincel9 = bola9.getPincel();
            centroX9 = bola9.getPosXInicial();
            centroY9 = bola9.getPosYInicial();
            velocidadX9 = bola9.getVelocidadX();
            velocidadY9 = bola9.getVelocidadY();
            numColor = bola9.getNumColor();
            contabilizaColor(numColor);

            //Décima bola
            bola10 = new Bola(anchoPantalla, altoPantalla);
            pincel10 = bola10.getPincel();
            centroX10 = bola10.getPosXInicial();
            centroY10 = bola10.getPosYInicial();
            velocidadX10 = bola10.getVelocidadX();
            velocidadY10 = bola10.getVelocidadY();
            numColor = bola10.getNumColor();
            contabilizaColor(numColor);

            iniciarActivity(20000);

        }

        protected void contabilizaColor(int numColor){

            if (numColor == Color.GREEN){

                num_bolas[0] = num_bolas[0] + 1;

            }else if(numColor == Color.BLUE){

                num_bolas[1] = num_bolas[1] + 1;

            }else if(numColor == Color.RED){

                num_bolas[2] = num_bolas[2] + 1;

            }else{

                num_bolas[3] = num_bolas[3] + 1;
            }
        }

        protected void onDraw(Canvas canvas){

            /*
            pincel_auxiliar.setTextSize(40);
            pincel_auxiliar.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(String.valueOf(num_bolas[0])+","+String.valueOf(num_bolas[1])+","+String.valueOf(num_bolas[2])+","+String.valueOf(num_bolas[3]), getWidth() / 2, 40, pincel_auxiliar);
            */

            int anchoPantalla = getWidth();
            int altoPantalla = getHeight();

            // Límites de pantalla
            int limiteDerecha = anchoPantalla - RADIO ;
            int limiteInferior = altoPantalla - RADIO ;

            //*****************************************************MOVIMIENTO DE LA PRIMERA BOLA
            centroX += velocidadX ;
            centroY += velocidadY ;

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

            canvas.drawCircle(centroX, centroY, RADIO, pincel1);
            postInvalidateDelayed(100);

            //******************************************************MOVIMIENTO DE LA SEGUNDA BOLA
            centroX2 += velocidadX2;
            centroY2 += velocidadY2;

            // Comprobar si invertir si llegamos al límite
            if (centroX2 >= limiteDerecha) {
                centroX2 = limiteDerecha ;
                velocidadX2 *= -1 ;
            }
            if (centroX2 <= RADIO) {
                centroX2 = RADIO ;
                velocidadX2 *= -1 ;
            }
            if (centroY2 >= limiteInferior) {
                centroY2 = limiteInferior ;
                velocidadY2 *= -1 ;
            }
            if (centroY2 <= RADIO) {
                centroY2 = RADIO ;
                velocidadY2 *= -1 ;
            }

            canvas.drawCircle(centroX2, centroY2, RADIO, pincel2);
            postInvalidateDelayed(100);

            //******************************************************MOVIMIENTO DE LA TERCERA BOLA
            centroX3 += velocidadX3;
            centroY3 += velocidadY3;

            // Comprobar si invertir si llegamos al límite
            if (centroX3 >= limiteDerecha) {
                centroX3 = limiteDerecha ;
                velocidadX3 *= -1 ;
            }
            if (centroX3 <= RADIO) {
                centroX3 = RADIO ;
                velocidadX3 *= -1 ;
            }
            if (centroY3 >= limiteInferior) {
                centroY3 = limiteInferior ;
                velocidadY3 *= -1 ;
            }
            if (centroY3 <= RADIO) {
                centroY3 = RADIO ;
                velocidadY3 *= -1 ;
            }

            canvas.drawCircle(centroX3, centroY3, RADIO, pincel3);
            postInvalidateDelayed(100);

            //*******************************************************MOVIMIENTO DE LA CUARTA BOLA
            centroX4 += velocidadX4;
            centroY4 += velocidadY4;

            // Comprobar si invertir si llegamos al límite
            if (centroX4 >= limiteDerecha) {
                centroX4 = limiteDerecha ;
                velocidadX4 *= -1 ;
            }
            if (centroX4 <= RADIO) {
                centroX4 = RADIO ;
                velocidadX4 *= -1 ;
            }
            if (centroY4 >= limiteInferior) {
                centroY4 = limiteInferior ;
                velocidadY4 *= -1 ;
            }
            if (centroY4 <= RADIO) {
                centroY4 = RADIO ;
                velocidadY4 *= -1 ;
            }

            canvas.drawCircle(centroX4, centroY4, RADIO, pincel4);
            postInvalidateDelayed(100);

            //********************************************************MOVIMIENTO DE LA QUINTA BOLA
            centroX5 += velocidadX5;
            centroY5 += velocidadY5;

            // Comprobar si invertir si llegamos al límite
            if (centroX5 >= limiteDerecha) {
                centroX5 = limiteDerecha ;
                velocidadX5 *= -1 ;
            }
            if (centroX5 <= RADIO) {
                centroX5 = RADIO ;
                velocidadX5 *= -1 ;
            }
            if (centroY5 >= limiteInferior) {
                centroY5 = limiteInferior ;
                velocidadY5 *= -1 ;
            }
            if (centroY5 <= RADIO) {
                centroY5 = RADIO ;
                velocidadY5 *= -1 ;
            }

            canvas.drawCircle(centroX5, centroY5, RADIO, pincel5);
            postInvalidateDelayed(100);

            //*********************************************************MOVIMIENTO DE LA SEXTA BOLA
            centroX6 += velocidadX6;
            centroY6 += velocidadY6;

            // Comprobar si invertir si llegamos al límite
            if (centroX6 >= limiteDerecha) {
                centroX6 = limiteDerecha ;
                velocidadX6 *= -1 ;
            }
            if (centroX6 <= RADIO) {
                centroX6 = RADIO ;
                velocidadX6 *= -1 ;
            }
            if (centroY6 >= limiteInferior) {
                centroY6 = limiteInferior ;
                velocidadY6 *= -1 ;
            }
            if (centroY6 <= RADIO) {
                centroY6 = RADIO ;
                velocidadY6 *= -1 ;
            }

            canvas.drawCircle(centroX6, centroY6, RADIO, pincel6);
            postInvalidateDelayed(100);

            //*******************************************************MOVIMIENTO DE LA SEPTIMA BOLA
            centroX7 += velocidadX7;
            centroY7 += velocidadY7;

            // Comprobar si invertir si llegamos al límite
            if (centroX7 >= limiteDerecha) {
                centroX7 = limiteDerecha ;
                velocidadX7 *= -1 ;
            }
            if (centroX7 <= RADIO) {
                centroX7 = RADIO ;
                velocidadX7 *= -1 ;
            }
            if (centroY7 >= limiteInferior) {
                centroY7 = limiteInferior ;
                velocidadY7 *= -1 ;
            }
            if (centroY7 <= RADIO) {
                centroY7 = RADIO ;
                velocidadY7 *= -1 ;
            }

            canvas.drawCircle(centroX7, centroY7, RADIO, pincel7);
            postInvalidateDelayed(100);

            //********************************************************MOVIMIENTO DE LA OCTAVA BOLA
            centroX8 += velocidadX8;
            centroY8 += velocidadY8;

            // Comprobar si invertir si llegamos al límite
            if (centroX8 >= limiteDerecha) {
                centroX8 = limiteDerecha ;
                velocidadX8 *= -1 ;
            }
            if (centroX8 <= RADIO) {
                centroX8 = RADIO ;
                velocidadX8 *= -1 ;
            }
            if (centroY8 >= limiteInferior) {
                centroY8 = limiteInferior ;
                velocidadY8 *= -1 ;
            }
            if (centroY8 <= RADIO) {
                centroY8 = RADIO ;
                velocidadY8 *= -1 ;
            }

            canvas.drawCircle(centroX8, centroY8, RADIO, pincel8);
            postInvalidateDelayed(100);

            //********************************************************MOVIMIENTO DE LA NOVENA BOLA
            centroX9 += velocidadX9;
            centroY9 += velocidadY9;

            // Comprobar si invertir si llegamos al límite
            if (centroX9 >= limiteDerecha) {
                centroX9 = limiteDerecha ;
                velocidadX9 *= -1 ;
            }
            if (centroX9 <= RADIO) {
                centroX9 = RADIO ;
                velocidadX9 *= -1 ;
            }
            if (centroY9 >= limiteInferior) {
                centroY9 = limiteInferior ;
                velocidadY9 *= -1 ;
            }
            if (centroY9 <= RADIO) {
                centroY9 = RADIO ;
                velocidadY9 *= -1 ;
            }

            canvas.drawCircle(centroX9, centroY9, RADIO, pincel9);
            postInvalidateDelayed(100);

            //********************************************************MOVIMIENTO DE LA DECIMA BOLA
            centroX10 += velocidadX10;
            centroY10 += velocidadY10;

            // Comprobar si invertir si llegamos al límite
            if (centroX10 >= limiteDerecha) {
                centroX10 = limiteDerecha ;
                velocidadX10 *= -1 ;
            }
            if (centroX10 <= RADIO) {
                centroX10 = RADIO ;
                velocidadX10 *= -1 ;
            }
            if (centroY10 >= limiteInferior) {
                centroY10 = limiteInferior ;
                velocidadY10 *= -1 ;
            }
            if (centroY10 <= RADIO) {
                centroY10 = RADIO ;
                velocidadY10 *= -1 ;
            }

            canvas.drawCircle(centroX10, centroY10, RADIO, pincel10);
            postInvalidateDelayed(100);

        }

        public void iniciarActivity(int milisegundos){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    //Cerramos la activity anterior antes de iniciar la siguiente
                    finish();
                    // acciones que se ejecutan tras los milisegundos
                    Intent i = new Intent(getApplicationContext(), FourActivity.class);
                    i.putExtra("solucion", num_bolas);
                    startActivity(i);
                }
            }, milisegundos);
        }


    }//fin de nuestra clase
}
