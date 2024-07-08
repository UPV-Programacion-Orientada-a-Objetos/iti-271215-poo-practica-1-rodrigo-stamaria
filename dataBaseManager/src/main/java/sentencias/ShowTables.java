package sentencias;
import sentencias.clasePadre.Sentencia;
import excepciones.InvalidSentenceException;

import java.io.FileNotFoundException;

public class ShowTables extends Sentencia{
    String[] consultaSeparada;

    public ShowTables(String[] consultaSeparada) {
        this.consultaSeparada = consultaSeparada;
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!consultaSeparada[1].equalsIgnoreCase("TABLES")) {
            throw new InvalidSentenceException();
        }
    }

    public void accionSentencia() {
        System.out.println("elias");
        //Aqui se deben imprimir cada una de las tablas que se encuentren dentro de la base de datos
    }
}

