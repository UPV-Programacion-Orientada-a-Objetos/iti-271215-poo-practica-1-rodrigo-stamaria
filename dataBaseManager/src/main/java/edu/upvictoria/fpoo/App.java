package edu.upvictoria.fpoo;

//Confirmar mediante uni testing
//Un jar autoejecutable
//Programar mi propio framework de excepciones
//Cada tabla es cada archivo

import edu.upvictoria.fpoo.exceptions.InvalidSentenceException;
import edu.upvictoria.fpoo.exceptions.IncorrectUseOfSentenceException;

import java.io.FileNotFoundException;

public class App {
    public static void main( String[] args ) {

        /*
        Definicion inicial de mis palabras reservadas y de la cadena en la que el usuario hará el input
         */
        String consulta = "";
        String ruta = "";
        consulta = ManipularStrings.encontrarCaracter(consulta);
        String[] consultaSeparada = ManipularStrings.separarConsulta(consulta);

        PalabrasReservadas PR = new PalabrasReservadas();

        for (int i=0; i<consultaSeparada.length; i++){
            System.out.print(consultaSeparada[i] + "|");
        }

        try {
            System.out.println(PR.identificarSentencia(consultaSeparada));
        } catch (IncorrectUseOfSentenceException e) {
            System.out.println("Sentencia errónamente utilizada");
        } catch (InvalidSentenceException e) {
            System.out.println("Sentencia invalida");
        }
    }
}
