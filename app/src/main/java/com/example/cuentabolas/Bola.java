package com.example.cuentabolas;


import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.ColorInt;


public class Bola {


    private Integer numColor;
    private Integer posXInicial;
    private Integer posYInicial;
    private Paint pincel;
    private Integer velocidadX;
    private Integer velocidadY;

    //Constructor

    public Bola(Integer anchoPantalla, Integer altoPantalla){

        this.numColor =  obtenerNumRecursoColor();
        this.posXInicial = obtenerCoordenadaAleatoria(anchoPantalla);
        this.posYInicial = obtenerCoordenadaAleatoria(altoPantalla);

        this.pincel = new Paint();
        this.pincel.setColor(this.numColor);

        this.velocidadX = obtenerVelocidadAleatoria();
        //La velocidad será la misma en x que en y
        this.velocidadY = this.velocidadX;

    }


    //Métodos getters
    public Integer getNumColor(){

        return this.numColor;
    }

    public Integer getPosXInicial(){

        return this.posXInicial;
    }

    public Integer getPosYInicial(){

        return this.posYInicial;
    }

    public Paint getPincel(){

        return this.pincel;
    }

    public Integer getVelocidadX(){

        return this.velocidadX;
    }

    public Integer getVelocidadY(){

        return this.velocidadY;
    }


    //Métodos setters
    public void setNumColor(Integer numColor){

        this.numColor = numColor;
    }

    public void setPosXInicial(Integer posXInicial){

        this.posXInicial = posXInicial;
    }

    public void setPosYInical(Integer posYInical){

        this.posYInicial = posYInical;
    }

    public void setPincel(Paint pincel){

        this.pincel = pincel;
    }

    public void setVelocidadX(Integer velocidadX){

        this.velocidadX = velocidadX;
    }

    public void setVelocidadY(Integer velocidadY){

        this.velocidadY = velocidadY;
    }

    //Obtener un número aleatorio que corresponderá con un color
    public Integer obtenerNumRecursoColor(){

        int numRecursoColor;

        /*Obtenemos un número aleatorio, dicho número representará un color
          Al multiplicar la función random * 4 nos devuelve un numero aleatorio double comprendido entre 0 y 4, sin incluir este último
          Si le sumamos uno conseguiremos un número aletorio double comprendido entre 1 y 5, sin incluir este último
          Al aplicar la función floor nos quedamos con la parte entera, obteniendo de esta forma un número entero comprendido entre 1 y 4, ambos inclusive
          Cada uno de estos números representará un color
          1:verde, 2:azul, 3:rojo, 4:amarillo*/

        int num = (int) Math.floor(Math.random()*4 + 1);

        if(num == 1){

            numRecursoColor = Color.GREEN;


        }else if (num == 2){

            numRecursoColor = Color.BLUE;


        }else if (num == 3){

            numRecursoColor = Color.RED;


        }else {

            numRecursoColor = Color.YELLOW;

        }

        return numRecursoColor;

    }

    public int obtenerCoordenadaAleatoria(int maximo){

        //Obtenemos un número el cual deberá de ser igual o menor al máximo número pasado como parámetro
        int coordenada = (int) Math.floor(Math.random()*maximo);

        return coordenada;
    }

    public int obtenerVelocidadAleatoria(){

        //Establecemos en el array 6 velocidades posibles
        int velocidades[]={30,31,32,33,34,35};


        //Obtenemos un número comprendido entre 0 y 6 que será el indice que apunta a los valores contenidos en el array velocidades
        int indice = (int) Math.floor(Math.random()*6 );

        return velocidades[indice];

    }

    //Método auxiliar para mostrar por pantalla el contenido del objeto
    public String toString(){

        return "NumColor: " + this.numColor + "- PosXInicial: " + this.posXInicial + "- PosYInical: " + this.posYInicial;
    }


}
