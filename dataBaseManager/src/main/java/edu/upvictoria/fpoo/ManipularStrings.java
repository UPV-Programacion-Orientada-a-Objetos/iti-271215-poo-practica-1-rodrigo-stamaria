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

        return linea.toLowerCase();
    }

    /*
    Funcion dedicada a leer la ingresion del usuario hasta que se encuentre un ";" en ella
     */
    public static String encontrarCaracter(String cadenaConcatenada) {
        do {
            cadenaConcatenada = cadenaConcatenada.concat(ManipularStrings.leerLinea());
        } while (!cadenaConcatenada.endsWith(";"));

        return cadenaConcatenada;
    }

    /*
    Funcion dedicada a separar la consult del usuario ṕor palabras
     */

}
