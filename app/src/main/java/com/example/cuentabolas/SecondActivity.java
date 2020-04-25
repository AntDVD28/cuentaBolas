package com.example.cuentabolas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvTextoAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTextoAnimado = (TextView) findViewById(R.id.tvTextoAnimado);

        //Debo de obtener la altura de la pantalla
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        //Obtengo las dimensiones de la pantalla
        display.getSize(size);
        //Me quedo sólo con la altura que es lo que necesito
        int alturaPantalla = size.y;

        //Método que realiza la animación
        animarTextoTopToBottom(tvTextoAnimado , alturaPantalla);
    }

    public void animarTextoTopToBottom(View view, int alturaPantalla){
        //Tiempo que durará la animación en milisegundos
        int duration = 8000;
        //Top de la pantalla
        int TopY = alturaPantalla * -1;
        //Bottom de la pantalla
        int BottomY = alturaPantalla;

        view.setTranslationY(TopY);     // lo muevo hacia arriba
        view.setTranslationY(-60);      // lo oculto un poco

        //Obtenemos un objeto ViewPropertyAnimator al que le indicamos el origen, destino y duración
        ViewPropertyAnimator vpa = view.animate();
        vpa.translationYBy(TopY).translationY(BottomY).setDuration(duration);

        //Iniciamos música intro
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.game_intro);
        mp.start();

        iniciarActivity(6000);


    }

    public void iniciarActivity(int milisegundos){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //Cerramos la activity anterior antes de iniciar la siguiente
                finish();

                // acciones que se ejecutan tras los milisegundos
                Intent i = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(i);
            }
        }, milisegundos);
    }


}
