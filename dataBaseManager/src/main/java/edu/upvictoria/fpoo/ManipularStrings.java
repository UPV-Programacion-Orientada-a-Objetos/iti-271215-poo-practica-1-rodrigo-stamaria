package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManipularStrings {

    /*
    Funcion dedicada a leer la linea ingresada por el usuario
     */
    public static String leerLinea() {
        String linea = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            linea = br.readLine();
        } catch (IOException e) {
            System.err.println("Excepcion encontrada al leer la entrada");
        }

        return linea;
        //toLowerCase();
    }

    /*
    Funcion dedicada a leer la ingresion del usuario hasta que se encuentre un ";" en ella
     */
    public static String encontrarCaracter(String cadenaConcatenada) {
        do {
            cadenaConcatenada = cadenaConcatenada.concat(ManipularStrings.leerLinea()).trim();
            if (!cadenaConcatenada.endsWith(";")) {
                cadenaConcatenada = cadenaConcatenada.concat(" ");
            }
        } while (!cadenaConcatenada.endsWith(";"));

        return cadenaConcatenada;
    }

    /*
    Funcion dedicada a separar la consulta por palabras siendo los espacios el indicador
     */
    public static String[] separarConsulta(String cadenaConcatenada) {
        cadenaConcatenada = cadenaConcatenada.substring(0, cadenaConcatenada.length() - 1);
        String[] arrayPalabras = cadenaConcatenada.split(" ");
        for (int i = 0; i < arrayPalabras.length; i++) {
            arrayPalabras[i] = arrayPalabras[i].trim();
        }
        return arrayPalabras;
    }

    public static String[] lowExcepto(String[] separacion, int excepcion) {
        for (int i = 0; i < separacion.length; i++) {
            if(i != excepcion) {
                separacion[i] = separacion[i].toLowerCase();
            }
        }

        return separacion;
    }
}
