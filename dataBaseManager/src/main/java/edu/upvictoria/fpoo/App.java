package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Confirmar mediante uni testing
//Un jar autoejecutable
//Programar mi propio framework de excepciones
//Cada tabla es cada archivo

public class App 
{
    public static void main( String[] args )
    {
        /*
        Definicion inicial de mis palabras reservadas y de la cadena en la que el usuario hará el input
         */
        PalabrasReservadas.definirHashmap();
        String consulta = "";

        consulta = ManipularStrings.encontrarCaracter(consulta);

        System.out.println(consulta);
    }
}
