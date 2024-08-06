package sentencias;
import sentencias.clasePadre.Sentencia;
import excepciones.InvalidSentenceException;

import java.io.File;
import java.io.FileNotFoundException;

public class ShowTables extends Sentencia {

    public ShowTables(String[] consultaSeparada, File ruta) {
        super(consultaSeparada, ruta);
    }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!consultaSeparada[1].equalsIgnoreCase("TABLES")) {
            throw new InvalidSentenceException();
        }
    }

    public void accionSentencia() {
        File[] tablas = ruta.listFiles();

        for (File tabla : tablas) {
            System.out.println(tabla.getName());
        }
    }
}

