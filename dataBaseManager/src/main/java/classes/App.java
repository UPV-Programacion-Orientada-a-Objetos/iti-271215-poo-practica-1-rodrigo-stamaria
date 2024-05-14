package classes;

//Confirmar mediante uni testing
//Un jar autoejecutable
//Programar mi propio framework de excepciones
//Cada tabla es cada archivo

import edu.upvictoria.fpoo.exceptions.InvalidIngresionException;
import edu.upvictoria.fpoo.exceptions.InvalidSentenceException;
import edu.upvictoria.fpoo.exceptions.IncorrectUseOfSentenceException;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemAlreadyExistsException;

public class App {
    public static void main( String[] args ) {

        /*
        Definicion de mis variables iniciales
         */
        String consulta = "";
        Sentencias sentencia = new Sentencias();

        /*
        Se pide la consulta hasta que el usuario ingresa ";" y se divide en palabras que son metidas dentro de un array
         */
        consulta = ManejarStrings.encontrarPuntoYcoma(consulta);
        String[] consultaSeparada = ManejarStrings.separarConsulta(consulta);


        /*
        ciclo for temporal que actualmente unicamente sirve para poder ver en consola el resultado de la cadena que ingresemos
        despues de haber sido procesada por ciertas funciones
         */
        for (int i=0; i<consultaSeparada.length; i++){
            System.out.print(consultaSeparada[i] + "|");
        }
        System.out.println("\n");

        try {
            System.out.println(sentencia.identificarSentencia(consultaSeparada));
        } catch (FileSystemAlreadyExistsException e) {
            System.out.println(e.getClass());
        } catch (FileNotFoundException e) {
            System.out.println(e.getClass());
        } catch (IncorrectUseOfSentenceException e) {
            System.out.println(e.getClass());
        } catch (InvalidSentenceException e) {
            System.out.println(e.getClass());
        } catch (InvalidIngresionException e) {
            System.out.println(e.getClass());
        }
    }
}
