package sentencias;

import excepciones.InvalidSentenceException;
import sentencias.clasePadre.Sentencia;

import java.io.FileNotFoundException;

public class Drop extends Sentencia {

    Drop (String[] consultaSeparada) {
        super(consultaSeparada);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!consultaSeparada[1].equalsIgnoreCase("TABLE")) {
            throw new InvalidSentenceException();
        }
        //Comprobar la existencia de la tabla
        System.out.println("Comprobar Sintaxis");
    }

    public void accionSentecia() {
        //Se borra la tabla seleccionada
    }
}
