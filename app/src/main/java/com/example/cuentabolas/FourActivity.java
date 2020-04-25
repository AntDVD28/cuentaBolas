package com.example.cuentabolas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FourActivity extends AppCompatActivity {

    private EditText etRojo, etAmarillo, etAzul, etVerde;
    private Button btComprobar;

    private int num_verde, num_azul, num_rojo, num_amarillo;
    private int solucion[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        //Obtengo una referencia a los editText y botón
        etVerde = (EditText) findViewById(R.id.etVerde);
        etAzul = (EditText) findViewById(R.id.etAzul);
        etRojo = (EditText) findViewById(R.id.etRojo);
        etAmarillo = (EditText) findViewById(R.id.etAmarillo);
        btComprobar = (Button) findViewById(R.id.btComprobar);

        //Rescato la informacion enviada de la anterior Activity
        Bundle datos = getIntent().getExtras();
        solucion = datos.getIntArray("solucion");


        btComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num_aciertos = 0;

                //Rescato la información introducida por el usuario en los EditText
                String verdeS = etVerde.getText().toString();
                String azulS = etAzul.getText().toString();
                String rojoS = etRojo.getText().toString();
                String amarilloS = etAmarillo.getText().toString();



                if(rojoS.length()==0 || amarilloS.length()==0 || azulS.length()==0 || verdeS.length()==0){

                    Toast.makeText(getApplicationContext(),"Respuesta incompleta", Toast.LENGTH_LONG).show();

                }else {
                    //Paso los datos introducidos a entero para poderlos comparar con los que tenemos en el array de soluciones
                    num_verde = Integer.parseInt(verdeS);
                    num_azul = Integer.parseInt(azulS);
                    num_rojo = Integer.parseInt(rojoS);
                    num_amarillo = Integer.parseInt(amarilloS);

                    if(num_verde == solucion[0]){
                        num_aciertos = num_aciertos + 1;
                    }

                    if(num_azul == solucion[1]){
                        num_aciertos = num_aciertos + 1;
                    }

                    if(num_rojo == solucion[2]){

                        num_aciertos = num_aciertos + 1;
                    }

                    if(num_amarillo == solucion[3]){

                        num_aciertos = num_aciertos + 1;
                    }

                    if(num_aciertos == 4){

                        //Reproducimos el sonido de victoria
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.victory);
                        mp.start();
                        //Mostramos mensaje
                        Toast.makeText(getApplicationContext(),"Enhorabuena ha ganado!!", Toast.LENGTH_LONG).show();

                        //Volvemos a MainActivity
                        iniciarActivity(5000);


                    }else{

                        //Reproducimos el sonido de fallo
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.fallo);
                        mp.start();
                        //Mostramos mensaje
                        Toast.makeText(getApplicationContext(),"Ha tenido "+num_aciertos+" aciertos", Toast.LENGTH_LONG).show();

                        //Volvemos a MainActivity
                        iniciarActivity(2000);
                    }
                }
            }
        });

    }

    public void iniciarActivity(int milisegundos){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //Cerramos la activity anterior antes de iniciar la siguiente
                finish();
                // acciones que se ejecutan tras los milisegundos
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        }, milisegundos);
    }
}
