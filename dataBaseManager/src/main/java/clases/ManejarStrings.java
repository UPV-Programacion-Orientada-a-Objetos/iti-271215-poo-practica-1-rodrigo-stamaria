package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManejarStrings {

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
    }

    /*
    Funcion dedicada a leer la ingresion del usuario hasta que se encuentre un ";" en ella
     */
    public static String encontrarPuntoYcoma() {
        String cadenaConcatenada = "";
        do {
            cadenaConcatenada = cadenaConcatenada.concat(ManejarStrings.leerLinea()).trim();
            if (!cadenaConcatenada.contains(";")) {
                cadenaConcatenada = cadenaConcatenada.concat(" ");
            }
        } while (!cadenaConcatenada.contains(";"));

        return cadenaConcatenada;
    }

    /*
    Funcion dedicada a separar la consulta por palabras siendo los espacios el indicador
     */
    public static String[] separarConsulta(String cadenaConcatenada) {
        cadenaConcatenada = cadenaConcatenada.substring(0, cadenaConcatenada.length() - 1);
        String[] arrayPalabras = cadenaConcatenada.split(" ");
        return arrayPalabras;
    }

    /*
    Funcion dedicada a encontrar un caracter diferente a una letra o un "_" en una cadena
     */
    public static boolean diferenteAabecedario(String cadena) {
        boolean caracterEncontrado = false;
        cadena = cadena.toLowerCase();
        for (int i=0; i<cadena.length(); i++) {
            //Podria cambiarse por comrpobacion por medio del codigo ascii
            if (cadena.charAt(i) != 'a' &&
                cadena.charAt(i) != 'b' &&
                cadena.charAt(i) != 'c' &&
                cadena.charAt(i) != 'd' &&
                cadena.charAt(i) != 'e' &&
                cadena.charAt(i) != 'f' &&
                cadena.charAt(i) != 'g' &&
                cadena.charAt(i) != 'h' &&
                cadena.charAt(i) != 'i' &&
                cadena.charAt(i) != 'j' &&
                cadena.charAt(i) != 'k' &&
                cadena.charAt(i) != 'l' &&
                cadena.charAt(i) != 'm' &&
                cadena.charAt(i) != 'n' &&
                cadena.charAt(i) != 'o' &&
                cadena.charAt(i) != 'p' &&
                cadena.charAt(i) != 'q' &&
                cadena.charAt(i) != 'r' &&
                cadena.charAt(i) != 's' &&
                cadena.charAt(i) != 't' &&
                cadena.charAt(i) != 'u' &&
                cadena.charAt(i) != 'v' &&
                cadena.charAt(i) != 'w' &&
                cadena.charAt(i) != 'x' &&
                cadena.charAt(i) != 'y' &&
                cadena.charAt(i) != 'z' &&
                cadena.charAt(i) != '_') {
                caracterEncontrado = true;
            }
        }
        return caracterEncontrado;
    }
}
